<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/18/2016
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<h1>上传文件</h1>

<form method="post"  enctype="multipart/form-data">
    <input type="file"  name="file" accept="image/jpeg,image/png">
    <button type="submit">提交</button>

</form>
</body>
</html>
