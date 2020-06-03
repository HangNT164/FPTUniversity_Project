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
    public partial class Dashboard : System.Web.UI.Page
    {
    
        protected User user { get; set; }
        protected ImageAvata avata { get; set; }
        protected List<User> listAccount { get; set; }
        protected List<Definition> listWorks { get; set; }
        protected List<User> listAdmin { get; set; }
        protected void Page_Load(object sender, EventArgs e)
        {
             user = (User)Session["userr"];
            if (user != null)
            {
                avata = new ImageDao().GetImageAvata(user.ID);
                listAccount = new UserDao().getAllUserBuRole(2);
                listAdmin = new UserDao().getAllUserBuRole(1);
                listWorks = new WorksDao().getAll();
            }
            else
            {
                Response.Redirect("Login.aspx");
            }
        }
    }
}