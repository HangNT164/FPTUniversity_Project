<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DetailUser.aspx.cs" Inherits="FrontEnd.DetailUser" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Setting|Dynamic Dictionary|Cài đặt</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="shortcut icon" href="https://stc-laban.zdn.vn/dictionary/images/favicon.ico" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <style>
        .header-top {
            background-image: url("./images/bg-header.jpg");
            min-height: 7vh;
        }

        .footer {
            background-image: url("./images/footer.png");
            min-height: 17vh;
        }

        .row-footer {
            background-color: rgba(0, 0, 0, 0.5);
            overflow: auto;
            height: 100%;
        }

        .container {
        }

        .div-content {
            height: 71.4vh;
        }

        body {
            overflow: auto;
            font-size: small;
            /* background-image: linear-gradient(#17a2b8, #9198e5); */
            background-size: contain;
        }

        .main {
            height: 100%;
            overflow: hidden;
        }

        .avatar {
            vertical-align: middle;
            width: 50px;
            height: 50px;
            border-radius: 50%;
        }

        .brand-img {
            width: 50px;
        }

        .logo-txt {
            font-weight: bold;
            font-size: xx-large;
        }

        ul li a {
            text-decoration: none;
        }

        .drop-menu {
            background-color: rgba(108, 117, 125, 0.2);
            width: max-content;
        }

        li {
            font-size: larger;
        }

        #avatar-wrapper {
            background-color: rgba(0, 0, 0, 0);
        }

            #avatar-wrapper:hover {
                background-color: rgba(0, 0, 0, 0.3);
            }
    </style>
