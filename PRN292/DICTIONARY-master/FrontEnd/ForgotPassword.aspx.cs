using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Mail;

namespace FrontEnd
{
    public partial class ForgotPassword : System.Web.UI.Page
    {
        UserWebService.UserService service = new UserWebService.UserService();

        protected void Page_Load(object sender, EventArgs e)
        {

        }
        private string RandomCode()
        {
            // tao mang random gui code
            string mess = "";
            Random rand = new Random();

            // mang so
            List<int> lists = new List<int>();
            for (int i = 0; i < 5; i++)
            {
                lists.Add(rand.Next(10));
            }
            // mess
            mess += lists[0] + "";
            mess += lists[1] + "";
            mess += lists[2] + "";
            mess += lists[3] + "";
            mess += lists[4] + "";
            return mess;
        }
        protected void txtSend_Click(object sender, EventArgs e)
        {
            if (!service.checkExisted("[email] like '" + TxtEmail.Text + "'"))
            {
                Label3.Text = "Email is not existed!";
                return;
            }
            string mess = RandomCode();
            Session["forgotCode"] = mess;
            try
            {
                using (MailMessage mail = new MailMessage("thaitnfx01652@funix.edu.vn", TxtEmail.Text, "Code", "Project như này không được 10 hơi phí thầy ơiiiii "+ mess))
                {
                    SmtpClient smtp = new SmtpClient("smtp.gmail.com", 587);
                    smtp.EnableSsl = true;
                    smtp.Credentials = new NetworkCredential("thaitnfx01652@funix.edu.vn", "35740112");
                    smtp.Send(mail);
                    string url = "";
                    url = "ConfirmPassword.aspx?usermail=" + TxtEmail.Text;
                    Response.Redirect(url);
                    Label3.Text = "";
                }
            }
            catch (Exception ex)
            {
                Label3.Text = ex.Message;
            }

        }
    }
}