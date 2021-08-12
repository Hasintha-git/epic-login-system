<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" href="assests/style.css">
</head>
<body class="body">

<%--*********left side box **********--%>
<div class=" box-1">
    <form id="signinForm">
<%--    this div is give the main idea about page and it style - (style.css - main idea boox style section)--%>
    <div class="input-box-1">
        <p class="main-txt">Hey! Are You old user ?<br><spam style="color: gray;font-size: 18px"> please be Sign in & enjoy </spam></p>
    </div>


        <div class="input-box-2">
<%--            input field - this style by style.css- input field style--%>
            <div class="input-box-sub-up">
                <h1 class="text" >Sign Up</h1>
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


            </div>
        </div>

<%--        button style section--%>
        <div class="input-box-3">
            <button type="button" class="btnSignin" id="signup" >sign up</button>
            <a  class="btnRoute" id="routesignin" >sign in</a>
        </div>
    </form>
<%-- ***form--%>
</div>

<%--*********img box style*******--%>
<div class="box-2">
    <%@include file="assests/img/support-team.svg" %>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
    $("#signup").click(function (){
        var form = $("#signinForm").serialize();
        $.ajax({
            url: '/LoginSystem/signup',
            method: 'POST',
            async: true,
            data: form,
            dataType: "json",
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                    window.location.href="Signin.jsp.jsp"
                }else{
                    window.location.href="Signup.jsp";
                    alert("something is error")
                }
            },

        });
    });

    $("#routesignin").click(function (){
        window.location.href="Signin.jsp";
    });


</script>
<script src="assests/js/validation.js"></script>
</body>
</html>
