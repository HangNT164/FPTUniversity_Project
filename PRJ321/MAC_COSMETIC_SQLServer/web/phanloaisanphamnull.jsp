<%-- 
    Document   : phanloaisanpham.jsp
    Created on : Aug 29, 2019, 1:59:30 AM
    Author     : HangNT
--%>

<%@page import="dao.CategoryDao"%>
<%@page import="entity.Category"%>
<%@page import="dao.SubCateDao"%>
<%@page import="entity.SubCate"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <link href="css/sanphambanchay.css" rel="stylesheet">
        <link href="css/sanphamfilter.css" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 
        <!-- Title -->
        <title>Phân Loại Sản Phẩm | M·A·C Cosmetics | VIỆT NAM </title>
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

        <!-- Content -->
        <div class="container" style="margin-top:8%;">
            <div class="row">
                <div class="col-lg-3 col-xl-3 col-md-4 col-sm-6">
                    <div class="card">
                        <div class="card-header"><a href="filter-product-detail?subID=0" ><b> LỌC SẢN PHẨM</b></a>
                        </div>
                        <c:forEach items="${listCate}" var="category" varStatus="i">   
                            <!-- Card 1 -->
                            <div class="card-body">
                                <b>${i.count}. ${category.categoryName}</b><br />
                                <ul style="margin-left:18%;">
                                    <c:forEach items="${listSub}" var="subCate">  
                                        <c:choose> 
                                            <c:when test="${category.id eq subCate.categoryId}">
                                                <li><a href="filter-product-detail?subID=${subCate.id}">
                                                        ${subCate.subCateName}
                                                    </a>
                                                </li>
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>
                                </ul>
                            </div>
                            <!-- /.Card 1 -->
                        </c:forEach>
                    </div>
                </div>
                <!-- Product -->
                <div class="col-lg-9 col-xl-9 col-md-8 col-sm-6">
                    <!-- Row 1 -->
                    <div class="row">
                        <p>Not found</p>
                    </div>
                    <!-- /.Row 1 -->
                    <br />
                </div>
                <!-- /.Product -->
            </div>
            <!-- Next  -->
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link"
                                             href="#">1</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">2</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
            <!-- /.Next  -->
        </div>
        <!-- /.Content -->

        <hr class="mb-5">
       <%@include file="component/footer.jsp" %>
    </body>

</html>