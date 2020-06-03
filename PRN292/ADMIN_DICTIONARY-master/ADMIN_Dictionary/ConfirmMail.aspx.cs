using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ADMIN_Dictionary
{
    public partial class ConfirmMail : System.Web.UI.Page
    {
        string usermail = "";
        protected void Page_Load(object sender, EventArgs e)
        {
            usermail = Request.QueryString["usermail"];
        }
        protected void txtConfirm_Click(object sender, EventArgs e)
        {
            string codeEnter = TxtEmail.Value;
            string codeSend = (string)Session["forgotCode"];
            if (codeEnter.Equals(codeSend))
            {
                Session.Clear();
                Response.Redirect("NewPassword.aspx?usermail=" + usermail);
            }
            else
            {
                pWarning.InnerText = "Code is wrong";

            }
        }
    }
}