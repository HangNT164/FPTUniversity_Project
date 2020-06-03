<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="FrontEnd.Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Login FormDynamic Dictionary|Đăng nhập</title>
    <link rel="stylesheet" href="css/style.css" />
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="shortcut icon" href="https://stc-laban.zdn.vn/dictionary/images/favicon.ico" />
    <link rel="stylesheet" href="css/login.css" />
    <%--<link rel="stylesheet" href="css/style.css" />--%>
</head>
<body class="bg-white">
    <div class="row d-flex justify-content-center align-items-center" style="height: 100vh;">
        <div class="col-7 container rounded-lg bg-light rounded mainContent shadow-lg h-50">
            <div class="row d-flex justify-content-center m-5">
                <div class="col-6">
                    <img src="images/loginForm/desktop.png" />
                </div>
                <div class="col-6">
                    <h3>Login</h3>
                    <form id="form1" runat="server" class="d-flex flex-column">
                        <input runat="server" id="txtUsername" name="txtUsername" class="username w-100 mx-0" type="text" placeholder="Username" required />
                        <input runat="server" id="txtPassword" class="password w-100 mx-0" type="password" placeholder="Password" required />
                        <p class="warning" runat="server" id="pWarning"></p>
                        <button runat="server" class="login my-4 py-2 w-100" onserverclick="LoginSubmit">Login</button>
                        <p>Forgot <a href="ForgotPassword.aspx">Username / Password ?</a></p>
                        <br />
                        <a href="Signup.aspx">Create Account ></a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
