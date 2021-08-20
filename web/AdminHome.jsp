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
    <link rel="stylesheet" href="assests/admin.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>
<body class="body">
<div class="box-2">
    <%@include file="assests/img/support-team.svg" %>
</div>
<div style="display: flex;flex-direction: column">
    <h1 class="welcome-txt">welcome Admin Home page</h1>
    <p style="color: gray;font-size: 14px">be enjoy & welcome again</p>
    <div style="display: flex;flex-direction: row;justify-content: space-around">
        <a id="log-out" href="#popup1" name="log-out" type="button" style="list-style: none;color: blue; text-decoration:none;font-size: 15px">Admin Sign Up</a>
        <a id="addNewPage" href="#popup2" name="addNewPage" type="button" style="list-style: none;color: blue; text-decoration:none;font-size: 15px">Add Page</a>
        <a id="setRoles" href="#popup3" name="setRoles" type="button" style="list-style: none;color: blue; text-decoration:none;font-size: 15px">user roles</a>
        <a id="addRole" href="#popup4" name="addRole" type="button" style="list-style: none;color: blue; text-decoration:none;font-size: 15px">new roles</a>
    </div>
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
<div id="popup2" class="overlay">
    <div class="popup">
        <h2>Add Page</h2>
        <a class="close" href="#">&times;</a>
        <div class="content-page">
            <div>
                <input type="text" placeholder="Page Name" class="input-user" name="pageName" id="pageName" >
                <span class="underline"></span>
            </div>
            <div>
                <input type="text" placeholder="description" class="input-user" name="des" id="des" >
                <span class="underline"></span>
            </div>


                <button  type="submit" class="btnSignin" id="addPage" name="addPage" >add page</button>

        </div>
    </div>
</div>

<div id="popup3" class="overlay">
    <div class="popup">
        <h2>Manage User roles</h2>
        <a class="close" href="#">&times;</a>
        <br>
        <div class="content-role">

                <div style="height: 50px;display: flex;flex-direction: row">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            Select Page
                        </button>
                        <ul class="dropdown-menu" id="pageCombo" aria-labelledby="dropdownMenuButton1" style="cursor: pointer">
                        </ul>
                    </div>
                    <hr>
                    <div class="dropdown" style="padding-left: 100px">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="false">
                            Select role
                        </button>
                        <ul class="dropdown-menu" id="roleCombo" aria-labelledby="dropdownMenuButton1" style="cursor: pointer">
                        </ul>
                    </div>


                </div>

                <div style="flex-direction: row;justify-content: space-between; display: flex;">
                    <label id="lblPageName" style="padding: 20px">page</label>
                    <label  id="lblRole"  style="padding: 20px">email</label>
                </div>

                <div style="display:flex;height: 100px;justify-content: center;align-items: center;padding-top: 50px">
                    <button  type="submit" class="btnSignin" id="setUserRole" name="setUserRole" >set user-role</button>
                </div>



        </div>
    </div>
</div>
<div id="popup4" class="overlay">
    <div class="popup">
        <h2>new user role</h2>
        <a class="close" href="#">&times;</a>
        <div class="content-new-role">
            <div>
                <input type="text" placeholder="add new role" class="input-user" name="txtnewRole" id="txtnewRole" >
                <span class="underline"></span>
            </div>

            <div class="input-box-3">
                <button  type="submit" class="btnSignin" id="btnAddRole" name="btnAddRole" >add role</button>
            </div>
        </div>
    </div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
    $("#btnAddRole").click(function (){
        let role = $("#txtnewRole").val();
        console.log(role)
        $.ajax({
            url: '/LoginSystem/newrole',
            method: 'POST',
            async: true,
            contentType: "application/json",
            data:JSON.stringify({
                "role":role,
            }),
            success: function (response,textState, xhr) {
                alert("success")
            }
        });
    })

    window.onload=(function (){
        // $('#tblRegistration').pageMe({pagerSelector:'#pagination',showPrevNext:true,hidePageNumbers:false,perPage:2});
        loadPages();
        loadUserRole();

    })

    function loadPages(){
        $.ajax({
            url: '/LoginSystem/pages',
            method: 'GET',
            async: true,
            dataType: "json",
            contentType:"application/json",
            success: function (response,textState, xhr) {
                console.log(response)
                for (var i=0; i<response.length; i++) {
                    var pages=response[i].pageName; // catch pageName and add it pages
                    console.log(pages)
                    var row = $(`<option id="selectedPage">`+pages+`</option>`) // set pageName to option
                    $("#pageCombo").append(row); // need add to comboBox to option
                }
            }
        });
    }

    $("#pageCombo").click(function (evt){
        $("#lblPageName").text($(evt.target).closest("option").text());
    })

    function loadUserRole(){
        $.ajax({
            url: '/LoginSystem/newrole',
            method: 'GET',
            async: true,
            dataType: "json",
            contentType:"application/json",
            success: function (response,textState, xhr) {
                console.log(response)
                for (var i=0; i<response.length; i++) {
                    var roles=response[i].role; // catch pageName and add it pages
                    console.log(roles)
                    var row = $(`<option id="selectedRole">`+roles+`</option>`) // set pageName to option
                    $("#roleCombo").append(row); // need add to comboBox to option
                }
            }
        });
    }

    $("#roleCombo").click(function (evt){
        $("#lblRole").text($(evt.target).closest("option").text());
    });

    $("#setUserRole").click(function (){
        let pageName = $("#lblPageName").text();
        let role = $("#lblRole").text();
        $.ajax({
            url: '/LoginSystem/roles',
            method: 'POST',
            async: true,
            contentType:"application/json",
            data:JSON.stringify({
                "pageName":pageName,
                "role":role,
            }),
            success: function (response,textState, xhr) {
              alert("success")
            }
        });
    })

    $("#addPage").click(function (){
        let pageName = $("#pageName").val();
        let des = $("#des").val();
        $.ajax({
            url: '/LoginSystem/pages',
            method: 'POST',
            async: true,
            data: {
                "pageName":pageName,
                "des":des,
            },
            dataType: "json",
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                    alert(" success")

                }else{
                    alert("wrong!!")
                }
            },

        });

    });

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
        var role = "Admin";
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

<script src="assests/js/validation.js"></script>
</body>
</html>
