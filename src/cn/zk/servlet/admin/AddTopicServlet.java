package cn.zk.servlet.admin;

import cn.zk.biz.ITopicService;
import cn.zk.biz.iml.TopicService;
import cn.zk.entity.Board;
import cn.zk.entity.User;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;

public class AddTopicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //图片文件路径
        SmartUpload sm = new SmartUpload();

        PageContext pageContext =JspFactory.getDefaultFactory().getPageContext(this,request,response,null,true,8192,true);
        sm.initialize(pageContext);

        sm.setCharset("UTF-8");
        try {
            sm.upload();
            sm.save("upfiles");
        } catch (Exception e) {
            e.printStackTrace();
        }


        Request srequest = sm.getRequest();

        String title =  srequest.getParameter("title");
        String context = srequest.getParameter("context");
        int id = Integer.parseInt(srequest.getParameter("boardid"));

        String pic = sm.getFiles().getFile(0).getFileName();
        ITopicService ITopicService = new TopicService();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Board board = new Board(id);
        boolean result = ITopicService.addTopic(title,context,user,board,pic);
        PrintWriter out = response.getWriter();
        if(result){
            response.sendRedirect("ManagerTopicServlet");
        } else {
            out.print("<script>alert('添加失败');</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
