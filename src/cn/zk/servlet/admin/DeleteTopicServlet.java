package cn.zk.servlet.admin;

import cn.zk.biz.ITopicService;
import cn.zk.biz.iml.TopicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteTopicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tid = Integer.parseInt(request.getParameter("tid"));
        ITopicService iTopicService = new TopicService();
        boolean result = iTopicService.delTopic(tid);
        PrintWriter out = response.getWriter();
        if (result){
            response.sendRedirect("ManagerTopic.jsp");
        }else {
            out.print("<script>alert('删除失败')</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
