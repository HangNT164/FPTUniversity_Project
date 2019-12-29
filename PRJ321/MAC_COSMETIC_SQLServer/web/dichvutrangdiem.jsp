<%-- 
    Document   : dichvutrangdiem
    Created on : Sep 11, 2019, 2:00:30 PM
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
        <link href="css/dichvutrangdiem.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 
        <!-- Title -->
        <title>M·A·C Cosmetics | VIỆT NAM | Makeup Services</title>
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
                         style="background-image: url('img/img_trang_diem/trangdiem.jpg'); background-repeat: no-repeat; background-size: cover;">
                        <!-- Mask & flexbox options-->
                        <div class="mask rgba-black-light d-flex justify-content-center align-items-center">

                            <!-- Content -->
                            <div class="text-center white-text mx-5 wow fadeIn">
                                <h1><b><strong style="font-size:100px;">DỊCH VỤ TRANG ĐIỂM</strong></b></h1>
                            </div>
                            <!-- Content -->
                        </div>
                        <!-- Mask & flexbox options-->
                    </div>
                </div>
            </div>
        </div>
        <!--/.Carousel Wrapper-->

        <!-- First Row -->
        <div class="container" id="container-body">
            <!--First row-->
            <div class="row features-small mt-5 wow fadeIn">

                <!--Grid column-->
                <div class="col-xl-3 col-lg-6">
                    <!--Grid row-->
                    <div class="row">
                        <div class="col-10 mb-2 pl-3">
                            <h2 class="feature-title font-bold mb-1"><b><strong>DỊCH VỤ NGAY TẠI QUẦY
                                        HƯỚNG DẪN TRANG ĐIỂM</strong></b></h2>
                            <p class="grey-text mt-2"><b style="color:black;">LỰA CHỌN DANH MỤC TRANG ĐIỂM TẠI QUẦY DANH MỤC
                                    SẢN PHẨM PHÍA DƯỚI.
                                    TÙY THEO SỰ CÓ MẶT CỦA ARTIST.
                                </b></p>
                            <p class="grey-text mt-2"><b style="color:black;">Tất cả các cửa hàng của MAC đều chú trọng đến
                                    nghệ thuật trang điểm, mang đến cho bạn cả dịch vụ trang điểm miễn phíngay tại quầy, đặt
                                    hẹn trước. HỌC kỹ năng trang điểm nâng cao và lớp trang điểm. Các Artist tay nghề cao
                                    của chúng tôi trải qua quá trình chứng nhận gắt gao. Họ sẽ thiết kế nên từng dịch vụ phù
                                    hợp với những nét đẹp riêng và màu sắc để tôn vinh phong cách của bạn.
                                </b></p>
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
                            <h5 class="feature-title font-bold mb-1"><b><strong>TẠO ĐIỂM NHẤN
                                    </strong></b></h5>
                            <ul>
                                <li>
                                    <p class="grey-text mt-2"><b style="color:black;">Trang điểm tập trung tạo 1 điểm nhấn
                                            trên khuôn mặt bạn với M-A-C Artist.
                                        </b></p>
                                </li>
                            </ul>
                            <h5 class="feature-title font-bold mb-1"><b><strong>ĐÔI MẮT
                                    </strong></b></h5>
                            <ul>
                                <li>
                                    <p class="grey-text mt-2"><b style="color:black;">Học về nghệ thuật trang điểm mắt kiểu
                                            cổ điển, tự nhiên, khói hoặc xu hướng.
                                        </b></p>
                                </li>
                            </ul>
                            <h5 class="feature-title font-bold mb-1"><b><strong>TẠO KHỐI CHO KHUÔN MẶT
                                    </strong></b></h5>
                            <ul>
                                <li>
                                    <p class="grey-text mt-2"><b style="color:black;">Dựa trên kiểu trang điểm đang sẵn có
                                            của bạn, học về các dụng cụ, kỹ thuật và cách tạo khối/tạo điểm nhấn/phấn hồng
                                            mà bạn cần tạo nét.
                                        </b></p>
                                </li>
                            </ul>
                            <h5 class="feature-title font-bold mb-1"><b><strong>ĐÔI MÔI
                                    </strong></b></h5>
                            <ul>
                                <li>
                                    <p class="grey-text mt-2"><b style="color:black;">Mi giả mới từ M·A·C của bạn sẽ thật
                                            vừa vặn hoàn hảo và chuyên nghiệp. (Mi giả không miễn phí).
                                        </b></p>
                                </li>
                            </ul>
                            <h5 class="feature-title font-bold mb-1"><b><strong>GẮN MI GIẢ
                                    </strong></b></h5>
                            <ul>
                                <li>
                                    <p class="grey-text mt-2"><b style="color:black;">Trang điểm tập trung tạo 1 điểm nhấn
                                            trên khuôn mặt bạn với M-A-C Artist.
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
                            <h5 class="feature-title font-bold mb-1"><b><strong>NÂNG CAO KỸ NĂNG*
                                    </strong></b></h5>
                            <ul>
                                <li>
                                    <p class="grey-text mt-2"><b style="color:black;">Khám phá các sản phẩm và kỹ thuật giúp
                                            kiểu trang điểm đang sẵn có của bạn trông lộng lẫy hơn, với sự hướng dẫn của
                                            M·A·C Artist chỉ trong 10-15 phút. *Chỉ áp dụng tại 1 số cửa hàng chọn lọc.
                                        </b></p>
                                </li>
                            </ul>
                            <h5 class="feature-title font-bold mb-1"><b><strong>QUYẾN RŨ THỜI THƯỢNG
                                    </strong></b></h5>
                            <ul>
                                <li>
                                    <p class="grey-text mt-2"><b style="color:black;">Học cách nâng cao kiểu trang điểm tự
                                            nhiên của bạn phù hợp với xu hướng mới nhất.
                                        </b></p>
                                </li>
                            </ul>
                            <h5 class="feature-title font-bold mb-1"><b><strong>ĐIỀU CHỈNH KIỂU TRANG ĐIỂM CỦA BẠN
                                    </strong></b></h5>
                            <ul>
                                <li>
                                    <p class="grey-text mt-2"><b style="color:black;">Dựa trên kiểu trang điểm đang sẵn có
                                            của bạn, học cách làm hài hòa các đường nét bằng cách hiệu chỉnh những gam màu
                                            trên da.
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

        <!-- Second row -->
        <div class="container" id="container-body">
            <!--First row-->
            <div class="row features-small mt-5 wow fadeIn">

                <!--Grid column-->
                <div class="col-xl-3 col-lg-6">
                    <!--Grid row-->
                    <div class="row">
                        <div class="col-10 mb-2 pl-3">
                            <h2 class="feature-title font-bold mb-1"><b><strong>ĐẶT HẸN TRƯỚC
                                        HỌC TRANG ĐIỂM VÀ NÂNG CAO KỸ NĂNG</strong></b></h2>
                            <p class="grey-text mt-2"><b style="color:black;">MỘT KÈM MỘT VỚI MAC ARTIST TAY NGHỀ CAO. TÙY
                                    THEO LỊCH HẸN TRƯỚC.
                                    QUY ĐỔI HOÀN TOÀN THÀNH SẢN PHẨM THEO DỊCH VỤ LỰA CHỌN.
                                </b></p>
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
                            <h5 class="feature-title font-bold mb-1"><b><strong>TRANG ĐIỂM TOÀN MẶT
                                    </strong></b></h5>
                            <ul>
                                <li>
                                    <p class="grey-text mt-2"><b style="color:black;">Trang điểm toàn mặt từ môi đến mi giả,
                                            thực hiện bởi Artist của M·A·C trong 60 phút. Bao gồm Face chart để giúp bạn tạo
                                            lại kiểu trang điểm này tại nhà. Lấy kiểu trang điểm của chúng tôi để tạo cảm
                                            hứng cho bạn. (Mi giả không miễn phí).
                                        </b></p>
                                    <p class="grey-text mt-2"><b style="color:black;">1,800.000Đ
                                        </b></p>
                                </li>
                            </ul>
                            <h5 class="feature-title font-bold mb-1"><b><strong>HỌC TRANG ĐIỂM *
                                    </strong></b></h5>
                            <ul>
                                <li>
                                    <p class="grey-text mt-2"><b style="color:black;">Buổi học trang điểm đầy đủ để bạn chủ
                                            động trang điểm cho chính mình, Artist của MAC chỉ dẫn thực hành trang điểm chi
                                            tiết từng bước cho toàn khuôn mặt trong 90 phút. Cung cấp Face Chart để giúp bạn
                                            tạo lại kiểu trang điểm này tại nhà. Lấy kiểu trang điểm của chúng tôi để tạo
                                            cảm hứng cho bạn. *Chỉ áp dụng tại 1 số cửa hàng chọn lọc.
                                        </b></p>
                                    <p class="grey-text mt-2"><b style="color:black;">2,500.000Đ
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
                            <h5 class="feature-title font-bold mb-1"><b><strong>TRANG ĐIỂM NHANH
                                    </strong></b></h5>
                            <ul>
                                <li>
                                    <p class="grey-text mt-2"><b style="color:black;">Áp dụng trang điểm nhanh cho các khách
                                            hàng không có nhiều thời gian, thực hiện bởi M·A·C Artist chỉ trong 30 phút.
                                        </b></p>
                                    <p class="grey-text mt-2"><b style="color:black;">800.000Đ
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
            <!--/Second row-->
        </div>

        <hr class="mb-5">

        <%@ include file="component/footer.jsp" %>

    </body>

</html>