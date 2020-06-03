using ADMIN_Dictionary.Entity;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Configuration;

namespace ADMIN_Dictionary.Dao
{
    public class WorksDao
    {
        string conn = WebConfigurationManager.ConnectionStrings["myConnectionString"].ToString();
        public List<Definition> getAll()
        {
            List<Definition> lists = new List<Definition>();
            string sql = "  select * from [def]";
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand da = new SqlCommand(sql, contr);
            contr.Open();
            //Read data form SQL and add to list
            SqlDataReader dr = da.ExecuteReader();
            while (dr.Read())
            {
                Definition u = new Definition();
                u.ID = (int)dr["id"];
                u.Index = (int)dr["index"];
                u.Content = (string)dr["content"];
                u.TypeCode = (int)dr["type"];
                u.TermID = (int)dr["termid"];
              
                lists.Add(u);
            }
            contr.Close();
            return lists;
        }
    }
}