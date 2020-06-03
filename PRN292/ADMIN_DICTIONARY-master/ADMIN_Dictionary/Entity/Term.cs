﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ADMIN_Dictionary.Entity
{
    public class Term
    {
        private int _id;
        private int _dictionaryId;
        private string _content;
        private List<Definition> _listDef;
        private string _note;
        public Term()
        {
            _id = -1;
            _listDef = new List<Definition>();
            _note = "";
        }
        public Term(int id, int dictionaryId, string content)
        {
            this._id = id;
            this._dictionaryId = dictionaryId;
            this._content = content;

        }
        public int ID
        {
            get { return _id; }
            set { _id = value; }
        }
        public int DictionaryID
        {
            get { return _dictionaryId; }
            set { _dictionaryId = value; }
        }
        public string Content
        {
            get { return _content; }
            set { _content = value; }
        }

        public string Note
        {
            get
            {
                return _note;
            }
            set
            {
                _note = value;
            }
        }
        public List<Definition> Definitions
        {
            get
            {
                return _listDef;
            }
            set
            {
                _listDef = value;
            }
        }
    }
}
