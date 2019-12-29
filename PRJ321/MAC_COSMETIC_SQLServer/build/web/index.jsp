
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

        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 
        <!-- Title -->
        <title>M·A·C Cosmetics | VIỆT NAM | Trang chủ</title>
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

            <!--Indicators-->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-1z" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-1z" data-slide-to="1"></li>
                <li data-target="#carousel-example-1z" data-slide-to="2"></li>
                <li data-target="#carousel-example-1z" data-slide-to="3"></li>
                <li data-target="#carousel-example-1z" data-slide-to="4"></li>
            </ol>
            <!--/.Indicators-->

            <!--Slides-->
            <div class="carousel-inner" role="listbox">

                <!--First slide-->
                <div class="carousel-item active">
                    <div class="view"
                         style="background-image: url('img/img_home/hinh1.jpg'); background-repeat: no-repeat; background-size: cover;">

                        <!-- Mask & flexbox options-->
                        <div class="mask rgba-black-light d-flex justify-content-center align-items-center">

                            <!-- Content -->
                            <div class="text-center white-text mx-5 wow fadeIn">
                                <p style="color:white;">
                                    <fmt:message key="home.slide1"/>
                                </p>
                                <a href="cuahang.jsp?language=${language}"
                                   class="btn btn-outline-white btn-lg">
                                    <fmt:message key="home.findthestore"/>
                                </a>
                            </div>
                            <!-- Content -->
                        </div>
                        <!-- Mask & flexbox options-->

                    </div>
                </div>
                <!--/First slide-->

                <!--Second slide-->
                <div class="carousel-item">
                    <div class="view"
                         style="background-image: url('img/img_home/hinh2.jpg'); background-repeat: no-repeat; background-size: cover;">

                        <!-- Mask & flexbox options-->
                        <div class="mask rgba-black-light d-flex justify-content-center align-items-center">

                            <!-- Content -->
                            <div class="text-center white-text mx-5 wow fadeIn">
                                <p style="color:white;">
                                    <fmt:message key="home.slide2"/>
                                </p>
                                <a href="cuahang.jsp?language=${language}"
                                   class="btn btn-outline-white btn-lg">    
                                    <fmt:message key="home.findthestore"/>

                                </a>
                            </div>
                            <!-- Content -->

                        </div>
                        <!-- Mask & flexbox options-->
                    </div>
                </div>
                <!--/Second slide-->

                <!--Third slide-->
                <div class="carousel-item">
                    <div class="view"
                         style="background-image: url('img/img_home/hinh3.jpg'); background-repeat: no-repeat; background-size: cover;">

                        <!-- Mask & flexbox options-->
                        <div class="mask rgba-black-light d-flex justify-content-center align-items-center">

                            <!-- Content -->
                            <div class="text-center white-text mx-5 wow fadeIn">
                                <p style="color:white;">
                                    <fmt:message key="home.slide3"/>
                                </p>
                                <a href="cuahang.jsp?language=${language}"
                                   class="btn btn-outline-white btn-lg">  
                                    <fmt:message key="home.findthestore"/>

                                </a>
                            </div>
                            <!-- Content -->

                        </div>
                        <!-- Mask & flexbox options-->

                    </div>
                </div>
                <!--/Third slide-->

                <!--Fouth slide-->
                <div class="carousel-item">
                    <div class="view"
                         style="background-image: url('img/img_home/hinh4.jpg'); background-repeat: no-repeat; background-size: cover;">

                        <!-- Mask & flexbox options-->
                        <div class="mask rgba-black-light d-flex justify-content-center align-items-center">

                            <!-- Content -->
                            <div class="text-center white-text mx-5 wow fadeIn">
                                <p style="color:white;">
                                    <fmt:message key="home.slide4"/>
                                </p>
                                <a target="_blank"
                                   href="cuahang.jsp?language=${language}"
                                   class="btn btn-outline-white btn-lg">         
                                    <fmt:message key="home.findthestore"/>
                                </a>
                            </div>
                            <!-- Content -->

                        </div>
                        <!-- Mask & flexbox options-->

                    </div>
                </div>
                <!--/Fouth slide-->

                <!--Fifth slide-->
                <div class="carousel-item">
                    <div class="view"
                         style="background-image: url('img/img_home/hinh5.jpg'); background-repeat: no-repeat; background-size: cover;">

                        <!-- Mask & flexbox options-->
                        <div class="mask rgba-black-light d-flex justify-content-center align-items-center">

                            <!-- Content -->
                            <div class="text-center white-text mx-5 wow fadeIn">
                                <p style="color:white;">
                                    <fmt:message key="home.slide5"/>
                                </p>
                                <a target="_blank"
                                   href="cuahang.jsp?language=${language}"
                                   class="btn btn-outline-white btn-lg">                              
                                    <fmt:message key="home.findthestore"/>
                                </a>
                            </div>
                            <!-- Content -->

                        </div>
                        <!-- Mask & flexbox options-->

                    </div>
                </div>
                <!--/Fifth slide-->

            </div>
            <!--/.Slides-->

            <!--Controls-->
            <a class="carousel-control-prev" href="#carousel-example-1z" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carousel-example-1z" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            <!--/.Controls-->

        </div>
        <!--/.Carousel Wrapper-->

        <!--Section: Main info-->
        <div style="background-color:black;">
            <div class="container-fuild">
                <div class="row" style="margin-right:0%;">
                    <div class="col-lg-6 col-xl-6" style="display:inline-block;">

                        <!-- Card -->
                        <div class="card">
                            <img src="img/img_home/duoi1.jpg" class="card-img-top" alt="...">
                            <div class="card-body" style="background-color:black;">
                                <h5 class="card-title"><b style="color:white;">
                                        <fmt:message key="home.outstory"/></b></h5>
                                <p class="card-text">
                                    <fmt:message key="home.docthem1"/></b></h5>
                                </p>
                                <a href="docthem1.jsp?language=${language}"
                                   class="btn btn-outline-white btn-lg" style="color:black;">
                                    <fmt:message key="home.readmore"/>
                                </a>
                            </div>
                        </div>
                        <!-- /Card  -->
                    </div>
                    <!--Grid column-->
                    <div class="col-lg-6 col-xl-6" style="display:inline-block;">
                        <!-- Card -->
                        <div class="card">
                            <img src="img/img_home/duoi2.jpg" class="card-img-top" alt="...">
                            <div class="card-body" style="background-color:black;">
                                <h5 class="card-title"><b style="color:white;">
                                        <fmt:message key="home.quymac"/>
                                    </b></h5>
                                <p class="card-text">
                                    <fmt:message key="home.docthem2"/></b></h5>
                                </p>
                                <a href="docthem2.jsp?language=${language}"
                                   class="btn btn-outline-white btn-lg" style="color:black;">   
                                    <fmt:message key="home.readmore"/>
                                </a>
                            </div>
                        </div>
                        <!-- /Card  -->
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="component/footer.jsp" %>
    </body>

</html>
