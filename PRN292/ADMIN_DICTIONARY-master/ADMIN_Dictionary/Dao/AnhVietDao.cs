using ADMIN_Dictionary.Entity;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Configuration;

namespace ADMIN_Dictionary.Dao
{
    public class AnhVietDao
    {
        string conn = WebConfigurationManager.ConnectionStrings["myConnectionString"].ToString();
        public List<AnhViet> getAll()
        {
            List<AnhViet> lists = new List<AnhViet>();
            string sql = "   select top 100 term.content as a , def.content as b   from term ,def , dictionary where term.[id] = def.termid and term.dictionaryid = 1 ";
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand da = new SqlCommand(sql, contr);
            contr.Open();
            //Read data form SQL and add to list
            SqlDataReader dr = da.ExecuteReader();
            while (dr.Read())
            {
                AnhViet u = new AnhViet();

                u.Name = (string)dr["a"];
                u.Mean = (string)dr["b"];


                lists.Add(u);
            }
            contr.Close();
            return lists;
        }
    }

}