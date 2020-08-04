package cn.ctrls.tmpoj.Spider;

import com.alibaba.fastjson.JSON;
import okhttp3.Cookie;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class NowCoderAnalyzerTest {

    @Test
    void getContestInfo() {
        Requester requester = new Requester();
        final String url = "https://ac.nowcoder.com/acm/contest/problem-list?id=5673";
        String cookie = "t=;";
//        String s = requester.get(url, cookie);
        String s = "{\"msg\":\"OK\",\"code\":0,\"data\":{\"data\":[{\"score\":0,\"acceptedCount\":58,\"submitCount\":297,\"tagId\":138401,\"index\":\"A\",\"myStatus\":\"未通过\",\"problemId\":209449,\"title\":\"All-Star Game\",\"info\":{}},{\"score\":0,\"acceptedCount\":1,\"submitCount\":10,\"tagId\":138402,\"index\":\"B\",\"myStatus\":\"未通过\",\"problemId\":210079,\"title\":\"Bon Voyage\",\"info\":{}},{\"score\":0,\"acceptedCount\":1,\"submitCount\":154,\"tagId\":138403,\"index\":\"C\",\"myStatus\":\"未通过\",\"problemId\":210247,\"title\":\"Cinema\",\"info\":{}},{\"score\":0,\"acceptedCount\":3,\"submitCount\":17,\"tagId\":138404,\"index\":\"D\",\"myStatus\":\"未通过\",\"problemId\":210274,\"title\":\"Disgusting Relationship\",\"info\":{}},{\"score\":0,\"acceptedCount\":123,\"submitCount\":552,\"tagId\":138405,\"index\":\"E\",\"myStatus\":\"未通过\",\"problemId\":210055,\"title\":\"Enigmatic Partition\",\"info\":{}},{\"score\":0,\"acceptedCount\":1,\"submitCount\":30,\"tagId\":138406,\"index\":\"F\",\"myStatus\":\"未通过\",\"problemId\":210275,\"title\":\"Factorio\",\"info\":{}},{\"score\":0,\"acceptedCount\":570,\"submitCount\":1815,\"tagId\":138407,\"index\":\"G\",\"myStatus\":\"未通过\",\"problemId\":209998,\"title\":\"Game SET\",\"info\":{}},{\"score\":0,\"acceptedCount\":19,\"submitCount\":175,\"tagId\":138408,\"index\":\"H\",\"myStatus\":\"未通过\",\"problemId\":210259,\"title\":\"Hard String Problem\",\"info\":{}},{\"score\":0,\"acceptedCount\":928,\"submitCount\":6943,\"tagId\":138409,\"index\":\"I\",\"myStatus\":\"通过\",\"problemId\":210022,\"title\":\"Interesting Computer Game\",\"info\":{}},{\"score\":0,\"acceptedCount\":1,\"submitCount\":27,\"tagId\":138410,\"index\":\"J\",\"myStatus\":\"未通过\",\"problemId\":210081,\"title\":\"Jumping Points\",\"info\":{}},{\"score\":0,\"acceptedCount\":921,\"submitCount\":5663,\"tagId\":138411,\"index\":\"K\",\"myStatus\":\"通过\",\"problemId\":210256,\"title\":\"Kabaleo Lite\",\"info\":{}}],\"basicInfo\":{\"contestId\":5673,\"pageCount\":1,\"problemCount\":11,\"pageSize\":50,\"pageCurrent\":0}}}";
        Pattern pat = Pattern.compile("(?:\"index\":\"([A-Z])?\".*?\"title\":\"([\\S\\s].*?)\")");
        Matcher mat = pat.matcher(s);
        int cnt = 0;
        while (mat.find()){
//            System.out.println(mat.groupCount());
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
        }
        System.out.println(cnt);
//        System.out.println(s);
    }
}