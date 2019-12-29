
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
        <title>Admin|Mac Cosmetic|VietName| Account</title>
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
                                Account
                            </h3>
                        </div>
                    </div>
                    <!--Field ra-->
                    <div class="row mt-3">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-12">
                                            <h5 class="mb-4">List Account Admin</h5>
                                            <table id="type-of-material" class="table table-bordered w-100" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>No</th>
                                                        <th>Name</th>
                                                        <th>Email</th>
                                                        <th>Phone</th>
                                                        <th>Gender</th>
                                                        <th>Address</th>
                                                        <th>Create Date</th>
                                                        <th class="w-action-3">Function</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="a" items="${listAdmin}" varStatus="loop">
                                                        <tr>
                                                            <td>${loop.count}</td>
                                                            <td>${a.name}</td>
                                                            <td>${a.email}</td>
                                                            <td>${a.phone}</td>
                                                            <td>  
                                                                <c:choose>
                                                                    <c:when test="${a.gender==0}">
                                                                        Female
                                                                    </c:when>
                                                                    <c:when test="${a.gender==1}">
                                                                        Male
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        Other
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>
                                                            <td>${a.address}</td>
                                                            <td>${a.createDate}</td>
                                                            <td style="text-align: center">         
                                                                <a href="#" data-target="#quick-${loop.count}" class="view mr-1" data-toggle="modal" title="Quick Detail"> <i class="fas fa-eye fa-fw"></i></a>
                                                            </td>
                                                        </tr>

                                                        <!-- Su kien show chi tiet -->
                                                    <div class="modal fade" id="quick-${loop.count}" tabindex="-1" role="dialog" aria-labelledby="changePasswordModal" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <!-- Modal Header -->
                                                                <div class="modal-header">
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <!-- Modal body -->
                                                                <div class="modal-body">
                                                                    <h4 class="mb-4">Information admin</h4>
                                                                    <div class="form-group row">
                                                                        <label class="col-sm-5 col-form-label">Name</label>
                                                                        <div class="col-sm-7">
                                                                            <input type="text" class="form-control" value="${a.name}"/>
                                                                            <br>
                                                                        </div>
                                                                        <label class="col-sm-5 col-form-label">Email</label>
                                                                        <div class="col-sm-7">
                                                                            <input type="text" class="form-control" value="${a.email}"/>
                                                                            <br>
                                                                        </div>
                                                                        <label class="col-sm-5 col-form-label">Phone</label>
                                                                        <div class="col-sm-7">
                                                                            <input type="text" class="form-control" value="${a.phone}"/>
                                                                            <br>
                                                                        </div>
                                                                        <label class="col-sm-5 col-form-label">Gender</label>
                                                                        <div class="col-sm-7">
                                                                            <c:choose>
                                                                                <c:when test="${a.gender==0}">
                                                                                    <input type="text" class="form-control" value="Female"/>
                                                                                    <br>
                                                                                </c:when>
                                                                                <c:when test="${a.gender==1}">
                                                                                    <input type="text" class="form-control" value="Male"/>
                                                                                    <br>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <input type="text" class="form-control" value="Other"/>
                                                                                    <br>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </div>
                                                                        <label class="col-sm-5 col-form-label">Address</label>
                                                                        <div class="col-sm-7">
                                                                            <input type="text" class="form-control" value="${a.address}"/>
                                                                            <br>
                                                                        </div>
                                                                        <label class="col-sm-5 col-form-label">Create date</label>
                                                                        <div class="col-sm-7">
                                                                            <input type="text" class="form-control" value="${a.createDate}"/>
                                                                            <br>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <!-- Modal footer -->
                                                                <div class="modal-footer">                                                                  
                                                                    <button type="button" class="btn btn-md btn-white" data-dismiss="modal">
                                                                        Close
                                                                    </button>
                                                                </div>
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
                    <div class="row mt-3">
                        <div class="col-12 mt-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-12">
                                            <h5 class="mb-4">List Account User</h5>
                                            <table id="type-of-material" class="table table-bordered w-100" cellspacing="0">
                                                <p style="text-align: center;">${requestScope.mess}</p>
                                                <thead>
                                                    <tr>
                                                        <th>No</th>
                                                        <th>Name</th>
                                                        <th>Email</th>
                                                        <th>Phone</th>
                                                        <th>Gender</th>
                                                        <th>Address</th>
                                                        <th>Create Date</th>
                                                        <th class="w-action-3">Function</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="a" items="${listUser}" varStatus="i">
                                                        <tr>
                                                            <td>${i.count}</td>
                                                            <td>${a.name}</td>
                                                            <td>${a.email}</td>
                                                            <td>${a.phone}</td>
                                                            <td>  
                                                                <c:choose>
                                                                    <c:when test="${a.gender==0}">
                                                                        Female
                                                                    </c:when>
                                                                    <c:when test="${a.gender==1}">
                                                                        Male
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        Other
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>                                                          
                                                            <td>${a.address}</td>
                                                            <td>${a.createDate}</td>
                                                            <td style="text-align: center">

                                                                <a href="#" data-target="#product_view-${i.count}"  class="edit mr-1" data-toggle="modal" title="Update"> <i class="fas fa-pen fa-fw"></i></a>
                                                                <a href="remove-user?idUser=${a.accountID}" class="remove" data-toggle="tooltip" data-target="#removeTypeOfMaterialModal" title="Remove"><i class="fas fa-trash fa-fw"></i></a>
                                                            </td>
                                                        </tr>

                                                        <!--Update-->
                                                    <div class="modal fade" id="product_view-${i.count}" tabindex="-1" role="dialog" aria-labelledby="changePasswordModal" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <form action="update-user?idUpdate=${a.accountID}" method="post">
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
                                                                            <label class="col-sm-5 col-form-label">Role:</label>
                                                                            <div class="col-sm-7">
                                                                                <select class="form-control" name="listRole">
                                                                                    <c:forEach var="s" items="${listRole}">
                                                                                        <option value="${s.id}">${s.roleName}</option>
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