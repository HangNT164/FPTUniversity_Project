using BackEnd.DAO;
using Entity;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


namespace FrontEnd
{
    public partial class DetailUser : System.Web.UI.Page
    {
        protected User userr { get; set; }
        protected string roleName { get; set; }
        protected ImageAvata ia { get; set; }

        protected void Page_Load(object sender, EventArgs e)
        {

            getUserInfo();

            string condition = " [username] like '" + (string)Session["userName"] + "'";
            userr = new UserDAO().getUser(condition);
            roleName = new UserDAO().getRole(userr.RoleID);
            ia = new UserDAO().getImageAvata(userr.ID);


            string action = Request.Form.Get("action");
            if (Request.Form.Get("action") != null && Request.Form.Get("action") == "changePass")
            {
                string old_password = Request.Form.Get("oldpass").Trim();
                string new_password = Request.Form.Get("newpass").Trim();

                string confirm_password = Request.Form.Get("cfnewpass").Trim();
                if (old_password == "" || new_password == "" || confirm_password == "")
                {
                    lbStatusChangePassword.ForeColor = Color.Red;
                    lbStatusChangePassword.Text = "Please fill all the blank fields";
                    return;
                }
                else if (new_password != confirm_password)
                {
                    lbStatusChangePassword.ForeColor = Color.Red;

                    lbStatusChangePassword.Text = "New Password and Confirm Password mus be the same";
                    return;

                }
                else if (old_password != userr.Password)
                {
                    lbStatusChangePassword.ForeColor = Color.Red;

                    lbStatusChangePassword.Text = "Password is not correct";
                    return;

                }
                new UserDAO().changePassword(new_password, " [id] = " + userr.ID);
                lbStatusChangePassword.ForeColor = Color.Green;

                lbStatusChangePassword.Text = "Change Password Sucessfully";

            }
        }

        protected void getUserInfo()
        {
            object userid = Session["userid"];
            string username = (string)Session["username"];
            linkLogout.Visible = true;
            linkLogin.Visible = false;
            linkEdit.Visible = true;
            linkNote.Visible = true;
            avatarBig.Src = new BackEnd.DAO.UserDAO().getImageAvata((int)Session["userid"]).ImageLink; ;
            avatarSmall.Src = new BackEnd.DAO.UserDAO().getImageAvata((int)Session["userid"]).ImageLink; ;
            avatarBigChange.Src = new BackEnd.DAO.UserDAO().getImageAvata((int)Session["userid"]).ImageLink; ;

        }

        protected void ChangeUser(object sender, EventArgs e)
        {
            Session.Remove("userid");
            Session.Remove("username");
            Response.Redirect("Dictionary.aspx");
        }
        protected void btnUpload1_Click(object sender, EventArgs e)
        {
            int user = (int)Session["userid"];
            string strFileName;
            string strFilePath;
            string strFolder;
            strFolder = Server.MapPath("./images/avata/");



            // Retrieve the name of the file that is posted.

            strFileName = oFile.PostedFile.FileName;
            strFileName = Path.GetFileName(strFileName);

            if (oFile.Value != "")
            {
                // Create the folder if it does not exist.
                if (!Directory.Exists(strFolder))
                {
                    Directory.CreateDirectory(strFolder);
                }

                // Save the uploaded file to the server.
                strFilePath = strFolder + strFileName;

                // substring path
                int indexOfImage = strFilePath.IndexOf("images");
                int length = strFilePath.Length;
                string str = strFilePath.Substring(indexOfImage, length - indexOfImage);
                string imageLink = str.Replace("\\", "//");

                if (File.Exists(strFilePath))
                {
                    // don't save to project
                }
                else
                {

                    // save to project
                    oFile.PostedFile.SaveAs(strFilePath);

                }
                // save to DB        
                new BackEnd.DAO.ImageDao().updateImageAvata(user, imageLink);
                
            }
            else
            {
                lblUploadResult.Text = "Click 'Browse' to select the file to upload.";
            }
            // Display the result of the upload.
            frmConfirmation.Visible = true;
            getUserInfo();
        }
    }
}