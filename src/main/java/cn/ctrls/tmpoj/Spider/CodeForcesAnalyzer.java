package cn.ctrls.tmpoj.Spider;

import cn.ctrls.tmpoj.Spider.Inter.ContestAnalyzer;
import cn.ctrls.tmpoj.Spider.Inter.ProblemAnalyzer;
import cn.ctrls.tmpoj.dto.ContestInfo;
import cn.ctrls.tmpoj.dto.ProblemContent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(value = "cfAnalyzer")
public class CodeForcesAnalyzer implements ContestAnalyzer , ProblemAnalyzer {
    private static final String PROBLEM_ID_REGEX = "([1-9]+)(.*?)";
    @Value("${CodeForces.contestUrl}")
    private String CONTEST_URL;
    //如果发现题目的Url错误了，请往下找problems在add的代码块修改
    @Value("${CodeForces.problemUrl}")
    private String PROBLEM_URL;
    @Resource(name = "requester")
    private Requester requester;

    @Override
    public ContestInfo getContestInfo(String id) {
        String contestUrl = CONTEST_URL+id;
        String rawString = requester.get(contestUrl);
        if (rawString==null)return null;
        ContestInfo contestInfo = new ContestInfo();
        Pattern pat = Pattern.compile("(?:<option value=\"([A-Z]*?[1-9]*?)\" >(.*?)</option>)*");
        Matcher mat = pat.matcher(rawString);
        ArrayList<ProblemContent> problems = new ArrayList<>();
        while(mat.find()){
            if (mat.group(0).isEmpty())continue;
            problems.add(new ProblemContent(id+mat.group(1),mat.group(2),contestUrl+"/problem/"+mat.group(1),"CodeForces"));
        }
        contestInfo.setContent(rawString);
        contestInfo.setProblems(problems);
        contestInfo.setUrl(contestUrl);
        contestInfo.setProblemCounts(problems.size());
        contestInfo.setTitle("CYQ-CF");
        contestInfo.setWriter("CYQ");
        return contestInfo;
    }

    @Override
    public ProblemContent getProblemContent(String id) {
        Pattern pat = Pattern.compile(PROBLEM_ID_REGEX);
        Matcher mat = pat.matcher(id);
        if (!mat.matches())return null;
        String url = PROBLEM_URL+mat.group(1)+"/"+mat.group(2);
        String data = requester.get(url);
        ProblemContent problemContent = new ProblemContent(mat.group(1)+mat.group(2), "test", url,"CodeForces");
        problemContent.setContent(data);
        return problemContent;
    }
}
