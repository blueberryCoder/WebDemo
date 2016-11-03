<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/3
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆</title>
    <link href="../css/common.css" rel="stylesheet" type="text/css">
    <link href="../css/home/home.css" rel="stylesheet" type="text/css">
    <script src="../js/login.js" type="text/javascript"></script>

</head>
<body>

<%
    String rootPath = pageContext.getServletContext().getContextPath();
%>

<div class="container">
    <div class="content">
        <form class="login_form" action="<%=rootPath%>/user/login.action" method="post" onsubmit="return checkForm(this)">
            <label>账户: </label><input type="text" name="account"><br/>
            <label>密码: </label><input type="password" name="password"><br/>
            <label>类型: </label><input type="radio" name="type" value="1">普通用户
            <input type="radio" name="type" value="0">管理员<br/>
            <button type="submit">确定</button>
            <a href="${pageContext.request.contextPath}/user/register.action">注册</a>
        </form>
    </div>
</div>
</body>
</html>
