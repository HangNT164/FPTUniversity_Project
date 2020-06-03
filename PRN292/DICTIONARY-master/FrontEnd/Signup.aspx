<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Signup.aspx.cs" Inherits="FrontEnd.Signup" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Signup FormDynamic Dictionary|Đăng kí</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/register.css" />
    <link rel="shortcut icon" href="https://stc-laban.zdn.vn/dictionary/images/favicon.ico" />

</head>
<body style="height: 100vh">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-6 container rounded-lg bg-light rounded p-3 shadow-lg">
            <div class="d-flex justify-content-center">
                <h3>Register</h3>
            </div>
            <form id="form1" runat="server">
                <div class="row">
                    <div class="col-4 d-flex justify-content-center">
                        <label>Username</label>
                    </div>
                    <div class="col-8 d-flex justify-content-center">
                        <input runat="server" id="txtName" name="username" placeholder="username" tabindex="2" type="text" required />
                    </div>
                </div>
                <div class="row">
                    <div class="col-4 d-flex justify-content-center ">
                        <label>Password</label>
                    </div>
                    <div class="col-8 d-flex justify-content-center">
                        <input runat="server" id="txtPassword" name="password" type="password" required />
                    </div>

                </div>

                <div class="row">
                    <div class="col-4 d-flex justify-content-center">
                        <label>Email</label>
                    </div>
                    <div class="col-8 d-flex justify-content-center">
                        <input runat="server" id="txtEmail" class="email" name="email" placeholder="example@domain.com" type="text" required />
                    </div>

                </div>
                <div class="row">
                    <div class="col-4 d-flex justify-content-center ">
                        <label>Date of Birth</label>
                    </div>
                    <div class="col-8 d-flex justify-content-center">
                        <input runat="server" id="txtDob" name="dob" placeholder="dd/mm/yyyy" required="" tabindex="2" type="text" />
                    </div>
                </div>
                <div class="row d-flex justify-content-center">
                    <div class="warning" style="color: red" runat="server" id="pWarning"></div>
                    <div class="col-12 d-flex justify-content-center">
                        <button class="submit" runat="server" id="btnSignup" onserverclick="SignupExcute">Sign Up</button></div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
