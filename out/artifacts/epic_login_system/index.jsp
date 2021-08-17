<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login System</title>
    <link rel="stylesheet" href="assests/style.css">
</head>
<body class="body">

        <div style="display: flex;flex-direction: column">
            <h1 style="font-size: 48px;color: #dc9044">welcome epic lanka <br> <spam style="color: #86bec0;font-size: 32px">login system</spam> </h1>
            <button type="button" class="btnSignin" id="goHome">Go Home</button>
        </div>

        <div class="home-box-2">
            <%@include file="assests/img/home-bg.svg" %>
        </div>


    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script>
        $("#goHome").click(function (){
            window.location.href="Signin.jsp";
        })
    </script>
</body>
</html>
