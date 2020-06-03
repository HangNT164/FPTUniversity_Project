<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="TermEdit.aspx.cs" Inherits="FrontEnd.TermEdit" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Team Edit|Dynamic Dictionary|Ghi chú</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css" />
    <link rel="stylesheet" type="text/css" href="CSS/home.css" />
    <link rel="shortcut icon" href="https://stc-laban.zdn.vn/dictionary/images/favicon.ico" />

    <style type="text/css">
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

        .div-note {
            display: flex;
            flex-direction: row;
            margin-bottom: 10px;
        }

        .div-note-btn {
            width: 35px;
        }

        .note-content {
            border: 1px solid gray;
            border-radius: 10px;
            line-height: 20px;
            padding: 5px;
            margin-left: 10px;
            width: 100%;
        }

        #txtNote, #txtNote2 {
            outline: none;
            height: 80px;
            font-family: sans-serif;
            font-size: 16px;
            resize: vertical;
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

    <!--Main-->
    <div class="container">
        <h3 id="kindOfDictionary" runat="server">Abide</h3>
        <hr />
        <form class="div-note" id="divNote" runat="server">
            <div class="div-note-btn">
                <a id="btnEdit" runat="server" onserverclick="EditNote">
                    <span style="font-size: 30px; color: Dodgerblue;">
                        <i class="fa fa-edit"></i>
                    </span>
                </a>
                <a id="btnCancel" runat="server" onserverclick="CancelEdit">
                    <span style="font-size: 30px; color: tomato;">
                        <i class="fa fa-ban"></i>
                    </span>
                </a>
            </div>

            <asp:TextBox CssClass="note-content" runat="server" ID="txtNote2" />

        </form>
        <div id="demo" runat="server"></div>
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
