<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/12/2016
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stomp</title>
    <script src="<%=pageContext.getServletContext().getContextPath()%>/resources/webjars/sockjs.min.js"></script>
    <script src="<%=pageContext.getServletContext().getContextPath()%>/resources/webjars/stomp.js"></script>
    <script src="<%=pageContext.getServletContext().getContextPath()%>/resources/webjars/jquery-3.1.1.js"></script>
</head>
<body>
<h1>测试Stomp</h1>
<script type="text/javascript">
    var url = '<%=pageContext.getServletContext().getContextPath()%>/marcopolo';
    var sock = new SockJS(url);
    var stomp = Stomp.over(sock);

    var payload = JSON.stringify({'message': 'Marco!'});

    var error_callback = function (error) {
        console.error("error: " + error);
    }

    stomp.connect({}, function (frame) { //连接STOMP端点
        console.log('connect success. ');
        stomp.send("/app/marco", {}, payload);
        stomp.subscribe("/topic/marco", function (msg) {
            console.log('Received: ', JSON.parse(msg.body));
//            stomp.send("/app/marco", {}, payload);
        })
        stomp.subscribe("/topic/spitter", function (msg) {
            console.log('Received: ', JSON.parse(msg.body));
        });
        stomp.subscribe("/queue/errors", function (msg) {
            console.log('Error: ', JSON.parse(msg.body));
        });
    }, error_callback)

    //------------------------

    function send(code) {
        // 访问 /send
        $.ajax('http://localhost:8080<%=pageContext.getServletContext().getContextPath()%>/send');
    }

    function sendError() {
        stomp.send("/app/marco", {}, JSON.stringify({'message': 'error'}));
    }
</script>

<button onclick="send(1)"> 发送</button>
<button onclick="sendError()">发送错误信息</button>


</body>
</html>
