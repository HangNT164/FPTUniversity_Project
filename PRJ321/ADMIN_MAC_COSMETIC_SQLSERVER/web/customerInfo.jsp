
<%-- 
    Document   : addCategory
    Created on : Oct 29, 2019, 2:24:09 AM
    Author     : TuanNA
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Font Awesome CSS -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="assetss/css/bootstrap/bootstrap.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="assetss/css/mnd/common.css">
        <link rel="stylesheet" href="assetss/css/mnd/materials.css">
        <link rel="stylesheet" href="assetss/css/mnd/tables.css">

        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!--title-->
        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 

        <title>Admin|Mac Cosmetic|Customer Information</title>
    </head>

    <body id="page-top">
        <%@include file="component/header.jsp" %>

        <!-- Start wrapper -->
        <div id="wrapper" >
            <!-- Sidebar -->
            <%@include file="component/menu.jsp" %>

            <div id="content-wrapper">
                <!-- Navbar -->

                <div class="container-fluid" style="margin-left: 100px">
                    <!-- Page Title -->
                    <div class="row title">
                        <div class="col-12">
                            <h3>
                                Account
                            </h3>
                        </div>
                    </div>

                    <div class="row mt-2 mb-3">
                        <div class="col-12 btn-add">
                            <p class="mb-3">Click the button to view user details.</p>
                            <button type="button" class="btn btn-success collapsed" data-toggle="collapse" data-target="#addPerson" aria-expanded="false" aria-controls="collapse">
                                Information of ${accoutDetail.name}<i class="fas fa-angle-down ml-2"></i>
                            </button>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-8">
                            <div class="collapse mb-2" id="addPerson">
                                <div class="card">
                                    <div class="card card-body">
                                        <h4 class="mb-4">Account Detail</h4>
                                        <form action="add-person" method="post">
                                            <div class="row">
                                                <div class="col-6 pr-5">
                                                    <div class="form-group row">
                                                        <label class="col-sm-4 col-form-label">Họ và tên</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" name="txtName" value="${accoutDetail.name}" readonly />
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-4 col-form-label">Số Điện Thoại</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" name="txtMobile"  value="${accoutDetail.mobile}"readonly  />
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-4 col-form-label">Giới tính</label>
                                                        <div class="col-sm-8"><c:choose>
                                                                <c:when test="${accoutDetail.gender==1}">
                                                                    <input type="text" class="form-control" name="txtMobile"  value="Male"  readonly/>
                                                                </c:when>
                                                                <c:when test="${accoutDetail.gender==0}">
                                                                    <input type="text" class="form-control" name="txtMobile"  value="Female" readonly />
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="text" class="form-control" name="txtMobile"  value="Other"  readonly/>
                                                                </c:otherwise>
                                                            </c:choose>

                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="col-6 pl-5">

                                                    <div class="form-group row">
                                                        <label class="col-sm-4 col-form-label">Địa Chỉ</label>
                                                        <div class="col-sm-8">
                                                            <input type="email" class="form-control" name="txtAddress"  value="${accoutDetail.address}" readonly/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-4 col-form-label">Ngày Tạo</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" name="txtCreate" value="${accoutDetail.createDate}" readonly/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-3">

                        <div class="col-8">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-12">
                                            <h5 class="mb-4">List Customer</h5>


                                            <table id="type-of-material" class="table table-bordered w-100" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th class="w-stt">STT</th>
                                                        <th>Customer Name</th>
                                                        <th>Mobile</th>
                                                        <th>Address</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr> 
                                                        <td>1</td>
                                                        <td>${customerInfo.name}</td>
                                                        <td>${customerInfo.mobile}</td>
                                                        <td>${customerInfo.address}</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!--Field ra-->
                    <div class="row mt-3">

                        <div class="col-8">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-12">
                                            <h5 class="mb-4">List Order Detail </h5>

                                            <table id="type-of-material" class="table table-bordered w-100" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th class="w-stt">STT</th>
                                                        <th>Product Name</th>
                                                        <th>Sell Price</th>
                                                        <th>Orgin Price</th>
                                                        <th>Quantity</th>         
                                                        <th>Total Price</th>                                                 
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="orderDetail" items="${lists}">
                                                        <tr> 
                                                            <td></td>
                                                            <td>${orderDetail.productName}</td>
                                                            <td>${orderDetail.sellPrice}</td>
                                                            <td>${orderDetail.orginPrice}</td>
                                                            <td>${orderDetail.quantity}</td>
                                                            <td>${orderDetail.totalPrice}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Field ra-->

                </div>
            </div>
        </div>
        <!-- End wrapper -->

        <!-- Bootstrap core JavaScript-->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="assetss/js/bootstrap/popper.min.js"></script>
        <script src="assetss/js/bootstrap/bootstrap.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="assetss/js/mnd/mnd.min.js"></script>

        <!-- Data Tables -->
        <script src="assetss/js/datatables/jquery.dataTables.min.js"></script>
        <script src="assetss/js/datatables/datatables.vietnamese.js"></script>
        <script src="assetss/js/datatables/dataTables.bootstrap4.min.js"></script>


    </body>

</html>