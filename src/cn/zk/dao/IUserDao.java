package cn.zk.dao;

import cn.zk.entity.User;

public interface IUserDao {
    boolean userReg(User user);

    User userLogin(String uName, String uPass);

    User adminLogin(String uName, String uPass);

    void viewUser();

    boolean Prohibit(User user);

    boolean setAdmin(User user);

    boolean delUser(int uId);

    public boolean searchTxt(String name);

    public User userLoginDemo(String name,String pwd);
}
