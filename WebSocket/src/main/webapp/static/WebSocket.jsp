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
    <title>WebSocket</title>
</head>
<body>
    <h1>测试WebSocket</h1>


    <script type="text/javascript">

        var url ="ws://"+window.location.host+'/websocket/marco';
        var socket = new WebSocket(url);


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
            socket.send('Marco')
        }
    </script>


    <button onclick="javascript:sayMarco()">点击测试</button>
</body>
</html>
