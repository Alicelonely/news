<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/4 0004
  Time: 下午 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
        body {
            background-image: url(pic/LeftBgroud.gif);
        }

    </style>
    <link rel="stylesheet" href="../css/css.css" type="text/css"></link>
</head>

<body leftmargin="0" topmargin="0">
<%@include file="loginContorl.jsp"%>
<table width="170" height="135" align="center" cellpadding="0" cellspacing="0" background="pic/msg.gif">
    <tr>
        <td width="170" height="64" valign="bottom" background="" class="menu_title">
            <table width="100%" height="21" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="80">&nbsp;</td>
                    <td><a href="index.html" target="_parent"><strong>退出系统</strong></a></td>
                </tr>

            </table>
        </td>
    </tr>
    <tr>
        <td width="170" align="center">
            <table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="38%">&nbsp;</td>
                    <td width="62%"><span class="red_9">&nbsp;&nbsp;

                    </span></td>
                </tr>
                <tr>
                    <td width="38%">&nbsp;</td>
                    <td>&nbsp;<span class="red_9">&nbsp;&nbsp;1级</span></td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<table width="170" align="center" height="25" cellpadding="0" cellspacing="0">
    <tr align="center">
        <td background="pic/bar.gif" valign="middle"><a href="ManagerBoardServlet"  target="main"><strong>主题管理</strong></a></td>
    </tr>
</table>

<table width="170" align="center" height="25" cellpadding="0" cellspacing="0">
    <tr align="center">
        <td background="pic/bar.gif" valign="middle"><a href="ManagerTopicServlet" target="main"><strong>新闻管理</strong></a></td>
    </tr>
</table>

</body>
</html>