using Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FrontEnd
{
    public partial class ConfirmAccount : System.Web.UI.Page
    {
        UserWebService.UserService service = new UserWebService.UserService();

        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void txtConfirm_Click(object sender, EventArgs e)
        {
            string codeEnter = TxtEmail.Text;
            string codeSend = (string)Session["confirmAccount"];
            User user = (User)Session["userTemp"];

            if (codeEnter.Equals(codeSend))
            {
                // luu vao DB 
                string dob = user.DateOfBirth + "";
                service.signup(user.Username, user.Password, user.Email, dob);
                // chuyen ve trang login 
                Session.Clear();
                Response.Redirect("login.aspx");
                pWarning.InnerText = "";
            }
            else
            {
                pWarning.InnerText = "Code is wrong";

            }
        }
    }
}