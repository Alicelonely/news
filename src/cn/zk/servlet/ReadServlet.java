package cn.zk.servlet;

import cn.zk.biz.ISummaryService;
import cn.zk.biz.ITopicService;
import cn.zk.biz.iml.SummaryService;
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

@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查找新闻
        GNNews(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    /**
     * 所有新闻
     * @param request
     * @param response
     */
    public void GNNews(HttpServletRequest request,HttpServletResponse response) {
        ITopicService iTopicService = new TopicService();
        JSONArray jsonArray = new JSONArray();
        //国内新闻
        List<Summary> ls = iTopicService.getSummaryByBid(14, 3);
        //国际新闻
        List<Summary> lj = iTopicService.getSummaryByBid(19, 3);
        //娱乐新闻
        List<Summary> ll = iTopicService.getSummaryByBid(20, 3);
        ISummaryService iSummaryService = new SummaryService();
        //新闻中心一
        List<Summary> lz = iSummaryService.getAllTopic();

        jsonArray.add(ls);
        jsonArray.add(lj);
        jsonArray.add(ll);
        jsonArray.add(lz);
        try {
            PrintWriter out = response.getWriter();
            out.println(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        request.setAttribute("GNNews", jsonArray);
        //这里传递到前台的数据时object
    }
}
