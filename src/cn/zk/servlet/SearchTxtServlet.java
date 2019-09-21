package cn.zk.servlet;

import cn.zk.biz.IUserService;
import cn.zk.biz.iml.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SearchTxtServlet")
public class SearchTxtServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        IUserService iUserService = new UserService();
        boolean flag = iUserService.searchTxt(name);
        PrintWriter out = response.getWriter();
        out.println(flag);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
