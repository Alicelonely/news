package cn.zk.servlet;

import cn.zk.biz.ISummaryService;
import cn.zk.biz.ITopicService;
import cn.zk.biz.iml.SummaryService;
import cn.zk.biz.iml.TopicService;
import cn.zk.entity.Summary;
import cn.zk.util.JsonServlet;
import cn.zk.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/GetNewsServlet")
public class GetNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISummaryService iSummaryService = new SummaryService();
        ITopicService iTopicService = new TopicService();
        String title = request.getParameter("title");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));

        int topicCount = iTopicService.getAllUserCount();
        int totalPages = PageUtil.getTotalPages(topicCount, pageSize);


        List<Summary> ls = iSummaryService.getNewsByPage(title,pageSize,pageNum);
        Map<String,Object> maps = new HashMap();
        maps.put("NewsList",ls);
        maps.put("pageSize",pageSize);
        maps.put("pageNum",pageNum);
        maps.put("totalPages", totalPages);
        JsonServlet.getJson(request,response,maps);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
