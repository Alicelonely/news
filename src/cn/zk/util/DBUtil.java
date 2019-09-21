package cn.zk.util;

import java.sql.*;

public class DBUtil {
    final static String DRIVER = "com.mysql.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/bbs";
    final static String DBNAME = "root";
    final static String DBPASS = "000000";


    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConn() {

        Connection conn = null;

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, DBNAME, DBPASS);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 通用的增删改方法
     *
     * @param sql    传递的sql语句
     * @param params 需要更改的数值
     * @return
     */
    public static int executeZSG(String sql, Object[] params) {
        int num = 0;
        Connection conn = getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            setParams(ps, params);
            num = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps);
        }
        return num;
    }

    /**
     * 循环绑定参数
     *
     * @param ps
     * @param params
     */
    public static void setParams(PreparedStatement ps, Object[] params) {
        try {
            if (params == null) return;
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 查到之后输出
     * @param sql
     * @param params
     */
    public static void executeCHA(String sql, Object[] params) {
        //获取连接
        Connection conn = getConn();
        //声明和数据库交互的对象
        PreparedStatement ps = null;
        //声明空的结果集
        ResultSet rs = null;
        try {
            //获取和数据库交互的对象
            ps = conn.prepareStatement(sql);
            //调用此方法，用来和循环绑定，把params当中的数据循环的绑定sql语句的占位符当中
            setParams(ps, params);
            //获取结果集
            rs = ps.executeQuery();
            //转化结果集合，以便于循环遍历，因为ResultSetMetaData当中有getColumnCount()方法可以查看每一行有多少列
            ResultSetMetaData rsd = rs.getMetaData();
            while (rs.next()) {   //指针下移
                for (int i = 1; i <=rsd.getColumnCount(); i++) {
                    System.out.print(rs.getString(i)+"\t\t");  //获取到每个数值，循环输出
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }
    }

    /**
     * 单行查询
     * @param sql
     * @param params
     * @return
     */
    public static int executeCH(String sql, Object[] params) {
        //获取连接
        Connection conn = getConn();
        //声明和数据库交互的对象
        PreparedStatement ps = null;
        //声明空的结果集
        ResultSet rs = null;
        //声明返回值
        int num =0;
        try {
            //获取和数据库交互的对象
            ps = conn.prepareStatement(sql);
            //调用此方法，用来和循环绑定，把params当中的数据循环的绑定sql语句的占位符当中
            setParams(ps, params);
            //获取结果集
            rs = ps.executeQuery();
            //转化结果集合，以便于循环遍历，因为ResultSetMetaData当中有getColumnCount()方法可以查看每一行有多少列
            ResultSetMetaData rsd = rs.getMetaData();
            while (rs.next()) {   //指针下移
                for (int i = 1; i <=rsd.getColumnCount(); i++) {
                    num =  rs.getInt(i);
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }

        return num;
    }


    /**
     * 关闭数据库连接
     */

    public static void closeAll(Connection conn, Statement st) {

        try {

            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 检查登录checkShowLoginMenu
     */
    public static boolean checkShowLoginMenu(String sql, Object[] params) {
        boolean flag = false;
        //获取连接
        Connection conn = getConn();
        //声明和数据库交互的对象
        PreparedStatement ps = null;
        //声明空的结果集
        ResultSet rs = null;
        try {
            //获取和数据库交互的对象
            ps = conn.prepareStatement(sql);
            //调用此方法，用来和循环绑定，把params当中的数据循环的绑定sql语句的占位符当中
            setParams(ps, params);
            //获取结果集
            rs = ps.executeQuery();
            //转化结果集合，以便于循环遍历，因为ResultSetMetaData当中有getColumnCount()方法可以查看每一行有多少列
            ResultSetMetaData rsd = rs.getMetaData();
            flag = false;
            while (rs.next()) {   //指针下移
                for (int i = 1; i < rsd.getColumnCount(); i++) {
                    System.out.print(rs.getString(i));  //获取到每个数值，循环输出
                    flag = true;
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }
        return flag;
    }


    public static void closeAll(Connection conn, Statement st, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
