<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/27
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
    <h1>Spring Struts Hibernate</h1>

    <s:form action="/addCustomer">
        <s:textfield name="name" label="name"></s:textfield>
        <s:textfield name="address" label="address"></s:textfield>
        <s:submit></s:submit>
    </s:form>

    <s:if test="customerList.size()>0">
        <table>
            <tr>
                <th>Customer ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Create Date</th>
            </tr>

            <s:iterator value="customerList" status="userStatus">
                <tr>
                    <td><s:property value="customerId"></s:property></td>
                    <td><s:property value="name"></s:property></td>
                    <td><s:property value="address"></s:property></td>
                    <td><s:property value="createDate"></s:property></td>
                </tr>
            </s:iterator>
        </table>
    </s:if>
</body>
</html>
