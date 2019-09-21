package cn.zk.biz.iml;


import cn.zk.dao.IUserDao;
import cn.zk.dao.iml.UserDao;
import cn.zk.entity.User;

public class UserService implements cn.zk.biz.IUserService {

    IUserDao IUserDao = new UserDao();

    public static User u = null;

    /**
     * 用户注册
     */
    @Override
    public boolean userReg(String uName, String uPass) {

        User user = new User(uName, uPass);
        boolean answer = IUserDao.userReg(user);
        return answer;

    }

    /**
     * 用户登录
     * @param uName
     * @param uPass
     * @return
     */
    @Override
    public User userLogin(String uName, String uPass) {
        User user = IUserDao.userLogin(uName, uPass);
        return  user;
    }


    /**
     * 管理员登录
     */
    @Override
    public User adminLogin(String uName, String uPass) {
        User user = IUserDao.adminLogin(uName, uPass);
        return  user;

    }

    @Override
    public boolean searchTxt(String name) {
        return IUserDao.searchTxt(name);
    }


    @Override
    public User userLoginDemo(String name, String pwd) {
        return IUserDao.userLoginDemo(name,pwd);
    }


}
