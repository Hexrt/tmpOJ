package cn.ctrls.tmpoj.controller;

import cn.ctrls.tmpoj.Spider.CodeForcesSpider;
import cn.ctrls.tmpoj.controller.utils.SpiderWithDatabase;
import cn.ctrls.tmpoj.dto.ProblemContent;
import cn.ctrls.tmpoj.mapper.CodeForcesMapper;
import cn.ctrls.tmpoj.model.CodeForcesContest;
import cn.ctrls.tmpoj.model.CodeForcesProblem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class CodeForcesController {
    @Resource(name = "cfMapper")
    private CodeForcesMapper cfMapper;
    @Resource(name="cfSpider")
    private CodeForcesSpider cfSpider;
    @Value("${CodeForces.remoteSite}")
    private String remoteSite;
    @Resource(name = "spiderWithDatabase")
    private SpiderWithDatabase spiderContestAndInsert;

    @GetMapping("/CodeForces/contest/{Id}")
    public String contestPage(HttpServletRequest request,
                              HttpServletResponse response,
                              @PathVariable(name = "Id",required = false) String Id){
        if (Id==null||!Id.matches("[0-9]*?"))
            return "error";
        String remoteId = cfMapper.getContestRemoteId(Id);
        if (remoteId!=null){
            return "redirect:"+remoteSite+remoteId;
        }
        CodeForcesContest contest = (CodeForcesContest) spiderContestAndInsert.spiderContestAndInsert(Id, cfSpider, cfMapper);
        if (contest == null)return "error";
        return "redirect:"+remoteSite+contest.getRemoteId();
    }

    @GetMapping("/CodeForces/problem/{Id}")
    public String problemPage(@PathVariable(name = "Id", required = false) String Id){
        Id = Id.toUpperCase();
        if (Id==null||!Id.matches("[0-9]+[A-Z][0-9]?")){
            return "error";
        }
        //获取题目ID以及测试的ID
        String[] args = Id.split("[A-Z]");
        String contestId = args[0];
        if (contestId==null||contestId.isEmpty()){
            return "error";
        }
        //从库存中查找
        String url = cfMapper.getProblemRemoteId(Id);
        //存在库存就直接重定向为url
        if (url!=null)return "redirect:"+remoteSite+url;
        //否则从测试页面中开始缓存题目
        CodeForcesContest contest = cfMapper.getContest(contestId);

        //如果库存中也没有这个测试，就临时爬取，并且入库
        if (contest==null){
            contest = (CodeForcesContest) spiderContestAndInsert.spiderContestAndInsert(Id, cfSpider, cfMapper);
            if (contest==null)return"error";
        }
        String[] problems = contest.getProblems().split("|");
        //题目出现了未知的问题
        if (problems==null||problems.length==0){
            return "error";
        }
        Id = Id.substring(contestId.length(), Id.length());
        boolean flag = false;
        for (String s : problems){
            if (s.equals(Id)){
                flag = true;break;
            }
        }
        //此题目在那个测试里面不存在！
        if (!flag)return "error";
        ProblemContent problemContent = cfSpider.getProblemContentById(contestId+Id);
        if (problemContent==null){
            return "error";
        }
        CodeForcesProblem problem = new CodeForcesProblem();
        problem.setId(problemContent.getProblemId());
        problem.setRemoteId(problemContent.getRemoteId());
        problem.setTitle(problemContent.getTitle());
        //入库保存
        cfMapper.insertProblem(problem);
        return "redirect:"+remoteSite+problemContent.getRemoteId();
    }

}
