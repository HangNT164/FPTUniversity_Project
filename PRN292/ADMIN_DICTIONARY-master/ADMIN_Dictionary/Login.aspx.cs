using ADMIN_Dictionary.Entity;
using ADMIN_Dictionary.Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ADMIN_Dictionary
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void LoginSubmit(object sender, EventArgs e)
        {
            User user = new UserService().login(txtUsername.Value, txtPassword.Value);
            if (user != null)
            {
                Session["username"] = user.Username;
                Session["userid"] = user.ID;
                Session["userr"] = user;
                int number = user.RoleID;
                if (number == 1)
                {
                    Response.Redirect("dashboard.aspx");
                }
                pWarning.InnerText = "Account can't  allowed to login";
            }
            else
            {
                pWarning.InnerText = "Username or password is wrong";
            }
        }
    }
}