﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// 
// This source code was auto-generated by Microsoft.VSDesigner, Version 4.0.30319.42000.
// 
#pragma warning disable 1591

namespace FrontEnd.SearchWebService {
    using System;
    using System.Web.Services;
    using System.Diagnostics;
    using System.Web.Services.Protocols;
    using System.Xml.Serialization;
    using System.ComponentModel;
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Web.Services.WebServiceBindingAttribute(Name="SearchServiceSoap", Namespace="http://tempuri.org/")]
    public partial class SearchService : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback HelloWorldOperationCompleted;

        internal void getTermsByString(int kindOfDictionary)
        {
            throw new NotImplementedException();
        }

        private System.Threading.SendOrPostCallback getListDefByStringOperationCompleted;
        
        private System.Threading.SendOrPostCallback getListSuggestByStringOperationCompleted;
        
        private System.Threading.SendOrPostCallback getListDefByTermOperationCompleted;
        
        private System.Threading.SendOrPostCallback getTermByStringOperationCompleted;
        
        private System.Threading.SendOrPostCallback getTermByStringWithUserOperationCompleted;
        
        private System.Threading.SendOrPostCallback getTermByIdWithUserOperationCompleted;
        
        private bool useDefaultCredentialsSetExplicitly;
        
        /// <remarks/>
        public SearchService() {
            this.Url = global::FrontEnd.Properties.Settings.Default.FrontEnd_SearchWebService_SearchService;
            if ((this.IsLocalFileSystemWebService(this.Url) == true)) {
                this.UseDefaultCredentials = true;
                this.useDefaultCredentialsSetExplicitly = false;
            }
            else {
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        public new string Url {
            get {
                return base.Url;
            }
            set {
                if ((((this.IsLocalFileSystemWebService(base.Url) == true) 
                            && (this.useDefaultCredentialsSetExplicitly == false)) 
                            && (this.IsLocalFileSystemWebService(value) == false))) {
                    base.UseDefaultCredentials = false;
                }
                base.Url = value;
            }
        }
        
        public new bool UseDefaultCredentials {
            get {
                return base.UseDefaultCredentials;
            }
            set {
                base.UseDefaultCredentials = value;
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        /// <remarks/>
        public event HelloWorldCompletedEventHandler HelloWorldCompleted;
        
        /// <remarks/>
        public event getListDefByStringCompletedEventHandler getListDefByStringCompleted;
        
        /// <remarks/>
        public event getListSuggestByStringCompletedEventHandler getListSuggestByStringCompleted;
        
        /// <remarks/>
        public event getListDefByTermCompletedEventHandler getListDefByTermCompleted;
        
        /// <remarks/>
        public event getTermByStringCompletedEventHandler getTermByStringCompleted;
        
        /// <remarks/>
        public event getTermByStringWithUserCompletedEventHandler getTermByStringWithUserCompleted;
        
        /// <remarks/>
        public event getTermByIdWithUserCompletedEventHandler getTermByIdWithUserCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/HelloWorld", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public string HelloWorld() {
            object[] results = this.Invoke("HelloWorld", new object[0]);
            return ((string)(results[0]));
        }
        
        /// <remarks/>
        public void HelloWorldAsync() {
            this.HelloWorldAsync(null);
        }
        
        /// <remarks/>
        public void HelloWorldAsync(object userState) {
            if ((this.HelloWorldOperationCompleted == null)) {
                this.HelloWorldOperationCompleted = new System.Threading.SendOrPostCallback(this.OnHelloWorldOperationCompleted);
            }
            this.InvokeAsync("HelloWorld", new object[0], this.HelloWorldOperationCompleted, userState);
        }
        
        private void OnHelloWorldOperationCompleted(object arg) {
            if ((this.HelloWorldCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.HelloWorldCompleted(this, new HelloWorldCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/getListDefByString", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Definition[] getListDefByString(int dicID, string search) {
            object[] results = this.Invoke("getListDefByString", new object[] {
                        dicID,
                        search});
            return ((Definition[])(results[0]));
        }
        
        /// <remarks/>
        public void getListDefByStringAsync(int dicID, string search) {
            this.getListDefByStringAsync(dicID, search, null);
        }
        
        /// <remarks/>
        public void getListDefByStringAsync(int dicID, string search, object userState) {
            if ((this.getListDefByStringOperationCompleted == null)) {
                this.getListDefByStringOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetListDefByStringOperationCompleted);
            }
            this.InvokeAsync("getListDefByString", new object[] {
                        dicID,
                        search}, this.getListDefByStringOperationCompleted, userState);
        }
        
        private void OngetListDefByStringOperationCompleted(object arg) {
            if ((this.getListDefByStringCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getListDefByStringCompleted(this, new getListDefByStringCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/getListSuggestByString", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Term[] getListSuggestByString(int dicID, string search) {
            object[] results = this.Invoke("getListSuggestByString", new object[] {
                        dicID,
                        search});
            return ((Term[])(results[0]));
        }
        
        /// <remarks/>
        public void getListSuggestByStringAsync(int dicID, string search) {
            this.getListSuggestByStringAsync(dicID, search, null);
        }
        
        /// <remarks/>
        public void getListSuggestByStringAsync(int dicID, string search, object userState) {
            if ((this.getListSuggestByStringOperationCompleted == null)) {
                this.getListSuggestByStringOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetListSuggestByStringOperationCompleted);
            }
            this.InvokeAsync("getListSuggestByString", new object[] {
                        dicID,
                        search}, this.getListSuggestByStringOperationCompleted, userState);
        }
        
        private void OngetListSuggestByStringOperationCompleted(object arg) {
            if ((this.getListSuggestByStringCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getListSuggestByStringCompleted(this, new getListSuggestByStringCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/getListDefByTerm", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Definition[] getListDefByTerm(Term term) {
            object[] results = this.Invoke("getListDefByTerm", new object[] {
                        term});
            return ((Definition[])(results[0]));
        }
        
        /// <remarks/>
        public void getListDefByTermAsync(Term term) {
            this.getListDefByTermAsync(term, null);
        }
        
        /// <remarks/>
        public void getListDefByTermAsync(Term term, object userState) {
            if ((this.getListDefByTermOperationCompleted == null)) {
                this.getListDefByTermOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetListDefByTermOperationCompleted);
            }
            this.InvokeAsync("getListDefByTerm", new object[] {
                        term}, this.getListDefByTermOperationCompleted, userState);
        }
        
        private void OngetListDefByTermOperationCompleted(object arg) {
            if ((this.getListDefByTermCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getListDefByTermCompleted(this, new getListDefByTermCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/getTermByString", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Term getTermByString(int dicID, string search) {
            object[] results = this.Invoke("getTermByString", new object[] {
                        dicID,
                        search});
            return ((Term)(results[0]));
        }
        
        /// <remarks/>
        public void getTermByStringAsync(int dicID, string search) {
            this.getTermByStringAsync(dicID, search, null);
        }
        
        /// <remarks/>
        public void getTermByStringAsync(int dicID, string search, object userState) {
            if ((this.getTermByStringOperationCompleted == null)) {
                this.getTermByStringOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetTermByStringOperationCompleted);
            }
            this.InvokeAsync("getTermByString", new object[] {
                        dicID,
                        search}, this.getTermByStringOperationCompleted, userState);
        }
        
        private void OngetTermByStringOperationCompleted(object arg) {
            if ((this.getTermByStringCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getTermByStringCompleted(this, new getTermByStringCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/getTermByStringWithUser", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Term getTermByStringWithUser(int dicID, string search, int userid) {
            object[] results = this.Invoke("getTermByStringWithUser", new object[] {
                        dicID,
                        search,
                        userid});
            return ((Term)(results[0]));
        }
        
        /// <remarks/>
        public void getTermByStringWithUserAsync(int dicID, string search, int userid) {
            this.getTermByStringWithUserAsync(dicID, search, userid, null);
        }
        
        /// <remarks/>
        public void getTermByStringWithUserAsync(int dicID, string search, int userid, object userState) {
            if ((this.getTermByStringWithUserOperationCompleted == null)) {
                this.getTermByStringWithUserOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetTermByStringWithUserOperationCompleted);
            }
            this.InvokeAsync("getTermByStringWithUser", new object[] {
                        dicID,
                        search,
                        userid}, this.getTermByStringWithUserOperationCompleted, userState);
        }
        
        private void OngetTermByStringWithUserOperationCompleted(object arg) {
            if ((this.getTermByStringWithUserCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getTermByStringWithUserCompleted(this, new getTermByStringWithUserCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/getTermByIdWithUser", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Term getTermByIdWithUser(int termid, int userid) {
            object[] results = this.Invoke("getTermByIdWithUser", new object[] {
                        termid,
                        userid});
            return ((Term)(results[0]));
        }
        
        /// <remarks/>
        public void getTermByIdWithUserAsync(int termid, int userid) {
            this.getTermByIdWithUserAsync(termid, userid, null);
        }
        
        /// <remarks/>
        public void getTermByIdWithUserAsync(int termid, int userid, object userState) {
            if ((this.getTermByIdWithUserOperationCompleted == null)) {
                this.getTermByIdWithUserOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetTermByIdWithUserOperationCompleted);
            }
            this.InvokeAsync("getTermByIdWithUser", new object[] {
                        termid,
                        userid}, this.getTermByIdWithUserOperationCompleted, userState);
        }
        
        private void OngetTermByIdWithUserOperationCompleted(object arg) {
            if ((this.getTermByIdWithUserCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getTermByIdWithUserCompleted(this, new getTermByIdWithUserCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        public new void CancelAsync(object userState) {
            base.CancelAsync(userState);
        }
        
        private bool IsLocalFileSystemWebService(string url) {
            if (((url == null) 
                        || (url == string.Empty))) {
                return false;
            }
            System.Uri wsUri = new System.Uri(url);
            if (((wsUri.Port >= 1024) 
                        && (string.Compare(wsUri.Host, "localHost", System.StringComparison.OrdinalIgnoreCase) == 0))) {
                return true;
            }
            return false;
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.8.3752.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://tempuri.org/")]
    public partial class Definition {
        
        private string typeField;
        
        private int idField;
        
        private int indexField;
        
        private string contentField;
        
        private int typeCodeField;
        
        private int termIDField;
        
        /// <remarks/>
        public string Type {
            get {
                return this.typeField;
            }
            set {
                this.typeField = value;
            }
        }
        
        /// <remarks/>
        public int ID {
            get {
                return this.idField;
            }
            set {
                this.idField = value;
            }
        }
        
        /// <remarks/>
        public int Index {
            get {
                return this.indexField;
            }
            set {
                this.indexField = value;
            }
        }
        
        /// <remarks/>
        public string Content {
            get {
                return this.contentField;
            }
            set {
                this.contentField = value;
            }
        }
        
        /// <remarks/>
        public int TypeCode {
            get {
                return this.typeCodeField;
            }
            set {
                this.typeCodeField = value;
            }
        }
        
        /// <remarks/>
        public int TermID {
            get {
                return this.termIDField;
            }
            set {
                this.termIDField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.8.3752.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://tempuri.org/")]
    public partial class Term {
        
        private int idField;
        
        private int dictionaryIDField;
        
        private string contentField;
        
        private string noteField;
        
        private Definition[] definitionsField;
        
        /// <remarks/>
        public int ID {
            get {
                return this.idField;
            }
            set {
                this.idField = value;
            }
        }
        
        /// <remarks/>
        public int DictionaryID {
            get {
                return this.dictionaryIDField;
            }
            set {
                this.dictionaryIDField = value;
            }
        }
        
        /// <remarks/>
        public string Content {
            get {
                return this.contentField;
            }
            set {
                this.contentField = value;
            }
        }
        
        /// <remarks/>
        public string Note {
            get {
                return this.noteField;
            }
            set {
                this.noteField = value;
            }
        }
        
        /// <remarks/>
        public Definition[] Definitions {
            get {
                return this.definitionsField;
            }
            set {
                this.definitionsField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    public delegate void HelloWorldCompletedEventHandler(object sender, HelloWorldCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class HelloWorldCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal HelloWorldCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public string Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((string)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    public delegate void getListDefByStringCompletedEventHandler(object sender, getListDefByStringCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getListDefByStringCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getListDefByStringCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Definition[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Definition[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    public delegate void getListSuggestByStringCompletedEventHandler(object sender, getListSuggestByStringCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getListSuggestByStringCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getListSuggestByStringCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Term[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Term[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    public delegate void getListDefByTermCompletedEventHandler(object sender, getListDefByTermCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getListDefByTermCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getListDefByTermCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Definition[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Definition[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    public delegate void getTermByStringCompletedEventHandler(object sender, getTermByStringCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getTermByStringCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getTermByStringCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Term Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Term)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    public delegate void getTermByStringWithUserCompletedEventHandler(object sender, getTermByStringWithUserCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getTermByStringWithUserCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getTermByStringWithUserCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Term Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Term)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    public delegate void getTermByIdWithUserCompletedEventHandler(object sender, getTermByIdWithUserCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.3752.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getTermByIdWithUserCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getTermByIdWithUserCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Term Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Term)(this.results[0]));
            }
        }
    }
}

#pragma warning restore 1591