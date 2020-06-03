using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using ADMIN_Dictionary.Dao;
using ADMIN_Dictionary.Entity;

namespace ADMIN_Dictionary.Service
{
    /// <summary>
    /// Summary description for DictionaryService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class DictionaryService : System.Web.Services.WebService
    {
        DictionaryDao dictionaryDAO = new DictionaryDao();
        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }

        [WebMethod]
        public List<Dictionary> getAllDictionary()
        {
            List<Dictionary> list = dictionaryDAO.getAllDictionary();
            return list;
        }
    }
}
