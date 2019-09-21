package cn.zk.entity;

import java.io.Serializable;

public class Reply implements Serializable {

    private int tId;
    private String title;
    private String context;
    private String pTime;
    private User user;
    private Topic topic;

    public Reply() {
    }

    public Reply(String title, String context, User user, Topic topic) {
        this.title = title;
        this.context = context;
        this.user = user;
        this.topic = topic;
    }

    public Reply(int tId, String title, String context, String pTime, User user, Topic topic) {
        this.tId = tId;
        this.title = title;
        this.context = context;
        this.pTime = pTime;
        this.user = user;
        this.topic = topic;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
