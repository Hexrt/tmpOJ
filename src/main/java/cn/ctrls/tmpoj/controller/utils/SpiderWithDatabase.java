package cn.ctrls.tmpoj.controller.utils;

import cn.ctrls.tmpoj.Spider.Inter.Spider;
import cn.ctrls.tmpoj.dto.ContestInfo;
import cn.ctrls.tmpoj.dto.ProblemContent;
import cn.ctrls.tmpoj.mapper.NowCoderMapper;
import cn.ctrls.tmpoj.mapper.inter.OJMapper;
import cn.ctrls.tmpoj.model.CodeForcesContest;
import cn.ctrls.tmpoj.model.NowCoderContest;
import cn.ctrls.tmpoj.model.inter.Contest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("spiderWithDatabase")
public class SpiderWithDatabase {
    //爬取并且插入库存中
    public Contest spiderContestAndInsert(String contestId, Spider spider, OJMapper mapper){
        ContestInfo contestInfo = spider.getContestInfoById(contestId);
        //没有这个测试，错误！
        if (contestInfo==null||contestInfo.getProblemCounts()==0){
            return null;
        }
        Contest contest;
        if (mapper instanceof NowCoderMapper) contest = new NowCoderContest();
        else contest = new CodeForcesContest();
        contest.setId(contestId);
        contest.setRemoteId(contestInfo.getRemoteId());
        contest.setContestTitle(contestInfo.getTitle());
        contest.setProblemsCount(contestInfo.getProblemCounts());
        ArrayList<ProblemContent> problems = contestInfo.getProblems();
        StringBuilder sbd = new StringBuilder();
        for (ProblemContent prob:problems){
            sbd.append(prob.getProblemId());
            sbd.append("|");
        }
        contest.setProblems(sbd.toString());
        mapper.insertContest(contest);
        return contest;
    }
}
