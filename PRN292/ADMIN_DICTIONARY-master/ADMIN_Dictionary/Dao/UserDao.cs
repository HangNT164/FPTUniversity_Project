using ADMIN_Dictionary.Entity;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Configuration;

namespace ADMIN_Dictionary.Dao
{
    public class UserDao
    {
        string conn = WebConfigurationManager.ConnectionStrings["myConnectionString"].ToString();
        public User login(string username, string password)
        {
            User u = null;
            string sql = "select * from [user] where username = '" + username + "' and password = '" + password + "'";
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand da = new SqlCommand(sql, contr);
            contr.Open();
            //Read data form SQL and add to list
            SqlDataReader dr = da.ExecuteReader();
            while (dr.Read())
            {
                u = new User();
                u.ID = (int)dr["id"];
                u.Username = (string)dr["username"];
                u.Password = (string)dr["password"];
                u.Email = (string)dr["email"];
                object tmp = dr["dob"];
                DateTime date = (DateTime)Convert.ToDateTime(tmp);
                u.DateOfBirth = date;
                u.RoleID = (int)dr["role_id"];
                object tmp1 = dr["create_date"];
                DateTime date1 = (DateTime)Convert.ToDateTime(tmp1);
                u.CreateDate = date1;
            }
            contr.Close();
            return u;
        }
        public void createUser(string username, string password, string email, DateTime dob)
        {
            string format = "yyyy-MM-dd HH:mm:ss";
            string date = dob.ToString(format);
            string query = "INSERT INTO [user] (username, password, email, dob) VALUES (N'" + username + "', '" + password + "', '" + email + "', '" + date + "')";
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand cmd = new SqlCommand(query, contr);
            contr.Open();
            cmd.ExecuteNonQuery();
            contr.Close();
        }

        public User getUserByUsername(string username)
        {
            User u = null;
            string sql = "select * from [user] where [username] like N'" + username + "'";
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand da = new SqlCommand(sql, contr);
            contr.Open();
            //Read data form SQL and add to list
            SqlDataReader dr = da.ExecuteReader();
            while (dr.Read())
            {
                u = new User();
                u.ID = (int)dr["id"];
                u.Username = (string)dr["username"];
                u.Password = (string)dr["password"];
                u.Email = (string)dr["email"];
                object tmp = dr["dob"];
                DateTime date = (DateTime)Convert.ToDateTime(tmp);
                u.DateOfBirth = date;
                u.RoleID = (int)dr["role_id"];
                object tmp1 = dr["create_date"];
                DateTime date1 = (DateTime)Convert.ToDateTime(tmp1);
                u.CreateDate = date1;
            }
            contr.Close();
            return u;
        }
        public void changePassword(string newPassword, string condition)
        {
            SqlConnection contr = new SqlConnection(conn);
            string query = "  update [user] set [password] ='" + newPassword + "' where " + condition;
            SqlCommand cmd = new SqlCommand(query, contr);
            contr.Open();
            cmd.ExecuteNonQuery();
            contr.Close();

        }
        public string getRole(int userID)
        {
            string role = "";
            string sql = "select role.role_name from [user] join [role] on [user].role_id = role.id where [user].id = " + userID ;
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand da = new SqlCommand(sql, contr);
            contr.Open();
            //Read data form SQL and add to list
            SqlDataReader dr = da.ExecuteReader();
            while (dr.Read())
            {
                role = (string)dr["role_name"];
            }
            contr.Close();
            return role;
        }
        public List<User> getAllUserBuRole(int role)
        {
            List<User> lists = new List<User>();
            string sql = "select * from [user] where role_id  = "+ role;
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand da = new SqlCommand(sql, contr);
            contr.Open();
            //Read data form SQL and add to list
            SqlDataReader dr = da.ExecuteReader();
            while (dr.Read())
            {
                User u = new User();
                u.ID = (int)dr["id"];
                u.Username = (string)dr["username"];
                u.Password = (string)dr["password"];
                u.Email = (string)dr["email"];
                object tmp = dr["dob"];
                DateTime date = (DateTime)Convert.ToDateTime(tmp);
                u.DateOfBirth = date;
                u.RoleID = (int)dr["role_id"];
                object tmp1 = dr["create_date"];
                DateTime date1 = (DateTime)Convert.ToDateTime(tmp1);
                u.CreateDate = date1;
                lists.Add(u);
            }
            contr.Close();
            return lists;
        }


    
    }
}