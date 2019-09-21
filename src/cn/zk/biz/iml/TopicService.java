package cn.zk.biz.iml;


import cn.zk.dao.ITopicDao;
import cn.zk.dao.iml.TopicDao;
import cn.zk.entity.Board;
import cn.zk.entity.Summary;
import cn.zk.entity.Topic;
import cn.zk.entity.User;

import java.util.List;


public class TopicService implements cn.zk.biz.ITopicService {

    ITopicDao ITopicDao = new TopicDao();

    /**
     * 发帖
     */
    @Override
    public boolean addTopic(String title,String context, User user,Board board,String pic) {
        Topic topic = new Topic(title, context, user, board,pic);

        boolean result = ITopicDao.addTopic(topic);
        return result;
    }






//    /**
//     * 修改新闻
//     */
//    @Override
//    public boolean Prohibit(int tId, String title, String context) {
//        Topic topic = new Topic(tId,title,context);
//        boolean result =  ITopicDao.Prohibit(topic);
//        return result;
//    }

    /**
     * 删除主贴
     * @param tId
     * @return
     */
    public boolean delTopic(int tId){
        return ITopicDao.delTopic(tId);
    }


    /**
     * 获取新闻总条数
     */
    @Override
    public int getAllUserCount() {

       int su =  ITopicDao.getAllTopicCount();
       return su;
    }

    /**
     * 根据新闻编号取出新闻的详细信息
     * @param tid
     * @return
     */
    @Override
    public List<Summary> getAllSummaryByTid(int tid) {
        return ITopicDao.getAllSummaryByTid(tid);
    }


    /**
     * 分页查询
     *
     * @param PageIndex
     * @param PageSize
     * @return
     */
    @Override
    public List<Summary> getUserByPage(int PageIndex, int PageSize) {
        return ITopicDao.getUserByPage(PageIndex,PageSize);
    }

    /**
     * 选择指定版块的，新闻的条数
     * @param bid
     * @param sum
     * @return
     */
    @Override
    public List<Summary> getSummaryByBid(int bid, int sum) {
        return ITopicDao.getSummaryByBid(bid,sum);
    }

    public List<Summary> getUserByPageAndLike(int PageIndex, int PageSize, String context){
        return ITopicDao.getUserByPageAndLike(PageIndex,PageSize,context);
    }

    @Override
    public List<Summary> getAllSummaryLike(String str) {
        return ITopicDao.getAllSummaryLike(str);
    }
}
