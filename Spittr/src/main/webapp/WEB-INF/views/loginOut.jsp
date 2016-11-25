<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/25/2016
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>退出</title>
</head>
<body>
    <sf:form method="post" action="${pageContext.servletContext.contextPath}/signOut">
        <input type="submit" value="退出">
    </sf:form>

</body>
</html>
