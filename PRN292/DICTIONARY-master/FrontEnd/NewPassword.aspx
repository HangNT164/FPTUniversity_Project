<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="NewPassword.aspx.cs" Inherits="FrontEnd.NewPassword" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>New PasswordDynamic Dictionary|Mật khẩu mới</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/forgotPassword.css" />
    <link rel="shortcut icon" href="https://stc-laban.zdn.vn/dictionary/images/favicon.ico" />

</head>
<body class="bg-white">
    <div class="row d-flex justify-content-center">
        <div class="col-6 bg-light rounded mainContent shadow-lg">
            <div class="row header d-flex justify-content-center">
                <h3>Confirm Code</h3>
            </div>
            <div class="row p-2 border-bottom">
                <p>A code has sent to you. Please check your email.</p>
                <br />

            </div>
            <div class="row m-2 ">
                <form id="form2" runat="server" class="w-100 d-flex justify-content-around">
                    <div>
                        <asp:Label ID="Label4" runat="server" Text="Enter password"></asp:Label>
                        <asp:TextBox ID="txtPassword" class="code px-3" runat="server" Width="150px" Visible="True" EnableViewState="True" TextMode="Password"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" ControlToValidate="txtPassword" runat="server" ErrorMessage="Require"></asp:RequiredFieldValidator>
                    </div>
                    <div>
                        <asp:Label ID="Label5" runat="server" Text="Confirm Password"></asp:Label>
                        <asp:TextBox ID="txtConfirmPass" runat="server" class="code px-3" Width="150px" TextMode="Password"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" ControlToValidate="txtConfirmPass" runat="server" ErrorMessage="Require"></asp:RequiredFieldValidator>
                    </div>
                    <p>
                        <asp:Button ID="btnNewPassword1" class="confirm px-3" runat="server" Text="ChangePassword" OnClick="btnNewPassword_Click" />
                    </p>
                </form>
                <p class="warning" runat="server" id="pWarning"></p>

            </div>
        </div>
    </div>
</body>
</html>
