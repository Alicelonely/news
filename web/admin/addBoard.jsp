<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/4 0004
  Time: 下午 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body background="pic/ManBgroud.gif">
<%@include file="loginContorl.jsp"%>
<form action="AddBoardServlet" method="post">
    主题名称：<input type="text" name="username"><br/>
    <input type="submit" value="确认添加">
</form>


</body>
</html>