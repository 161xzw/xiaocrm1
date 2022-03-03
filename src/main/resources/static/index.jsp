<%--
  Created by IntelliJ IDEA.
  User: QY
  Date: 2020-11-21
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery3.js"></script>
    <script>
        //页面加载
        $(function () {
            $("#btn").click(function (){
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"saleChance/findAll",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"北榛","password":"123456"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data服务器响应的json数据，进行解析
                            alert(data.msg)
                            alert(data.code)
                            alert(data.count)
                    }
                })
            })
        })
    </script>
</head>
<body>
    <a href="saleChance/findAll">查询营销机会信息</a>

    <h3>测试包</h3>

    <a href="html/frame.html">首页</a>
    <button id="btn">发送ajax请求</button>
</body>
</html>
