<%-- 
    Document   : chart
    Created on : Oct 29, 2019, 1:15:53 AM
    Author     : TuanNA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin|Mac Cosmetic|Charts</title>

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
    </head>

    <body id="page-top">

        <%@include file="component/header.jsp" %>

        <div id="wrapper">

            <ul class="sidebar navbar-nav" >
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp" style="background: black">
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
                        <li class="breadcrumb-item active">Charts</li>
                    </ol>

                    <!-- Area Chart Example-->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-chart-area"></i>

                            MONTHLY SALES CHART</div>
                        <div class="card-body">
                            <canvas id="myAreaChart" width="100%" height="30"></canvas>
                        </div>
                        <div class="card-footer small text-muted">Update By Mac Comsetic</div>
                    </div>

                    <div class="row">
                        <div class="col-lg-8">
                            <div class="card mb-3">
                                <div class="card-header">
                                    <i class="fas fa-chart-bar"></i>

                                    GROSS MONTHLY MONEY GROSS CHART</div>
                                <div class="card-body">
                                    <canvas id="myBarChart" width="100%" height="50"></canvas>
                                </div>
                                <div class="card-footer small text-muted">Updated by Mac Comsetic</div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card mb-3">
                                <div class="card-header">
                                    <i class="fas fa-chart-pie"></i>
                                    GROSS GROSS CHART OF PRODUCT TYPES</div>
                                <div class="card-body">
                                    <canvas id="myPieChart" width="100%" height="100"></canvas>
                                </div>
                                <div class="card-footer small text-muted">Updated by Mac Comsetic</div>
                            </div>
                        </div>
                    </div>


                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <footer class="sticky-footer">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Mac Comestic Admin By TuanNA</span>
                        </div>
                    </div>
                </footer>

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

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin.min.js"></script>

        <!-- Demo scripts for this page-->
            <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>

  
   



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
                            data: ["${t1}", "${t2}", "${t3}", "${t4}", "${t5}", "${t6}", "${t7}", "${t8}", "${t9}", "${t10}", "${t11}", "${t12}"],
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


        <script>
            // Set new default font family and font color to mimic Bootstrap's default styling
            Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
            Chart.defaults.global.defaultFontColor = '#292b2c';

// Pie Chart Example
            var ctx = document.getElementById("myPieChart");
            var myPieChart = new Chart(ctx, {
                type: 'pie',
                data: {
                    labels: ["Product < 300k", "Product [300k-600k]", "Product[600k-1000k]", "Other"],
                    datasets: [{
                            data: ["${c1}", "${c2}", "${c3}", "${c2}"],
                            backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745'],
                        }],
                },
            });

        </script>

        <script>
            // Set new default font family and font color to mimic Bootstrap's default styling
            Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
            Chart.defaults.global.defaultFontColor = '#292b2c';

            var ctx = document.getElementById("myBarChart");
            var myLineChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
                    datasets: [{
                            label: "Total Price",
                            backgroundColor: "rgba(2,117,216,1)",
                            borderColor: "rgba(2,117,216,1)",
                            data: ["${tt1}", "${tt2}", "${tt3}", "${tt4}", "${tt5}", "${tt6}", "${tt7}", "${tt8}", "${tt9}", "${tt10}", "${tt11}", "${tt12}"],
                        }],
                },
                options: {
                    scales: {
                        xAxes: [{
                                time: {
                                    unit: 'month'
                                },
                                gridLines: {
                                    display: false
                                },
                                ticks: {
                                    maxTicksLimit: 6
                                }
                            }],
                        yAxes: [{
                                ticks: {
                                    min: 0,
                                    max: 7000000,
                                    maxTicksLimit: 5
                                },
                                gridLines: {
                                    display: true
                                }
                            }],
                    },
                    legend: {
                        display: false
                    }
                }
            });

        </script>
    </body>

</html>
