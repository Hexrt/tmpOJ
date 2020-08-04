package cn.ctrls.tmpoj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ContestAndProblemUrlController {

    private final static String CF_REGEX = "^(?:https?://)?(?:www\\.)?codeforces\\.com/(contest|problemset/problem)/([\\S\\s]+)";
    private final static String NK_REGEX = "^(?:https?://)?ac\\.nowcoder\\.com/acm/(problem|contest)/([\\S\\s]+)";
    private final static Pattern cfPat = Pattern.compile(CF_REGEX);
    private final static Pattern nkPat = Pattern.compile(NK_REGEX);
    @GetMapping("/getByUrl/")
    public String UrlAnalyzer(@RequestParam(name = "url",required = false) String url){
        System.out.println(url);
        if (url.matches(CF_REGEX)){
            Matcher mat = cfPat.matcher(url);
            if (mat.matches()){
                String flag = mat.group(1);
                String id = mat.group(2);
                //注意
                //这里使用了转发路径，若路径修改了，这里需要同步
                if (flag.equals("contest")){
                    return "redirect:"+"/CodeForces/contest/"+id;
                }else if (flag.equals("problemset/problem")){
                    return "redirect:"+"/CodeForces/problem/"+id;
                }
            }
        }
        else if (url.matches(NK_REGEX)){
            Matcher mat = nkPat.matcher(url);
            if (mat.matches()){
                String flag = mat.group(1);
                String id = mat.group(2);
                //注意
                //这里使用了转发路径，若路径修改了，这里需要同步
                if (flag.equals("contest")){
                    return "redirect:"+"/NowCoder/contest/"+id;
                }else{
                    //ToDo 需要增加功能
                }
            }
        }
        return "error";
    }
}
