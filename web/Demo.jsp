<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

</head>
<body>
<H1 align="center">请输入两个字符串</H1>
<div align="center">
    <form id="form">
        first:<input type="text" name="first" id="first">
        second:<input type="text" name="second" id="second" oninput="ajaxFun()"><br>　　　　　//点击按钮的时候触发属性
        <button type="button" >button</button> //提交 按钮
    </form>
    <input type="text" id="results">
    // 用来 显示 result
</div>
<script src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    function ajaxFun(){
        $.ajax({
            type: "POST",                            //传数据的方式
            url: "DemoServlet",                   //servlet地址

            data: $('#form').serialize(),            //传的数据  form表单 里面的数据
            success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中

                // stringify()用于从一个对象解析出字符串
                // jsonData = JSON.stringify(result);

                // JSON.parse用于从一个字符串中解析出json对象
                // 利用each遍历json数组，i代表下标，item代表该对象
                jQuery.each(JSON.parse(result), function(i,item){

                       $("#results").val(item.tTitle);
                });
                // var summary = JSON.parse(jsonData);
                // // $("#results").val(person.summary.tTitle);
                // console.log(summary.tTitle);


                 // 找到输入框 并且将result的值 传进去

            }
        });
    }

</script>
</body>
</html>