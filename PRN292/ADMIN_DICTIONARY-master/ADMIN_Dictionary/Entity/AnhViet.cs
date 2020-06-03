using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ADMIN_Dictionary.Entity
{
    public class AnhViet
    {
        string name;
        string mean;


        public AnhViet()
        {

        }
        public AnhViet(string name,string mean)
        {
            this.name = name;
            this.mean = mean;
        }

        public string Name { get => name; set => name = value; }

        public string Mean { get => mean; set => mean = value; }





    }
}