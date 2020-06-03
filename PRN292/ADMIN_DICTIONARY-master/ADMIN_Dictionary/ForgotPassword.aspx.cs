using ADMIN_Dictionary.Service;
using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Mail;

namespace ADMIN_Dictionary
{
    public partial class ForgotPassword : System.Web.UI.Page
    {
        UserService service = new UserService();
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
            string mess = RandomCode();
            Session["forgotCode"] = mess;
            try
            {
                using (MailMessage mail = new MailMessage("thaitnfx01652@funix.edu.vn", TxtEmail.Value, "Code", mess))
                {
                    SmtpClient smtp = new SmtpClient("smtp.gmail.com", 587);
                    smtp.EnableSsl = true;
                    smtp.Credentials = new NetworkCredential("thaitnfx01652@funix.edu.vn", "35740112");
                    smtp.Send(mail);
                    string url = "";
                    url = "ConfirmMail.aspx?usermail=" + TxtEmail.Value;
                    Response.Redirect(url);
                }
            }
            catch (Exception ex)
            {
                pWarning.InnerText=ex.Message;
            }
        }
    }
}