using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FrontEnd
{
    public partial class NewPassword : System.Web.UI.Page
    {
        string usermail;
        protected void Page_Load(object sender, EventArgs e)
        {
            usermail = Request.QueryString["usermail"];
        }
        protected void btnNewPassword_Click(object sender, EventArgs e)
        {
            string password = txtPassword.Text;
            string cfPass = txtConfirmPass.Text;
            if (!password.Equals(cfPass))
            {
                pWarning.InnerText="Password and Confirm password not match";
                
            }
            else
            {
                // update password
                UserWebService.UserService service = new UserWebService.UserService();
                service.changePassword(password, " email like '" + usermail + "' ");
                // chuyen toi login
                Response.Redirect("Login.aspx");
            }

        }
    }
}