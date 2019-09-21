package cn.zk.servlet.admin;

import cn.zk.biz.iml.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        //int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("context");
        BoardService boardService = new BoardService();
        PrintWriter out = response.getWriter();
        boolean result = boardService.checkBoard(Integer.parseInt(id), name);
        if (result) {
            out.print("<script>alert('修改成功');location.href='main.jsp'</script>");
        } else {
            response.sendRedirect("addBoard.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
