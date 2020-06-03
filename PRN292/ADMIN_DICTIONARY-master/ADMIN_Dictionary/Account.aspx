<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Account.aspx.cs" Inherits="ADMIN_Dictionary.Account" %>

<head runat="server">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Dictionary Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="images/favicon.png" />

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="container-scroller">
        <!-- partial:partials/_navbar.html -->
        <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
            <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
                <p style="font-size: 25px;">Admin</p>
            </div>
            <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
                <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
                    <span class="ti-view-list"></span>
                </button>
                <ul class="navbar-nav navbar-nav-right">
                    <li class="nav-item nav-profile dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
                            <img src="<%=avata.ImageLink%>" alt="profile" />
                        </a>
                        <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
                            <a class="dropdown-item" href="Setting.aspx">
                                <i class="ti-settings text-primary"></i>Settings
                            </a>
                            <a class="dropdown-item" href="Login.aspx">
                                <i class="ti-power-off text-primary"></i>Logout
                            </a>
                        </div>
                    </li>
                </ul>
                <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
                    <span class="ti-view-list"></span>
                </button>
            </div>
        </nav>
        <!-- partial -->
        <div class="container-fluid page-body-wrapper">
            <!-- partial:partials/_sidebar.html -->
            <nav class="sidebar sidebar-offcanvas" id="sidebar">
                <ul class="nav">
                    <li class="nav-item">
                        <a class="nav-link" href="Dashboard.aspx">
                            <i class="ti-shield menu-icon"></i>
                            <span class="menu-title">Dashboard</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Works.aspx">
                            <i class="ti-pie-chart menu-icon"></i>
                            <span class="menu-title">Words</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Account.aspx">
                            <i class="ti-pie-chart menu-icon"></i>
                            <span class="menu-title">Account</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Chart.aspx">
                            <i class="ti-pie-chart menu-icon"></i>
                            <span class="menu-title">Charts</span>
                        </a>
                    </li>

                </ul>
            </nav>
            <!-- partial -->
            <div class="main-panel">

                <div class="content-wrapper">

                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Account</li>
                    </ol>

                    <div style="margin-bottom: 24px;">
                        <h1 style="font-size: 20px">Account Admin</h1>
                    </div>


                    <div class="row" style="display: block">

                       
                        <table id="example" class="table table-striped table-bordered" style="width: 100%">

                            <thead>

                                <tr>
                                    <th>User Name</th>
                                    <th>Email</th>
                                    <th>Date Of Birth</th>
                                    <th>Create Date</th>
                                 
                                </tr>
                            </thead>
                            <tbody>
                                <asp:Repeater ID="Repeater2" runat="server">
                                    <ItemTemplate>
                                        <tr>
                                            <td><%#Eval("username")%></td>
                                            <td><%#Eval("email")%></td>
                                            <td><%#Eval("DateOfBirth")%></td>
                                            <td><%#Eval("CreateDate")%></td>
                                         

                                         

                                        </tr>
                                    </ItemTemplate>
                                </asp:Repeater>

                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>User Name</th>
                                    <th>Email</th>
                                    <th>Date Of Birth</th>
                                    <th>Create Date</th>
                                 

                                </tr>
                            </tfoot>
                        </table>




                    </div>




                    <div style="margin-bottom: 24px; margin-top: 30px">
                        <h1 style="font-size: 20px">Account </h1>
                    </div>


                    <div class="row" style="display: block">



                        <table id="example2" class="table table-striped table-bordered" style="width: 100%">

                            <thead>
                                <tr>
                                    <th>User Name</th>
                                    <th>Email</th>
                                    <th>Date Of Birth</th>
                                    <th>Create Date</th>
                                   

                                </tr>
                            </thead>
                            <tbody>
                                <asp:Repeater ID="Repeater1" runat="server">
                                    <ItemTemplate>
                                        <tr>
                                            <td><%#Eval("username")%></td>
                                            <td><%#Eval("email")%></td>
                                            <td><%#Eval("DateOfBirth")%></td>
                                            <td><%#Eval("CreateDate")%></td>

             
                                        </tr>
                                    </ItemTemplate>
                                </asp:Repeater>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>User Name</th>
                                    <th>Email</th>
                                    <th>Date Of Birth</th>
                                    <th>Create Date</th>

                                </tr>
                            </tfoot>
                        </table>
                    </div>


                </div>
            </div>
            <!-- main-panel ends -->
        </div>
        <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->

    <!-- plugins:js -->
    <script src="vendors/base/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page-->
    <script src="vendors/chart.js/Chart.min.js"></script>
    <!-- End plugin js for this page-->
    <!-- inject:js -->
    <script src="js/off-canvas.js"></script>
    <script src="js/hoverable-collapse.js"></script>
    <script src="js/template.js"></script>
    <script src="js/todolist.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page-->
    <script src="js/dashboard.js"></script>
    <script src="js/dashboard.js"></script>

    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/script.js"></script>

    <script>
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
    <script>
        $(document).ready(function () {
            $('#example2').DataTable();
        });
    </script>
    <!-- End custom js for this page-->
</body>

</html>
