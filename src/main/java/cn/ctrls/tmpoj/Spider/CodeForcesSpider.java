package cn.ctrls.tmpoj.Spider;

import cn.ctrls.tmpoj.dto.ContestInfo;
import cn.ctrls.tmpoj.dto.ProblemContent;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.ArrayList;

@Component(value = "cfSpider")
public class CodeForcesSpider {

    @Resource(name = "cfAnalyzer")
    CodeForcesAnalyzer cfAnalyzer;

    public ProblemContent getProblemContentById(String id){
        ProblemContent problemContent = cfAnalyzer.getProblemContent(id);
        return problemContent;
    }

    public ContestInfo getContestInfoById(String id){
        ContestInfo contestInfo = cfAnalyzer.getContestInfo(id);
        return contestInfo;
    }

    public ArrayList<ProblemContent> getProblemsByContestId(String id){
        return getContestInfoById(id).getProblems();
    }


}
