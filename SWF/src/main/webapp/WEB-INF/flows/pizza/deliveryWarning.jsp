<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/21/2016
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>是否接受上门取件?</h1>

<a href="${flowExecutionUrl}&_eventId=accept">Accept</a>
<span>&nbsp;&nbsp;</span >
<a href="${flowExecutionUrl}&_eventId=cancel">Cancel</a>
<%--<sf:form>--%>
    <%--<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">--%>
    <%--<input type="submit" name="_eventId_accept" value="Accept">--%>
    <%--<span>&nbsp;&nbsp;</span>--%>
    <%--<input type="submit" name="_eventId_cancel" value="Cancel">--%>
<%--</sf:form>--%>
</body>
</html>
