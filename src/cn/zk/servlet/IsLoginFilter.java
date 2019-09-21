package cn.zk.servlet;

import cn.zk.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IsLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if(user != null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            response.sendRedirect("/admin/index.html");
        }

    }

    @Override
    public void destroy() {

    }
}
