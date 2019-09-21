package cn.zk.servlet.admin;

import cn.zk.biz.iml.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bId = Integer.parseInt(request.getParameter("id"));
        BoardService boardService = new BoardService();
        boolean result = boardService.delBoard(bId);
        PrintWriter out = response.getWriter();
        if (result) {
            out.print("<script>alert('删除成功');location.href='ManagerBoardServlet.jsp'</script>");
        } else {
            out.print("<script>alert('删除失败');</script>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
