<%@ page import="cn.zk.biz.ITopicService" %>
<%@ page import="cn.zk.biz.iml.TopicService" %>
<%@ page import="cn.zk.entity.Summary" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/2 0002
  Time: 下午 5:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="Charater.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>新闻中国</title>
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
    <link href="/layui/css/layui.css" rel="stylesheet" type="text/css"/>
</head>
<style>
    .sou {
        position: relative;
        width: 300px;
    }

    .serch_text {
        width: 100%;
    }

    .serches {
        position: absolute;
        left: 0;
        top: 19px;
        width: 100%;
        border: 1px solid #000;
        border-top: none;
        background-color: #fff;
        z-index: 999;
        display: none;
    }

    .serches a {
        display: inline-block;
        text-decoration: none;
    }

    .on {
        color: #fff;
        background-color: #000;
        cursor: pointer;
    }

    .Page a {
        cursor: pointer;
    }
</style>
<script src="/layui/layui.all.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>

<body>

<div id="header">
    <div id="top_login">
        <label></label>

        <form id="form">
            <input type="text" id="uname" value="" class="login_input" name="uname"/>
            <label> 密&#160;&#160;码 </label>
            <input type="password" id="upwd" value="" class="login_input" name="upwd"/>
            <input type="button" class="login_sub" value="登录" onclick="ajaxFun()"/>
            <a href="register.html">注册</a>

            <div class="sou" style="display: inline-block;">
                <input type="text" size="30" id="serch" class="serch_text" oninput="serchS()" onfocus="get_text()"
                       onblur="setTimeout('lose_text()','200')">
                <div class="serches"></div>
            </div>
            <input type="button" name="search" class="class_date" value="搜索">
            <span><a href=""><img src="pic/QQ.png" style="width: 20px;height: 20px" alt=""></a>&nbsp;&nbsp;&nbsp;<a href=""><img src="pic/weixin.png" style="width: 20px;height: 20px" alt=""></a></span>

        </form>


        <label id="error"> </label>
        <img src="Images/friend_logo.gif" alt="Google" id="friend_logo"/>
    </div>
    <div id="nav">

        <img src="Images/ad.gif" alt=""/>

    </div>
</div>
<div id="container">
    <div class="sidebar">
        <h1><img src="Images/title_1.gif" alt="国内新闻"/></h1>
        <div class="side_list">
            <ul class="GNNews">
            </ul>
        </div>
        <h1><img src="Images/title_2.gif" alt="国际新闻"/></h1>
        <div class="side_list">
            <ul class="GJNews">
            </ul>
        </div>
        <h1><img src="Images/title_3.gif" alt="娱乐新闻"/></h1>
        <div class="side_list">
            <ul class="YLNews">
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="class_type"><img src="Images/class_type.gif" alt="新闻中心"/></div>
        <div class="content">
            <ul class="class_date">
                <li id='class_month'>

                </li>
            </ul>
            <ul class="classlist">

            </ul>
            <div id="demoPage">

            </div>
            <div class="Page"><span align="right" class="pageINdex"> 当前页数:[1/2]&nbsp; </span><a
                    class="firstPage">首页</a><a class="proPage">上一页</a><span class="pageName"></span><a
                    class="nextPage">下一页</a> <a class="lastPage">末页</a></div>
            <div class="JsonPage">
                <a href="javascript:void(0)" id="first" class="pages">首页</a>
                <a href="javascript:void(0)" id="prev" class="pages">上一页</a>
                <div class="pageNum"></div>
                <a href="javascript:void(0)" id="next" class="pages">下一页</a>
                <a href="javascript:void(0)" id="last" class="pages">尾页</a>
            </div>
        </div>


        <div class="picnews">
            <ul>
                <li><a href="#"><img src="Images/Picture1.jpg" width="249" alt=""/> </a><a
                        href="#">伦敦骚乱情景堪比二战空袭</a>
                </li>
                <li><a href="#"><img src="Images/Picture2.jpg" width="249" alt=""/> </a><a href="#">故事：贫困生的大学梦</a>
                </li>
                <li><a href="#"><img src="Images/Picture3.jpg" width="249" alt=""/> </a><a
                        href="#">北京暴雨地铁13号线中断</a>
                </li>
                <li><a href="#"><img src="Images/Picture4.jpg" width="249" alt=""/> </a><a
                        href="#">斯杯决赛宝贝争与球员合影</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="friend">
    <h1 class="friend_t"><img src="Images/friend_ico.gif" alt="合作伙伴"/></h1>
    <div class="friend_list">
        <ul class="onLine">
            当前在线用户：<br/>
            <c:forEach items="${onlineUsers}" var="u">
                ${u.uName}
            </c:forEach>
        </ul>
    </div>
</div>
<div id="footer">
    <p class=""> 24小时客户服务热线：010-88888888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160;
        新闻热线：010-888888888 <br/></p>
    <p class="copyright"> Copyright &copy; 1999-2010 News China gov, All Right Reserver <br/>
        新闻中心 版权所有 </p>
</div>

