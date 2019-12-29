
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin|Mac Cosmetic|Dashboard</title>

        <!--title-->


        <!-- Bootstrap core CSS-->
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">




    </head>

    <body id="page-top" >       
        <%@include file="component/header.jsp" %>
        <div id="wrapper">           
            <ul class="sidebar navbar-nav" >
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Product</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <a class="dropdown-item" href="get-all-productt">Get All Product</a>
                        <a class="dropdown-item" href="get-all-category">Create category </a>
                        <a class="dropdown-item" href="get-sub-category">Create subcategory </a>
                        <!--<a class="dropdown-item" href="addProduct.jsp">Tao san pham </a>-->
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="get-all-order">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Order</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="get-all-account">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Account</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="chart">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Chart</span></a>
                </li>
            </ul>
            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Overview</li>
                    </ol>

                    <!-- Icon Cards-->
                    <div class="row">
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-primary o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-comments"></i>
                                    </div>
                                    <div class="mr-5">${product.size()} Products!</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="get-all-productt">
                                    <span class="float-left">View Details</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-warning o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-list"></i>
                                    </div>
                                    <div class="mr-5">${account.size()} Accounts</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="get-all-account">
                                    <span class="float-left">View Details</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-success o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-shopping-cart"></i>
                                    </div>
                                    <div class="mr-5">${order.size() } Orders</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="get-all-order">
                                    <span class="float-left">View Details</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-danger o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-life-ring"></i>
                                    </div>
                                    <div class="mr-5">${card.size() } Process Order</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="get-all-order">
                                    <span class="float-left">View Details</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                    </div>

                    <!-- Area Chart Example-->
                    <div class="card mb-3" >
                        <div class="card-header">
                            <i class="fas fa-chart-area"></i> Area Chart Example</div>
                        <div class="card-body">
                            <canvas id="myAreaChart" width="100%" height="30"></canvas>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div>



                    <!-- /.container-fluid -->
                    <!-- Sticky Footer -->
                    <!--                <footer class="sticky-footer">
                                       
                                    </footer>-->

                </div>
                <!-- /.content-wrapper -->

            </div>
            <!-- /#wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            <!-- Logout Modal-->
            <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <a class="btn btn-primary" href="login.html">Logout</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Bootstrap core JavaScript-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Page level plugin JavaScript-->
            <script src="vendor/chart.js/Chart.min.js"></script>
            <script src="vendor/datatables/jquery.dataTables.js"></script>
            <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin.min.js"></script>

            <!-- Demo scripts for this page-->
            <script src="js/demo/datatables-demo.js"></script>
            <script src="js/demo/chart-area-demo.js"></script>

            <script type="text/javascript">

                var $table = $('#fresh-table'),
                        $alertBtn = $('#alertBtn'),
                        full_screen = false;
                $().ready(function () {
                    $table.bootstrapTable({
                        toolbar: ".toolbar",
                        showRefresh: true,
                        search: true,
                        showToggle: true,
                        showColumns: true,
                        pagination: true,
                        striped: true,
                        sortable: true,
                        pageSize: 8,
                        pageList: [8, 10, 25, 50, 100],
                        formatShowingRows: function (pageFrom, pageTo, totalRows) {
                            //do nothing here, we don't want to show the text "showing x of y from..."
                        },
                        formatRecordsPerPage: function (pageNumber) {
                            return pageNumber + " rows visible";
                        },
                        icons: {
                            refresh: 'fa fa-refresh',
                            toggle: 'fa fa-th-list',
                            columns: 'fa fa-columns',
                            detailOpen: 'fa fa-plus-circle',
                            detailClose: 'fa fa-minus-circle'
                        }
                    });
                });
                $(function () {
                    $alertBtn.click(function () {
                        alert("You pressed on Alert");
                    });
                });
                function operateFormatter(value, row, index) {
                    return [
                        '<a rel="tooltip" title="Like" class="table-action like" href="javascript:void(0)" title="Like">',
                        '<i class="fa fa-heart"></i>',
                        '</a>',
                        '<a rel="tooltip" title="Edit" class="table-action edit" href="javascript:void(0)" title="Edit">',
                        '<i class="fa fa-edit"></i>',
                        '</a>',
                        '<a rel="tooltip" title="Remove" class="table-action remove" href="b?id=' + row.id + '"' + 'title="Remove">',
                        '<i class="fa fa-remove"></i>',
                        '</a>'
                    ].join('');
                }

                window.operateEvents = {
                    'click .like': function (e, value, row, index) {
                        alert('Do you want delete product' + JSON.stringify(row));
                        console.log(value, row, index);
                    },
                    'click .edit': function (e, value, row, index) {
                        console.log(value, row, index);
                    },
                    'click .remove': function (e, value, row, index) {
                        confirm('Do you want delete product?');
                        console.log(value, row, index);
                    }
                };
            </script>

            <script>
                // Set new default font family and font color to mimic Bootstrap's default styling
                Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
                Chart.defaults.global.defaultFontColor = '#292b2c';
// Area Chart Example
                var c = '${a}';
                var ctx = document.getElementById("myAreaChart");
                var myLineChart = new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
                        datasets: [{
                                label: "Money",
                                lineTension: 0.1,
                                backgroundColor: "pink",
                                borderColor: "red",
                                pointRadius: 5,
                                pointBackgroundColor: "pink",
                                pointBorderColor: "deeppink",
                                pointHoverRadius: 5,
                                pointHoverBackgroundColor: "pink",
                                pointHitRadius: 50,
                                pointBorderWidth: 2,
                                data: [299000, 0, 787400, 480000, 578900, 480000, 299000, 730000, 549000, 1800000, 1000000, 0],
                            }],
                    },
                    options: {
                        scales: {
                            xAxes: [{
                                    time: {
                                        unit: 'date'
                                    },
                                    gridLines: {
                                        display: false
                                    },
                                    ticks: {
                                        maxTicksLimit: 7
                                    }
                                }],
                            yAxes: [{
                                    ticks: {
                                        min: 0,
                                        max: 2000000,
                                        maxTicksLimit: 10
                                    },
                                    gridLines: {
                                        color: "rgba(0, 0, 0, .125)",
                                    }
                                }],
                        },
                        legend: {
                            display: false
                        }
                    }
                });</script>
    </body>

</html>