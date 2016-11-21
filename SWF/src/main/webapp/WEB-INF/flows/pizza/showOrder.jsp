<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/21/2016
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="j" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>显示订单</title>
</head>
<body>

    <h1>订单信息</h1>
    <h1>顾客姓名:${flowScope.order.customer.username}</h1>
    <h1>披萨:</h1>
    <j:if test="${flowScope.order.pizzas!=null && flowScope.order.pizzas.size()>0}">
        <j:forEach items="${flowScope.order.pizzas}" var="pizza">
            <h3>披萨:${pizza.size}英寸</h3>
        </j:forEach>
    </j:if>

    <a href="${flowExecutionUrl}&_eventId=createPizza">创建Pizza</a>
    <br/>
    <a href="${flowExecutionUrl}&_eventId=orderCreated">创建订单</a>
    <br/>
    <a href="${flowExecutionUrl}&_eventId=cancel">取消订单</a>
</body>
</html>