<script type="text/javascript">

    //ajax用户登陆，但是不刷新页面
    function ajaxFun() {
        $.ajax({
            type: "POST",                          //传数据的方式
            url: "IndexServlet",                   //servlet地址
            data: $('#form').serialize(),            //传的数据  form表单 里面的数据
            success: function (result) {//传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
                if ($.isEmptyObject(JSON.parse(result))) {
                    alert("输入错误");
                } else {
                    jQuery.each(JSON.parse(result), function (i, item) {

                        $uName = item.uName;
                        $("#form").html("<input type='button' value=" + $uName + "><a onclick='loginout()'>注销</a>     <div class=\"sou\" style=\"display: inline-block;\">\n" +
                            "                    <input type=\"text\" size=\"30\" id=\"serch\" class=\"serch_text\" oninput=\"serchS()\" onfocus=\"get_text()\" onblur=\"setTimeout('lose_text()','200')\">\n" +
                            "                    <div class=\"serches\" ></div>\n" +
                            "                </div>\n" +
                            "             <input type=\"button\" name=\"search\" value=\"搜索\" >");
                        $(".onLine").append($uName);
                    });

                }
                // stringify()用于从一个对象解析出字符串
                // jsonData = JSON.stringify(result);

                // JSON.parse用于从一个字符串中解析出json对象
                // 利用each遍历json数组，i代表下标，item代表该对象
                // alert(result);
                // jQuery.each(JSON.parse(result), function (i, item) {
                //
                //     $("#results").val(item.tTitle);
                // });

            }
        });
    }

    function serchS() {
        let serchStr = document.getElementById("serch").value;
        $.ajax({
            type: "POST",                          //传数据的方式
            url: "LikeAllNewsServlet?",                   //servlet地址
            data: {
                name: serchStr
            },            //传的数据  form表单 里面的数据
            success: function (result) {//传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
                let serchs = JSON.parse(result);
                $.each(serchs, function (j, val) {
                    $(".serches").html("");
                    $.each(serchs[j], function (i, val) {
                        console.log(val);
                        let $tTitle = val.tTitle;
                        let $tId = val.tId;

                        $(".serches").css({
                            "display": "block"
                        })
                        $(".serches").append("<a  onmouseenter='addClass(this)' onmouseleave='removeClass(this)'  href='detailTopic.jsp?tid=" + $tId + "'>" + $tTitle + "</a>");
                    })
                })

            }
        });
    }

    function addClass(obj) {
        obj.classList.add("on");

        $("#serch").val(obj.innerText);
    }


    function removeClass(obj) {
        obj.classList.remove("on");
    }

    function get_text() {
        $(".serches").css({
            "display": "block"
        })
    }

    function lose_text() {
        $(".serches").css({
            "display": "none"
        })
    }


    function loginout() {
        $("#form").html("  <input type=\"text\" id=\"uname\" value=\"\" class=\"login_input\" name=\"uname\"/>\n" +
            "            <label> 密&#160;&#160;码 </label>\n" +
            "            <input type=\"password\" id=\"upwd\" value=\"\" class=\"login_input\" name=\"upwd\"/>\n" +
            "            <input type=\"button\" class=\"login_sub\" value=\"登录\" onclick=\"ajaxFun()\"/>\n" +
            "            <a href=\"register.html\">注册</a>");

    }

    //遍历后台的list
    //国内新闻

    let ZNews;
    $(document).ready(function () {


        $.ajax({
            type: "post",
            url: "ReadServlet",
            async: true,
            data: {},
            success: function (data)//成功取回数据之后的回调函数
            {

                let news = JSON.parse(data);
                //国内新闻
                let GNNews = news[0];
                $.each(GNNews, function (i, val) {
                    let $tId = val.tId;
                    let $tTitle = val.tTitle;
                    $(".GNNews").append("<li><a href='detailTopic.jsp?tid=" + $tId + "'><b>" + $tTitle + "</b></a></li>");
                });


                //国际新闻
                let GJNews = news[1];
                $.each(GJNews, function (i, val) {
                    let $tId = val.tId;
                    let $tTitle = val.tTitle;
                    $(".GJNews").append("<li><a href='detailTopic.jsp?tid=" + $tId + "'><b>" + $tTitle + "</b></a></li>");
                });

                //娱乐新闻
                let YLNews = news[2];
                $.each(YLNews, function (i, val) {
                    let $tId = val.tId;
                    let $tTitle = val.tTitle;
                    $(".YLNews").append("<li><a href='detailTopic.jsp?tid=" + $tId + "'><b>" + $tTitle + "</b></a></li>");
                })

                ZNews = news[3];


                let laypage = layui.laypage;
                let PageSize = 20;
                laypage.render({
                    elem: 'demoPage'
                    , count: ZNews.length
                    , first: '首页'
                    , last: '尾页'
                    , layout: [
                        'count'
                        , 'prev'
                        , 'page'
                        , 'next'
                        , 'limit'
                        , 'refresh'
                        , 'skip'
                    ]

                    // ,prev: '<em>←</em>'
                    // ,next: '<em>→</em>'
                    , limit: PageSize
                    , jump: function (obj) {
                        //模拟渲染
                        document.getElementsByClassName('classlist')[0].innerHTML = function () {
                            let arr = []
                                , thisData = ZNews.concat().splice(obj.curr * obj.limit - obj.limit, obj.limit);
                            layui.each(thisData, function (index, item) {
                                arr.push("<li><a href='detailTopic.jsp?tid=" + item.tId + "'>" + item.tTitle + "</a><span>" + item.pTime + "</span></li>");
                            });
                            return arr.join('');
                        }();
                    }
                });


                let pTotal = Math.ceil(ZNews.length / PageSize) + 1;
                for (let i = 1; i < pTotal; i++) {
                    let $a = "&nbsp;&nbsp;<a class='pName'>" + i + "</a>&nbsp;&nbsp;";
                    $(".pageName").append($a);
                }

                let index = 1;
                contextShow(index);


                $(".pageName").on("click", '.pName', function () {
                    $index = $(event.target).html();
                    contextShow($index);
                })
                //  for (let i = news.length-1; i >= news.length - 3; i--) {
                //新闻中心


                //}


                // jQuery.each(JSON.parse(data), function (i, item) {
                //
                //     $uName = item.context;
                //     alert($uName);
                //     //$("#form").html("<input type='button' value="+$uName+">");
                //     // $("#form").remove()
                // });
                // for (var i = 0; i < data.length; i++) {
                //     var array_element = data[i];
                //
                // }
                // alert("传回的数据是:"+array_element);
            },
            error: function ()//没能取回数据之后的回调函数
            {
                alert("请求失败！");
            }
        })

        let index;
        $(".nextPage").click(function () {
            index = $(".index").html();
            Pagetatol = $(".Pagetatol").html();
            if (index < Pagetatol) {
                index++;
            }
            $(".index").html(index);
            contextShow(index);
        });

        $(".proPage").click(function () {
            index = $(".index").html();
            Pagetatol = $(".Pagetatol").html();
            if (index > 1) {
                index--;
            }
            $(".index").html(index);
            contextShow(index);
        });

        $(".firstPage").click(function () {
            contextShow(1);
        })


        $(".lastPage").click(function () {
            index = $(".Pagetatol").html();
            $(".index").html(index);
            contextShow(index);
        })


        function contextShow(index) {
            let PageSize = 20;
            let Pagetatol = Math.ceil(ZNews.length / PageSize);
            $(".pageINdex").html("当前页数:[<span class='index'>" + index + "</span>/<span class='Pagetatol'>" + Pagetatol + "</span>]");
            $(".pageName a").each(function (i) {
                $(".pageName a").eq(i).removeClass("on");
            })
            $(".pageName a").eq(index - 1).addClass("on");

            $(".classlist").html("");
            for (let i = PageSize * (index - 1); i < PageSize * index; i++) {
                let $tId = ZNews[i].tId;
                let $tTitle = ZNews[i].tTitle;
                $(".classlist").prepend("<li><a href='detailTopic.jsp?tid=" + $tId + "'>" + $tTitle + "</a><span>" + ZNews[i].pTime + "</span></li>");
                if (i % 5 == 0) {
                    $(".classlist").prepend("<li class='space'></li>");
                }
            }


        }


        //模糊搜索分页

        let currPage     //当前页
            , tPages,         //总页数

            getTopicList = function (curr) {
                $.ajax({
                    type: "POST"
                    , url: "GetNewsServlet"
                    , dataType: "JSON"
                    , data: {
                        pageSize: 20
                        , pageNum: curr || 1
                        , title: $("#serch").val()
                    }
                    , success: function (data) {

                        

                        $(".classlist").find("li").remove();
                        $.each(data.NewsList, function (index, obj) {
                            $(".classlist").prepend("<li><a href='detailTopic.jsp?tid=" + obj.tId + "'>" + obj.tTitle + "</a><span>" + obj.pTime + "</span></li>");
                        });


                        ;currPage = data.pageNum;
                        tPages = data.totalPages;
                        fn(tPages);
                    }
                })


            }

        getTopicList();

        function fn() {
            if ($(".pageNum").html() == '') {
                for (let i = 1; i <= tPages; i++) {
                    let $a = "&nbsp;&nbsp;<a class='pNum'>" + i + "</a>&nbsp;&nbsp;";
                    $(".pageNum").append($a);
                }
            }
        }

        $(".JsonPage").on("click", ".pages", function () {
            $index = $(event.target).html();
            if ($index == "首页") {
                currPage = 1;
            } else if ($index == "下一页") {
                currPage++;
                if (currPage > tPages) {
                    currPage = tPages;
                }
            } else if ($index == "上一页") {
                currPage--;
                if (currPage == 0) {
                    currPage = 1;
                }
            } else if ($index == "尾页") {
                getTopicList(tPages);
            }

        })

        $(".JsonPage").on("click", ".pNum", function () {
            $index = $(event.target).html() * 1;
            currPage = $index;
            getTopicList(currPage);
        })


        $(".class_date").on("click", function () {
            getTopicList();
        })


    })


</script>
</body>

</html>