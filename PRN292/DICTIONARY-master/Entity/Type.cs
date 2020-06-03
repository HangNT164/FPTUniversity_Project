using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Entity
{
    public class Type
    {
        private int id;
        private string typeName;
        public Type()
        {

        }
        public Type(int id, string typeName)
        {
            this.Id = id;
            this.TypeName = typeName;
        }

        public int Id { get => id; set => id = value; }
        public string TypeName { get => typeName; set => typeName = value; }
    }
}
