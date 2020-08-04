package cn.ctrls.tmpoj.Spider;

import cn.ctrls.tmpoj.Spider.Inter.Analyzer;
import cn.ctrls.tmpoj.Spider.Inter.ContestAnalyzer;
import cn.ctrls.tmpoj.Spider.Inter.ProblemAnalyzer;
import cn.ctrls.tmpoj.config.CookieConfig;
import cn.ctrls.tmpoj.dto.ContestInfo;
import cn.ctrls.tmpoj.dto.ProblemContent;
import okhttp3.Cookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(value = "nkAnalyzer")
public class NowCoderAnalyzer implements Analyzer {
    private static final String PROBLEM_ID_REGEX = "([1-9]+)(.*?)";
    private static final String PROBLEM_INFO_REGEX = "(?:\"index\":\"([A-Z])?\".*?\"title\":\"([\\S\\s].*?)\")";
    @Value(value = "${NowCoder.contestDataUrl}")
    private String contestDataUrl;
    @Value("${NowCoder.contestUrl}")
    private String CONTEST_URL;
    //如果发现题目的Url错误了，请往下找problems在add的代码块修改
    @Value("${NowCoder.problemUrl}")
    private String PROBLEM_URL;
    @Resource(name = "requester")
    private Requester requester;
    @Resource(name = "cookieConfig")
    CookieConfig cookieConfig;

    @Override
    public ContestInfo getContestInfo(String id) {
        String contestUrl = CONTEST_URL+id;
        String rawString = requester.get(contestDataUrl+id, cookieConfig.getNowCoderCookie());
        if (rawString==null||rawString.matches("请输入密码"))return null;
        ContestInfo contestInfo = new ContestInfo();
        ArrayList<ProblemContent> problems = new ArrayList<>();
        Pattern pat = Pattern.compile(PROBLEM_INFO_REGEX);
        Matcher mat = pat.matcher(rawString);
        while (mat.find()){
            problems.add(new ProblemContent(mat.group(1), mat.group(2),contestUrl+"/"+mat.group(1) ,"ac.NowCoder.com"));
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
        String url = CONTEST_URL+mat.group(1)+"/"+mat.group(2);
        String data = requester.get(url,cookieConfig.getNowCoderCookie());
        if (data==null||data.matches("请输入密码"))return null;
        ProblemContent problemContent = new ProblemContent(mat.group(1)+mat.group(2), "test", url,"ac.NowCoder.com");
        problemContent.setContent(data);
        return problemContent;
    }
}
