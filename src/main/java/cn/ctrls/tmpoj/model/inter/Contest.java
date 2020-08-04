package cn.ctrls.tmpoj.model.inter;

public interface Contest {
    public void setId(String contestId);

    public void setRemoteId(String remoteId);

    public void setContestTitle(String title);

    public void setProblemsCount(Integer problemCounts);

    public void setProblems(String toString);
}
