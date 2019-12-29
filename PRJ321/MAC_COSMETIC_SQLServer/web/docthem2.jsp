<%-- 
    Document   : docthem2
    Created on : Sep 11, 2019, 2:01:07 PM
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
        <title>Viva Glam & M·A·C Aids Fund | M·A·C Vietnam</title>
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

        <!--Carousel Wrapper-->
        <div id="carousel-example-1z" class="carousel slide carousel-fade" data-ride="carousel">
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active">
                    <div class="view"
                         style="background-image: url('img/img_home/duoi2.jpg'); background-repeat: no-repeat; background-size: cover;">

                    </div>
                </div>
            </div>
            <!--/.Carousel Wrapper-->


            <div class="container" id="container-body">
                <!--First row-->
                <div class="row features-small mt-5 wow fadeIn">

                    <!--Grid column-->
                    <div class="col-xl-3 col-lg-6">
                        <!--Grid row-->
                        <div class="row">
                            <div class="col-10 mb-2 pl-3">
                                <h2 class="feature-title font-bold mb-1">
                                    <b><strong> <fmt:message key="home.quymac"/></strong></b></h2>
                            </div>
                        </div>
                        <!--/Grid row-->
                    </div>
                    <!--/Grid column-->

                    <!--Grid column-->
                    <div class="col-xl-3 col-lg-6">
                        <!--Grid row-->
                        <div class="row">
                            <div class="col-10 mb-2 pl-3">
                                <ul>
                                    <li>
                                        <p class="grey-text mt-2"><b style="color:black;">
                                                 <fmt:message key="docthem2.phan11"/>
                                            </b></p>
                                    </li>
                                    <li>
                                        <p class="grey-text mt-2"><b style="color:black;">
                                                 <fmt:message key="docthem2.phan12"/>
                                            </b></p>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!--/Grid row-->
                    </div>
                    <!--/Grid column-->

                    <!--Grid column-->
                    <div class="col-xl-3 col-lg-6">
                        <!--Grid row-->
                        <div class="row">
                            <div class="col-10 mb-2 pl-3">
                                <ul>
                                    <li>
                                        <p class="grey-text mt-2"><b style="color:black;">
                                                 <fmt:message key="docthem2.phan21"/>
                                            </b></p>
                                    </li>
                                    <li>
                                        <p class="grey-text mt-2"><b style="color:black;"> 
                                                <fmt:message key="docthem2.phan22"/>
                                            </b></p>
                                    </li>
                                    <li>
                                        <p class="grey-text mt-2"><b style="color:black;">
                                                <fmt:message key="docthem2.phan23"/>
                                            </b></p>
                                    </li>
                                    <li>
                                        <p class="grey-text mt-2"><b style="color:black;">
                                                 <fmt:message key="docthem2.phan24"/>
                                            </b></p>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!--/Grid row-->
                    </div>
                    <!--/Grid column-->

                    <!--Grid column-->
                    <div class="col-xl-3 col-lg-6">

                    </div>
                    <!--/Grid column-->

                </div>
                <!--/First row-->
            </div>
            <hr class="mb-5">
           <%@include file="component/footer.jsp" %>
    </body>

</html>