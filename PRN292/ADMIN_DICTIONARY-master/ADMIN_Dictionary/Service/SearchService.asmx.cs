using System.Collections.Generic;
using System.Web.Services;
using System.Text;
using ADMIN_Dictionary.Dao;
using ADMIN_Dictionary.Entity;

namespace ADMIN_Dictionary.Service
{
    /// <summary>
    /// Summary description for SearchService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class SearchService : System.Web.Services.WebService
    {
        DictionaryDao dictionaryDAO = new DictionaryDao();
        NoteDao noteDAO = new NoteDao();
        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }

        [WebMethod]
        public List<Definition> getListDefByString(int dicID, string search)
        {
            List<Definition> list = dictionaryDAO.getListDefByString(dicID, processSearchInput(search));
            return list;
        }

        [WebMethod]
        public List<Term> getListSuggestByString(int dicID, string search)
        {
            /*
             * When user is typing
             * Get list top 5 terms that term's content contains user's typing
             */
            List<Term> list = dictionaryDAO.getTop5TermByString(dicID, search);
            return list;
        }
        [WebMethod]
        public List<Definition> getListDefByTerm(Term term)
        {
            /*
             * When user choice a term in suggest
             * Get list definitions of this term
             */
            List<Definition> list = dictionaryDAO.getDefinitionByTerm(term);
            return list;
        }

        [WebMethod]
        public Term getTermByString(int dicID, string search)
        {
            Term term = dictionaryDAO.getTermByString(dicID, search);
            return term;
        }

        [WebMethod]
        public Term getTermByStringWithUser(int dicID, string search, int userid)
        {
            Term term = dictionaryDAO.getTermByString(dicID, search);
            noteDAO.getNoteByTerm(term, userid);
            return term;
        }

        [WebMethod]
        public Term getTermByIdWithUser(int termid, int userid)
        {
            Term term = dictionaryDAO.getTermById(termid);
            noteDAO.getNoteByTerm(term, userid);
            return term;
        }

        string processSearchInput(string input)
        {  
            return input.Trim().ToLower();
        }
    }
}
