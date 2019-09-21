package cn.zk.servlet;

import cn.zk.biz.ISummaryService;
import cn.zk.biz.IUserService;
import cn.zk.biz.iml.SummaryService;
import cn.zk.biz.iml.UserService;
import cn.zk.entity.Summary;
import cn.zk.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/userLoginServlet")
public class userLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        IUserService iUserService = new UserService();
        ISummaryService iSummaryService = new SummaryService();
        List<Summary> ls = iSummaryService.getAllTopic();
        User user = iUserService.userLoginDemo(name, pwd);
        HttpSession session = request.getSession();
        boolean flag =true;
        if (user != null) {
          flag = true;
            session.setAttribute("user",user);
            session.setAttribute("ls",ls);
        }else{
            flag = false;
        }
        session.setAttribute("flag",flag);
        request.getRequestDispatcher("loginUser.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
