using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Entity
{
    public  class TeamNote
    {
        private int termID;
        private int userID;
        private string note;

        public int TermID { get => termID; set => termID = value; }
        public int UserID { get => userID; set => userID = value; }
        public string Note { get => note; set => note = value; }

        public TeamNote(int termID, int userID, string note)
        {
            this.TermID = termID;
            this.UserID = userID;
            this.Note = note;
        }

        public TeamNote()
        {

        }
    }
}
