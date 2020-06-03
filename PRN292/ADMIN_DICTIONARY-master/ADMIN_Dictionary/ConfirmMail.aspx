<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ConfirmMail.aspx.cs" Inherits="ADMIN_Dictionary.ConfirmMail" %>

<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" i ntegrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assetss/css/bootstrap/bootstrap.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="assetss/css/mnd/form.css">

    <title>Forgot password</title>


</head>

<body>

    <div id="intro">
        <div class="middle signin">
            <div class="login-panel">
                <div class="logo text-center">
                    <br />
                    <a href="#">Dictionary</a><br />
                    <br />
                </div>
                <form id="form1" runat="server">
                    <p class="warning" runat="server" id="pWarning"></p>
                    <div class="form-group">
                        <label>
                            <i class="fas fa-user fa-fw"></i>
                        </label>
                        <input type="text" class="form-control" placeholder="Verify" id="TxtEmail" runat="server" required />
                    </div>

                    <br>
                    <div class="form-group">
                        <div class="col">
                            <button runat="server" onserverclick="txtConfirm_Click" class="btn btn-sm">
                                <i class="fas fa-sign-in-alt fa-fw mr-1"></i>Confirm
                               
                            </button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col">
                            <a class="link-effect" href="#"></a>
                            <a class="link-effect float-right" href="Login.aspx">
                                <i class="fas fa-question fa-fw mr-1"></i>Login
                            </a>
                            <br />
                            <br />
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>

    <footer>
        <p>
            © 2020 Dictionary System
       
        </p>
    </footer>

    <!-- Bootstrap core JavaScript-->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js "></script>
    <script src="assetss/js/bootstrap/popper.min.js"></script>
    <script src="assetss/js/bootstrap/bootstrap.min.js"></script>
</body>

</html>
