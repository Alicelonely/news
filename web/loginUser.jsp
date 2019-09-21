<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/21 0021
  Time: 下午 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="userLoginServlet">
    请输入账号：<input type="text" name="name">
    请输入密码：<input type="password" name="pwd">
    <input type="submit" value="确定">
</form>

    ${flag}
</body>
</html>
