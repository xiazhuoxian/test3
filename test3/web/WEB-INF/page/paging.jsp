<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11841
  Date: 2019/4/27
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <input type="text" id="queryCondition">
        <input type="button" onclick="query()" value="搜索">
        <input type="button" onclick="reset()" value="重置">
        <input type="button" onclick="addUser()" value="增加">
        <table>
            <tr>
                <th>id</th>
                <th>用户名</th>
                <th>密码</th>
                <th>性别</th>
            </tr>
            <c:forEach var="user" items="${paging.userList}">
                <tr>
                    <td><input type="text" value="${user.id}"></td>
                    <td><input type="text" value="${user.username}"></td>
                    <td><input type="text" value="${user.password}"></td>
                    <td><input type="text" value="${user.sex}"></td>
                    <td><a href="/user/modify?id=${user.id}">修改</a></td>
                    <td><a href="/user/deleteUser?id=${user.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <span>第${paging.pageNumber}/${paging.totalPageCount}页</span>
        <a href="/user/paging?pageNumber=1&queryCondition=${paging.queryCondition}">首页</a>
        <a href="/user/paging?pageNumber=${paging.pageNumber-1}&queryCondition=${paging.queryCondition}" onclick="return checkIfFirstPage()">上一页</a>
        <a href="/user/paging?pageNumber=${paging.pageNumber+1}&queryCondition=${paging.queryCondition}" onclick="return checkIfLastPage()">下一页</a>
        <a href="/user/paging?pageNumber=${paging.totalPageCount}&queryCondition=${paging.queryCondition}">尾页</a>
        <input type="text" id="searchPage">
        <input type="button" onclick="turn()" value="跳转">
    </div>

<script>
    function query() {
        var queryCondition=document.getElementById("queryCondition").value;
        window.location.href="/user/paging?pageNumber=1&queryCondition="+queryCondition;
    }

    function reset() {
        window.location.href="/user/paging?pageNumber=1";
    }

    function addUser() {
        window.location.href="/user/addPage";
    }

    function checkIfFirstPage() {
        if(${paging.pageNumber>1}){
            return true;
        }
        alert("当前为第一页");
        return false;
    }
    function checkIfLastPage() {
        if(${paging.pageNumber<paging.totalPageCount}){
            return true;
        }
        alert("当前为最后一页");
        return false;
    }
    function turn() {
        var searchPage=document.getElementById("searchPage").value;
        if(searchPage==null||searchPage==""){
            alert("请输入要跳转的页数")
        }else if(searchPage>${paging.totalPageCount}){
            alert("请求跳转的页数大于总页数")
        }else {
            window.location.href="/user/paging?pageNumber="+searchPage+"&queryCondition=${paging.queryCondition}";
        }
    }
</script>
</body>
</html>
