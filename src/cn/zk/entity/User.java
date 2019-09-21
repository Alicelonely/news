package cn.zk.entity;

import java.io.Serializable;

public class User implements Serializable {
    private int uId;
    private String uName;
    private String uPass;
    private int state;      //0代表正常 1代表禁用
    private int flag;       //0代表用户 1代表管理员

    public User(String uName) {
    }

    public User(String uName, String uPass) {
        this.uName = uName;
        this.uPass = uPass;
    }



    public User(int uId, int flag) {
        this.uId = uId;
        this.flag = flag;
    }

    public User(int uId, String uName, String uPass, int state, int flag) {
        this.uId = uId;
        this.uName = uName;
        this.uPass = uPass;
        this.state = state;
        this.flag = flag;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
