<%-- 
    Document   : cuahang
    Created on : Sep 11, 2019, 2:00:00 PM
    Author     : HangNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link href="css/docthem1.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 
        <!-- Title -->
        <title>Cửa hàng M·A·C, Địa điểm M·A·C, Giờ mở cửa</title>
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

        <!--Carousel Wrapper-->
        <div id="carousel-example-1z" class="carousel slide carousel-fade" data-ride="carousel">
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active">
                    <div class="view"
                         style="background-image: url('img/img_cua_hang/cuahang.jpg'); 
                         background-repeat: no-repeat; background-size: cover;">
                        <!-- Mask & flexbox options-->
                        <div class="mask rgba-black-light d-flex justify-content-center align-items-center">

                            <!-- Content -->
                            <div class="text-center white-text mx-5 wow fadeIn">
                                <h2><b><strong style="font-size:35px;">
                                            <fmt:message key="timcuahang.timcuahangmac"/>
                                        </strong></b></h2>
                                <!-- Example split danger button -->
                                <div class="btn-group">
                                    <button type="button" class="btn btn-outline-white">THÀNH PHỐ</button>
                                    <button type="button"
                                            class="btn btn-outline-white dropdown-toggle dropdown-toggle-split"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="#">HÀ NỘI</a>
                                        <a class="dropdown-item" href="#">HỒ CHÍ MINH</a>
                                    </div>
                                </div>
                                <a target="_blank" 
                                   href="timkiem.jsp" class="btn btn-outline-white btn">Tìm kiếm
                                </a>
                            </div>
                            <!-- Content -->
                        </div>
                        <!-- Mask & flexbox options-->

                    </div>
                </div>
            </div>
        </div>
        <!--/.Carousel Wrapper-->

        <%@ include file="component/footer.jsp" %>

    </body>

</html>