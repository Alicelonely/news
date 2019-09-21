package cn.zk.servlet.admin;


import cn.zk.biz.iml.BoardService;
import cn.zk.entity.Board;
import cn.zk.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/ManagerBoardServlet")
public class ManagerBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String context = request.getParameter("context");
        String currPage = request.getParameter("pageIndex");
        HttpSession session = request.getSession();
        if (currPage == null) {
            currPage = "1";
        }

        int pageIndex = Integer.parseInt(currPage);

        BoardService boardService = new BoardService();
        int count = boardService.getAllUserCount();
        int totalPages = PageUtil.getTotalPages(count, PageUtil.PAGE_SIZE);

        if (pageIndex < 1) {
            pageIndex = 1;
        } else if (pageIndex > totalPages) {
            pageIndex = totalPages;
        }

        List<Board> boardList = (List<Board>) request.getAttribute("boardList");

        if(boardList == null){

            if (context == null) {
                boardList = boardService.getUserByPage(pageIndex, PageUtil.PAGE_SIZE);
            }else {
                boardList = boardService.getUserByPageAndLike(pageIndex, PageUtil.PAGE_SIZE,context);
                request.setAttribute("boardList",boardList);
                request.getRequestDispatcher("ManagerBoard.jsp").forward(request,response);
            }
        }

        PrintWriter out = response.getWriter();
        request.setAttribute("pageIndex",pageIndex);
        request.setAttribute("totalPages",totalPages);
        request.setAttribute("context",context);
        request.setAttribute("boardList",boardList);
        request.getRequestDispatcher("ManagerBoard.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
