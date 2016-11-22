<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/22/2016
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>支付</title>
</head>
<body>
<sf:form commandName="paymentDetails">
    <sf:radiobuttons path="type" items="${paymentTypeLists}" delimiter="&lt;br/&gt"></sf:radiobuttons>
    <input type="submit" name="_eventId_paymentSubmitted" value="Submit">
    <input type="submit" name="_eventId_cancel" value="Cancel">
</sf:form>
</body>
</html>
