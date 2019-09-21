<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/10 0010
  Time: 下午 2:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>>
<%@include file="Charater.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body background="pic/ManBgroud.gif">
<h2>发布主贴</h2>
<form action="AddTopicServlet" enctype="multipart/form-data" method="post">
    标题：<input type="text" name="title"><br/>
    板块：<select name="boardid" id="boardid">

    <c:forEach items="${boardList}" var="board">

        <option value="${board.bId}">${board.bName}

        </option>
    </c:forEach>



</select>
    <br/>
    图片：<input type="file" name="pic"><br/>
    内容：<textarea name="context"></textarea>
    <input type="submit" value="发布">

</form>

</body>
</html>
