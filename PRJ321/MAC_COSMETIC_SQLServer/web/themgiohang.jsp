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
        <title>Giỏ Hàng | M·A·C Cosmetics | VIỆT NAM </title>
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
        <c:if test="${sessionScope.user ne null}">
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
                    <div class="col-xl-4 col-lg-4 col-md-4">
                        <p style="text-align: center;font-size:20px;"><b>       
                                <fmt:message key="product"/>
                            </b></p>
                    </div>
                    <div class="col-xl-2 col-lg-2 col-md-2">
                        <p style="text-align: center;font-size:20px;"><b>       
                                <fmt:message key="price"/>
                            </b></p>            
                    </div>
                    <div class="col-xl-2 col-lg-2 col-md-2">
                        <p style="text-align: center;font-size:20px;"><b>       
                                <fmt:message key="quantity"/>
                            </b></p>            
                    </div>
                    <div class="col-xl-2 col-lg-2 col-md-2">
                        <p style="text-align: center;font-size:20px;"><b>       
                                <fmt:message key="amount"/>
                            </b></p>          
                    </div>
                    <div class="col-xl-2 col-lg-2 col-md-2">
                        <p style="text-align: center;font-size:20px;"><b>       
                                <fmt:message key="remove"/>
                            </b></p>           
                    </div>
                </div>    
            </div>
            <br/>

            <div class="container" style="background-color:whitesmoke;"><br />
                <c:set scope="page" var="totalPrice" value="0" />

                <c:forEach items="${sessionScope.listCard}" var="cardProduct" varStatus="i">   
                    <div class="row">
                        <div class="col-xl-4 col-lg-4 col-md-4">
                            <div class="media">
                                <img src="${cardProduct.imageLink}" class="mr-3" style="width:40%;">
                                <div class="media-body">
                                    <h5 class="mt-0">${cardProduct.productName}</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-2 col-lg-2 col-md-2">
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
                        <div class="col-xl-2 col-lg-2 col-md-2"style="padding-left:5%;padding-top:2%;">
                            <br />
                            <form action="add-cart?action=update" name="${cardProduct.id}">
                                <select name="quantity" 
                                        onchange="document.forms.namedItem(${cardProduct.id}).submit()">
                                    <c:forEach var="i" begin="1" end="${cardProduct.productQuantity}" step="1">
                                        <option value="${i}"
                                                ${i == cardProduct.quantity?"selected":""}>
                                            ${i}
                                        </option>
                                    </c:forEach>
                                </select>
                                <input type="hidden" value="${cardProduct.id}" name="id"/>
                                <input type="hidden" value="update" name="action"/>
                            </form>

                        </div>
                        <div class="col-xl-2 col-lg-2 col-md-2">
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
                        <div class="col-xl-2 col-lg-2 col-md-2">
                            <a href="remove-cart?id=${cardProduct.id}"
                               onclick="return confirm('Do you want to remove product?')">
                                <p style="text-align: center;padding-top:50px;">  
                                    <img src="https://img.icons8.com/windows/32/000000/delete-forever.png">
                                </p>
                            </a>
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
                <a href="remove-cart?id=0"    
                   onclick="return confirm('Do you want to remove all product?')">
                    <p style="text-align: right;">     
                        <fmt:message key="giohang.xoatatca"/>
                    </p>
                </a>
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
            </p>
            <p style="text-align: right;">
                <a href="muahang.jsp">           
                    <button type="button" class="btn btn-warning btn-sm">       
                        <fmt:message key="giohang.muahang"/>
                    </button>
                </a>
            </p>

        </div>
        <!--Tong tien-->
        <br /><br /><br /><br /><br /><br /><br /><br /><br /><br />

    </c:if>
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
</body>

</html>