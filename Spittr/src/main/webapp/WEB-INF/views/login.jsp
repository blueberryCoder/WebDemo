<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/24/2016
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>登陆</title>

    <style type="text/css">
        .errorMessage {
            color: red;
        }
    </style>
</head>
<body onload="document.getElementById('usernameInput').onfocus()">
<%--%>
    <%--StringBuffer sb = new StringBuffer();--%>
<%--Enumeration<String> attributeNames = request.getSession().getAttributeNames();--%>

<%--while (attributeNames.hasMoreElements()) {--%>
<%--String name = attributeNames.nextElement();--%>
<%--Object value = request.getSession().getAttribute(name);--%>
<%--sb.append("{" + name + "=" + value + "}");--%>
<%--}--%>
<%--%>--%>

<%--<div>--%>
<%--<%=sb.toString()%>--%>
<%--</div>
<%----%>
<c:if test="${not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION'] }">

    <div class="errorMessage"> ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION']}</div>
</c:if>
<sf:form  method="post">
    用户名:<input id="usernameInput" type="text" name="username"><br/>
    密码 : <input type="password" name="password"><br/>

    <label>记住密码 </label><input type="checkbox" name="remember-me">
    <span>&nbsp;&nbsp;</span>
    <input type="submit" value="submit">
</sf:form>
</body>
</html>
