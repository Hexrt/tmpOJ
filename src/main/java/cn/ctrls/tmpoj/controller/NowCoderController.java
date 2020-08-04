package cn.ctrls.tmpoj.controller;

import cn.ctrls.tmpoj.Spider.NowCoderSpider;
import cn.ctrls.tmpoj.controller.utils.SpiderWithDatabase;
import cn.ctrls.tmpoj.dto.ContestInfo;
import cn.ctrls.tmpoj.dto.ProblemContent;
import cn.ctrls.tmpoj.mapper.NowCoderMapper;
import cn.ctrls.tmpoj.model.CodeForcesContest;
import cn.ctrls.tmpoj.model.NowCoderContest;
import cn.ctrls.tmpoj.model.NowCoderProblem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

@Controller
public class NowCoderController {
    @Resource(name = "nkMapper")
    private NowCoderMapper nkMapper;
    @Resource(name = "nkSpider")
    private NowCoderSpider nkSpider;
    @Value(value = "${NowCoder.remoteSite}")
    private String remoteSite;
    @Resource(name = "spiderWithDatabase")
    private SpiderWithDatabase spiderContestAndInsert;

    @GetMapping("/NowCoder/contest/{contestId}")
    public String contestPage(@PathVariable(name = "contestId",required = false) String contestId){
        String remoteId = nkMapper.getContestRemoteId(contestId);
        if (remoteId!=null){
            return "redirect:"+remoteSite+remoteId;
        }
        NowCoderContest contest = (NowCoderContest) spiderContestAndInsert.spiderContestAndInsert(contestId, nkSpider, nkMapper);
        if (contest == null) return "error";
        return "redirect:"+remoteSite+contest.getRemoteId();
    }
    @GetMapping("/NowCoder/contest/{contestId}/{problemId}")
    private String contestToProblemPage(@PathVariable(name = "contestId",required = false) String contestId,
                                        @PathVariable(name = "problemId",required = false) String problemId){
        if (contestId==null||problemId==null) return "error";
        problemId = problemId.toUpperCase();
        //拓展需要判断ID是否为null
//        if (problemId==null||contestId==null) return "error";
        //从库存中查找
        String url = nkMapper.getProblemRemoteId(contestId+problemId);
        if (url!=null) return "redirect:"+remoteSite+url;
        NowCoderContest contest = nkMapper.getContest(contestId);
        if (contest==null){
            contest = (NowCoderContest) spiderContestAndInsert.spiderContestAndInsert(contestId, nkSpider, nkMapper);
            if (contest == null)return "error";
        }
        String[] problems = contest.getProblems().split("|");
        if (problems == null||problems.length==0){
            return "error";
        }
        boolean flag = false;
        for (String s : problems)if (s.equals(problemId)){
            flag = true;break;
        }
        if (!flag) return "error";
        ProblemContent problemContent = nkSpider.getProblemContentById(contestId+problemId);
        if (problemContent==null){
            return "error";
        }
        NowCoderProblem problem = new NowCoderProblem();
        problem.setId(problemContent.getProblemId());
        problem.setRemoteId(problemContent.getRemoteId());
        problem.setTitle(problemContent.getTitle());
        nkMapper.insertProblem(problem);
        return "redirect:"+remoteSite+problem.getRemoteId();
    }
}
