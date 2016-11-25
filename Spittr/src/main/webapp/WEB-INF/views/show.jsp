<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/25/2016
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Show</title>
</head>
<body>
<sec:accesscontrollist hasPermission="ROLE_SPITTER" domainObject="${null}">
<h1> accesscontrollist 标签 </h1>
</sec:accesscontrollist>

<sec:authentication property="principal.username" var="loginId" scope="request"/>
<sec:authentication property="details" var="details" scope="request"></sec:authentication>
<h1>loginId=${loginId}</h1>
<h1>${details}</h1>

<sec:authorize url="/show" access="isAuthenticated() and principal.username =='blueberry' ">
    <h1>只有blueberry能访问到这里，信不？</h1>
</sec:authorize>
</body>
</html>
