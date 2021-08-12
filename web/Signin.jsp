<%--
  Created by IntelliJ IDEA.
  User: Hasintha
  Date: 8/11/2021
  Time: 7:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" href="assests/style.css">
</head>
<body class="body">

<%--*********left side box **********--%>
<div class=" box-1">
    <%--    this div is give the main idea about page and it style - (style.css - main idea boox style section)--%>
    <div class="input-box-1">
        <p class="main-txt">Hey! Are You New user ?<br><spam style="color: gray;font-size: 18px"> please be Sign up first </spam></p>
    </div>

<%--        send data to back end using form --%>
    <form id="signinForm" name="signinForm" action="signup" method="get" >
        <div class="input-box-2">

            <div class="input-box-sub">
                <h1 class="text" >Sign In</h1>
                <div>
                    <input type="email" placeholder="e mail" class="input-user" name="email" id="email"  required=""  >
                    <span class="underline"></span>
                </div>
                <div>
                    <input type="text" placeholder="pass word" class="input-user" id="password" name="password" required="" >
                    <span class="underline"></span>
                </div>

            </div>
        </div>
        <%--        button style section--%>
        <div class="input-box-3">
            <button form="signinForm" type="submit" class="btnSignin" id="signin" name="signin" >sign in</button>
            <a  class="btnRoute" id="routesignin" >sign up</a>
        </div>

    </form>
</div>

<%--*********img box style*******--%>
<div class="box-2">
    <%@include file="assests/img/support-team.svg" %>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
    // $("#signin").click(function (){
    //     var email = $("#email").val();
    //     var password = $("#password").val();
    //
    //     $.ajax({
    //         url: '/LoginSystem/signup',
    //         method: 'GET',//go to doGet method
    //         async: true,
    //         data: {"email":email,"password":password},//json data
    //         dataType: "json",// convert response into JSON if valid
    //         success: function (response,textState, xhr) {
    //             console.log(textState)
    //             console.log(xhr)
    //             console.log(response.operation);
    //             if (response.operation==="success"){
    //                 window.location.href="Home.jsp"
    //             }else{
    //                 window.location.href="Signin.jsp";
    //                 alert("something is error")
    //             }
    //
    //         },
    //
    //     });
    // });


    $("#routesignin").click(function (){
        window.location.href="Signup.jsp";
    });

</script>
<script src="assests/js/validation.js"></script>
</body>
</html>
