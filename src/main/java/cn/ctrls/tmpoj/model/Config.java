package cn.ctrls.tmpoj.model;

public class Config {
    private Integer id;
    private String nowCoderCookie;
    private String codeForcesCookie;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNowCoderCookie() {
        return nowCoderCookie;
    }

    public void setNowCoderCookie(String nowCoderCookie) {
        this.nowCoderCookie = nowCoderCookie;
    }

    public String getCodeForcesCookie() {
        return codeForcesCookie;
    }

    public void setCodeForcesCookie(String codeForcesCookie) {
        this.codeForcesCookie = codeForcesCookie;
    }
}
