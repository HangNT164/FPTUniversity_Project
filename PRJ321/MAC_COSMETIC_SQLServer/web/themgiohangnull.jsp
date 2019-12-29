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
        <div class="container" style="margin-top:8%;">
            <p style="text-align: left;"><b>               
                    <fmt:message key="giohang"/>
                </b>(0 <fmt:message key="product"/>
                )</p>
        </div><br />
        <div class="container" style="background-color:whitesmoke;"><br />
            <div class="class-img">
                <p style="text-align:center;"> <img src="img/img_gio_hang/giohang.png" ></p>
                <p style="text-align:center;"><fmt:message key="noproduct"/>
                </p>
                <p style="text-align:center;"><a href="index.jsp">
                        <button type="button" class="btn btn-warning"> 
                            <fmt:message key="buycontinue"/>
                        </button>
                    </a></p><br />
            </div> 
        </div>
        <br /><br /><br /><br /><br /><br /><br /><br />
        <br /><br /><br /><br />
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