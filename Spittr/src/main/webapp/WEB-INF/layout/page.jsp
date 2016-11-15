<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/15/2016
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<html>
<head>
    <title>Page</title>
    <style type="text/css">

        #header {
            width: 100%;
            text-align: center;
            height: 10%;
        }

        #content {
            width: 100%;
            height: 80%;
            text-align: center;
        }

        #footer {
            width: 100%;
            text-align: center;
            height: 10%;
        }
    </style>
</head>
<body>
<div id="header">
    <!-- 插入头部-->
    <t:insertAttribute name="header"></t:insertAttribute>
</div>

<div id="content">
    <!-- 插入主题内容-->
    <t:insertAttribute name="body"></t:insertAttribute>
</div>

<div id="footer">
    <!-- 插入尾部-->
    <t:insertAttribute name="footer"></t:insertAttribute>
</div>

</body>
</html>
