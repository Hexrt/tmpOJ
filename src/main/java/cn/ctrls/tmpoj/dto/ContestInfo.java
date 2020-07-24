package cn.ctrls.tmpoj.dto;

import java.util.ArrayList;

public class ContestInfo {
    private String title;
    private String url;
    private String remoteId;
    private Integer problemCounts;
    private String writer;
    private String content;
    private ArrayList<ProblemContent> problems;


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getProblemCounts() {
        return problemCounts;
    }

    public void setProblemCounts(Integer problemCounts) {
        this.problemCounts = problemCounts;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public ArrayList<ProblemContent> getProblems() {
        return problems;
    }

    public void setProblems(ArrayList<ProblemContent> problems) {
        this.problems = problems;
    }

    public String getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
