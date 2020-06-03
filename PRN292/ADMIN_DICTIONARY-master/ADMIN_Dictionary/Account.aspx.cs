using ADMIN_Dictionary.Dao;
using ADMIN_Dictionary.Entity;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ADMIN_Dictionary
{
    public partial class Account : System.Web.UI.Page
    {

        protected List<User> listAccount { get; set; }

        protected ImageAvata avata { get; set; }

        protected User user { get; set; }

        protected void Page_Load(object sender, EventArgs e)
        {
            user = (User)Session["userr"];
            avata = new ImageDao().GetImageAvata(user.ID);
            if(avata == null)
            {
                avata.ImageLink = "default.jpg";
            }

            listAccount = new UserDao().getAllUserBuRole(2);
            List<User> lst = listAccount;
            DataTable dt = ConvertToDataTable(lst);

            Repeater1.DataSource = dt;

            Repeater1.DataBind();


            List<User> listAccount2 = new UserDao().getAllUserBuRole(1);
            List<User> lst2 = listAccount2;
            DataTable dt2 = ConvertToDataTable(lst2);

            Repeater2.DataSource = dt2;

            Repeater2.DataBind();



        }

        public DataTable ConvertToDataTable<T>(IList<T> data)
        {
            PropertyDescriptorCollection properties =
               TypeDescriptor.GetProperties(typeof(T));
            DataTable table = new DataTable();
            foreach (PropertyDescriptor prop in properties)
                table.Columns.Add(prop.Name, Nullable.GetUnderlyingType(prop.PropertyType) ?? prop.PropertyType);
            foreach (T item in data)
            {
                DataRow row = table.NewRow();
                foreach (PropertyDescriptor prop in properties)
                    row[prop.Name] = prop.GetValue(item) ?? DBNull.Value;
                table.Rows.Add(row);
            }
            return table;

        }

        protected void aaaa(object sender, EventArgs e)
        {
            List<User> listAccount2 = new UserDao().getAllUserBuRole(1);
            List<User> lst2 = listAccount2;
            DataTable dt2 = ConvertToDataTable(lst2);

            Repeater2.DataSource = dt2;

            Repeater2.DataBind();

        }

        public void a(object sender, EventArgs e)
        {
            List<User> listAccount2 = new UserDao().getAllUserBuRole(1);
        }


        public static void main()
        {
            List<User> listAccount2 = new UserDao().getAllUserBuRole(1);
            Console.WriteLine(listAccount2);

        }


 

  
        
    }
}