
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

        <title>Admin|Mac Cosmetic|Add Product</title>
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
                                Add Product
                            </h3>
                        </div>
                    </div>

                    <div class="row mt-3 mb-3">
                        <div class="col-12 btn-add">
                            <p class="mb-3">Click button to add new product .</p>

                            <button type="button" class="btn btn-success collapsed" data-toggle="collapse" data-target="#addMaterials" aria-expanded="false" aria-controls="collapse">
                                Add New Product<i class="fas fa-angle-down ml-2"></i>
                            </button>
                        </div>
                    </div>

                    <!--Field ra-->
                    <div class="row">
                        <div class="col-12">
                            <div class="collapse mb-2 ${flag == 1 ? " show " : " "}" id="addMaterials">
                                <div class="col-12">
                                    <div class="mb-2">
                                        <div class="card">
                                            <div class="card-body">
                                                <h5 class="mb-3">Enter infomation of product</h5>


                                                <form action="add-product" method="post" enctype="multipart/form-data" acceptcharset="UTF-8">
                                                    <div class="row">
                                                        <div class="col-6 pr-4">
                                                            <div class="form-group row">
                                                                <div class="col-sm-12">
                                                                    <label>Code Product</label>
                                                                    <input type="text" class="form-control" name="code" value ="" />
                                                                </div>
                                                            </div>
                                                            <div class="form-group row">
                                                                <div class="col-sm-12">
                                                                    <label>Product Name</label>
                                                                    <input type="text" class="form-control" name="name" value ="" />
                                                                </div>
                                                            </div>

                                                            <div class="form-group row">
                                                                <div class="col-sm-12">
                                                                    <label>Sub Category</label>
                                                                    <select class="form-control" name="intSubCate">

                                                                        <c:forEach items="${listSubCategory}" var="sC" varStatus = "loop">
                                                                            <option value="${sC.id}">${sC.subCateName}</option>
                                                                        </c:forEach>

                                                                    </select>
                                                                </div>
                                                            </div>

                                                            <div class="form-group row">
                                                                <div class="col-sm-12">
                                                                    <label>Quantity</label>
                                                                    <input type="text" class="form-control" name="quantity" value ="" />
                                                                </div>
                                                            </div>



                                                        </div>

                                                        <div class="col-6 pl-4">

                                                            <div class="form-group row">
                                                                <div class="col-sm-12">
                                                                    <label>OrginPrice</label>
                                                                    <input type="text" class="form-control" name="orginPrice" value ="" />
                                                                </div>
                                                            </div>
                                                            <div class="form-group row">
                                                                <div class="col-sm-12">
                                                                    <label>SellPrice</label>
                                                                    <input type="text" class="form-control" name="sellPrice" value ="" />
                                                                </div>
                                                            </div>   
                                                            <div class="form-group row">
                                                                <div class="col-sm-12">
                                                                    <label>Color </label>
                                                                    <input type="text" class="form-control" name="color" value ="" />
                                                                </div>
                                                            </div>
                                                            <div class="form-group row mt-4">
                                                                <div class="col-sm-12">
                                                                    <label>Image</label>
                                                                    <input type="file"  class="form-control " style="padding-bottom: 38px" name="fileUpload" multiple />
                                                                </div>
                                                            </div>



                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-12">
                                                            <div class="form-group row">
                                                                <div class="col-sm-12">
                                                                    <label>Descripton Product</label>
                                                                    <textarea rows="3" class="form-control" name="txtDescriptionProduct" placeholder="Enter descripton product " value =" ${p.description}"></textarea>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button type="submit" class="btn btn-md btn-info mr-2"><i class="fas fa-check fa-fw mr-1"></i>ADD</button>
                                                        <button type="button" class="btn btn-md btn-white" data-dismiss="modal">Close</button>
                                                    </div>

                                                </form>   
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>


                    <!-- Modal footer -->
                    <div class="row mt-3">

                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-12">
                                            <h5 class="mb-4">LIST ALL PRODUCT</h5>


                                            <table id="type-of-material" class="table table-bordered w-100" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th class="w-stt">No</th>
                                                        <th>Product Code</th>
                                                        <th>Product Name</th>
                                                        <th>Color</th>
                                                        <th>Orgin Price</th>
                                                        <th>Sell Price</th>
                                                        <th>Quantity</th>
                                                        <th>Status</th>
                                                        <th>Create date</th>

                                                        <th class="w-action-3">Function</th>
                                                    </tr>
                                                </thead>
                                                <tbody>


                                                    <c:forEach items="${listProduct}" var="p" varStatus = "loop">
                                                        <tr>
                                                            <td></td>
                                                            <td>${p.productCode}</td>
                                                            <td>${p.productName}</td>
                                                            <td>${p.color}</td>
                                                            <fmt:setLocale value="vi_VN"/>
                                                            <td><fmt:formatNumber value="${p.orginPrice}" type="currency"/></td>
                                                            <td><fmt:formatNumber value="${p.sellPrice}" type="currency"/></td>
                                                            <td>${p.quantity}</td>
                                                            <td>${p.statusName}</td>
                                                            <td>${p.createDate}</td>
                                                            <td style="text-align: center">
                                                                <a href="#" class="view mr-1" data-toggle="modal" data-target="#detail${p.id}" title="Xem chi tiết"> <i class="fas fa-eye fa-fw"></i></a>
                                                                <a href="#" class="edit mr-1" data-toggle="modal" data-target="#update${p.id}" title="Xem chi tiết"> <i class="fas fa-pen fa-fw"></i></a>
                                                                <a href="delete?id=${p.id}" class="remove" title="Xóa"><i class="fas fa-trash fa-fw"></i></a>
                                                            </td>
                                                        </tr>


                                                        <!-- Su kien show chi tiet -->
                                                    <div class="modal fade" id="detail${p.id}" tabindex="-1" role="dialog" aria-labelledby="detail${p.id}" aria-hidden="true">
                                                        <div class="modal-dialog  modal-lg" role="document">
                                                            <div class="modal-content">
                                                                <div class="card">
                                                                    <div class="card-body">
                                                                        <h5 class="mb-3">Detail infomation of product</h5>
                                                                        <div class="row">
                                                                            <div class="col-6 pr-4">
                                                                                <div class="form-group row">
                                                                                    <div class="col-sm-12">
                                                                                        <label>Code Name</label>
                                                                                        <span class="form-control">${p.productCode} </span>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <div class="col-sm-12">
                                                                                        <label>Name Product</label>
                                                                                        <span class="form-control">${p.productName}</span>
                                                                                    </div>
                                                                                </div>

                                                                                <div class="form-group row">
                                                                                    <div class="col-sm-12">
                                                                                        <label>Sub Category </label>
                                                                                        <span class="form-control">${p.subCateID}</span>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <div class="col-sm-12">
                                                                                        <label>Color </label>
                                                                                        <span class="form-control">${p.color}</span>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <div class="col-sm-12">
                                                                                        <label>Quantity</label>
                                                                                        <span class="form-control">${p.quantity}</span>
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                            <div class="col-6 pl-4">
                                                                                <div class="form-group row">
                                                                                    <div class="col-sm-12">
                                                                                        <label>Quantity</label>
                                                                                        <span class="form-control">${p.quantity}</span>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <div class="col-sm-12">
                                                                                        <label>Orgin Price</label>
                                                                                        <span class="form-control"><fmt:formatNumber value="${p.orginPrice}" type="currency"/> </span>

                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <div class="col-sm-12">
                                                                                        <label>Sell Price</label>
                                                                                        <span class="form-control">
                                                                                            <fmt:formatNumber value="${p.sellPrice}" type="currency"/></span>
                                                                                    </div>
                                                                                </div>                                                        



                                                                                <div class="form-group row">
                                                                                    <div class="col-sm-12">
                                                                                        <label>Create Date</label>
                                                                                        <span class="form-control">${p.createDate}</span>
                                                                                    </div>
                                                                                </div>


                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-12">
                                                                                <div class="form-group row">
                                                                                    <div class="col-sm-12">
                                                                                        <label>Description Product</label>
                                                                                        <textarea rows="5" class="form-control" >${p.description}</textarea>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>

                                                                        <div class="modal-footer">

                                                                            <button type="button" class="btn btn-md btn-white" data-dismiss="modal">Close</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>


                                                    <!-- Su kien update-->
                                                    <div class="modal fade" id="update${p.id}" tabindex="-1" role="dialog" aria-labelledby="update${p.id}" aria-hidden="true">
                                                        <div class="modal-dialog  modal-lg" role="document">
                                                            <div class="modal-content">
                                                                <div class="card">
                                                                    <div class="card-body">
                                                                        <h5 class="mb-3">Detail Information Product</h5>
                                                                        <form action="update-product?idP=${p.id}" method="post" enctype="multipart/form-data" acceptcharset="UTF-8">
                                                                            <div class="row">
                                                                                <div class="col-6 pr-4">
                                                                                    <div class="form-group row">
                                                                                        <div class="col-sm-12">
                                                                                            <label>Code Product</label>
                                                                                            <input type="text" class="form-control" name="code" value = "" />
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group row">
                                                                                        <div class="col-sm-12">
                                                                                            <label>Name Product</label>
                                                                                            <input type="text" class="form-control" name="name" value ="" />
                                                                                        </div>
                                                                                    </div>

                                                                                    <div class="form-group row">
                                                                                        <div class="col-sm-12">
                                                                                            <label>Sub Category</label>
                                                                                            <select class="form-control" name="intSubCate">

                                                                                                <c:forEach items="${listSubCategory}" var="sC" varStatus = "loop">
                                                                                                    <option value="${sC.id}">${sC.subCateName}</option>
                                                                                                </c:forEach>

                                                                                            </select>
                                                                                        </div>
                                                                                    </div>

                                                                                    <div class="form-group row">
                                                                                        <div class="col-sm-12">
                                                                                            <label>Quantity</label>
                                                                                            <input type="text" class="form-control" name="quantity" value ="" />
                                                                                        </div>
                                                                                    </div>



                                                                                </div>

                                                                                <div class="col-6 pl-4">

                                                                                    <div class="form-group row">
                                                                                        <div class="col-sm-12">
                                                                                            <label>Orgin Price</label>
                                                                                            <input type="text" class="form-control" name="orginPrice" value ="" />
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group row">
                                                                                        <div class="col-sm-12">
                                                                                            <label>Sell Price</label>
                                                                                            <input type="text" class="form-control" name="sellPrice" value ="" />
                                                                                        </div>
                                                                                    </div>    
                                                                                    <div class="form-group row">
                                                                                        <div class="col-sm-12">
                                                                                            <label>Color </label>
                                                                                            <input type="text" class="form-control" name="color" value ="" />
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group row mt-4">
                                                                                        <div class="col-sm-12">
                                                                                            <label>Image</label>
                                                                                            <input type="file"  class="form-control " style="padding-bottom: 38px" name="fileUpload" multiple />
                                                                                        </div>
                                                                                    </div>



                                                                                </div>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-12">
                                                                                    <div class="form-group row">
                                                                                        <div class="col-sm-12">
                                                                                            <label>Description Product</label>
                                                                                            <textarea rows="3" class="form-control" name="txtDescriptionProduct" placeholder="Enter description product" value =""></textarea>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                            <div class="modal-footer">
                                                                                <button type="submit" class="btn btn-md btn-info mr-2"><i class="fas fa-check fa-fw mr-1"></i>Update</button>
                                                                                <button type="button" class="btn btn-md btn-white" data-dismiss="modal">Close</button>
                                                                            </div>

                                                                        </form> 



                                                                    </div>
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