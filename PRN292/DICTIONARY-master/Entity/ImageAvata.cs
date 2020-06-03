using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Entity
{
    public class ImageAvata
    {
        private int id;
        private int userID;
        private string imageLink;
        public ImageAvata()
        {

        }
        public ImageAvata(int id, int userID, string imageLink)
        {
            this.Id = id;
            this.UserID = userID;
            this.ImageLink = imageLink;
        }

        public int Id { get => id; set => id = value; }
        public int UserID { get => userID; set => userID = value; }
        public string ImageLink { get => imageLink; set => imageLink = value; }
    }
}
