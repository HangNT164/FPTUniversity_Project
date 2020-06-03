<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Dictionary.aspx.cs" Inherits="FrontEnd.Dictionary" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Home|Dynamic Dictionary|Trang chủ</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css" />
    <link rel="stylesheet" type="text/css" href="CSS/home.css" />
    <link rel="shortcut icon" href="https://stc-laban.zdn.vn/dictionary/images/favicon.ico"/>
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

        .pointer {
            cursor: pointer;
        }
    </style>
</head>
<body id="body">

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

    <!-- main -->

    <div class="container mt-3 mb-4 col-12 main bg-light">
        <div class="row d-flex justify-content-center">
            <div class="col-md-2" style="display: block">
                <div class="card div-content">
                    <div class="card-header">
                        <h4>Related words</h4>
                    </div>
                    <div style="height: 92%; overflow: auto">
                        <ul id="listWord" runat="server" class="list-group list-group-flush">
                            <li class="list-group-item">Cras justo odio</li>
                            <li class="list-group-item">Cras justo odio</li>
                            <li class="list-group-item">Cras justo odio</li>
                            <li class="list-group-item">Cras justo odio</li>
                            <li class="list-group-item">Dapibus ac facilisis in</li>
                            <li class="list-group-item">Dapibus ac facilisis in</li>
                            <li class="list-group-item">Cras justo odio</li>
                            <li class="list-group-item">Vestibulum at eros</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-7 rounded border div-content" style="overflow: auto">
                <div id="container">

                    <div class="header" style="display: none">
                        <div class="header-left">
                            <h1><span>DYNAMIC</span> DICTIONARY</h1>
                            <h3 id="head-description">Search in own dictionary</h3>
                        </div>
                        <div class="header-right">
                            <button runat="server" id="btnUserChange" onserverclick="ChangeUser"></button>
                            <a class="header-link" runat="server" id="lblUsername"></a>
                        </div>
                    </div>
                    <div style="height: 20%">
                        <form id="searchForm" runat="server">
                            <input type="text" name="keyWord" id="keyword" runat="server" placeholder="Tìm kiếm từ khóa..." />
                            <div id="selection">
                                <select id="kindOfDic" runat="server" onchange="changeDictionary()">
                                    <option value="1">Anh - Việt</option>
                                    <option value="2">Việt - Anh</option>
                                </select>
                                <%--<asp:Button ID="btSearch" class="searchButton" runat="server" OnClick="Search" Text="Search" />--%>
                                <button id="btns" class="searchButton" onserverclick="Search" runat="server"><i style="margin-top: -10px;" class="fa fa-search"></i></button>
                                <%--<button id="btnWord" class="searchButton" onserverclick="showWord" runat="server" style="display:none"></button>--%>
                            </div>
                        </form>
                    </div>

                    <div style="height: 80%; overflow: auto">
                        <h3 id="kindOfDictionary">Từ điển Anh - Việt</h3>
                        <span id="volumnUp"><i class="fa fa-volume-up"></i></span>
                        <hr />
                        <div class="div-note" id="divNote" runat="server">
                            <a id="btnNote" runat="server" href="Login.aspx">
                                <span style="font-size: 30px; color: Dodgerblue;">
                                    <i class="fa fa-edit"></i>
                                </span>
                            </a>

                            <div class="note-content" id="lblNote" runat="server"></div>
                        </div>
                        <div id="demo" runat="server"></div>
                    </div>
                    <%--<div id="demo" runat="server"></div>--%>
                </div>

            </div>
            <div class="col-md-2" runat="server" id="myNote">
                <div class="card">
                    <div class="card-header">
                        <h4>My note</h4>
                    </div>
                    <ul id="lstNote" runat="server" class="list-group list-group-flush">
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Dapibus ac facilisis in</li>
                        <li class="list-group-item">Dapibus ac facilisis in</li>
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Vestibulum at eros</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- end main -->
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
    <script>
        window.onload = changeDictionary();

        function show(text) {
            document.getElementById("keyword").value = text;
            document.getElementById("btns").click();

        }

        function changeDictionary() {
            onloading();
            var val = document.getElementById('kindOfDic').value;
            if (val === "1") {
                document.getElementById('kindOfDictionary').innerText = "Từ điển Anh - Việt";
            } else {
                document.getElementById('kindOfDictionary').innerText = "Từ điển Việt - Anh";
            }

        }

        //speech
        function onloading() {
            if ('speechSynthesis' in window) {
                var synth = speechSynthesis;
                var flag = false;
                synth.getVoices().forEach(voice => {
                    console.log(voice.name, voice.lang)
                })

                /* references to the buttons */
                var playEle = document.querySelector('#volumnUp');


                /* click event handlers for the buttons */
                playEle.addEventListener('click', onClickPlay);
                function onClickPlay() {
                    if (!flag) {
                        flag = true;
                        utterance = new SpeechSynthesisUtterance(
                            document.getElementById('keyword').value);
                        utterance.voice = synth.getVoices()[8];
                        console.log(utterance.voice.lang);
                        utterance.onend = function () {
                            flag = false;
                        };
                        synth.speak(utterance);
                    }
                    if (synth.paused) { /* unpause/resume narration */
                        synth.resume();
                    }
                }

            }
            else {
                /* speech synthesis not supported */
                alert('No')
            }
        }



    </script>
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
