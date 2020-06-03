using System.Data.SqlClient;
using System.Web.Configuration;
using System;
using Entity;

namespace BackEnd.DAO
{
    public class UserDAO
    {
        string conn = WebConfigurationManager.ConnectionStrings["myConnectionString"].ToString();

        public User login(string username, string password)
        {
            User u = null;
            string sql = "select * from [user] where [username] ='" + username + "' and [password] ='" + password + "'";
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand da = new SqlCommand(sql, contr);
            contr.Open();
            //Read data form SQL and add to list
            SqlDataReader dr = da.ExecuteReader();
            while (dr.Read())
            {
                u = new User();
                u.ID = (int) dr["id"];
                u.Username = (string) dr["username"];
                u.Password = (string) dr["password"];
                u.Email = (string) dr["email"];
                object tmp = dr["dob"];
                u.RoleID = (int)dr["role_id"];
                object createDate = dr["create_date"];
                DateTime date = (DateTime)Convert.ToDateTime(tmp);
                u.DateOfBirth = date;
                DateTime cD = (DateTime)Convert.ToDateTime(createDate);
                u.CreateDate = cD;
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
            generateAvaDefault(getUserByUsername(username).ID);
        }

        private void generateAvaDefault(int userID)
        {
            string query = "insert into image_avata values ("+userID+ ",'images/avata/DefaultAvatar.jpg')";
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand cmd = new SqlCommand(query, contr);
            contr.Open();
            cmd.ExecuteNonQuery();
            contr.Close();
        }
        // condition is propreties after where
        public void changePassword( string newPassword , string condition)
        {
            SqlConnection contr = new SqlConnection(conn);
            string query = "  update [user] set [password] ='" + newPassword + "' where " + condition ;
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
                u.RoleID = (int)dr["role_id"];
                object createDate = dr["create_date"];
                DateTime date = (DateTime)Convert.ToDateTime(tmp);
                u.DateOfBirth = date;
                DateTime cD = (DateTime)Convert.ToDateTime(createDate);
                u.CreateDate = cD;
            }
            contr.Close();
            return u;
        }

        public String getRole(int roleID)
        {
            string roleName = "";
            String sql = "select [role_name] from [role] where [id]  = " + roleID;
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand da = new SqlCommand(sql, contr);
            contr.Open();
            //Read data form SQL and add to list
            SqlDataReader dr = da.ExecuteReader();
            while (dr.Read())
            {
                roleName = (string)dr["role_name"];
            }
            contr.Close();
            return roleName;
        }
        public ImageAvata getImageAvata(int user_id)
        {
            ImageAvata avata = new ImageAvata();
            avata.UserID = user_id;
            String sql = "select * from image_avata where [user_id] = " + user_id;
            SqlConnection contr = new SqlConnection(conn);
            SqlCommand da = new SqlCommand(sql, contr);
            contr.Open();
            //Read data form SQL and add to list
            SqlDataReader dr = da.ExecuteReader();
            while (dr.Read())
            {
                avata.Id = (int)dr["id"];
                avata.ImageLink = (string)dr["image_link"];
            }
            contr.Close();
            return avata;
        }

        //condition after "where"
        public User getUser(string condition)
        {
            User u = null;
            string sql = "select * from [user] where " + condition;
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
                object createDate = dr["create_date"];
                DateTime cD = (DateTime)Convert.ToDateTime(createDate);
                u.CreateDate = cD;
            }
            contr.Close();
            return u;
        }
    }
}