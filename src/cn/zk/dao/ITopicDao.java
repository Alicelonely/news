package cn.zk.dao;

import cn.zk.entity.Board;
import cn.zk.entity.Summary;
import cn.zk.entity.Topic;

import java.util.List;

public interface ITopicDao {
    boolean addTopic(Topic topic);

    boolean delTopic(int tId);

    int getAllTopicCount();

    List<Summary> getUserByPage(int PageIndex, int PageSize);

    List<Summary> getSummaryByBid(int bid,int sum);

    List<Summary> getAllSummaryByTid(int tid);

    List<Summary> getUserByPageAndLike(int PageIndex, int PageSize,String context);

    List<Summary> getAllSummaryLike(String str);

    }