</head>
<body>
    <!-- header -->
    <!-- <div class="container"> -->
    <nav class="navbar col-12 navbar-default bg-info header-top">
        <div class="container-fluid d-flex align-items-center">
            <div class="navbar-header fl">
                <a class="navbar-brand" href="Dictionary.aspx">
                    <img class="brand-img" alt="Brand" src="./images/brand.png">
                </a>
            </div>
            <div class="navbar-header fl pl-5">
                <span class="logo-txt text-white"><span class="text-green"></span>MY - DICTIONARY</span>
            </div>
            <form class="navbar-form navbar-left" role="search">

                <div class="dropdown float-left px-3">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                        aria-expanded="false">
                        <img id="avatarBig" runat="server" src="images/default.jpg"
                            alt="Avatar" class="avatar">

                        <span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-menu-right drop-menu">
                        <li><a class="text-decoration-none " runat="server" id="linkEdit" href="DetailUser.aspx">
                            <img id="avatarSmall" runat="server" style="width: 25px; height: auto;"
                                src="images/default.jpg"
                                alt="Avatar" class="avatar">
                            Edit User Profile</a></li>
                        <li><a class="text-decoration-none " runat="server" id="linkNote" href="MyPage.aspx">
                            <img style="width: 25px; height: auto;" src="./images/note.png">
                            Term note</a></li>
                        <li><a class="text-decoration-none" runat="server" id="linkLogout" href="#">
                            <img style="width: 25px; height: auto;" src="./images/logout.png">
                            <span id="txtLogout" onclick="logout()">Logout</span></a></li>
                        <li><a class="text-decoration-none" runat="server" id="linkLogin" href="Login.aspx">
                            <img style="width: 25px; height: auto;" src="./images/login.png">
                            <span id="txtLogin" runat="server">Login</span></a></li>
                        <li role="separator" class="divider"></li>
                        <!-- <li><a href="#">Separated link</a></li> -->
                    </ul>
                </div>
            </form>
            <script>
                // On mouse-over, execute myFunction
                function logout() {
                    document.getElementById("btnUserChange").click(); // Click on the checkbox
                }
            </script>
        </div>

    </nav>
    <!-- </div> -->
    <!-- end header -->
    <div class="header" style="display: none">
        <button runat="server" id="btnUserChange" onserverclick="ChangeUser"></button>

    </div>
    <script>
        function upload() {
            document.getElementById("oFile").click();
            document.getElementById("oFile").onchange = function () {
                document.getElementById("btnUpload1").click();
            };
        }

    </script>
    <!--Main-->
    <div class="container" style="position: relative; margin-top: 100px;">
        <div class="row">
            <div class="col-4">
                <div class="img-wrapper shadow-lg ml-5" style="width: 200px; height: 200px; border-radius: 50%; overflow: hidden">
                    <img id="avatarBigChange" runat="server" style="width: 100%;" src="<%= ia.ImageLink %>">
                    <div id="avatar-wrapper" class=" d-flex justify-content-center align-items-end" style="width: 200px; height: 200px; position: absolute; top: 0px; border-radius: 50%">
                        <img onclick="upload()" id="camera" src="images/camera.png" style="width: 50px;" />
                    </div>
                </div>
            </div>
            <div class="col-8">
                <h5>Thông tin của <%= userr.Username %></h5>
                <h4>Role : <%= roleName %></h4>
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#about">About</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#changePassword">Change Password</a>
                    </li>
                    <li class="nav-item" style="visibility: hidden;">
                        <a class="nav-link" data-toggle="tab" href="#avataUpdate">Update Avata</a>
                    </li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div id="about" class="container tab-pane active">
                        <br>
                        <div class="row">
                            <div class="col-md-4">
                                <label>Username</label>
                            </div>
                            <div class="col-md-4">
                                <p><%= userr.Username %></p>
                            </div>
                        </div>
                        <%--    <div class="row">
                    <div class="col-md-4">
                        <label>Name</label>
                    </div>
                    <div class="col-md-4">
                        <p>Kshiti Ghelani</p>
                    </div>
                </div>--%>
                        <div class="row">
                            <div class="col-md-4">
                                <label>Email</label>
                            </div>
                            <div class="col-md-4">
                                <p><%= userr.Email %></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                Date of Birth
                            </div>
                            <div class="col-md-4">
                                <p><%= userr.DateOfBirth.ToShortDateString() %></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                Created Date
                            </div>
                            <div class="col-md-4">
                                <p><%= userr.CreateDate.ToShortDateString() %></p>
                            </div>
                        </div>

                    </div>
                    <%--UpdateAvata--%>
                    <div id="avataUpdate" class="container tab-pane fade">
                        <form id="detailUser" runat="server">
                            <div>
                                <input id="oFile" type="file" runat="server" name="oFile" />
                                <asp:Button ID="btnUpload1" type="submit" Text="Upload" runat="server" OnClick="btnUpload1_Click"></asp:Button>
                                <asp:Panel ID="frmConfirmation" Visible="False" runat="server">
                                    <asp:Label ID="lblUploadResult" runat="server"></asp:Label>
                                </asp:Panel>
                            </div>
                        </form>
                    </div>
                    <%-- /UpdateAvata--%>
                    <div id="changePassword" class="container tab-pane fade">
                        <br>
                        <form action="detailUser.aspx" method="post" id="changePasswordID">
                            <div class="form-group">
                                <label for="inputPass">Old Password</label>
                                <input type="password" class="form-control" placeholder="Old Password" name="oldpass">
                            </div>
                            <div class="form-group">
                                <label for="inputNew">New Password</label>
                                <input type="password" class="form-control" placeholder="New Password" name="newpass" id="password">
                            </div>
                            <div class="form-group">
                                <label for="inputConfNew">Confirm new password</label>
                                <input type="password" class="form-control" placeholder="Confirm New Password" name="cfnewpass">
                            </div>

                            <br />
                            <asp:Label ID="lbStatusChangePassword" runat="server" Text=""></asp:Label>
                            <br />
                            <p style="text-align: right;">
                                <button type="submit" id="action" name="action" value="changePass" class="btn btn-info">Update</button>
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Nav tabs -->

    </div>

    <!--end Main-->

    <div class="page-footer col-12 container bg-info text-white footer" style="position: fixed; bottom: 0px;">
        <div class="row pt-3 row-footer">
            <div class="col-6">
                <div class="pl-5">
                    <h3>Contact</h3>
                    <p>A project developed by HangBeo Team</p>
                    <p>(+84) 032 818 6778</p>
                    <p>P/s: Yêu thầy Hà Đẹp Trai</p>
                </div>
            </div>
            <div class="col-6 ">
                <div class="row d-flex justify-content-center">
                    <h3 class="shadow">Member Of Team</h3>
                </div>
                <div class="row">
                    <div class="col-6 d-flex justify-content-center">
                        <p class="shadow">Nguyễn Thuý Hằng</p>
                    </div>
                    <div class="col-6 d-flex justify-content-center">
                        <p class="shadow">Nguyễn Tiến Dũng</p>
                    </div>
                </div>
                <div class="row ">
                    <div class="col-6 d-flex justify-content-center">
                        <p class="shadow">Nguyễn Văn Đạt</p>
                    </div>
                    <div class="col-6 d-flex justify-content-center">
                        <p class="shadow">Ngô Anh Tuấn</p>
                    </div>
                </div>
                <div class="row  d-flex justify-content-center">
                    <p class="shadow">Nguyễn Duy Quân</p>
                </div>

            </div>
        </div>

    </div>
    <!-- script -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/snow.js"></script>

</body>
</html>
