<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/4 0004
  Time: 下午 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新闻系统后台</title>
</head>
<body style="height:1000px;">
<%@include file="loginContorl.jsp"%>
<iframe src="top.jsp" height="100px" width="100%" scrolling="no"></iframe>
<iframe src="left.jsp" height="100%" width="200px" scrolling="no" name="side"></iframe>
<iframe src="main.jsp" height="100%" width="1000px" scrolling="no" name="main"></iframe>


</body>

</html>
