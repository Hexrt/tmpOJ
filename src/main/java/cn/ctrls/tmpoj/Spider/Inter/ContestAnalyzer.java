package cn.ctrls.tmpoj.Spider.Inter;

import cn.ctrls.tmpoj.dto.ContestInfo;
import cn.ctrls.tmpoj.dto.ProblemContent;
import org.springframework.stereotype.Component;


public interface ContestAnalyzer {
    public ContestInfo getContestInfo(String id);
}