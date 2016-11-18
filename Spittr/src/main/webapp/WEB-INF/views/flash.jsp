<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/14
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!-- Spring的 Jsp库-->
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!-- Spring的 通用标签库-->
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>
<style type="text/css">

</style>
<body>
<h1>Register</h1>

<h1>测试Flash</h1>
<form method="POST"  >
    First Name:<input type="text" name="firstName"/> <br/>
    Last Name:<input  type="text" name="lastName"/> <br/>
    Username:<input type="text" name="username"/><br/>
    Password:
    <input type="password" name="password"/>
    <br/>
    <input type="submit" value="Register">
</form>

</body>
</html>
