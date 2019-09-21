package cn.zk.dao.iml;

import cn.zk.entity.Board;
import cn.zk.entity.Summary;
import cn.zk.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao extends DBUtil implements cn.zk.dao.IBoardDao {
    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 查看所有板块
     */
    @Override
    public List<Board> getAllBoard(){
        Connection conn = getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Board> list = new ArrayList();
        String sql = "select * from board";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
              Board board = new Board(rs.getInt("bId"),rs.getString("bName"));
              list.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }

        return list;
    }

    /**
     * 创建板块
     * @return
     */
    @Override
    public boolean setBoard(String bName){
        String sql ="insert into board(bName) values(?)";
        Object[]params= {bName};
        int result = executeZSG(sql, params);
        return result > 0 ? true : false;
    }


    /**
     * 更改板块
     */
    @Override
    public boolean checkBoard(Board board) {
        String sql = "UPDATE board SET bName = ? WHERE bId = ?";
        Object [] params = {board.getbName(),board.getbId()};
        int result = executeZSG(sql,params);
        return result>0?true:false;
    }


    /**
     * 板块总贴书
     */
    @Override
    public List<Summary> totalBoard(){
        Connection conn = getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Summary> list = new ArrayList();
        String sql = "SELECT b.bName,COUNT(*) f from board b,topic t WHERE b.bId = t.bId GROUP BY b.bName ORDER BY f;";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Summary summary = new Summary(rs.getString("bName"),rs.getInt("g"));

                list.add(summary);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }


        return list;
    }


    /**
     * 删除板块
     */
    @Override
    public boolean delBoard(int bId){
        String sql = "delete board from board where bId = ?";
        Object [] params = {bId};
        int result = executeZSG(sql,params);
        return result >0?true : false;
    }


    /**
     * 查询用户总条数
     * @return
     */
    @Override
    public int getAllUserCount() {
        int userCount = 0;

        try {
            conn = getConn();
            String sql="select count(1) from board";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
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
     * @param PageIndex 当前页
     * @param PageSize  每页的条数
     * @return
     */
    @Override
    public List<Board> getUserByPage(int PageIndex, int PageSize){
        List<Board> ls = new ArrayList();
        try{
            conn =getConn();
            String sql = "select * from board order by bId desc limit ?,?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,PageSize*(PageIndex-1));
            ps.setInt(2,PageSize);
            rs = ps.executeQuery();

            while (rs.next()){
                Board board= new Board(rs.getInt("bId"),rs.getString("bName"));
                ls.add(board);
            }
        }catch (Exception e){

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
    public List<Board> getUserByPageAndLike(int PageIndex, int PageSize,String context){
        List<Board> ls = new ArrayList();
        try{
            conn =getConn();
            String sql = "select * from board where bName like ? order by bId desc limit ?,?";

            ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+context+"%");
            ps.setInt(2,PageSize*(PageIndex-1));
            ps.setInt(3,PageSize);

            rs = ps.executeQuery();

            while (rs.next()){
                Board board= new Board(rs.getInt("bId"),rs.getString("bName"));
                ls.add(board);
            }
        }catch (Exception e){

        }finally {
           closeAll(conn,ps,rs);
        }
        return ls;
    }

}
