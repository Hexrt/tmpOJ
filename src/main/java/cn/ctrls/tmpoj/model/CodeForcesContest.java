package cn.ctrls.tmpoj.model;

public class CodeForcesContest {
    private String contestTitle;
    //测试ID仅仅保留该ID
    //如1234
    private String id;
    private Integer problemsCount;
    //仅仅保留URL后缀
    //例如 https://static.ctrl-s.cn/index.html
    //保存为index.html
    private String remoteId;
    //将题目缓冲为一串字符串，以|分割
    //例如A1|A2|B|C
    private String problems;


    public String getContestTitle() {
        return contestTitle;
    }

    public void setContestTitle(String contestTitle) {
        this.contestTitle = contestTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getProblemsCount() {
        return problemsCount;
    }

    public void setProblemsCount(Integer problemsCount) {
        this.problemsCount = problemsCount;
    }

    public String getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

}
