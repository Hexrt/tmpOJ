package cn.ctrls.tmpoj.mapper.inter;

import cn.ctrls.tmpoj.model.NowCoderContest;
import cn.ctrls.tmpoj.model.inter.Contest;
import cn.ctrls.tmpoj.model.inter.Problem;


public interface OJMapper {
    public void insertContest(Contest contest);
    public void insertProblem(Problem problem);
    public String getContestRemoteId(String id);
    public String getProblemRemoteId(String id);
    public Contest getContest(String contestId);
}
