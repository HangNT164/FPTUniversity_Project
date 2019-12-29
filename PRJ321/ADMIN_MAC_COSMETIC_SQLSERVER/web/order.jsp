<%-- 
    Document   : order
    Created on : Nov 2, 2019, 11:12:53 PM
    Author     : HangNT
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

        <!--title-->
        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <title>Admin|Mac Cosmetic| View Order</title>
    </head>

    <body id="page-top">

        <%@include file="component/header.jsp" %>

        <!-- Start wrapper -->
        <div id="wrapper" >
            <!-- Sidebar -->
            <%@include file="component/menu.jsp" %>

            <div id="content-wrapper">
                <!-- Navbar -->


                <div class="container-fluid">
                    <!-- Page Title -->
                    <div class="row title">
                        <div class="col-12">
                            <h3>
                                Manager Order
                            </h3>
                        </div>
                    </div>

                    <div class="row mt-3">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-12">
                                            <h5 class="mb-4">List Order</h5>
                                            <table id="type-of-material" class="table table-bordered w-100" cellspacing="0">
                                                <p style="text-align: center;">${requestScope.mess}</p>
                                                <thead>
                                                    <tr>
                                                        <th class="w-stt">No</th>
                                                        <th>Order ID</th>
                                                        <th>Customer Name</th>
                                                        <th>Address </th>
                                                        <th>Total Price</th>                                                                                                    
                                                        <th>Create Date</th>
                                                        <th>Status</th>
                                                        <th>Payment</th>
                                                        <th class="w-action-3">Function</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${listOrders}" var="p" varStatus = "loop">
                                                        <tr>
                                                            <td></td>
                                                            <td>${p.id}</td>
                                                            <td>${p.getNameCustomer(requestScope.listC)}</td>
                                                            <td>${p.getAddress(requestScope.listC)}</td>
                                                            <td>${p.totalPrice}</td>
                                                            <td>${p.createDate}</td>
                                                            <td>
                                                                <c:choose>
                                                                    <c:when test="${p.statusOrderDetailId==1}">
                                                                        Đang xử lí
                                                                    </c:when>
                                                                    <c:when test="${p.statusOrderDetailId==2}">
                                                                        Đang vận chuyển
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        Thành công
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>
                                                            <td>${p.payment}</td>
                                                            <td style="text-align: center">
                                                                <a href="view-detail-order?idOrder=${p.id}"  class="view mr-1" data-target="#detail" title="Quick Detail"> <i class="fas fa-eye fa-fw"></i></a>
                                                                    <c:if test="${p.statusOrderDetailId!=3}">
                                                                    <a href="#" data-target="#product_view-${loop.count}" class="edit mr-1" data-toggle="modal" data-target="#update${p.id}" title="Update"> <i class="fas fa-pen fa-fw"></i></a>
                                                                </c:if>
                                                                <a href="remove-order?idOrder=${p.id}" class="remove" data-toggle="modal" data-target="#removeTypeOfMaterialModal" title="Remove "><i class="fas fa-trash fa-fw"></i></a>
                                                            </td>

                                                        </tr>
                                                      
                                                    <!--Update status-->
                                                    <div class="modal fade" id="product_view-${loop.count}" tabindex="-1" role="dialog" aria-labelledby="changePasswordModal" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <form action="update-order?idUpdate=${p.id}" method="post">
                                                                    <!-- Modal Header -->
                                                                    <div class="modal-header">
                                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </button>
                                                                    </div>
                                                                    <!-- Modal body -->
                                                                    <div class="modal-body">
                                                                        <h4 class="mb-4">Update Status Order</h4>
                                                                        <div class="form-group row">
                                                                            <label class="col-sm-5 col-form-label">Status:</label>
                                                                            <div class="col-sm-7">
                                                                                <select class="form-control" name="listStatus">
                                                                                    <c:forEach var="s" items="${listStatus}">
                                                                                        <option value="${s.id}">${s.statusOrderName}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <!-- Modal footer -->
                                                                    <div class="modal-footer">
                                                                        <button type="submit" class="btn btn-md btn-info mr-2">
                                                                            <i class="fas fa-check fa-fw mr-1"></i>Update
                                                                        </button>
                                                                        <button type="button" class="btn btn-md btn-white" data-dismiss="modal">
                                                                            Close
                                                                        </button>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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