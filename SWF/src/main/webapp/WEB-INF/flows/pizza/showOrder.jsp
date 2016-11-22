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
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>显示订单</title>
</head>
<body>

    <h1>订单信息</h1>
    <h1>顾客姓名:${order.customer.username}</h1>
    <h1>披萨:</h1>
    <j:if test="${order.pizzas!=null && order.pizzas.size()>0}">
        <j:forEach items="${order.pizzas}" var="pizza">
            <h3>披萨:${pizza.size}英寸</h3> <span>&nbsp;&nbsp;</span>
            <h3>配料:
                <j:if test="${pizza.topping!=null && pizza.topping.size()>0}">
                    <j:forEach items="${pizza.topping}" var="topping">
                        ${topping}&nbsp;&nbsp;
                    </j:forEach>
                </j:if>
            </h3>
        </j:forEach>
    </j:if>

    <a href="${flowExecutionUrl}&_eventId=createPizza">创建Pizza</a>
    <br/>
    <a href="${flowExecutionUrl}&_eventId=checkOut">创建订单</a>
    <br/>
    <a href="${flowExecutionUrl}&_eventId=cancel">取消订单</a>
</body>
</html>
