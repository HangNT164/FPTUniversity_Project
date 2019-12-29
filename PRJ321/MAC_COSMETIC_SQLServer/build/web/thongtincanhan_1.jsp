<%-- 
    Document   : thongtincanhan
    Created on : Oct 13, 2019, 5:02:54 PM
    Author     : HangNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/thongtincanhan.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">

        <!-- Material Design Bootstrap -->
        <link href="css/mdb.min.css" rel="stylesheet">

        <!-- Your custom styles (optional) -->
        <link href="css/style.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/chitietsanpham.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 

        <!-- Title -->
        <title>M·A·C Cosmetics | VIỆT NAM | Thông tin tài khoản</title>
    </head>
    <body>
        <%@ include file="component/header.jsp"%>

        <div class="container emp-profile">
            <div class="row">
                <div class="col-md-4">
                    <div class="profile-img">
                        <img src="${sessionScope.avataAccount.imageLink}"class="mr-3"style="border-radius: 50%;">
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
                        <li class="nav-item"style="padding-left: 10%;">
                            <a class="nav-link" id="cart-tab" 
                               data-toggle="tab" href="#orderInProgress" 
                               role="tab" aria-controls="orderInProgress"
                               aria-selected="false">Order in progress</a>
                        </li>

                        <li class="nav-item"style="padding-left: 10%;">
                            <a class="nav-link" id="cart-tab" 
                               data-toggle="tab" href="#orderTransported" 
                               role="tab" aria-controls="orderTransported"
                               aria-selected="false">Order Transported</a>
                        </li>
                        <li class="nav-item"style="padding-left: 10%;">
                            <a class="nav-link" id="cart-tab" 
                               data-toggle="tab" href="#boughtcart" 
                               role="tab" aria-controls="boughtcart"
                               aria-selected="false">Bought Cart</a>
                        </li>
                        <li class="nav-item"style="padding-left: 10%;">
                            <a class="nav-link" id="cart-tab" 
                               data-toggle="tab" href="#deleteAccount" 
                               role="tab" aria-controls="deleteAccount"
                               aria-selected="false">Delete account</a>
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
                            <h5>New Password must dulicate with old password</h5>

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

                        <!--Dang Xu Li-->
                        <div class="tab-pane fade" id="orderInProgress" 
                             role="tabpanel" aria-labelledby="orderInProgress-tab">
                            <c:choose>
                                <c:when test="${empty listCardProcess}">
                                    <img src="img/img_home/cartprocessempty.png"style="width:50%;">
                                </c:when>
                                <c:otherwise>
                                    <div class="container" style="background-color:whitesmoke;"><br />
                                        <div class="row">
                                            <div class="col-xl-5 col-lg-5 col-md-5">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        <fmt:message key="product"/>
                                                    </b></p>
                                            </div>                                
                                            <div class="col-xl-2 col-lg-3 col-md-3">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        <fmt:message key="quantity"/>
                                                    </b></p>            
                                            </div>
                                            <div class="col-xl-2 col-lg-2 col-md-2">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        <fmt:message key="amount"/>
                                                    </b></p>          
                                            </div>
                                            <div class="col-xl-3 col-lg-3 col-md-3">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        Create Date
                                                    </b></p>          
                                            </div>
                                        </div>    
                                    </div>
                                    <br/>
                                    <div class="container" style="background-color:whitesmoke;"><br />
                                        <c:forEach items="${listCardProcess}" var="product" varStatus="i">   
                                            <div class="row">
                                                <div class="col-xl-5 col-lg-5 col-md-5">
                                                    <div class="media">
                                                        <img src="${product.imageLink}" class="mr-3" style="width:40%;">
                                                        <div class="media-body">
                                                            <h5 class="mt-0">${product.productName}</h5>
                                                        </div>
                                                    </div>
                                                </div>                                    
                                                <div class="col-xl-2 col-lg-2 col-md-2">
                                                    <br />
                                                    <p style="text-align: center;padding-top:26px;">          
                                                        ${product.quantity}
                                                    </p>
                                                </div>
                                                <div class="col-xl-2 col-lg-2 col-md-2">
                                                    <p style="text-align: center;padding-top:50px;">
                                                        <c:if test="${language eq 'vi_VN'}">
                                                            <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                                              value="${product.totalPrice}"/>
                                                        </c:if>   
                                                        <c:if test="${language eq 'en_US'}">
                                                            <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                                              value="${product.changeTotalPriceToUS}"/>
                                                        </c:if>  
                                                    </p>
                                                </div>
                                                <div class="col-xl-3 col-lg-3 col-md-3">
                                                    <br />
                                                    <p style="text-align: center;padding-top:26px;">          
                                                        ${product.createDate}
                                                    </p>
                                                </div>
                                            </div>                      
                                            <br /><br />
                                            <span style="display:none">
                                                ${totalPriceAll=totalPriceAll+product.totalPrice}
                                            </span>
                                        </c:forEach>
                                    </div>
                                    <!-- /.Gio Hang -->

                                    <br /><br />
                                    <!-- Tong tien -->
                                    <div class="container">      
                                        <p style="text-align: right;">
                                            <fmt:message key="giohang.tongtien"/>
                                            ( ${listCardProcess.size()}      
                                            <fmt:message key="giohang.sanpham"/>
                                            ):                       
                                            <c:if test="${language eq 'vi_VN'}">
                                                <fmt:formatNumber type="currency" maxFractionDigits="3" 
                                                                  value="${totalPriceAll}"/>
                                            </c:if>   
                                            <c:if test="${language eq 'en_US'}">
                                                <c:set var = "numberTotal" scope = "session" value = "${Math.round(totalPriceAll/23)}"/>
                                                <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                                  value="${numberTotal}"/>
                                            </c:if>  
                                        </p>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <!--/Dang xu li-->

                        <!--Dang van chuyen-->
                        <div class="tab-pane fade" id="orderTransported" 
                             role="tabpanel" aria-labelledby="orderTransported-tab">
                            <c:choose>
                                <c:when test="${empty listCardTrans}">
                                    <img src="img/img_home/cartdangvanchuyenempty.png"style="width:50%;">
                                </c:when>
                                <c:otherwise>
                                    <div class="container" style="background-color:whitesmoke;"><br />
                                        <div class="row">
                                            <div class="col-xl-5 col-lg-5 col-md-5">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        <fmt:message key="product"/>
                                                    </b></p>
                                            </div>                                
                                            <div class="col-xl-2 col-lg-3 col-md-3">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        <fmt:message key="quantity"/>
                                                    </b></p>            
                                            </div>
                                            <div class="col-xl-2 col-lg-2 col-md-2">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        <fmt:message key="amount"/>
                                                    </b></p>          
                                            </div>
                                            <div class="col-xl-3 col-lg-3 col-md-3">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        Create Date
                                                    </b></p>          
                                            </div>
                                        </div>   
                                    </div>
                                    <br/>
                                    <div class="container" style="background-color:whitesmoke;"><br />
                                        <c:forEach items="${listCardTrans}" var="product" varStatus="i">   
                                            <div class="row">
                                                <div class="col-xl-5 col-lg-5 col-md-5">
                                                    <div class="media">
                                                        <img src="${product.imageLink}" class="mr-3" style="width:40%;">
                                                        <div class="media-body">
                                                            <h5 class="mt-0">${product.productName}</h5>
                                                        </div>
                                                    </div>
                                                </div>                                    
                                                <div class="col-xl-2 col-lg-2 col-md-2">
                                                    <br />
                                                    <p style="text-align: center;padding-top:26px;">          
                                                        ${product.quantity}
                                                    </p>
                                                </div>
                                                <div class="col-xl-2 col-lg-2 col-md-2">
                                                    <p style="text-align: center;padding-top:50px;">
                                                        <c:if test="${language eq 'vi_VN'}">
                                                            <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                                              value="${product.totalPrice}"/>
                                                        </c:if>   
                                                        <c:if test="${language eq 'en_US'}">
                                                            <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                                              value="${product.changeTotalPriceToUS}"/>
                                                        </c:if>  
                                                    </p>
                                                </div>
                                                <div class="col-xl-3 col-lg-3 col-md-3">
                                                    <br />
                                                    <p style="text-align: center;padding-top:26px;">          
                                                        ${product.createDate}
                                                    </p>
                                                </div>
                                            </div>            
                                            <br /><br />
                                            <span style="display:none">
                                                ${totalPriceAll=totalPriceAll+product.totalPrice}
                                            </span>
                                        </c:forEach>
                                    </div>
                                    <!-- /.Gio Hang -->

                                    <br /><br />
                                    <!-- Tong tien -->
                                    <div class="container">      
                                        <p style="text-align: right;">
                                            <fmt:message key="giohang.tongtien"/>
                                            ( ${listCardTrans.size()}      
                                            <fmt:message key="giohang.sanpham"/>
                                            ):                       
                                            <c:if test="${language eq 'vi_VN'}">
                                                <fmt:formatNumber type="currency" maxFractionDigits="3" 
                                                                  value="${totalPriceAll}"/>
                                            </c:if>   
                                            <c:if test="${language eq 'en_US'}">
                                                <c:set var = "numberTotal" scope = "session" value = "${Math.round(totalPriceAll/23)}"/>
                                                <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                                  value="${numberTotal}"/>
                                            </c:if>  
                                        </p>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <!--/Dang van chuyen-->

                        <!--Mua thanh cong-->
                        <div class="tab-pane fade" id="boughtcart" 
                             role="tabpanel" aria-labelledby="boughtcart-tab">
                            <c:choose>
                                <c:when test="${empty listCardSuccess}">
                                    <img src="img/img_home/cartsucess.png"style="width:50%;">
                                </c:when>
                                <c:otherwise>
                                    <div class="container" style="background-color:whitesmoke;"><br />
                                        <div class="row">
                                            <div class="col-xl-5 col-lg-5 col-md-5">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        <fmt:message key="product"/>
                                                    </b></p>
                                            </div>                                
                                            <div class="col-xl-2 col-lg-3 col-md-3">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        <fmt:message key="quantity"/>
                                                    </b></p>            
                                            </div>
                                            <div class="col-xl-2 col-lg-2 col-md-2">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        <fmt:message key="amount"/>
                                                    </b></p>          
                                            </div>
                                            <div class="col-xl-3 col-lg-3 col-md-3">
                                                <p style="text-align: center;font-size:20px;"><b>       
                                                        Create Date
                                                    </b></p>          
                                            </div>
                                        </div>   
                                    </div>
                                    <br/>
                                    <div class="container" style="background-color:whitesmoke;"><br />
                                        <c:forEach items="${listCardSuccess}" var="product" varStatus="i">   
                                            <div class="row">
                                                <div class="col-xl-5 col-lg-5 col-md-5">
                                                    <div class="media">
                                                        <img src="${product.imageLink}" class="mr-3" style="width:40%;">
                                                        <div class="media-body">
                                                            <h5 class="mt-0">${product.productName}</h5>
                                                        </div>
                                                    </div>
                                                </div>                                    
                                                <div class="col-xl-2 col-lg-2 col-md-2">
                                                    <br />
                                                    <p style="text-align: center;padding-top:26px;">          
                                                        ${product.quantity}
                                                    </p>
                                                </div>
                                                <div class="col-xl-2 col-lg-2 col-md-2">
                                                    <p style="text-align: center;padding-top:50px;">
                                                        <c:if test="${language eq 'vi_VN'}">
                                                            <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                                              value="${product.totalPrice}"/>
                                                        </c:if>   
                                                        <c:if test="${language eq 'en_US'}">
                                                            <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                                              value="${product.changeTotalPriceToUS}"/>
                                                        </c:if>  
                                                    </p>
                                                </div>
                                                <div class="col-xl-3 col-lg-3 col-md-3">
                                                    <br />
                                                    <p style="text-align: center;padding-top:26px;">          
                                                        ${product.createDate}
                                                    </p>
                                                </div>
                                            </div>                   
                                            <br /><br />
                                            <span style="display:none">
                                                ${totalPriceAll=totalPriceAll+product.totalPrice}
                                            </span>
                                        </c:forEach>
                                    </div>
                                    <!-- /.Gio Hang -->

                                    <br /><br />
                                    <!-- Tong tien -->
                                    <div class="container">      
                                        <p style="text-align: right;">
                                            <fmt:message key="giohang.tongtien"/>
                                            ( ${listCardSuccess.size()}      
                                            <fmt:message key="giohang.sanpham"/>
                                            ):                       
                                            <c:if test="${language eq 'vi_VN'}">
                                                <fmt:formatNumber type="currency" maxFractionDigits="3" 
                                                                  value="${totalPriceAll}"/>
                                            </c:if>   
                                            <c:if test="${language eq 'en_US'}">
                                                <c:set var = "numberTotal" scope = "session" value = "${Math.round(totalPriceAll/23)}"/>
                                                <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                                  value="${numberTotal}"/>
                                            </c:if>  
                                        </p>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <!--/Mua Thanh cong-->

                        <!--Delete Account-->
                        <div class="tab-pane fade" id="deleteAccount" 
                             role="tabpanel" aria-labelledby="deleteAccount-tab">
                            <a href="remove-account?account_detail_id=${sessionScope.user.id}"
                               onclick="return confirm('Do you want to remove account?')">
                                <p style="text-align: center;padding-top:50px;">  
                                    <img src="img/img_home/removeAccount.png"style="width:50%;">
                                </p>
                            </a>
                        </div>
                        <!--/Delete Account-->
                    </div>
                </div>
            </div>
        </div>
        <hr class="mb-5">
        <%@ include file="component/footer.jsp" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/changeForm.js"></script>  
    </body>
</html>
