using ADMIN_Dictionary.Entity;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Configuration;

namespace ADMIN_Dictionary.Dao
{
    public class ImageDao
    {
        string conn = WebConfigurationManager.ConnectionStrings["myConnectionString"].ToString();
        public ImageAvata GetImageAvata(int userID)
        {
            ImageAvata u = null;
            string sql = "select * from image_avata where user_id = "+userID;
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand da = new SqlCommand(sql, contr);
            contr.Open();
            //Read data form SQL and add to list
            SqlDataReader dr = da.ExecuteReader();
            while (dr.Read())
            {
                u = new ImageAvata();
                u.Id = (int)dr["id"];
                u.UserID = (int)dr["user_id"];
                u.ImageLink = (string)dr["image_link"];
            }
            contr.Close();
            return u;
        }
    }
}