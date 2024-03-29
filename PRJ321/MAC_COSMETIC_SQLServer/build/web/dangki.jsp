<%-- 
    Document   : newlogin
    Created on : Oct 28, 2019, 2:47:25 PM
    Author     : HangNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0090)https://mdbootstrap.com/previews/docs/latest/html/intros/intro-register-classic-form.html# -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Required meta tags always come first -->

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 

        <!-- Title -->
        <title>M·A·C Cosmetics | VIỆT NAM |Đăng nhập</title> 
        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/all.css">
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="css/mdb.min.css" rel="stylesheet">

        <!--Custom styles-->

        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
              integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" 
              crossorigin="anonymous">
        <style>
            /* Required for full background image */

            html,
            body,
            header,
            .view {
                height: 100%;
            }

            @media (max-width: 740px) {
                html,
                body,
                header,
                .view {
                    height: 1000px;
                }
            }
            @media (min-width: 800px) and (max-width: 850px) {
                html,
                body,
                header,
                .view {
                    height: 650px;
                }
            }

            .top-nav-collapse {
                background-color: #3f51b5 !important;
            }

            .navbar:not(.top-nav-collapse) {
                background: transparent !important;
            }

            @media (max-width: 991px) {
                .navbar:not(.top-nav-collapse) {
                    background: #3f51b5 !important;
                }
            }

            .rgba-gradient {
                background: -webkit-linear-gradient(45deg, rgba(0, 0, 0, 0.7), rgba(72, 15, 144, 0.4) 100%);
                background: -webkit-gradient(linear, 45deg, from(rgba(0, 0, 0, 0.7), rgba(72, 15, 144, 0.4) 100%));
                background: linear-gradient(to 45deg, rgba(0, 0, 0, 0.7), rgba(72, 15, 144, 0.4) 100%);
            }

            .card {
                background-color: rgba(126, 123, 215, 0.2);
            }

            .md-form label {
                color: #ffffff;
            }
            input:-moz-placeholder { /* Firefox 18- */
                color: white;
                .text-semi-bold;
            }
            h6 {
                line-height: 1.7;
            }
        </style>
        <style type="text/css">/* Chart.js */
            @-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style></head>

    <body aria-busy="true">
        <!-- Main navigation -->
        <header>
            <!-- Full Page Intro -->
            <div class="view" style="background-image: url(&#39;http://mdbootstrap.com/img/Photos/Others/images/91.jpg&#39;); background-repeat: no-repeat; background-size: cover; background-position: center center;">
                <!-- Mask & flexbox options-->
                <div class="mask rgba-gradient d-flex justify-content-center align-items-center">
                    <!-- Content -->
                    <div class="container">
                        <!--Grid row-->
                        <div class="row mt-5">
                            <!--Grid column-->
                            <div class="col-md-6 mb-5 mt-md-0 mt-5 white-text text-center text-md-left">
                                <h1 class="h1-responsive font-weight-bold wow fadeInLeft" data-wow-delay="0.3s" style="visibility: visible; animation-name: fadeInLeft; animation-delay: 0.3s;">MAC COSMETIC</h1>
                                <hr class="hr-light wow fadeInLeft" data-wow-delay="0.3s" style="visibility: visible; animation-name: fadeInLeft; animation-delay: 0.4s;">
                                <h6 class="mb-3 wow fadeInLeft" data-wow-delay="0.3s" style="visibility: visible; animation-name: fadeInLeft; animation-delay: 0.5s;">
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Rem repellendus quasi fuga
                                    nesciunt dolorum nulla magnam veniam sapiente, fugiat! Commodi sequi non animi ea
                                    dolor molestiae, quisquam iste, maiores. Nulla.
                                </h6>

                                <a href="index.jsp" class="btn btn-outline-white wow fadeInLeft waves-effect waves-light" data-wow-delay="0.3s" style="visibility: visible; animation-name: fadeInLeft; animation-delay: 0.3s;">Learn more</a>
                            </div>
                            <!/--Grid column-->

                            <!--Grid column-->
                            <div class="col-md-6 col-xl-5 mb-4">
                                <!--Form-->
                                <form action="signup" method="post" id ="registration">
                                    <div class="card wow fadeInRight" data-wow-delay="0.3s" style="visibility: visible; animation-name: fadeInRight; animation-delay: 0.3s;">
                                        <div class="card-body">
                                            <!--Header-->
                                            <div class="text-center">
                                                <h3 class="white-text">
                                                    <p style="color:white">${requestScope.message}</p>
                                                    Register</h3>
                                                <hr class="hr-light">
                                            </div>
                                            <!--Body-->
                                            <div class="md-form">
                                                <i class="fas fa-user prefix white-text"></i>
                                                <input type="text" id="form3" class="white-text form-control"  name = "username" placeholder = "Username"/>
                                            </div>
                                            <div class="md-form">
                                                <i class="fas fa-envelope prefix white-text"></i>
                                                <input type="email" class="white-text form-control" 
                                                       placeholder="Email"name="email"/>
                                            </div>
                                            <div class="md-form">
                                                <i class="fas fa-phone prefix white-text"></i>
                                                <input type="text" class="white-text form-control" 
                                                       placeholder="Mobile"name="mobile"/>                                            </div>
                                            <div class="md-form">
                                                <i class="fas fa-address-card prefix white-text"></i>
                                                <textarea class = "white-text form-control" name = "address" placeholder="Address"></textarea>                             
                                            </div>
                                            <div class="input-group md-form">
                                                <i class="fas fa-venus-mars prefix white-text"></i>
                                                <div style="color:white;margin-left:10%;"class = "gender"> 
                                                    <input type="radio" name="gender" value="Male"  />Male
                                                    <input type="radio" name="gender" value="Female" />Female 
                                                    <input type="radio" name="gender" value="Other" />Other<br/>
                                                </div>
                                            </div>
                                            <div class="md-form">
                                                <i class="fas fa-lock prefix white-text"></i>
                                                <input type="password" class="white-text form-control"name = "password"
                                                       placeholder = "Password" id = "password"/>
                                            </div>
                                            <div class="md-form">
                                                <i class="fas fa-lock prefix white-text"></i>
                                                <input type="password" class="white-text form-control" name = "confirm" placeholder = "Confirm Password"/>
                                            </div>

                                            <div class="text-center mt-4">
                                                <button class="btn submit btn-indigo waves-effect waves-light">Sign in</button>
                                                <hr class="hr-light mb-3 mt-4">
                                                <div class="d-flex justify-content-center links"style="color:white;">
                                                    User an account?<a href="dangnhap.jsp">Sign up</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/.Form-->
                                </form>
                            </div>
                            <!--Grid column-->
                        </div>
                        <!--Grid row-->
                    </div>
                    <!-- Content -->
                </div>
                <!-- Mask & flexbox options-->
            </div>
            <!-- Full Page Intro -->
        </header>
        <!-- Main navigation -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/register.js"></script>  
    </body>
</html>