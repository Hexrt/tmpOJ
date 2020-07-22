package cn.ctrls.tmpoj.dto;

import java.util.ArrayList;

public class ContestInfo {
    private String name;
    private String url;
    private Integer problemCounts;
    private String writer;
    private ArrayList<ProblemContent> problems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
