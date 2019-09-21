package cn.zk.dao.iml;

import cn.zk.entity.Summary;
import cn.zk.entity.Topic;
import cn.zk.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TopicDao extends DBUtil implements cn.zk.dao.ITopicDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 发帖
     *
     * @return
     */
    @Override
    public boolean addTopic(Topic topic) {

        String sql = "insert into topic(title,context,pTime,uId,bId,pic) values(?,?,now(),?,?,?)";
        Object[] params = {topic.getTitle(), topic.getContext(), topic.getUser().getuId(), topic.getBoard().getbId(),topic.getPic()};
        int result = executeZSG(sql, params);
        return result > 0 ? true : false;

    }



    public boolean Prohibit(Topic topic) {
        String sql = "update topic set  title = ?,context=? where tId = ?;";
        Object[] params = {topic.getTitle(), topic.getContext(), topic.gettId()};
        int result = executeZSG(sql, params);
        return result > 0 ? true : false;
    }


    /**
     * 删除主贴
     *
     * @param tId
     * @return
     */
    @Override
    public boolean delTopic(int tId) {


        String sql1 = "delete from topic where tId = ?";
        Object[] params1 = {tId};
        int result1 = executeZSG(sql1, params1);
        return result1 > 0 ? true : false;

    }

    /**
     * 查看主贴总条数
     *
     * @return
     */
    @Override
    public int getAllTopicCount() {
        int userCount = 0;

        try {
            conn = getConn();
            String sql = "select count(1) from topic";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                userCount = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }

        return userCount;
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
        List<Summary> ls = new ArrayList();

        try {
            String sql = "select t.tId,t.title,t.context,t.pTime,u.uName,b.bId,b.bName from topic t,User u,board b where t.uId = u.uId and t.bId = b.bId order by t.tId limit ?,?";
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, PageSize * (PageIndex - 1));
            ps.setInt(2, PageSize);
            rs = ps.executeQuery();
            while (rs.next()){
                Summary summary = new Summary(rs.getInt("tId"),rs.getString("title"),rs.getString("context"),rs.getString("pTime"),rs.getString("uName"),rs.getInt("bId"),rs.getString("bName"));
                ls.add(summary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }
        return ls;
    }

    /**
     * 获取国际新闻
     * @param bid   获取的哪个版块的新闻
     * @param sum   获取这个版块的几条新闻
     * @return      返回的是这条新闻的所有信息
     */
    @Override
    public List<Summary> getSummaryByBid(int bid, int sum) {
        List<Summary> ls = new ArrayList();
        conn = getConn();
        try{
            String sql="select t.tId,t.title,t.context,t.pTime,u.uName,b.bId,b.bName from topic t,User u,board b where t.uId = u.uId and t.bId = b.bId and t.bId = ? order by t.tId limit ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,bid);
            ps.setInt(2,sum);
            rs = ps.executeQuery();
            while (rs.next()){
                Summary summary = new Summary(rs.getInt("tId"),rs.getString("title"),rs.getString("context"),rs.getString("pTime"),rs.getString("uName"),rs.getInt("bId"),rs.getString("bName"));
                ls.add(summary);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return ls;

    }

    /**
     * 根据新闻编号取出所有的新闻信息
     * @param tid
     * @return
     */
    @Override
    public List<Summary> getAllSummaryByTid(int tid) {
        List<Summary> ls = new ArrayList();
        conn = getConn();
        try{
            String sql="select t.tId,t.title,t.context,t.pTime,t.pic,u.uName,b.bId,b.bName from topic t,User u,board b where t.uId = u.uId and t.bId = b.bId and t.tId = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,tid);
            rs = ps.executeQuery();
            while (rs.next()){
                Summary summary = new Summary(rs.getInt("tId"),rs.getString("title"),rs.getString("context"),rs.getString("pTime"),rs.getString("pic"),rs.getString("uName"),rs.getInt("bId"),rs.getString("bName"));
                ls.add(summary);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return ls;
    }


    /**
     * 分页查询并匹配含有关键字
     *
     * @param PageIndex 当前页
     * @param PageSize  每页的条数
     * @return
     */
    @Override
    public List<Summary> getUserByPageAndLike(int PageIndex, int PageSize,String context){
        List<Summary> ls = new ArrayList();
        try{
            conn =getConn();
            String sql = "select t.tId,t.title,t.context,t.pTime,t.pic,u.uName,b.bId,b.bName from topic t,User u,board b where t.uId = u.uId and t.bId = b.bId and title like ? limit ?,?";

            ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+context+"%");
            ps.setInt(2,PageSize*(PageIndex-1));
            ps.setInt(3,PageSize);

            rs = ps.executeQuery();

            while (rs.next()){
                Summary Summary= new Summary(rs.getInt("tId"),rs.getString("title"),rs.getString("context"),rs.getString("pTime"),rs.getString("pic"),rs.getString("uName"),rs.getInt("bId"),rs.getString("bName"));
                ls.add(Summary);
            }
        }catch (Exception e){

        }finally {
            closeAll(conn,ps,rs);
        }
        return ls;
    }

    @Override
    public List<Summary> getAllSummaryLike(String str) {
        List<Summary> ls = new ArrayList();
        try{
            conn =getConn();
            String sql = "select t.tId,t.title,t.context,t.pTime,t.pic,u.uName,b.bId,b.bName from topic t,User u,board b where t.uId = u.uId and t.bId = b.bId and title like ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+str+"%");
            rs = ps.executeQuery();

            while (rs.next()){
                Summary Summary= new Summary(rs.getInt("tId"),rs.getString("title"),rs.getString("context"),rs.getString("pTime"),rs.getString("pic"),rs.getString("uName"),rs.getInt("bId"),rs.getString("bName"));
                ls.add(Summary);
            }
        }catch (Exception e){

        }finally {
            closeAll(conn,ps,rs);
        }
        return ls;
    }


}
