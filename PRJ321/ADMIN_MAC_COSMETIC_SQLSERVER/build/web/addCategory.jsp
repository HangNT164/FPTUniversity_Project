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

        <!--title-->
        <link rel = "icon" href =  
              "http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico" 
              type = "image/x-icon"> 

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <title>Admin|Mac Cosmetic| Add Category</title>
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
                                Manager Category
                            </h3>
                        </div>
                    </div>

                    <div class="row mt-3">
                        <div class="col-5">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-12 col-sm-12 col-md-12 col-lg-12">
                                            <h5 class="mb-4">Add new category</h5>

                                            <form action="add-category" method="post">
                                                <p style="text-align: center"><b>${requestScope.mess}</b></p>
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Category code:</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" class="form-control" name="txtCodeCategory" placeholder="Enter code category:" required />
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Category name:</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" class="form-control" name="txtCategory" placeholder="Enter name category:" required />
                                                    </div>
                                                </div>
                                                <button type="submit" class="btn btn-info btn-md btn-float-r" name="btnSubmit">
                                                    <i class="fas fa-check fa-fw mr-1"></i>Save
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-7">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-12">
                                            <h5 class="mb-4">List Category</h5>

                                            <c:set value="" var="listTypeOfMaterial" />
                                            <table id="type-of-material" class="table table-bordered w-100" cellspacing="0">
                                                <p style="text-align: center;">${requestScope.messUpdate}</p>
                                                <thead>
                                                    <tr>
                                                        <th class="w-stt">No</th>
                                                        <th class="w-action-3">Code</th>
                                                        <th>Category name</th>
                                                        <th class="w-action-3">Function</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${listCategory}" var="p" varStatus = "i">
                                                        <tr>
                                                            <td></td>
                                                            <td>${p.categoryCode}</td>
                                                            <td>${p.categoryName}</td>
                                                            <td style="text-align: center">
                                                                <a href="#"  data-target="#product_view-${i.count}" class="edit mr-1" data-toggle="modal" title="Xem chi tiết"> <i class="fas fa-pen fa-fw"></i></a>
                                                                <a href="delete-category?id=${p.id}" class="remove" data-toggle="tooltip" data-target="#removeTypeOfMaterialModal" title="Xóa"><i class="fas fa-trash fa-fw"></i></a>
                                                            </td>
                                                        </tr>
                                                    <div class="modal fade" id="product_view-${i.count}" tabindex="-1" role="dialog" aria-labelledby="changePasswordModal" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <form action="update-category?idUpdate=${p.id}" method="post">
                                                                    <!-- Modal Header -->
                                                                    <div class="modal-header">
                                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </button>
                                                                    </div>
                                                                    <!-- Modal body -->
                                                                    <div class="modal-body">
                                                                        <h4 class="mb-4">Update information</h4>
                                                                        <div class="form-group row">
                                                                            <label class="col-sm-5 col-form-label">New category name</label>
                                                                            <div class="col-sm-7">
                                                                                <input type="text" class="form-control" name="txtCategoryUpdate" value="${p.categoryName}"required />
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