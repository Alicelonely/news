package cn.zk.dao.iml;

import cn.zk.entity.Summary;
import cn.zk.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SummaryDao extends DBUtil implements cn.zk.dao.ISummaryDao {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * 获取汇总数据
     * @return
     */
    @Override
    public List<Summary> getAllTopic(){

        conn = getConn();
        ps = null;
        rs = null;
        List<Summary> list = new ArrayList();
        String sql = "select t.tId,t.title,t.context,t.pTime,t.pic,u.uName,b.bId,b.bName from topic t,User u,board b where t.uId = u.uId and t.bId = b.bId order by t.tId";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Summary summary = new Summary(rs.getInt("tId"),rs.getString("title"),rs.getString("context"),rs.getString("pTime"),rs.getString("pic"),rs.getString("uName"),rs.getInt("bId"),rs.getString("bName"));

                list.add(summary);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }


        return list;
    }

    @Override
    public List<Summary> getNewsByPage(String title, int pageSize, int pageNum) {
        List<Summary> ls = new ArrayList();
        conn = getConn();
        String sql = "select t.tId,t.title,t.context,t.pTime,t.pic,u.uName,b.bId,b.bName from topic t,User u,board b where t.uId = u.uId and t.bId = b.bId and t.title like ? limit ?,?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+title+"%");
            ps.setInt(2,pageSize*(pageNum-1));
            ps.setInt(3,pageSize);
            rs = ps.executeQuery();
            while (rs.next()){
                Summary summary = new Summary(rs.getInt("tId"),rs.getString("title"),rs.getString("context"),rs.getString("pTime"),rs.getString("pic"),rs.getString("uName"),rs.getInt("bId"),rs.getString("bName"));

                ls.add(summary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls;
    }


    public List<Summary> mostActive(){
        conn = getConn();
        ps = null;
        rs = null;
        List<Summary> list = new ArrayList();
        String sql = "SELECT u.uName,COUNT(*) f from user u,topic t WHERE u.uId = t.uId GROUP BY u.uName ORDER BY f;";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Summary summary = new Summary(rs.getString("uName"),rs.getInt("f"));

                list.add(summary);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }


        return list;
    }

}
