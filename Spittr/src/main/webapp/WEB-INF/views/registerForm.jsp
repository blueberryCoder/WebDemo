<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/14
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spittr</title>
</head>
<style type="text/css">

</style>
<body>
<h1>Register</h1>

<sf:form method="POST" commandName="spitter">
    First Name:<sf:input   path="firstName"/> <sf:errors path="firstName" cssClass="error"></sf:errors><br/>
    Last Name:<sf:input  path="lastName"/> <sf:errors path="lastName" cssClass="error"></sf:errors><br/>
    Username:<sf:input path="username"/><sf:errors path="username" cssClass="error"/><br/>
    Password:<sf:password path="password"/><sf:errors path="password" cssClass="error"></sf:errors><br/>
    <input type="submit" value="Register">
</sf:form>
</body>
</html>
