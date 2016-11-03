<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/1
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link href="../css/common.css" rel="stylesheet" type="text/css">
    <link href="../css/home/home.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../js/register.js"></script>
    <script type="text/javascript" src="../js/security.js"></script>
</head>
<body>

<script type="text/javascript">
    //请求加密
    loadSecurity2Cookie("../Security");
</script>

<s:if test="getActionErrors().size()>0">
    <s:iterator value="getActionErrors()" var="e">
        <a><s:property value="e"></s:property></a>
        <br/>
    </s:iterator>
</s:if>

<form action="${pageContext.request.contextPath}/user/register.action" method="POST" onsubmit="return checkRegisterForm(this)">
    <table>
        <tr>
            <td>
                <label>账号:</label>
            </td>
            <td>
                <input name="account" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <label>密码:</label>
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>
                <label>再次确认密码:</label>
            </td>
            <td>
                <input type="password" name="passwordAgain">
            </td>
        </tr>
        <tr>
            <s:submit value="确定"></s:submit>
        </tr>
    </table>
</form>
</body>
</html>
