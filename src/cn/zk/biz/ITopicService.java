package cn.zk.biz;

import cn.zk.entity.Board;
import cn.zk.entity.Summary;
import cn.zk.entity.User;

import java.util.List;

public interface ITopicService {
    boolean addTopic(String title, String context, User user, Board board,String pic);

//    boolean Prohibit(int tId, String title, String context);

    boolean delTopic(int tId);

    int getAllUserCount();

    List<Summary> getAllSummaryByTid(int tid);

    List<Summary> getUserByPage(int PageIndex, int PageSize);


    List<Summary> getSummaryByBid(int bid, int sum);

    List<Summary> getUserByPageAndLike(int PageIndex, int PageSize,String context);

    List<Summary> getAllSummaryLike(String str);
}
