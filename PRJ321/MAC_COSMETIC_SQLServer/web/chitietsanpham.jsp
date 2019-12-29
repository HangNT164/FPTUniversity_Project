<%-- 
    Document   : productdetail.jsp
    Created on : Aug 28, 2019, 2:09:04 PM
    Author     : HangNT
--%>

<%@page import="util.Validate"%>
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
        <link href="css/chitietsanpham.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 

        <!-- Title -->
        <title>M·A·C Cosmetics | VIỆT NAM | Chi tiết sản phẩm</title>
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

        <div class="container" style="margin-top:5%;">
            <div class="card" style="background-color: white;">
                <div class="row">
                    <div class="col-6 col-md-6 col-xl-6">
                        <c:forEach items="${listImage}" var="image" varStatus="i">    
                            <div class="mySlides">
                                <img src="${listImage.get(i.count-1).imageLink}" style="width:100%">
                            </div>
                        </c:forEach>
                        <br/>
                        <div class="row">
                            <c:forEach items="${listImage}" var="image" varStatus="i">    
                                <div class="col-3 col-md-3">
                                    <img class="demo cursor" src="${listImage.get(i.count-1).imageLink}" style="height: 80%;width:100%" 
                                         onclick="currentSlide(${i.count})">
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="details col-6 col-md-6 col-xl-6">
                        <h3 class="product-title">${productDetail.productName}</h3>
                        <div class="rating">
                            <div class="stars"> <span class="fa fa-star checked"></span> <span
                                    class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span
                                    class="fa fa-star"></span> <span class="fa fa-star"></span>
                            </div> <span class="review-no">123 đánh giá</span>
                        </div>
                        <p class="vote"><strong>91%</strong> of người mua hài lòng với sản phẩm này <strong>(87 bình
                                chọn)</strong>
                        </p>
                        <p>${productDetail.tileColor}</p>
                        <p class="product-description">Mã : ${productDetail.productCode}</p>

                        <p>Giá: 
                            <c:if test="${language eq 'vi_VN'}">
                                <fmt:formatNumber type="currency" 
                                                  maxFractionDigits="3" 
                                                  value="${productDetail.priceNew}"/> 
                            </c:if>   
                            <c:if test="${language eq 'en_US'}">
                                <fmt:formatNumber type="currency"
                                                  maxFractionDigits="0"
                                                  value="${productDetail.changeNewPriceToUS}"/> 
                            </c:if>   
                            <c:if test="${language eq 'ja_JP'}">
                                <fmt:formatNumber type="currency"
                                                  maxFractionDigits="0"
                                                  value="${productDetail.changeNewPriceToJa}"/> 
                            </c:if>   
                        </p>
                        <div class="action"> 
                            <div class="row">
                                <a href="add-card?id=${productDetail.id}&flag=2"> 
                                    <button class="add-to-cart btn btn-default" type="button">
                                        Add To Card
                                    </button> 
                                    <a href="add-card?id=${productDetail.id}&flag=1"> 
                                        <button class="add-to-cart btn btn-default" type="button">
                                            Buy Now
                                        </button> 
                                    </a> 
                                </a> 
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr class="mb-5">
    </div>

    <!-- Mo ta san pham -->
    <div class="container">
        <h2><b style="text-align: center;">Mô tả sản phẩm</b>
            <span class="sr-only">(current)</span></h2>
        <b><p>${productDetail.productName}</p></b>
        <p>${productDetail.description}</p>

        <hr class="mb-5">
    </div>
    <!-- /.Mo ta san pham -->

    <!--Binh luan-->
    <div class="container">
        <h2 style="text-align: left;"> <b style="text-align: center;">Bình luận</b>
            <span class="sr-only">(current)</span></h2><br />
        <div class="row">
            <div class="col-3 col-xl-3 col-md-3">
                <div class="media">
                    <img src="img/img_san_pham/hangnguyen.jpg" class="mr-3" alt="...">                  
                </div> 
            </div>
            <div class="col-9 col-xl-9 col-md-9">
                <div class="media-body">
                    <h5 class="mt-0">Hằng Nguyễn</h5><br/>
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                </div>
            </div>
        </div>
        <br/><br/>
        <hr class="mb-5">
    </div>
    <!--/.Binh luan-->

    <!-- Sản phẩm tương tự -->
    <div class="container">
        <h2 style="text-align: left;"> <b style="text-align: center;">Các sản phẩm khác</b>
            <span class="sr-only">(current)</span></h2><br />
        <div class="row blog">
            <div class="col-md-12">
                <div id="blogCarousel" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#blogCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#blogCarousel" data-slide-to="1"></li>
                    </ol>
                    <!-- Carousel items -->
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="row">
                                <div class="col-md-3">
                                    <a href="#">
                                        <div class="image-box">
                                            <img src="img/img_san_pham/sanpham2.jpg" alt="" class="card-img-top">
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-3">
                                    <a href="#">
                                        <div class="image-box">
                                            <img src="img/img_san_pham/sanpham3.jpg" alt="" class="card-img-top">
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-3">
                                    <a href="#">
                                        <div class="image-box">
                                            <img src="img/img_san_pham/sanpham4.jpg" alt="" class="card-img-top">
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-3">
                                    <a href="#">
                                        <div class="image-box">
                                            <img src="img/img_san_pham/sanpham5.jpg" alt="" class="card-img-top">
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <!--.row-->
                        </div>
                        <!--.item-->

                        <div class="carousel-item">
                            <div class="row">
                                <div class="col-md-3">
                                    <a href="#">
                                        <div class="image-box">
                                            <img src="img/img_san_pham/sanpham6.jpg" alt="" class="card-img-top">
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-3">
                                    <a href="#">
                                        <div class="image-box">
                                            <img src="img/img_san_pham/sanpham7.jpg" alt="" class="card-img-top">
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-3">
                                    <a href="#">
                                        <div class="image-box">
                                            <img src="img/img_san_pham/sanpham8.jpg" alt="" class="card-img-top">
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-3">
                                    <a href="#">
                                        <div class="image-box">
                                            <img src="img/img_san_pham/sanpham9.jpg" alt="" class="card-img-top">
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <!--.row-->
                        </div>
                        <!--.item-->
                    </div>
                    <!--.carousel-inner-->

                </div>
                <!--.Carousel-->
            </div>
        </div>
        <br /><br />
        <hr class="mb-5">
    </div>

    <!-- /.Sản phẩm tương tự -->

    <%@ include file="component/footer.jsp" %>

    <script>
        $('#blogCarousel').carousel({
            interval: 5000
        });</script>

    <script>
        var slideIndex = 1;
        showSlides(slideIndex);

        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("demo");
            var captionText = document.getElementById("caption");
            if (n > slides.length) {
                slideIndex = 1
            }
            if (n < 1) {
                slideIndex = slides.length
            }
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex - 1].style.display = "block";
            dots[slideIndex - 1].className += " active";
            captionText.innerHTML = dots[slideIndex - 1].alt;
        }
    </script>
</body>

</html>