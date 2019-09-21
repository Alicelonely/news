<%@ page import="cn.zk.biz.iml.BoardService" %>
<%@ page import="cn.zk.entity.Board" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.zk.util.PageUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.zk.biz.ITopicService" %>
<%@ page import="cn.zk.biz.iml.TopicService" %>
<%@ page import="cn.zk.entity.Summary" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/5 0005
  Time: 上午 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="Charater.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    a {
        text-decoration: none;
        color: #000;
    }

    input {
        outline: none;
        text-align: center;
        cursor: pointer;
        background-color: transparent;
    }
</style>
<body background="pic/ManBgroud.gif">
<%@include file="loginContorl.jsp" %>
<table>
    <tr>
        <th>
            <form action="ManagerTopicServlet">
                <input type="text" id="text" style="cursor: text;text-align: left;" name="context">
                <input type="submit" value="搜索" id="btn">
            </form>

        </th>
    </tr>
    <tr>
        <td>新闻编号</td>
        <td>新闻题目</td>
        <td>新闻内容</td>
        <td>新闻时间</td>
        <td>新闻发布者名字</td>
        <td>新闻版块号</td>
        <td>新闻版块号名称</td>
        <td>操作</td>

        <th><a href="AddTopicOptionServlet"><input type="button" value="+"></a></th>
    </tr>

    <c:forEach items="${ls}" var="summary">
    <tr>

        <td>${summary.tId}
        </td>
        <td>${summary.tTitle}
        </td>
        <td>${summary.pTime}
        </td>
        <td>${summary.uName}
        </td>
        <td>${summary.bId}
        </td>
        <td><input type="text" value="${summary.bName}" readonly="true" style="border:none;" name="context"
                   class="context"></td>
        <td>
            <a class="del" href="DeleteTopicServlet?tid=${summary.tId}" onclick="return delTopic()">删除</a></td>
        </td>


    </tr>
    </c:forEach>

    <tr>
        <td colspan="4" align="center">
            <a href="ManagerTopicServlet?pageIndex=1">首页</a>
            <a href="ManagerTopicServlet?pageIndex=${pageIndex-1}">上一页</a>
            <a href="ManagerTopicServlet?pageIndex=${pageIndex+1}">下一页</a>
            <a href="ManagerTopicServlet?pageIndex=${totalPages}">尾页</a>
        </td>
    </tr>

</table>
<script src="../js/jquery-1.8.3.min.js"></script>
<script>

    $(function () {
        $(".del").click(function () {

            var answer = confirm("确认删除？");

            if (answer) {
                return true;
            } else {
                return false;
            }

        })


        // function ajaxFun(){
        //     $.ajax({
        //         type: "POST",                            //传数据的方式
        //         url: "DemoServlet",                   //servlet地址
        //
        //         data: $('#form').serialize(),            //传的数据  form表单 里面的数据
        //         success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
        //             $("#results").val(result);           //找到输入框 并且将result的值 传进去
        //         }
        //     });
        // }
    })



</script>
</body>
</html>



