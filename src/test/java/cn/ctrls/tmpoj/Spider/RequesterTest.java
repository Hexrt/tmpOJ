package cn.ctrls.tmpoj.Spider;

import cn.ctrls.tmpoj.Spider.Inter.ProblemAnalyzer;
import cn.ctrls.tmpoj.dto.ProblemContent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class RequesterTest {

    Requester requester = new Requester();
    @Test
    void get() {
        System.out.println(requester.get("https://codeforces.com/contest/1365/problem/A"));
    }
    @Test
    void prob(){
        String url = "https://codeforces.com/contest/1365";
        String rawString = "                <select style=\"width: 25em;\" name=\"submittedProblemIndex\">\n" +
                "                <option value=\"\">Choose problem</option>\n" +
                "                    <option value=\"A\" >A - Matrix Game</option>\n" +
                "                    <option value=\"B\" >B - Trouble Sort</option>\n" +
                "                    <option value=\"C\" >C - Rotation Matching</option>\n" +
                "                    <option value=\"D\" >D - Solve The Maze</option>\n" +
                "                    <option value=\"E\" >E - Maximum Subsequence Value</option>\n" +
                "                    <option value=\"F\" >F - Swaps Again</option>\n" +
                "                    <option value=\"G\" >G - Secure Password</option>\n" +
                "                </select>";

    }
}