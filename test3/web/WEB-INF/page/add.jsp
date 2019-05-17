<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11841
  Date: 2019/4/18
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加用户</title>
</head>
<body>
    <div>
        <%--<form action="/user/db_add">--%>
        <form>
            <ul>
                <li>id：<input type="text" name="id" id="id"></li>
                <li>用户名：<input type="text" name="username" id="username"></li>
                <li>密码：<input type="password" name="password" id="password"></li>
                <li>sex性别性别：<input type="text" name="sex" id="sex"></li>
                <%--<input type="submit" value="添加">--%>
            </ul>
        </form>
    </div>

    <input type="button" value="检验" id="check">
    <input type="button" value="增加" id="add">
    <a>${s}</a>
    <c:if test="${s!=null}">
        ${s}
    </c:if>
    <c:if test="${s==null}">
        ${s}+null
    </c:if>

    <script src="../../static/resources/jquery-3.4.0.min.js"></script>
<script>
    $(document).ready(function () {

        $("#check").click(function() {
            $.ajax({
                url : "/user/checkIdWhetherExist",
                type : "POST",
                /*dataType:"text",*/
                dataType:"json",
                <!-- 向后端传输的数据 -->
                data : {id:$("#id").val()},
                success:function(result) {
                    alert("ID："+result.id+"已存在");
                },
                error:function(result){
                    alert("ID："+$("#id").val()+"可以使用");
                }
            });
        });

        $("#add").click(function () {
            $(window).attr("location","/user/db_add?" +
                "id="+$("#id").val()+
                "&username="+$("#username").val()+
                "&password="+$("#password").val()+
                "&sex="+$("#sex").val())
            /*window.location.href="/user/db_add?id="+$("#id").val()+"&username="+$("#username").val()+"&password="+$("#password").val()+"&sex="+$("#sex").val();*/
            /*window.location.href="/user/db_add?id=9929&username=1&password=1&sex=1";*/
        })

    })


</script>

</body>
</html>
