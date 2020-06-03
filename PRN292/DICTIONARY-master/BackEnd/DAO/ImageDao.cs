using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Configuration;

namespace BackEnd.DAO
{
    public class ImageDao
    {
        string conn = WebConfigurationManager.ConnectionStrings["myConnectionString"].ToString();

        public void  updateImageAvata(int userID,string imageLink)
        {
            SqlConnection contr = new SqlConnection(conn);
            string query = @"UPDATE [dbo].[image_avata]
                               SET [image_link] = '" +imageLink +"' WHERE [user_id] = "+userID;
            SqlCommand cmd = new SqlCommand(query, contr);
            contr.Open();
            cmd.ExecuteNonQuery();
            contr.Close();
        }
    }
}