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

<sf:form method="POST" commandName="spitter">
    First Name:<sf:input path="firstName"/> <sf:errors path="firstName" cssClass="error"></sf:errors><br/>
    Last Name:<sf:input path="lastName"/> <sf:errors path="lastName" cssClass="error"></sf:errors><br/>
    Username:<sf:input path="username"/><sf:errors path="username" cssClass="error"/><br/>
    Password:<sf:password path="password"/><sf:errors path="password" cssClass="error"></sf:errors><br/>
    <input type="submit" value="Register">
</sf:form>

<s:escapeBody htmlEscape="true">
    <h1>这是一个h1标签</h1>
</s:escapeBody>

<br/>

<a href="<s:url value="{username}" >
    <s:param name="username" value="username-url" ></s:param>
    </s:url>">点击返回username-url</a>
<br/>
<s:message code="spitter.message" ></s:message>

</body>
</html>
