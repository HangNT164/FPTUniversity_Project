<%-- 
    Document   : index2.jsp
    Created on : Aug 27, 2019, 6:33:17 PM
    Author     : HangNT
--%>

<%@page import="java.util.Random"%>
<%@page import="dao.ImageDao"%>
<%@page import="entity.Image"%>
<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%@page import="entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <link href="css/sanphambanchay.css" rel="stylesheet">
        <link href="css/sanphamfilter.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 
        <title>Tìm sản phẩm | M·A·C Cosmetics | VIỆT NAM </title>
        <style type="text/css">
            @media (min-width: 800px) and (max-width: 850px) {
                .navbar:not(.top-nav-collapse) {
                    background: #1C2331 !important;
                }
            }
        </style>
    </head>

    <body>
        <%@ include file="component/header.jsp" %>
        <!-- Full Page Intro -->
        <div class="view" style="background-image: url('img/img_home/PrepPrime.jpg'); 
             background-repeat: no-repeat; background-size: cover;height:80%;">

            <!-- Mask & flexbox options-->
            <div class="mask rgba-black-light d-flex justify-content-center align-items-center">

                <!-- Content -->
                <div class="text-center white-text mx-5 wow fadeIn">
                    <h1 style="color:white;font-size:60px;"><b><strong>Tìm sản phẩm</strong>
                        </b></h1>
                </div>
                <!-- Content -->
            </div>
            <!-- Mask & flexbox options-->
        </div>
        <!-- Full Page Intro -->
        <div class="container" style="margin-top:2%;">

            <!-- Row 1 -->
            <div class="row">
                <c:forEach items="${listProductInAPage}" var="product" varStatus="i"> 
                    <div class="col-lg-4 col-md-4 col-sm-6 ">
                        <div class="card"style="background-color: white;height:90%;">
                            <div class="image-box"style="height:320px;">                            
                                <a href="product-detail?id=${product.id}">
                                    <img src="${listImageTrue.get(i.count-1)}"title="${product.productName}" class="card-img-top">
                                </a>
                            </div>
                            <!-- Card Body -->
                            <div class="card-body">
                                <p class="card-title"style="text-align: center;">${product.productName}</p>
                                <p class="card-text"style="text-align: center;font-size: 15px;"> Price:                         
                                    <c:if test="${language eq 'vi_VN'}">
                                        <fmt:formatNumber type="currency" 
                                                          maxFractionDigits="3" 
                                                          value="${product.priceNew}"/> 
                                    </c:if>   
                                    <c:if test="${language eq 'en_US'}">
                                        <fmt:formatNumber type="currency"
                                                          maxFractionDigits="0"
                                                          value="${product.changeNewPriceToUS}"/> 
                                    </c:if>   
                                    <c:if test="${language eq 'ja_JP'}">
                                        <fmt:formatNumber type="currency"
                                                          maxFractionDigits="0"
                                                          value="${product.changeNewPriceToJa}"/> 
                                    </c:if>   
                                </p>
                                <div style="text-align: center"> <span>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                    </span>
                                    <small>0 REVIEWS</small>
                                </div>
                                <div style="text-align: center;"> <a
                                        href="add-card?id=${product.id}"
                                        class="btn btn-outline-dark btn-lg">THÊM GIỎ HÀNG
                                    </a></div>
                            </div>
                            <!-- /.Card body -->
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- /.Row 1 -->
        </div>

        <hr class="mb-5">

        <%@ include file="component/footer.jsp" %>
    </body>

</html>