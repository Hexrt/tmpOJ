package cn.ctrls.tmpoj.model;

import cn.ctrls.tmpoj.model.inter.Problem;

public class NowCoderProblem  implements Problem {
    private String id;
    private String title;
    private String remoteId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
    }
}
