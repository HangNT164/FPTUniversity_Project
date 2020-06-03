using ADMIN_Dictionary.Dao;
using ADMIN_Dictionary.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ADMIN_Dictionary
{
    public partial class Setting : System.Web.UI.Page
    {
        protected User user { get; set; }
        protected ImageAvata avata { get; set; }
        protected string role { get; set; }



        protected void Page_Load(object sender, EventArgs e)
        {
            labelError.Text = "";

            user = (User)Session["userr"];
            if (user != null)
            {
                avata = new ImageDao().GetImageAvata(user.ID);
                role = new UserDao().getRole(user.ID);
                string action = HttpContext.Current.Request["submit"];

                if (action != null && action == "UpdatePassword") UpdatePassWord();
            }
            else
            {
                Response.Redirect("Login.aspx");
            }
        }

        protected void UpdatePassWord()
        {
            string password = HttpContext.Current.Request["oldpass"];
            string newPass = HttpContext.Current.Request["newpass"];
            string cfPass = HttpContext.Current.Request["cfnewpass"];
            if (password == "" || newPass == "" || cfPass == "")
            {
                Response.Write("<script LANGUAGE='JavaScript' >alert('Fail! Please fill all the blank filed')</script>");
                return;
            }
            if (!user.Password.Equals(password))
            {
                Response.Write("<script LANGUAGE='JavaScript' >alert('Fail! Password is incorrect')</script>");
                return;
            }

            if (!newPass.Equals(cfPass))
            {
                Response.Write("<script LANGUAGE='JavaScript' >alert('Fail! Password and Confirm Password have to be the same')</script>");
                return;
            }
            new UserDao().changePassword(newPass, " id = " + user.ID);
            Response.Write("<script LANGUAGE='JavaScript' >alert('Password is changed sucessfully')</script>");
        }
    }
}