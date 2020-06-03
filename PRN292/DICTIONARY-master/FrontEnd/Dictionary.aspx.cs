using Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Entity;
using BackEnd;
using System.Web.UI.WebControls;
using BackEnd.DAO;

namespace FrontEnd
{
    public partial class Dictionary : System.Web.UI.Page
    {
        public SearchWebService.Term[] terms;

        public SearchWebService.SearchService ss;
        public NoteWebService.NoteService noteService;

        protected void Page_Load(object sender, EventArgs e)
        {
            ss = new SearchWebService.SearchService();
            noteService = new NoteWebService.NoteService();
            getUserInfo();
            divNote.Visible = false;
            getWords();
        }

        protected void getNotes()
        {
            object user = Session["userid"];
            int userid = Convert.ToInt32(user);
            NoteWebService.Note[] list = noteService.getNoteByUser(userid);
            string lsthtml = "";
            foreach (NoteWebService.Note i in list)
            {

                string lstNote = "<li class='list-group-item text-decoration-none text-black'><a href='TermEdit.aspx?term=" + i.TermID + "'>" + i.TermContent + "</a></li>";
                lsthtml += lstNote;
            }
            lstNote.InnerHtml = lsthtml;
        }

        protected void showWord(object sender, EventArgs e)
        {
            getWords();
        }

        protected void getWords()
        {
            
            string input = Request.Form["keyWord"];
            int kindOfDictionary = Int32.Parse(kindOfDic.Value);
            terms = ss.getListSuggestByString(kindOfDictionary, input);
            string lsthtml = "";
            foreach (SearchWebService.Term i in terms)
            {

                string lstNote = "<li onclick='show(\""+i.Content+"\".trim())' class='list-group-item text-decoration-none text-black pointer btn'><p>" + i.Content + "</p></li>";
                lsthtml += lstNote;
            }
            listWord.InnerHtml = lsthtml;

        }

        protected void getUserInfo()
        {
            object userid = Session["userid"];
            if (userid != null)
            {
                string username = (string)Session["username"];
                
                btnUserChange.InnerText = "Logout";
                linkLogout.Visible = true;
                linkLogin.Visible = false;
                myNote.Visible = true;
                linkEdit.Visible = true;
                linkNote.Visible = true;
                
                avatarBig.Src = new UserDAO().getImageAvata((int)Session["userid"]).ImageLink;
                avatarSmall.Src = new UserDAO().getImageAvata((int)Session["userid"]).ImageLink;
                getNotes();

            }
            else
            {
                lblUsername.Visible = false;
                btnUserChange.InnerText = "Login";
                linkLogout.Visible = false;
                linkLogin.Visible = true;
                myNote.Visible = false;
                linkEdit.Visible = false;
                linkNote.Visible = false;
                avatarBig.Src = "images/default.jpg";
                avatarSmall.Src = "images/default.jpg";
                //getNotes();
            }

        }

        protected void ChangeUser(object sender, EventArgs e)
        {
            object userid = Session["userid"];
            if (userid == null)
            {
                Response.Redirect("Login.aspx");
            }
            else
            {
                Session.Remove("userid");
                Session.Remove("username");
                //lblUsername.Visible = false;
                //btnUserChange.InnerText = "Login";
                Response.Redirect("Dictionary.aspx");
            }
        }

        protected void Search(object sender, EventArgs e)
        {
            string input = Request.Form["keyWord"];
            int kindOfDictionary = Int32.Parse(kindOfDic.Value);
            getDefinitions(input, kindOfDictionary);
            getWords();
        }

        protected void getDefinitions(string input, int kindOfDictionary)
        {
            SearchWebService.Term term = null;
            object userid = Session["userid"];
            if (userid != null)
            {
                term = ss.getTermByStringWithUser(kindOfDictionary, input, Convert.ToInt32(userid));
                if (term.ID != -1)
                {
                    divNote.Visible = true;
                    getNote(term);
                }
            }
            else
            {
                term = ss.getTermByString(kindOfDictionary, input);
            }
            showDefinition(term);
        }



        protected void getNote(SearchWebService.Term term)
        {
            btnNote.HRef = "TermEdit.aspx?term=" + term.ID;
            if (term.Note.Length == 0)
            {
                lblNote.Visible = false;
            }
            lblNote.InnerText = term.Note;


        }

        protected void showDefinition(SearchWebService.Term term)
        {
            var html = "";
            html += "<table>";
            foreach (SearchWebService.Definition d in term.Definitions)
            {
                html += "<tr>";
                if (d.Type == "word-class")
                {
                    html += "<td class=\"word-class\">* " + d.Content + "</td>";
                }
                else if (d.Type == "meaning")
                {
                    html += "<td class=\"meaning\">&emsp;" + d.Content + "</td>";
                }
                else if (d.Type == "header")
                {
                    html += "<td class=\"header\">" + d.Content + "</td>";
                }
                else if (d.Type == "example")
                {
                    html += "<td class=\"example\">-&emsp;&emsp;" + d.Content + "</td>";
                }
                else if (d.Type == "explain")
                {
                    html += "<td class=\"explain\">&emsp;&emsp;" + d.Content + "</td>";
                }
                else if (d.Type == "other")
                {
                    html += "<td class=\"other\">" + d.Content + "</td>";
                }

                // more cells here as needed
                html += "</tr>";
            }
            if (term.Definitions.Length == 0) 
                if(terms.Length <=0) { html = "<h4 style='color:black'>Not found. " + "</h4>"; }
                else { html = "<h4 style='color:black'>Not found. " + "May be you want to search <a href='#' onclick = 'show(\"" + terms.ElementAt(0).Content + "\".trim())'>" + terms.ElementAt(0).Content + "</a>" + "</h4>"; }

            html += "</table>";
            demo.InnerHtml = html;
        }
    }
}