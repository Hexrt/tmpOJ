package cn.ctrls.tmpoj.controller;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class ContestAndProblemUrlControllerTest {
    private final static String CF_REGEX = "^(?:https?://)?(?:www\\.)?codeforces\\.com/(contest|problemset/problem)/([\\S\\s]+)";
    private final static String NK_REGEX = "^(?:https?://)?ac\\.nowcoder\\.com/acm/(problem|contest)/([\\S\\s]+)";

    @Test
    void urlAnalyzer() {
        String url = "www.codeforces.com/contest/123";
        Pattern pat = Pattern.compile(CF_REGEX);
        Matcher mat = pat.matcher(url);
        if (mat.matches()){
            System.out.println(mat.groupCount());
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
        }
    }
}