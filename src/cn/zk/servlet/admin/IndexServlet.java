package cn.zk.servlet.admin;

import cn.zk.biz.IUserService;
import cn.zk.biz.iml.UserService;
import cn.zk.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("loginId");
        String password = request.getParameter("password");
        IUserService IUserService = new UserService();

        User user = IUserService.adminLogin(name, password);

        if (user != null) {
            HttpSession session =request.getSession();
            //设置session域的值
            session.setAttribute("user", user);
            //带值跳转页面    客户端行为
            request.getRequestDispatcher("mainfrom.jsp").forward(request, response);
        }else {
            //不设置参数，跳转到登录页面
            response.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
