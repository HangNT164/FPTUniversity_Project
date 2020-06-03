using ADMIN_Dictionary.Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ADMIN_Dictionary
{
    public partial class NewPassword : System.Web.UI.Page
    {
        string usermail;
        protected void Page_Load(object sender, EventArgs e)
        {
            usermail = Request.QueryString["usermail"];
        }
        protected void txtConfirm_New_Click(object sender, EventArgs e)
        {
            string password = TxtNewPassword.Value;
            string cfPass = txtConfirmPass.Value;
            if (!password.Equals(cfPass))
            {
                pWarning.InnerText = "Password and Confirm password not match";

            }
            else
            {
                // update password
                UserService service = new UserService();
                service.changePassword(password, " email like '" + usermail + "' ");
                // chuyen toi login
                Response.Redirect("Login.aspx");
            }

        }
    }
}