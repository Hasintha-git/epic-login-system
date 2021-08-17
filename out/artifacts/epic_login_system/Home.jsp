<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="assests/style.css">
</head>
<body class="body">
<div class="box-2">
    <%@include file="assests/img/support-team.svg" %>
</div>
<div style="display: flex;flex-direction: column">
    <h1 class="welcome-txt">welcome Home page</h1>
    <p style="color: gray;font-size: 14px">be enjoy & welcome again</p>
    <button class="btnSignin" id="log-out" name="log-out" type="button">Log out</button>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
    $("#log-out").click(function (){
        window.location.href="index.jsp";
    })
</script>

</body>
</html>
