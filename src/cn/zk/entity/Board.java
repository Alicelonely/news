package cn.zk.entity;

import java.io.Serializable;

public class Board implements Serializable {
    private int bId;
    private String bName;

    public Board(String bName) {
        this.bName = bName;
    }

    public Board() {
    }

    public Board(int bId) {
        this.bId = bId;
    }

    public Board(int bId, String bName) {
        this.bId = bId;
        this.bName = bName;
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
