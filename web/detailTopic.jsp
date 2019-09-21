<%@ page import="cn.zk.biz.ITopicService" %>
<%@ page import="cn.zk.biz.iml.TopicService" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.zk.entity.Summary" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/10 0010
  Time: 下午 7:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="Charater.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int tid = Integer.parseInt(request.getParameter("tid"));
    ITopicService iTopicService = new TopicService();
    List<Summary> ls = iTopicService.getAllSummaryByTid(tid);
    for (Summary s:ls) {



%>
<div style="width: 300px;height: 100%; margin: 0px auto">
    <h2><%=s.gettTitle()%>
    </h2>
    <div>
        <span class="b"><%=s.getuName()%></span>发布于<span
            class="b"><%=s.getpTime()%></span>所属板块：<span class="b"><%=s.getbName()%></span>
    </div>
    <div>
        <img src="/upfiles/<%=s.getPic()%>">
    </div>
    <div>
        <%=s.getContext()%>
    </div>

    <%
    }
    %>
</div>

</body>
</html>
