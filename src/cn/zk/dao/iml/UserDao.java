package cn.zk.dao.iml;

import cn.zk.entity.User;
import cn.zk.biz.iml.UserService;
import cn.zk.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends DBUtil implements cn.zk.dao.IUserDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;




    /**
     * 用户注册
     *
     * @return
     */
    @Override
    public boolean userReg(User user) {


        String sql1 = "select uId from user where uName = ?";
        Object[] params1 = {user.getuName()};
        int result1 = executeCH(sql1, params1);
        if (result1 == 0) {
            String sql = "insert into user (uName,uPass,state,flag) values(?,MD5(?),0,0)";
            Object[] params = {user.getuName(), user.getuPass()};
            int result = executeZSG(sql, params);

            return result > 0 ? true : false;
        } else {
            return false;
        }
    }

    /**
     * 用户登录
     *
     * @param uName
     * @param uPass
     * @return
     */
    @Override
    public User userLogin(String uName, String uPass) {
        conn = getConn();
        ps = null;
        rs = null;
        User user = null;
        String sql = "select * from user where uName = ? and uPass = ? and state = 0;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, uName);
            ps.setString(2, uPass);

            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("uId"), rs.getString("uName"), rs.getString("uPass"), rs.getInt("state"), rs.getInt("flag"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }
        return user;
    }


    /**
     * 管理员登录
     *
     * @param uName
     * @param uPass
     * @return
     */
    @Override
    public User adminLogin(String uName, String uPass) {
        conn = getConn();
        ps = null;
        rs = null;
        User user = null;
        String sql = "select * from user where uName = ? and uPass = ? and state = 0 and flag = 1;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, uName);
            ps.setString(2, uPass);

            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("uId"), rs.getString("uName"), rs.getString("uPass"), rs.getInt("state"), rs.getInt("flag"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }
        return user;
    }

    /**
     * 查看用户
     */
    @Override
    public void viewUser() {
        System.out.println("用户id\t用户姓名\t用户密码\t用户状态\t用户权限");
        String sql = "select * from user";
        executeCHA(sql, null);
    }

    /**
     * 修改用户状态用户
     */
    @Override
    public boolean Prohibit(User user) {
        User user1 = UserService.u;
        String sql = "update user set state = ? where uId = ? and uName != ?;";
        Object[] params = {user.getState(), user.getuId(), user1.getuName()};
        System.out.println(user.getState());
        int result = executeZSG(sql, params);
        return result > 0 ? true : false;
    }

    /**
     * 设置管理员
     */
    @Override
    public boolean setAdmin(User user) {
        User user1 = UserService.u;
        String sql = "update user set flag = ? where uId = ? and uName != ?;";
        Object[] params = {user.getFlag(), user.getuId(), user1.getuName()};
        System.out.println(user.getFlag() + "," + user1.getuName());
        int result = executeZSG(sql, params);
        return result > 0 ? true : false;
    }

    /**
     * 删除用户
     */
    @Override
    public boolean delUser(int uId) {

        String sql2 = "delete from reply where uId = ?";
        Object[] params2 = {uId};
        int result = executeZSG(sql2, params2);
        String sql1 = "delete from topic where uId = ?";
        Object[] params1 = {uId};
        int result1 = executeZSG(sql1, params1);
        String sql = "delete from user where uId = ?";
        Object[] params = {uId};
        int result2 = executeZSG(sql, params);
        return result > 0 && result1 > 0 && result2 > 0 ? true : false;
    }


    /**
     * 查看用户名是否被注册
     * @return
     */
    public boolean searchTxt(String name){
        conn = getConn();
        String sql = "select * from user where uName = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if(rs.next()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public User userLoginDemo(String name, String pwd) {
        User user = null;
        conn = getConn();
        String sql = "select * from user where uName = ? and uPass = ?";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                user = new User(rs.getString("uName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


}
