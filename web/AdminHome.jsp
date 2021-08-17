<%--
  Created by IntelliJ IDEA.
  User: Hasintha
  Date: 8/12/2021
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Home</title>
    <link rel="stylesheet" href="assests/style.css">
</head>
<body class="body">
<div class="box-2">
    <%@include file="assests/img/support-team.svg" %>
</div>
<div style="display: flex;flex-direction: column">
    <h1 class="welcome-txt">welcome Admin Home page</h1>
    <p style="color: gray;font-size: 14px">be enjoy & welcome again</p>
    <a id="log-out" href="#popup1" name="log-out" type="button" style="color: #333333;font-size: 20px">Admin Sign Up</a>
    <br>
    <br>
    <div style="display: flex;flex-direction: row;justify-content: space-around">
        <button  type="submit" class="btnSignin" id="view" name="view" >View & edit</button>
        <button  type="submit" class="btnSignin" id="logout" name="logout" >Log Out</button>
    </div>

</div>

<div id="popup1" class="overlay">
    <div class="popup">
        <h2>Sign up here</h2>
        <a class="close" href="#">&times;</a>
        <div class="content">
            <div>
                <input type="text" placeholder="user name" class="input-user" name="userName" id="userName" required="">
                <span class="underline"></span>
            </div>
            <div>
                <input type="text" placeholder="e mail" class="input-user" name="email" id="email" required="">
                <span class="underline"></span>
            </div>
            <div>
                <input type="text" placeholder="address" class="input-user" name="address" id="address" required="">
                <span class="underline"></span>
            </div>
            <div>
                <input type="text" placeholder="contact" class="input-user" name="phone" id="phone" required="">
                <span class="underline"></span>
            </div>
            <div>
                <input type="text" placeholder="password" class="input-user" name="password" id="password" required="">
                <span class="underline"></span>
            </div>

            <div class="input-box-3">
                <button  type="submit" class="btnSignin" id="signup" name="signup" >sign up</button>
            </div>
        </div>
    </div>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
    $("#logout").click(function (){
        window.location.href="index.jsp"
    });
    $("#view").click(function (){
        window.location.href="ViewRegistration.jsp"
    });
    $("#signup").click(function (){
        var email = $("#email").val();
        var userName = $("#userName").val();
        var address = $("#address").val();
        var contact = $("#phone").val();
        var password = $("#password").val();
        var role = "AdminHome.jsp";
        // var form = $("#signinForm").serialize();

        $.ajax({
            url: '/LoginSystem/signup',
            method: 'POST',
            async: true,
            data: {
                "email":email,
                "userName":userName,
                "address":address,
                "contact":contact,
                "password":password,
                "role":role,
            },
            dataType: "json",
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                   alert("register success")

                }else{
                    alert("wrong!!")
                }
            },

        });
    })
</script>
<script src="assests/js/validation.js"></script>
</body>
</html>
