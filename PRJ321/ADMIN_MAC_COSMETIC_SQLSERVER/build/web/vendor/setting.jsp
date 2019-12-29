<%-- 
    Document   : setting
    Created on : Nov 3, 2019, 2:01:38 AM
    Author     : HangNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Font Awesome CSS -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="assetss/css/bootstrap/bootstrap.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="assetss/css/mnd/common.css">
        <link rel="stylesheet" href="assetss/css/mnd/materials.css">
        <link rel="stylesheet" href="assetss/css/mnd/tables.css">

        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!--title-->
        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
        <title>Admin|Mac Cosmetic|VietName| Setting</title>
    </head>

    <body id="page-top">
        <%@include file="component/header.jsp" %>
        <!-- Start wrapper -->
        <div id="wrapper" >
            <!-- Sidebar -->
            <%@include file="component/menu.jsp" %>

            <div id="content-wrapper">
                <!-- Navbar -->
                <div class="container-fluid">
                    <div class="container emp-profile">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="profile-img">
                                    <img src="${sessionScope.avataAccount.imageLink}"class="mr-3">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="profile-head"><br/><br/><br/>
                                    <h5>
                                        Welcome ${sessionScope.user.name}
                                    </h5>

                                </div>
                            </div>
                            <div class="col-md-2">
                                <a href="logout"> 
                                    <button type="button" class="btn btn-outline-dark"style="width:80%;
                                            border-radius: 16px;">
                                        Logout</button></a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <ul class="nav  flex-column">
                                    <li class="nav-item"style="padding-left: 10%;">
                                        <a class="nav-link active" id="home-tab" 
                                           data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                                    </li>
                                    <li class="nav-item"style="padding-left: 10%;">
                                        <a class="nav-link" id="profile-tab" 
                                           data-toggle="tab" href="#profile" 
                                           role="tab" aria-controls="profile"
                                           aria-selected="false">Update</a>
                                    </li>
                                    <li class="nav-item"style="padding-left: 10%;">
                                        <a class="nav-link" id="changePass-tab"
                                           data-toggle="tab" href="#changePass" 
                                           role="tab" aria-controls="changePass" 
                                           aria-selected="false">Change Password</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-md-8">
                                <div class="tab-content profile-tab" id="myTabContent">
                                    <!--Home-->
                                    <div class="tab-pane fade show active" id="home" role="tabpanel"
                                         aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-3">
                                                <label>Name</label>
                                            </div>
                                            <div class="col-md-5">
                                                <p>${sessionScope.user.name}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-5">
                                                <p>${sessionScope.account.email}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">
                                                <label>Phone</label>
                                            </div>
                                            <div class="col-md-5">
                                                <p>${sessionScope.user.mobile}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">
                                                <label>Role</label>
                                            </div>
                                            <div class="col-md-5">
                                                <p>${sessionScope.account.roleName}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">
                                                <label>Create Date</label>
                                            </div>
                                            <div class="col-md-5">
                                                <p>${sessionScope.user.createDate}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">
                                                <label>Gender</label>
                                            </div>
                                            <div class="col-md-5">
                                                <p>${sessionScope.user.displayGender}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">
                                                <label>Address</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${sessionScope.user.address}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/Home-->

                                    <!--Update-->
                                    <div class="tab-pane fade" id="profile" role="tabpanel" 
                                         aria-labelledby="profile-tab">
                                        <form action="update-info" id ="registration">
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label for="inputEmail4">Name</label>
                                                    <input type="text" class="form-control" 
                                                           placeholder="Name"name="username"
                                                           value="${sessionScope.user.name}">
                                                </div>
                                                <div class="form-group col-md-6">
                                                    <label for="inputPassword4">Mobile</label>
                                                    <input type="text" class="form-control" 
                                                           placeholder="Mobile"name="mobile"
                                                           value="${sessionScope.user.mobile}">
                                                </div>
                                            </div>
                                            <div class="input-group form-group">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text"
                                                          style="background-color: white;
                                                          border-color: white;color:black;
                                                          padding-left: 0px;">
                                                        <label for="inputEmail">Gender</label></span>
                                                </div>
                                                <div style="color:black;padding:2%;"class = "gender"> 
                                                    <c:choose>
                                                        <c:when test="${sessionScope.user.gender==1}">
                                                            <input type="radio" name="gender" value="Male" class = "form-contorl"checked="checked"/>Male
                                                            <input type="radio" name="gender" value="Female" class = "form-contorl"/>Female 
                                                            <input type="radio" name="gender" value="Other" class = "form-contorl"/>Other
                                                        </c:when>
                                                        <c:when test="${sessionScope.user.gender==0}">
                                                            <input type="radio" name="gender" value="Male" class = "form-contorl"/>Male
                                                            <input type="radio" name="gender" value="Female" class = "form-contorl"checked="checked"/>Female 
                                                            <input type="radio" name="gender" value="Other" class = "form-contorl"/>Other                                            </c:when>
                                                        <c:otherwise>
                                                            <input type="radio" name="gender" value="Male" class = "form-contorl"/>Male
                                                            <input type="radio" name="gender" value="Female" class = "form-contorl"/>Female 
                                                            <input type="radio" name="gender" value="Other" class = "form-contorl"checked="checked"/>Other                                            </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputEmail">Email</label>
                                                <input type="email" class="form-control" 
                                                       placeholder="Email"name="email"
                                                       value="${sessionScope.account.email}">
                                            </div>
                                            <div class="form-group">
                                                <label for="inputAddress">Address</label>
                                                <input type="text" class="form-control" 
                                                       placeholder="Address"name="address"
                                                       value="${sessionScope.user.address}">
                                            </div>
                                            <br/>

                                            <!--<form action="change-avata">-->
                                            <input type="file" name="pic" accept="image/*">
                                            <!--</form>-->

                                            <p style="text-align: right;">
                                                <input type="submit" value="Update" />
                                            </p>
                                        </form>
                                    </div>
                                    <!--/Update-->

                                    <!--Change Password-->
                                    <div class="tab-pane fade" id="changePass" 
                                         role="tabpanel" aria-labelledby="changePass-tab">

                                        <form action="change-password"method="post"id="changePasswordID">
                                            <div class="form-group">
                                                <label for="inputPass">Old Password</label>
                                                <input type="password" class="form-control" 
                                                       placeholder="Old Password"name="oldpass">
                                            </div>
                                            <div class="form-group">
                                                <label for="inputNew">New Password</label>
                                                <input type="password" class="form-control" 
                                                       placeholder="New Password"name="newpass"id="password">
                                            </div>
                                            <div class="form-group">
                                                <label for="inputConfNew">Confirm new password</label>
                                                <input type="password" class="form-control" 
                                                       placeholder="Confirm New Password"name="cfnewpass">
                                            </div>
                                            <br/><br/>
                                            <p style="text-align: right;">
                                                <input type="submit" value="Update" />
                                            </p>
                                        </form>
                                    </div>
                                    <!--/ChangePassword-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript-->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="assetss/js/bootstrap/popper.min.js"></script>
        <script src="assetss/js/bootstrap/bootstrap.min.js"></script>
        <!-- Custom scripts for all pages-->
        <script src="assetss/js/mnd/mnd.min.js"></script>
        <!-- Data Tables -->
        <script src="assetss/js/datatables/jquery.dataTables.min.js"></script>
        <script src="assetss/js/datatables/datatables.vietnamese.js"></script>
        <script src="assetss/js/datatables/dataTables.bootstrap4.min.js"></script>
    </body>
</html>