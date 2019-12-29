<%-- 
    Document   : login
    Created on : Nov 11, 2019, 8:16:38 PM
    Author     : TuanNA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Font Awesome CSS -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="assetss/css/bootstrap/bootstrap.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="assetss/css/mnd/form.css">

        <title>Đăng nhập</title>


    </head>
    <body>

        <div id="intro">
            <div class="middle signin">
                <div class="login-panel">
                    <div class="logo text-center">
                        <a href="#" >-MAC-</a>
                        <p>${requestScope.mess}</p>
                    </div>
                    <p class="notification"> ${message}&nbsp; </p>
                    <form action="login" method="post">
                        <div class="form-group">
                            <label>
                                <i class="fas fa-user fa-fw"></i>
                            </label>
                            <input type="email" class="form-control" placeholder="Email" name="txtEmail" required />
                        </div>
                        <div class="form-group">
                            <label>
                                <i class="fas fa-key fa-fw"></i>
                            </label>
                            <input type="password" class="form-control" placeholder="Password" name="txtPassword" required />
                        </div>
                        <br>
                        <div class="form-group">
                            <div class="col">
                                <button type="submit" class="btn btn-sm">
                                    <i class="fas fa-sign-in-alt fa-fw mr-1"></i>Đăng nhập
                                </button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col">
                                <a class="link-effect" href="#">
                                </a>
                                <a class="link-effect float-right" href="reminder_password.html">
                                    <i class="fas fa-question fa-fw mr-1"></i>Quên mật khẩu?
                                </a>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <footer>
            <p>
                © 2019 MAC ADMIN System
            </p>
        </footer>

        <!-- Bootstrap core JavaScript-->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js "></script>
        <script src="assetss/js/bootstrap/popper.min.js"></script>
        <script src="assetss/js/bootstrap/bootstrap.min.js"></script>
    </body>

</html>