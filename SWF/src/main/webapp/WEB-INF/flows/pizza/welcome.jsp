<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/21/2016
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome !!!</h1>


<sf:form>
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
    <input type="text" name="phoneNumber"> <br/>
    <!-- 触发 phoneEntered事件-->
    <input type="submit" name="_eventId_phoneEntered" value="Lookup Customer">
</sf:form>

</body>
</html>
