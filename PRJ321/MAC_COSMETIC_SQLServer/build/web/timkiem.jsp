<%-- 
    Document   : timkiem
    Created on : Oct 12, 2019, 5:56:41 PM
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

    <body style="margin-top:75px;">

        <%@ include file="component/header.jsp" %>


        <!--Carousel Wrapper-->
        <section id="map">
            <div id="gmap"></div>
            <script>
                function myMap() {
                    var myCenter = new google.maps.LatLng(21.0294434, 105.8506198, 17.38);
                    var mapCanvas = document.getElementById("gmap");
                    var mapOptions = {
                        center: myCenter,
                        zoom: 17
                    };
                    var map = new google.maps.Map(mapCanvas, mapOptions);
                    var marker = new google.maps.Marker({
                        position: myCenter
                    });
                    marker.setMap(map);
                    var infowindow = new google.maps.InfoWindow({
                        content: "Hồ Gươm"
                    });
                    infowindow.open(map, marker);
                }
            </script>

            <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB2LlIj3sk2akFpnpNcXzX9_NS08Xda1sE&callback=myMap"></script>

        </section>
        <!-- footer -->
        <!--/.Carousel Wrapper-->


        <!-- Footer -->
        <%@ include file="component/footer.jsp" %>

    </body>

</html>