using ADMIN_Dictionary.Dao;
using ADMIN_Dictionary.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ADMIN_Dictionary.Service
{
    /// <summary>
    /// Summary description for UserService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class UserService : System.Web.Services.WebService
    {
        UserDao dao = new UserDao();
        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }

        [WebMethod]
        public User login(string username, string password)
        {
            return dao.login(username, password);
        }

        [WebMethod]
        public bool signup(string username, string password, string email, string dob)
        {
            DateTime date = Convert.ToDateTime(dob);
            dao.createUser(username, password, email, date);

            return true;
        }

        [WebMethod]
        public bool userExited(string username)
        {
            User user = dao.getUserByUsername(username);
            if(user == null)
            {
                return false;
            }
            return true;
        }

        [WebMethod]
        public void changePassword(string newPassword, string condition)
        {
            dao.changePassword(newPassword, condition);
        }
    }
}
