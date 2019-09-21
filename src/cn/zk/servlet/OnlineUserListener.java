package cn.zk.servlet;

import cn.zk.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

@WebListener("/OnlineUserListener")
public class OnlineUserListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener{
    ServletContext application = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //tomcat启动，创建集合，放入application作用域
        List<User> onlineUsers = new ArrayList<User>();
        application = servletContextEvent.getServletContext();
        application.setAttribute("onlineUsers", onlineUsers);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        //登陆的时候，将登陆人的对象取出，存入集合
        HttpSession session = httpSessionBindingEvent.getSession();
        User user = (User) session.getAttribute("user");
        List<User> onlineUsers = (List<User>) application.getAttribute("onlineUsers");
        onlineUsers.add(user);


    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        //当某用户注销的时候，从session中移除指定用户
        User user = (User) httpSessionBindingEvent.getValue();
        List<User> onlineUsers = (List<User>) application.getAttribute("onlineUsers");
        onlineUsers.remove(user);

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        User user = (User) session.getAttribute("user");
        List<User> onlineUsers = (List<User>) application.getAttribute("onlineUsers");
        onlineUsers.remove(user);
    }
}