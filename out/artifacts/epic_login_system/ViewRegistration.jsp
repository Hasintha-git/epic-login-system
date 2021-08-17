<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Hasintha
  Date: 8/12/2021
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration View</title>
    <link rel="stylesheet" href="assests/admin.css">
    <link rel="stylesheet" href="assests/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body class="admin-body">

<div class="admin-nav-box">
    <button class="btnSignin" id="back" name="back" type="button">back</button>
    <button class="btnSignin" id="loadAll" name="loadAll" type="button">load all</button>
<%--    <button class="btnSignin" id="loadData" name="loadData" type="button">Load data</button>--%>
    <div style="display: flex;justify-content: center">
        <input type="text" class="input-user" id="search" placeholder="enter name and click enter">
    </div>

</div>

<div  style="align-items: center;display: flex;height: 80vh;flex-direction: column">
    <div class="col-md-8">
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>email</th>
                <th>userName</th>
                <th>Address</th>
                <th>Contact</th>
                <th>Password</th>
                <th>Role</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody id="tblRegistration" style="color: #333333;cursor: pointer;">
            </tbody>
        </table>
    </div>

    <div id="popup1" class="overlay">
        <div class="popup">
            <h2>Update Admin</h2>
            <a class="close" href="#">&times;</a>
            <div class="content">
                <div>
                    <input type="text"  placeholder="user name" class="input-user" name="userName" id="userName" required="">
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
                    <button  type="submit" class="btnSignin" id="update" name="update" >Update</button>
                </div>
            </div>
        </div>
    </div>

    <div id="deleteRow" class="overlay">
        <div class="popup">
            <h2>Confirm Delete</h2>
            <a class="close" href="#">&times;</a>
            <div class="content-2">
                <div class="input-box-3">
                    <div style="display: flex;flex-direction: row;justify-content: space-between">
                        <button  type="submit" class="btnSignin" id="delete" name="delete" >remove</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<a href="RegistrationDetails">view employees</a>--%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
    $("#loadAll").click(function (){
        loadData();
    })
    window.onload=(function (){
        loadData();
    })


    function loadData(){
        $("#tblRegistration").empty();
        $.ajax({
            url: '/LoginSystem/loadData',
            method: 'GET',
            async: true,
            dataType: "json",
            contentType:"application/json",
            success: function (response,textState, xhr) {
                // console.log(response)
                // console.log(textState)
                // console.log(xhr)
                // $("#tblRegistration").remove();

                for (var i=0; i<response.length; i++) {
                    <%--var row = `<tr><td>${cus.email}</td><td>${cus.userName}</td><td>${cus.address}</td><td>${cus.contact}</td><td>${cus.password}</td><td>${cus.role}</td></tr>`;--%>
                    var row = $('<tr><td id="mail">' + response[i].email+ '</td><td>' + response[i].userName + '</td><td>' + response[i].address + '</td><td>' + response[i].contact + '</td><td>' + response[i].password + '</td><td>' + response[i].role + '</td>' +
                        '<td><a id="up" href="#popup1">Update</a></td><td><a href="#deleteRow">Delete</a></td></tr>');
                    $("#tblRegistration").append(row);

                }

            }

        });
    }
    //
    $("#back").click(function (){
        window.location.href="AdminHome.jsp";
    })
    let rowSelectRole;
    let deleteMail;
    $("#tblRegistration").click(function (evt){
        let email = $(evt.target).closest("tr").children('td:eq(0)').text();
        let userName = $(evt.target).closest("tr").children('td:eq(1)').text();
        let adress = $(evt.target).closest("tr").children('td:eq(2)').text();
        let contact = $(evt.target).closest("tr").children('td:eq(3)').text();
        let  password= $(evt.target).closest("tr").children('td:eq(4)').text();
        let role = $(evt.target).closest("tr").children('td:eq(5)').text();

        $("#email").val(email)
        $("#userName").val(userName)
        $("#address").val(adress)
        $("#phone").val(contact)
        $("#password").val(password)
        rowSelectRole=role;
        deleteMail=email;
    })
    $("#update").click(function (){
        var email = $("#email").val();
        var userName = $("#userName").val();
        var address = $("#address").val();
        var contact = $("#phone").val();
        var password = $("#password").val();
        var newRole = rowSelectRole;

        alert(email)
        $.ajax({
            url: '/LoginSystem/details',
            type: 'PUT',
            async: true,
            contentType: "application/json",
            data:JSON.stringify( {
                email:email,
                userName:userName,
                address:address,
                contact:contact,
                password:password,
                role:newRole,
            }),
            success: function (response,textState, xhr) {
                alert("success")
            },

        });
    })

    var allData=null;
    var Name=/^[A-Z]{1}[a-z]{1,9}$/;
    $("#search").on("keydown",function (e){
        var input=(e.key);
        let inputName=$('#search').val();
        if (Name.test(inputName)){
            if (input=="Enter"){
                $("#tblRegistration").empty();
                $.ajax({
                            url: '/LoginSystem/details',
                            method: 'GET',//go to doGet method
                            async: true,
                            data: {"userName":inputName},//json data
                            dataType: "json",// convert response into JSON if valid
                            success: function (response,textState, xhr) {
                                allData=response;
                                if($("#tblRegistration").empty()){
                                    for (var i=0; i<response.length; i++) {
                                        <%--var row = `<tr><td>${cus.email}</td><td>${cus.userName}</td><td>${cus.address}</td><td>${cus.contact}</td><td>${cus.password}</td><td>${cus.role}</td></tr>`;--%>
                                        var row = $('<tr><td id="mail">' + response[i].email+ '</td><td>' + response[i].userName + '</td><td>' + response[i].address + '</td><td>' + response[i].contact + '</td><td>' + response[i].password + '</td><td>' + response[i].role + '</td>' +
                                            '<td><a id="up" href="#popup1">Update</a></td><td><a href="#deleteRow">Delete</a></td></tr>');
                                        $("#tblRegistration").append(row);

                                    }
                                }

                            },

                        });
            }
        }
    })

    $("#delete").click(function (){
        $.ajax({
            url: '/LoginSystem/details',
            method: 'DELETE',
            async: true,
            data: JSON.stringify({
                email:deleteMail
            }),
            contentType: "application/json",
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                    alert("updated")
                }else{

                    alert("something is error")
                }
            },

        });
    })
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>
