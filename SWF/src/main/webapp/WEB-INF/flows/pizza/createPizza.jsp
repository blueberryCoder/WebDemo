<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/22/2016
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>添加Pizza</title>
</head>
<body>
<sf:form commandName="pizza" acceptCharset="utf-8" >
    <sf:radiobutton path="size" label="Small(12-inch)" value="SMALL"/><br/>
    <sf:radiobutton path="size" label="Medium(14inch)" value="MEDIUM"/><br/>
    <sf:radiobutton path="size" label="Large(16-inch)" value="LARGE"/><br/>

    <br/><br/>
    <sf:checkboxes path="topping" items="${toppingsList}" delimiter="&lt;br/&gt;"
    />
    <br/><br/>
    <input type="submit" name="_eventId_addPizza" value="Continue">
    <input type="submit" name="_eventId_cancel" value="Cancel">
</sf:form>
</body>
</html>
