<%--
  Created by IntelliJ IDEA.
  User: 11841
  Date: 2019/4/20
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
    <form action="/user/updateOne">
        <ul>
            <li><input type="text" name="id" value="${user.id}"></li>
            <li><input type="text" name="username" value="${user.username}"></li>
            <li><input type="text" name="password" value="${user.password}"></li>
            <li><input type="text" name="sex" value="${user.sex}"></li>
            <li><input type="submit" value="修改"></li>
        </ul>
    </form>
</body>
</html>
