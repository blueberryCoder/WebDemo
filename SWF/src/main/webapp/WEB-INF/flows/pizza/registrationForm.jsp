<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/21/2016
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>注册新用户</title>
</head>
<body>
<sf:form>
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
    <label>用户名:</label> <input type="text" name="username"> <br/>
    <label>地址:</label><input type="text" name="address"><br/>
    <label>电话号码:</label><input type="tel" name="phoneNumber"> <br/>
    <label>地区Code</label><input type="number" name="zipCode"> <br/>
    <input type="submit" name="_eventId_submit" value="Submit">
    <span>&nbsp;&nbsp;</span>
    <input type="submit" name="_eventId_cancel" value="Cancel">
</sf:form>
</body>
</html>
