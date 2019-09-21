package cn.zk.servlet;

import cn.zk.biz.IUserService;
import cn.zk.biz.iml.UserService;
import cn.zk.entity.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("uname");
        String password = request.getParameter("upwd");
        PrintWriter out = response.getWriter();
        //验证用户登陆
        IUserService IUserService = new UserService();
        User user = IUserService.userLogin(name, password);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", user);
        out.println(jsonObject);



//        ITopicService iTopicService = new TopicService();
//        List<Summary> ls = iTopicService.getSummaryByBid(14,3);

        //request.getRequestDispatcher("index.jsp").forward(request, response);

//        ITopicService iTopicService = new TopicService();
//        List<Summary> ls = iTopicService.getSummaryByBid(14,3);
//
//
//
//        JSONArray jsonArray = JSONArray.fromObject(ls);
//        out.println(jsonArray);

        //  jsonArray.add(ls);
//        JSONArray jsonArray = new JSONArray();
        // jsonArray.add(ls);
        // out.println(jsonArray.toString());
//        response.setContentType("application/json;charset=utf-8");
//        PrintWriter outputStream = response.getWriter();
//        //outputStream.println(jsonArray.toString());
//        response.getWriter().write(jsonArray.toString());//发送响应

        //第一种方法 在jsp当中加入java代码
        //第二种方法 用jslt即${}接受
        //第三种方法
        //JSONArray object=JSONArray.fromObject(ls);

//        request.setAttribute("SummaryList", jsonArray);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
