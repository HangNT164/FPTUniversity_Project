using ADMIN_Dictionary.Entity;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Configuration;

namespace ADMIN_Dictionary.Dao
{
    public class VietAnhDao
    {

        string conn = WebConfigurationManager.ConnectionStrings["myConnectionString"].ToString();
        public List<VietAnh> getAll()
        {
            List<VietAnh> lists = new List<VietAnh>();
            string sql = "select top 500 term.content as a , def.content as b   from term ,def , dictionary where term.[id] = def.termid and term.dictionaryid = 2";
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand da = new SqlCommand(sql, contr);
            contr.Open();
            //Read data form SQL and add to list
            SqlDataReader dr = da.ExecuteReader();
            while (dr.Read())
            {
                VietAnh u = new VietAnh();

                u.Name = (string)dr["a"];
                u.Mean = (string)dr["b"];


                lists.Add(u);
            }
            contr.Close();
            return lists;
        }
    }
}