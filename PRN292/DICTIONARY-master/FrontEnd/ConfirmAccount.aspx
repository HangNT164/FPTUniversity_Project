﻿<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ConfirmAccount.aspx.cs" Inherits="FrontEnd.ConfirmAccount" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Confirm EmailDynamic Dictionary|Xác thực tài khoản</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/forgotPassword.css" />
    <link rel="shortcut icon" href="https://stc-laban.zdn.vn/dictionary/images/favicon.ico" />

</head>
<body class="bg-white">
    <div class="row d-flex justify-content-center">
        <div class="col-6 bg-light rounded mainContent shadow-lg">
            <div class="row header d-flex justify-content-center">
                <h3>Confirm email</h3>
            </div>
            <div class="row p-2 border-bottom">
                <p>Please enter your email to get code:</p>
            </div>
            <div class="row m-2 ">
                <form id="form1" runat="server" class="w-100 d-flex justify-content-left">
                    <div class="ml-5">
                        <asp:Label ID="Label1" runat="server" Text="Enter Code:"></asp:Label>
                        <asp:TextBox ID="TxtEmail" class="code" runat="server" Width="150px"></asp:TextBox>
                    </div>
                    <br />
                    <p>
                        <asp:Button ID="txtConfirm" class="mx-5" runat="server" Text="Confirm" OnClick="txtConfirm_Click" />
                    </p>
                    <p class="warning" runat="server" id="pWarning"></p>
                </form>

            </div>
        </div>
    </div>
</body>
</html>
