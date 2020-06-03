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
    public partial class Works : System.Web.UI.Page
    {


        protected List<VietAnh> listAccount { get; set; }

        protected ImageAvata avata { get; set; }

        protected User user { get; set; }
        protected void Page_Load(object sender, EventArgs e)
        {
            user = (User)Session["userr"];
            avata = new ImageDao().GetImageAvata(user.ID);

            listAccount = new VietAnhDao().getAll();
            List<VietAnh> lst = listAccount;
            DataTable dt = ConvertToDataTable(lst);

            Repeater1.DataSource = dt;

            Repeater1.DataBind();


            List<AnhViet> listAccount2 = new AnhVietDao().getAll();
            List<AnhViet> lst2 = listAccount2;
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
    }
}