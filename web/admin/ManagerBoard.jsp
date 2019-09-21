<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/5 0005
  Time: 上午 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form action="ManagerBoardServlet">
                <input type="text" id="text" style="cursor: text;text-align: left;" name="context">
                <input type="submit" value="搜索" id="btn">
            </form>

        </th>
    </tr>
    <tr>
        <th>板块编号</th>
        <th>板块内容</th>
        <th>板块操作</th>
        <th><a href="addBoard.jsp"><input type="button" value="+"></a></th>
    </tr>


    <c:forEach items="${boardList}" var="board">
        <tr>

            <td class="id">${board.bId}
            </td>
            <td><input type="text" value="${board.bName}" readonly="true" style="border:none;" name="context"
                       class="context"></td>
            <td><input type="button" value="修改">
                <a class="del" href="DeleteBoardServlet?id=${board.bId}"><input type="button" value="删除"></a>
                <a href=""><input type="button" value="确定"></a>

            </td>

        </tr>

    </c:forEach>



    <tr>
        <td colspan="4" align="center">
            <a href="ManagerBoardServlet?pageIndex=1">首页</a>
            <a href="ManagerBoardServlet?pageIndex=${pageIndex-1}">上一页</a>
            <a href="ManagerBoardServlet?pageIndex=${pageIndex+1}">下一页</a>
            <a href="ManagerBoardServlet?pageIndex=${totalPages}">尾页</a>
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


        $("input[value='修改']").click(function () {
            $(this).parent().prev().children().attr("readonly", false).css({
                "cursor": "text",
                "border": "1px solid skyblue",
                "background-color": "#fff"
            })
        })

        $("input[value='确定']").each(function (i) {

            $("input[value='确定']").eq(i).click(function () {

                $(this).parent().parent().prev().children().attr("readonly", true).css({
                    "cursor": "pointer",
                    "border": "none",
                    "background-color": "transparent"
                })

                var $bId = $(".id").eq(i).html().trim();
                var $context = $(".context").eq(i).val();
                var $a = $("input[value='确定']").parent().eq(i);

                $a.attr(
                    "href", "CheckBoardServlet?id=" + $bId + "&context=" + $context + ""
                )


                })
        })


    })


</script>
</body>
</html>
