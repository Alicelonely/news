package cn.zk.entity;

import java.io.Serializable;

public class Summary implements Serializable {
    private int tId;
    private String tTitle;
    private String context;
    private String pTime;
    private String uName;
    private int bId;
    private String pic;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }


    public Summary(int tId, String tTitle, String context, String pTime,String pic, String uName, int bId, String bName, int f, int g) {
        this.tId = tId;
        this.tTitle = tTitle;
        this.context = context;
        this.pTime = pTime;
        this.uName = uName;
        this.bId = bId;
        this.pic = pic;
        this.bName = bName;
        this.f = f;
        this.g = g;
    }

    private String bName;
    private int f;      //汇总的最活跃用户发的帖子
    private int g;      //汇总的版本总贴书


    public Summary(int tId, String tTitle, String context, String pTime, String pic, String uName, int bId, String bName) {
        this.tId = tId;
        this.tTitle = tTitle;
        this.context = context;
        this.pTime = pTime;
        this.pic = pic;
        this.uName = uName;
        this.bId = bId;
        this.bName = bName;
    }

    public Summary(int bId, String bName) {
        this.bId = bId;
        this.bName = bName;
    }

    public Summary(String uName, int f) {
        this.uName = uName;
        this.f = f;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public Summary(int tId, String tTitle, String context, String pTime, String uName, int bId, String bName) {
        this.tId = tId;
        this.tTitle = tTitle;
        this.context = context;
        this.pTime = pTime;
        this.uName = uName;
        this.bId = bId;
        this.bName = bName;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

}
