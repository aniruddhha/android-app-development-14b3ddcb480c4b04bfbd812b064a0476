package com.aniruddha.kudalkar.appdevsession.week3;

public class ImpMsg {

    private String nm;
    private String msg;
    private String num;

    public ImpMsg(String nm, String msg, String num) {

        this.nm = nm;
        this.msg = msg;
        this.num = num;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
