package cn.zk.servlet.admin;

import cn.zk.biz.IBoardService;
import cn.zk.biz.iml.BoardService;
import cn.zk.entity.Board;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/AddTopicOptionServlet")
public class AddTopicOptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBoardService iBoardService = new BoardService();
        List<Board> boardList = iBoardService.getAllBoard();
        request.setAttribute("boardList",boardList);
        request.getRequestDispatcher("addTopic.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
