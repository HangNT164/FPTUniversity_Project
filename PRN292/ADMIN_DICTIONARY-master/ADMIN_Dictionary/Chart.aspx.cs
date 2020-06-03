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
    public partial class Chart : System.Web.UI.Page
    {
        protected List<User> listAccount { get; set; }

        protected User user { get; set; }
        protected ImageAvata avata { get; set; }
        protected void Page_Load(object sender, EventArgs e)
        {
            user = (User)Session["userr"];
            avata = new ImageDao().GetImageAvata(user.ID);

            listAccount = new UserDao().getAllUserBuRole(2);
        }

        int c = 10;

        protected int Count(int number,int number2)
        {
           int count = 0;

            DateTime now = DateTime.Today;

         

     

            int nowYear = Convert.ToInt32(now.Year);
            Console.WriteLine(nowYear);

            listAccount = new UserDao().getAllUserBuRole(2);

            foreach (User a in listAccount)
            {
                DateTime xyz = a.DateOfBirth;


                int age = Convert.ToInt32(xyz.Year);

                Console.WriteLine(age);

                
                if (nowYear - age > number && nowYear - age < number2)
                {
                    count++;
                }
            }
           

            return count;
        }





    }
}