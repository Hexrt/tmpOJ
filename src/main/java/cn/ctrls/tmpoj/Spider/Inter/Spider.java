package cn.ctrls.tmpoj.Spider.Inter;

import cn.ctrls.tmpoj.dto.ContestInfo;
import cn.ctrls.tmpoj.dto.ProblemContent;

public interface Spider {
    public ProblemContent getProblemContentById(String id);
    public ContestInfo getContestInfoById(String id);
}
