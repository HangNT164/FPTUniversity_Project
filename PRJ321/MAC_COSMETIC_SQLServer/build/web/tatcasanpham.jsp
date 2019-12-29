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
        <link href="css/tatcasanpham.css" rel="stylesheet">
        <link href="css/sanphamfilter.css" rel="stylesheet">
        <link href="css/sanphambanchay.css" rel="stylesheet">

        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon">
        <!-- Title -->
        <title>M·A·C Cosmetics | VIỆT NAM | Tất cả sản phẩm</title>
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
        <!-- Full Page Intro -->
        <div class="view" style="background-image: url(img/img_login/login.jpg);
             background-position: center; background-repeat: no-repeat; background-size: cover; height:70%;">
        </div>
        <div class="container" style="margin-top:2%;">

            <!-- Row 1 -->
            <div class="row">
                <c:forEach items="${listProductInAPage}" var="product" varStatus="i">    
                    <div class="col-md-3 col-sm-6">
                        <div class="product-grid">
                            <div class="product-image"style="height:300px;">
                                <a href="product-detail?id=${product.id}">
                                    <img class="pic-1" src="${listImageTrue.get(i.count-1)}"title="${product.productName}">
                                    <img class="pic-2" src="${listImageFalse.get(i.count-1)}"title="${product.productName}"></a>
                                <ul class="social">
                                    <li><a href="#"
                                           data-tip="Quick View" data-toggle="modal" 
                                           data-target="#product_view-${i.count}">
                                            <i class="fa fa-search"></i></a></li>
                                    <li>
                                        <a href="add-card?id=${product.id}&flag=3" 
                                           data-tip="Add to Wishlist">
                                            <i class="fa fa-shopping-bag"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="add-card?id=${product.id}&flag=1"
                                           data-tip="Add To Card">
                                            <i class="fa fa-shopping-cart">                                           
                                            </i>
                                        </a>
                                    </li>
                                </ul>      
                                <span class="product-new-label">${product.displayStatus}</span>
                                <c:choose>
                                    <c:when test="${product.descriptionStatus>0}">
                                        <span class="product-discount-label">${product.descriptionStatus}%</span>
                                    </c:when>
                                </c:choose>
                            </div>
                            <ul class="rating"style="text-align: center;">
                                <li class="fa fa-star"></li>
                                <li class="fa fa-star"></li>
                                <li class="fa fa-star"></li>
                                <li class="fa fa-star"></li>
                                <li class="fa fa-star disable"></li>
                            </ul>
                            <div class="product-content"style="text-align: center;">
                                <h3 class="title"><a href="#">${product.productName}</a></h3>
                                    <c:choose>
                                        <c:when test="${product.comparePrice==0}">
                                        <div class="price">
                                            <c:if test="${language eq 'vi_VN'}">
                                                <fmt:formatNumber type="currency"
                                                                  maxFractionDigits="2"
                                                                  value="${product.sellPrice}"/> 
                                            </c:if>   
                                            <c:if test="${language eq 'en_US'}">
                                                <fmt:formatNumber type="currency"
                                                                  maxFractionDigits="0"
                                                                  value="${product.changeOldPriceToUS}"/> 
                                            </c:if>   
                                            <c:if test="${language eq 'ja_JP'}">
                                                <fmt:formatNumber type="currency"
                                                                  maxFractionDigits="0"
                                                                  value="${product.changeOldPriceToJa}"/> 
                                            </c:if>   
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="price"> 
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
                                            <span>
                                                <c:if test="${language eq 'vi_VN'}">
                                                    <fmt:formatNumber type="currency"
                                                                      maxFractionDigits="2"
                                                                      value="${product.sellPrice}"/> 
                                                </c:if>   
                                                <c:if test="${language eq 'en_US'}">
                                                    <fmt:formatNumber type="currency"
                                                                      maxFractionDigits="0"
                                                                      value="${product.changeOldPriceToUS}"/> 
                                                </c:if>   
                                                <c:if test="${language eq 'ja_JP'}">
                                                    <fmt:formatNumber type="currency"
                                                                      maxFractionDigits="0"
                                                                      value="${product.changeOldPriceToJa}"/> 
                                                </c:if>   
                                            </span>
                                        </div>
                                    </c:otherwise>
                                </c:choose>                             
                            </div>
                        </div>                                
                        <br /><br />
                    </div>      
                    <div class="modal fade product_view" id="product_view-${i.count}">
                        <div class="modal-dialog">
                            <div class="modal-content">                   
                                <div class="modal-body">
                                    <div class="card" style="background-color: white;">
                                        <div class="row">
                                            <div class="col-6 col-md-6 col-xl-6">
                                                <img class="pic-1" src="${listImageTrue.get(i.count-1)}">
                                                <br/>
                                            </div>
                                            <div class=" col-6 col-md-6 col-xl-6">
                                                <p style="text-align: left;" ><b>${product.productName}</b><br/><br/>
                                                    Mã :${product.productCode}
                                                </p>
                                                <p style="text-align: left;">${product.tileColor}</p>
                                                <p style="text-align: left;">Giá:
                                                    <c:if test="${language eq 'vi_VN'}">
                                                        <fmt:formatNumber type="currency"
                                                                          maxFractionDigits="2"
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
                                            </div>
                                        </div>
                                        <br/>
                                        <div class="row"style="margin-left:10%;">
                                            <a href="product-detail?id=${product.id}"> 
                                                <button class="btn btn-outline-dark btn-sm"type="button">See all detail</button> 
                                            </a>
                                            <a href="add-card?id=${product.id}&flag=1"> 
                                                <button class="btn btn-outline-dark btn-sm"type="button">Add to card</button> 
                                            </a> <a href="add-card?id=${product.id}&flag=3"> 
                                                <button class="btn btn-outline-dark btn-sm"type="button">Add to wishlist</button> 
                                            </a>
                                        </div>   
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <br /><br />
            </div>


            <!-- /.Row 1 -->
            <%String link = String.valueOf(request.getAttribute("linkPage"));%>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <%int linkTemp = Integer.valueOf(link);
                        if (linkTemp > 0) {%>

                    <li class="page-item" >
                        <a class="page-link" href="get-all-product?pageId=<%=link%>&language=${language}">Previous</a>
                    </li>
                    <%} else {%>
                    <li class="page-item disabled" >
                        <a class="page-link" href="get-all-product?pageId=<%=link%>&language=${language}">Previous</a>
                    </li>
                    <%}%>
                    <c:forEach items="${listPage}" var="page">    
                        <li class="page-item">
                            <a class="page-link"href="get-all-product?pageId=${page}&language=${language}">${page}</a>
                        </li>
                    </c:forEach>
                    <%String link1 = String.valueOf(request.getAttribute("linkPage1"));%>

                    <li class="page-item" >
                        <a class="page-link" href="get-all-product?pageId=<%=link1%>">Next</a>
                    </li>
                </ul>
            </nav>
        </div>

        <hr class="mb-5">

        <%@include file="component/footer.jsp" %>
    </body>

</html>
