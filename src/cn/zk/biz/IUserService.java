package cn.zk.biz;

import cn.zk.entity.User;

public interface IUserService {
    boolean userReg(String uName, String uPass);

    User userLogin(String uName, String uPass);


    User adminLogin(String uName, String uPass);

    boolean searchTxt(String name);

    public User userLoginDemo(String name,String pwd);
}
