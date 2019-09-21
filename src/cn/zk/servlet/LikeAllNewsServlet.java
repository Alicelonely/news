package cn.zk.servlet;

import cn.zk.biz.ITopicService;
import cn.zk.biz.iml.TopicService;
import cn.zk.entity.Summary;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/LikeAllNewsServlet")
public class LikeAllNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String str = request.getParameter("name");
        if(str != ""){
            PrintWriter out = response.getWriter();
            ITopicService iTopicService = new TopicService();
            List<Summary> ls = iTopicService.getAllSummaryLike(str);
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(ls);
            out.println(jsonArray.toString());
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
