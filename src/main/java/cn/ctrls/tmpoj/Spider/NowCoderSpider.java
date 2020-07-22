package cn.ctrls.tmpoj.Spider;

import cn.ctrls.tmpoj.Spider.Inter.ContestAnalyzer;
import cn.ctrls.tmpoj.dto.ProblemContent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class NowCoderSpider {

    @Resource(name = "cfAnalyzer")
    CodeForcesAnalyzer analyzer;

    public ProblemContent getProblemContentById(Integer id){
        return null;
    }
}
