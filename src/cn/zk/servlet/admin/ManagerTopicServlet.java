package cn.zk.servlet.admin;

import cn.zk.biz.ITopicService;
import cn.zk.biz.iml.TopicService;
import cn.zk.entity.Summary;
import cn.zk.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/ManagerTopicServlet")
public class ManagerTopicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String context = request.getParameter("context");
        String currPage = request.getParameter("pageIndex");
        HttpSession session = request.getSession();
        if (currPage == null) {
            currPage = "1";
        }
        int pageIndex = Integer.parseInt(currPage);

        ITopicService iTopicService = new TopicService();


        int count = iTopicService.getAllUserCount();
        int totalPages = PageUtil.getTotalPages(count, PageUtil.PAGE_SIZE);
        if (pageIndex < 1) {
            pageIndex = 1;
        } else if (pageIndex > totalPages) {
            pageIndex = totalPages;
        }


        List<Summary> ls = (List<Summary>) request.getAttribute("ls");

        if(ls == null){

            if (context == null) {
                ls = iTopicService.getUserByPage(pageIndex, PageUtil.PAGE_SIZE);
            }else {
                ls = iTopicService.getUserByPageAndLike(pageIndex,PageUtil.PAGE_SIZE,context);
                request.setAttribute("ls",ls);
                request.getRequestDispatcher("ManagerTopic.jsp").forward(request,response);
            }
        }


        request.setAttribute("pageIndex",pageIndex);
        request.setAttribute("totalPages",totalPages);
        request.setAttribute("context",context);
        request.setAttribute("ls",ls);
        request.getRequestDispatcher("ManagerTopic.jsp").forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
