<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/9/2016
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SocketJs</title>
    <script src="<%=pageContext.getServletContext().getContextPath()%>/resources/webjars/sockjs.min.js"></script>

</head>
<body>


    <h1>测试SocketJs</h1>


    <script type="text/javascript">

        var url ="<%=pageContext.getServletContext().getContextPath()%>/socketJS";
        var socket = new SockJS(url);


        socket.onopen = function () {
          console.log('Opening');
        }

        socket.onmessage = function (e) {

            console.log('Received message: ',e.data);
            setTimeout(function () {
                sayMarco();
            },2000);
        }

        socket.onclose = function () {
            console.log("Closing");
        }

        function sayMarco() {
            console.log('Sending Marco!');
            socket.send('i am client')
        }
    </script>


    <button onclick="javascript:sayMarco()">点击测试</button>
</body>
</html>
