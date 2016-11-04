<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/1
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>微博——首页</title>
    <link href="css/common.css" rel="stylesheet" type="text/css">
    <link href="css/home/home.css" rel="stylesheet" type="text/css">
    <script src="js/login.js" type="text/javascript"></script>
    <script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
    <script src="js/jsencrypt.min.js"></script>
    <script src="js/register.js" type="text/javascript"></script>
</head>
<body>

<h1><a href="login/login.jsp">登陆</a></h1>
<h1><a href="${pageContext.request.contextPath}/user/register.action">注册</a></h1>
<p id="encypted"></p>
<script type="text/javascript">

    var str = encypt('123456', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5A/' +
            'TPEmOQYgT2po11qvjeBUPEdqUEz1Z7MeHH7KI2p74pYK8RsvYngy1cH/wnMXmsf+Wb3tmlqNGa7atW8wlpSfXX' +
            'QV9bFECPEVRnESo8xtN7ZAlJFcdRvBVgfVwC3m9HWpVvKnd9NREXIcg5NHh57q7u' +
            'lsGCZJ2VOJm9EIgFEwIDAQAB');
    document.getElementById("encypted").innerHTML=''+str;
</script>
</body>
</html>
