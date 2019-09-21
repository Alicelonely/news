package cn.zk.servlet.admin;

import cn.zk.biz.iml.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("username");
        BoardService boardService = new BoardService();
        boolean result = boardService.setBoard(name);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (result) {
            out.print("<script>alert('发布成功');location.href='ManagerBoardServlet.jsp'</script>");
        } else {
            out.print("<script>alert('发布失败，请检查');</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
