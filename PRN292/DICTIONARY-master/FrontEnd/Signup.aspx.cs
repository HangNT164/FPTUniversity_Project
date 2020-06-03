using Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FrontEnd
{
    public partial class Signup : System.Web.UI.Page
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
        protected void SignupExcute(object sender, EventArgs e)
        {
            string username = txtName.Value;
            string password = txtPassword.Value;
            string email = txtEmail.Value;
            string dob = txtDob.Value;
            if (username != "" && password != "" && email != "" && dob != "")
            {
                if (service.userExited(username))
                {
                    pWarning.InnerHtml = "<p>User has choosed by other.</p> <p>Please try these word: <span style='color:blue; font-weight:bold'>" + username + "123 </span>, <span style='color:blue; font-weight:bold'>" + username+ "9xpro</span>, <span style='color:blue; font-weight:bold'>" + username + "xxx</span> or <span style='color:blue; font-weight:bold'>BoDoi" + username + "</ span ></p>";
                    return;
                }
                if (service.checkExisted("[email] like '" + txtEmail.Value + "'"))
                {
                    pWarning.InnerText = "Email has connected to another account";
                    return;
                }
                DateTime dobDate;
                try
                {
                    dobDate = DateTime.Parse(dob);

                }
                catch (Exception)
                {

                    pWarning.InnerText = "Date not right format";
                    return;
                }
                User user = new User(username, password, email, dobDate);
                Session["userTemp"] = user;

                string mess =  RandomCode();
                Session["confirmAccount"] = mess;

                try
                {
                    using (MailMessage mail = new MailMessage("thaitnfx01652@funix.edu.vn", txtEmail.Value, "Code", "Project như này không được 10 hơi phí thầy ơiiiiii " + mess))
                    {
                        SmtpClient smtp = new SmtpClient("smtp.gmail.com", 587);
                        smtp.EnableSsl = true;
                        smtp.Credentials = new NetworkCredential("thaitnfx01652@funix.edu.vn", "35740112");
                        smtp.Send(mail);
                        Response.Redirect("ConfirmAccount.aspx");
                    }
                }
                catch (Exception ex)
                {
                    pWarning.InnerText = ex.Message;
                }
            }
            else
            {
                pWarning.InnerText = "Please enter all above information";
            }

        }
    }
}