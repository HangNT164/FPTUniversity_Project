<%-- 
    Document   : cardproduct
    Created on : Sep 9, 2019, 7:44:47 PM
    Author     : HangNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  

<!DOCTYPE html>
<html lang="en">

    <head>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
        <link href="css/tatcasanpham.css" rel="stylesheet">
        <link href="css/hangdoi.css" rel="stylesheet">
        <link href="css/sanphambanchay.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Robonto&display=swap" rel="stylesheet">
        <link rel="icon" href="http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico"
              type="image/x-icon">
        <!-- Title -->
        <title>Mua sắm | M·A·C Cosmetics | VIỆT NAM </title>
        <style type="text/css">
            @media (min-width: 800px) and (max-width: 850px) {
                .navbar:not(.top-nav-collapse) {
                    background: #1C2331 !important;
                }
            }
        </style>
    </head>

    <body>

        <%@include file="component/header.jsp" %>

        <!-- Gio hang -->
        <div class="container" style="margin-top:8%;">
            <p style="text-align: left;"><b>   
                    <fmt:message key="giohang"/>
                </b>(${sessionScope.listCard.size()}                
                <fmt:message key="giohang.sanpham"/>
                )</p>
        </div>
        <br />
        <div class="container" style="background-color:whitesmoke;"><br />
            <div class="row">
                <div class="col-xl-3 col-lg-3 col-md-3">
                    <p style="text-align: center;font-size:20px;"><b>       
                            <fmt:message key="product"/>
                        </b></p>
                </div>
                <div class="col-xl-3 col-lg-3 col-md-3">
                    <p style="text-align: center;font-size:20px;"><b>       
                            <fmt:message key="price"/>
                        </b></p>            
                </div>
                <div class="col-xl-3 col-lg-3 col-md-3">
                    <p style="text-align: center;font-size:20px;"><b>       
                            <fmt:message key="quantity"/>
                        </b></p>            
                </div>
                <div class="col-xl-3 col-lg-3 col-md-3">
                    <p style="text-align: center;font-size:20px;"><b>       
                            <fmt:message key="amount"/>
                        </b></p>          
                </div>

            </div>    
        </div>
        <br/>
        <div class="container" style="background-color:whitesmoke;"><br />
            <c:forEach items="${sessionScope.listCard}" var="cardProduct" varStatus="i">   
                <div class="row">
                    <div class="col-xl-3 col-lg-3 col-md-3">
                        <div class="media">
                            <img src="${cardProduct.imageLink}" class="mr-3" style="width:40%;">
                            <div class="media-body">
                                <h5 class="mt-0">${cardProduct.productName}</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-3 col-md-3">
                        <p style="text-align: center;padding-top:50px;">  
                            <c:if test="${language eq 'vi_VN'}">
                                <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                  value="${cardProduct.sellPrice}"/>
                            </c:if>   
                            <c:if test="${language eq 'en_US'}">
                                <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                  value="${cardProduct.changePriceToUS}"/>
                            </c:if>   
                            <c:if test="${language eq 'ja_JP'}">
                                <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                  value="${cardProduct.changePriceToJa}"/>
                            </c:if>   
                        </p>
                    </div>
                    <div class="col-xl-3 col-lg-3 col-md-3">
                        <br />
                        <p style="text-align: center;padding-top:26px;">          
                            ${cardProduct.quantity}
                        </p>
                    </div>
                    <div class="col-xl-3 col-lg-3 col-md-3">
                        <p style="text-align: center;padding-top:50px;">
                            <c:if test="${language eq 'vi_VN'}">
                                <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                  value="${cardProduct.totalPrice}"/>
                            </c:if>   
                            <c:if test="${language eq 'en_US'}">
                                <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                  value="${cardProduct.changeTotalPriceToUS}"/>
                            </c:if>  
                            <c:if test="${language eq 'ja_JP'}">
                                <fmt:formatNumber type="currency" maxFractionDigits="0" 
                                                  value="${cardProduct.changeTotalPriceToJa}"/>
                            </c:if>  
                        </p>
                    </div>
                </div>                      
                <br /><br />
                <span style="display:none">
                    ${totalPriceAll=totalPriceAll+cardProduct.totalPrice}
                </span>
            </c:forEach>
        </div>
        <!-- /.Gio Hang -->

        <br /><br />
        <!-- Tong tien -->
        <div class="container">      
            <p style="text-align: right;">
                <fmt:message key="giohang.tongtien"/>
                ( ${sessionScope.listCard.size()}      
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
            <p><b style="font-size:25px;">Thông tin khách hàng</b></p>
            <form action="check-out" id="2">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Name</label>
                        <input type="text" class="form-control" 
                               placeholder="Name"name="Name"
                               value="${sessionScope.user.name}">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Mobile</label>
                        <input type="text" class="form-control" 
                               placeholder="Mobile"name="Mobile"
                               value="${sessionScope.user.mobile}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputAddress">Address</label>
                    <input type="text" class="form-control" 
                           placeholder="Address"name="Address"
                           value="${sessionScope.user.address}">
                </div>
                <div class="form-group">
                    <label for="inputNote">Note</label>
                    <input type="text" class="form-control" 
                           placeholder="Note"name="Note">
                </div>
                <div class="form-group">
                    <label for="inputPayment">Payment</label>
                    <input type="text" class="form-control" 
                           placeholder="Payment"name="Payment">
                </div>
                <br/><br/>
                <p style="text-align: right;">
                    <input type="submit" value="Xác nhận" />
                </p>
            </form>
        </div>
        <!--Tong tien-->
        <%@include file="component/footer.jsp" %>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

        <!-- Main navigation -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/muahang.js"></script>  
    </body>

</html>