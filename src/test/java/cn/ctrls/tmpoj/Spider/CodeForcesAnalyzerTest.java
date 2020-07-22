package cn.ctrls.tmpoj.Spider;

import cn.ctrls.tmpoj.dto.ContestInfo;
import cn.ctrls.tmpoj.dto.ProblemContent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class CodeForcesAnalyzerTest {

    @Test
    void getContestInfo() {
        CodeForcesAnalyzer cfAnalyzer = new CodeForcesAnalyzer();
        ContestInfo contestInfo = cfAnalyzer.getContestInfo("1366");
        System.out.println(contestInfo.getUrl());
        ArrayList<ProblemContent> problemContents = contestInfo.getProblems();
        if (problemContents==null) System.out.println("null");
        System.out.println(problemContents.size());
        for (ProblemContent a: problemContents){
            System.out.println(a.getTitle());
//            System.out.println(a.getUrl());
        }
    }

    @Test
    void getProblemContent(){
        CodeForcesAnalyzer cfAnalyzer = new CodeForcesAnalyzer();
        cfAnalyzer.getProblemContent("1385G");
    }
}