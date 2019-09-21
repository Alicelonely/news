<%@ page import="cn.zk.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/4 0004
  Time: 下午 2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    User u = (User) session.getAttribute("user");

    if(u == null){
        response.sendRedirect("index.html");
        return;
    }

%>
</body>
</html>
