package cn.ctrls.tmpoj.dto;


import java.util.ArrayList;

public class ProblemContent {
    private String problemId;
    private String title;
    private String timeLimit;
    private String memoryLimit;
    private String inputFile;
    private String outputFile;
    private String content;
    private String inputSpecification;
    private String outputSpecification;
    private ArrayList<TestCase> sampleTests;
    private String url;
    private String sourceFrom;
    private String remoteId;


    public String getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
    }
    public ProblemContent(String problemId, String title, String url, String sourceFrom) {
        this.problemId = problemId;
        this.title = title;
        this.url = url;
        this.sourceFrom = sourceFrom;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }
}
