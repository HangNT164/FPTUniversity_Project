package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class setting_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/component/header.jsp");
    _jspx_dependants.add("/component/menu.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_when_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("        <!-- Font Awesome CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.1/css/all.css\" integrity=\"sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assetss/css/bootstrap/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assetss/css/mnd/common.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assetss/css/mnd/materials.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assetss/css/mnd/tables.css\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS-->\n");
      out.write("        <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom fonts for this template-->\n");
      out.write("        <link href=\"vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("        <!-- Page level plugin CSS-->\n");
      out.write("        <link href=\"vendor/datatables/dataTables.bootstrap4.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!--title-->\n");
      out.write("        <link rel = \"icon\" href =  \n");
      out.write("              \"http://www.maccosmetics.com.vn/sites/maccosmetics/themes/mac_base/favicon.ico\" \n");
      out.write("              type = \"image/x-icon\"> \n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template-->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/setting.css\" rel=\"stylesheet\">\n");
      out.write("        <title>Admin|Mac Cosmetic|VietName| Setting</title>\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body id=\"page-top\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand navbar-dark  static-top\" style=\"background-color:forestgreen\">\n");
      out.write("\n");
      out.write("            <a class=\"navbar-brand mr-1\" href=\"index.jsp\">Admin MAC COSMETIC </a>\n");
      out.write("\n");
      out.write("            <button class=\"btn btn-link btn-sm text-white order-1 order-sm-0\" id=\"sidebarToggle\" href=\"#\">\n");
      out.write("                <i class=\"fas fa-bars\"></i>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <!-- Navbar Search -->\n");
      out.write("            <form class=\"d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0\">\n");
      out.write("                <div class=\"input-group\">\n");
      out.write("\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <!-- Navbar -->\n");
      out.write("            <ul class=\"navbar-nav ml-auto ml-md-0\">         \n");
      out.write("                <li class=\"nav-item dropdown no-arrow\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\"\n");
      out.write("                       role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.avataAccount.imageLink}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                             style=\"width:32px;height:32px;border-radius: 50%;\"class=\"mr-3\">\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right\" aria-labelledby=\"userDropdown\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"setting\">Settings</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"logout\">Logout</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        <!-- Start wrapper -->\n");
      out.write("        <div id=\"wrapper\" >\n");
      out.write("            <!-- Sidebar -->\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <body>\n");
      out.write("        <!-- Sidebar -->\n");
      out.write("        <ul class=\"sidebar navbar-nav\" style=\"position: absolute\">\n");
      out.write("            <li class=\"nav-item active\">\n");
      out.write("                <a class=\"nav-link\" href=\"index.jsp\" style=\"background: black\">\n");
      out.write("                    <i class=\"fas fa-fw fa-tachometer-alt\"></i>\n");
      out.write("                    <span>Dashboard</span>\n");
      out.write("                </a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item dropdown\">\n");
      out.write("                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"pagesDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                    <i class=\"fas fa-fw fa-folder\"></i>\n");
      out.write("                    <span>Product</span>\n");
      out.write("                </a>\n");
      out.write("                <div class=\"dropdown-menu\" aria-labelledby=\"pagesDropdown\">\n");
      out.write("                    <a class=\"dropdown-item\" href=\"get-all-productt\">Get All Product</a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"get-all-category\">Create category </a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"get-sub-category\">Create subcategory </a>\n");
      out.write("                    <!--<a class=\"dropdown-item\" href=\"addProduct.jsp\">Tao san pham </a>-->\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"get-all-order\">\n");
      out.write("                    <i class=\"fas fa-fw fa-folder\"></i>\n");
      out.write("                    <span>Order</span></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"get-all-account\">\n");
      out.write("                    <i class=\"fas fa-fw fa-table\"></i>\n");
      out.write("                    <span>Account</span></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"chart\">\n");
      out.write("                    <i class=\"fas fa-fw fa-chart-area\"></i>\n");
      out.write("                    <span>Chart</span></a>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"content-wrapper\">\n");
      out.write("                <!-- Navbar -->\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"container emp-profile\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <div class=\"profile-img\">\n");
      out.write("                                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.avataAccount.imageLink}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"class=\"mr-3\"style=\"border-radius: 50%;\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <div class=\"profile-head\"><br/><br/><br/>\n");
      out.write("                                    <h5>\n");
      out.write("                                        Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                    </h5>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>                          \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <ul class=\"nav  flex-column\">\n");
      out.write("                                    <li class=\"nav-item\"style=\"padding-left: 10%;\">\n");
      out.write("                                        <a class=\"nav-link active\" id=\"home-tab\" \n");
      out.write("                                           data-toggle=\"tab\" href=\"#home\" role=\"tab\" aria-controls=\"home\" aria-selected=\"true\">About</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item\"style=\"padding-left: 10%;\">\n");
      out.write("                                        <a class=\"nav-link\" id=\"profile-tab\" \n");
      out.write("                                           data-toggle=\"tab\" href=\"#profile\" \n");
      out.write("                                           role=\"tab\" aria-controls=\"profile\"\n");
      out.write("                                           aria-selected=\"false\">Update</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item\"style=\"padding-left: 10%;\">\n");
      out.write("                                        <a class=\"nav-link\" id=\"changePass-tab\"\n");
      out.write("                                           data-toggle=\"tab\" href=\"#changePass\" \n");
      out.write("                                           role=\"tab\" aria-controls=\"changePass\" \n");
      out.write("                                           aria-selected=\"false\">Change Password</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-8\">\n");
      out.write("                                <div class=\"tab-content profile-tab\" id=\"myTabContent\">\n");
      out.write("                                    <!--Home-->\n");
      out.write("                                    <div class=\"tab-pane fade show active\" id=\"home\" role=\"tabpanel\"\n");
      out.write("                                         aria-labelledby=\"home-tab\">\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-3\">\n");
      out.write("                                                <label>Name</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-5\">\n");
      out.write("                                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-3\">\n");
      out.write("                                                <label>Email</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-5\">\n");
      out.write("                                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-3\">\n");
      out.write("                                                <label>Phone</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-5\">\n");
      out.write("                                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.mobile}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-3\">\n");
      out.write("                                                <label>Role</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-5\">\n");
      out.write("                                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.roleName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-3\">\n");
      out.write("                                                <label>Create Date</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-5\">\n");
      out.write("                                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.createDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-3\">\n");
      out.write("                                                <label>Gender</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-5\">\n");
      out.write("                                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.displayGender}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-3\">\n");
      out.write("                                                <label>Address</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-6\">\n");
      out.write("                                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!--/Home-->\n");
      out.write("\n");
      out.write("                                    <!--Update-->\n");
      out.write("                                    <div class=\"tab-pane fade\" id=\"profile\" role=\"tabpanel\" \n");
      out.write("                                         aria-labelledby=\"profile-tab\">\n");
      out.write("                                        <form action=\"update-info\" id =\"registration\">\n");
      out.write("                                            <div class=\"form-row\">\n");
      out.write("                                                <div class=\"form-group col-md-6\">\n");
      out.write("                                                    <label for=\"inputEmail4\">Name</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" \n");
      out.write("                                                           placeholder=\"Name\"name=\"username\"\n");
      out.write("                                                           value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group col-md-6\">\n");
      out.write("                                                    <label for=\"inputPassword4\">Mobile</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" \n");
      out.write("                                                           placeholder=\"Mobile\"name=\"mobile\"\n");
      out.write("                                                           value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.mobile}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-group form-group\">\n");
      out.write("                                                <div class=\"input-group-prepend\">\n");
      out.write("                                                    <span class=\"input-group-text\"\n");
      out.write("                                                          style=\"background-color: white;\n");
      out.write("                                                          border-color: white;color:black;\n");
      out.write("                                                          padding-left: 0px;\">\n");
      out.write("                                                        <label for=\"inputEmail\">Gender</label></span>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div style=\"color:black;padding:2%;\"class = \"gender\"> \n");
      out.write("                                                    ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"inputEmail\">Email</label>\n");
      out.write("                                                <input type=\"email\" class=\"form-control\" \n");
      out.write("                                                       placeholder=\"Email\"name=\"email\"\n");
      out.write("                                                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"inputAddress\">Address</label>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" \n");
      out.write("                                                       placeholder=\"Address\"name=\"address\"\n");
      out.write("                                                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <br/>\n");
      out.write("\n");
      out.write("                                            <!--<form action=\"change-avata\">-->\n");
      out.write("                                            <input type=\"file\" name=\"pic\" accept=\"image/*\">\n");
      out.write("                                            <!--</form>-->\n");
      out.write("\n");
      out.write("                                            <p style=\"text-align: right;\">\n");
      out.write("                                                <input type=\"submit\" value=\"Update\" />\n");
      out.write("                                            </p>\n");
      out.write("                                        </form>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!--/Update-->\n");
      out.write("\n");
      out.write("                                    <!--Change Password-->\n");
      out.write("                                    <div class=\"tab-pane fade\" id=\"changePass\" \n");
      out.write("                                         role=\"tabpanel\" aria-labelledby=\"changePass-tab\">\n");
      out.write("\n");
      out.write("                                        <form action=\"change-password\"method=\"post\"id=\"changePasswordID\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"inputPass\">Old Password</label>\n");
      out.write("                                                <input type=\"password\" class=\"form-control\" \n");
      out.write("                                                       placeholder=\"Old Password\"name=\"oldpass\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"inputNew\">New Password</label>\n");
      out.write("                                                <input type=\"password\" class=\"form-control\" \n");
      out.write("                                                       placeholder=\"New Password\"name=\"newpass\"id=\"password\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"inputConfNew\">Confirm new password</label>\n");
      out.write("                                                <input type=\"password\" class=\"form-control\" \n");
      out.write("                                                       placeholder=\"Confirm New Password\"name=\"cfnewpass\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <br/><br/>\n");
      out.write("                                            <p style=\"text-align: right;\">\n");
      out.write("                                                <input type=\"submit\" value=\"Update\" />\n");
      out.write("                                            </p>\n");
      out.write("                                        </form>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!--/ChangePassword-->\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Bootstrap core JavaScript-->\n");
      out.write("        <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"assetss/js/bootstrap/popper.min.js\"></script>\n");
      out.write("        <script src=\"assetss/js/bootstrap/bootstrap.min.js\"></script>\n");
      out.write("        <!-- Custom scripts for all pages-->\n");
      out.write("        <script src=\"assetss/js/mnd/mnd.min.js\"></script>\n");
      out.write("        <!-- Data Tables -->\n");
      out.write("        <script src=\"assetss/js/datatables/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script src=\"assetss/js/datatables/datatables.vietnamese.js\"></script>\n");
      out.write("        <script src=\"assetss/js/datatables/dataTables.bootstrap4.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                        ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                                        ");
        if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                                        ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.gender==1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                            <input type=\"radio\" name=\"gender\" value=\"Male\" class = \"form-contorl\"checked=\"checked\"/>Male\n");
        out.write("                                                            <input type=\"radio\" name=\"gender\" value=\"Female\" class = \"form-contorl\"/>Female \n");
        out.write("                                                            <input type=\"radio\" name=\"gender\" value=\"Other\" class = \"form-contorl\"/>Other\n");
        out.write("                                                        ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.gender==0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                            <input type=\"radio\" name=\"gender\" value=\"Male\" class = \"form-contorl\"/>Male\n");
        out.write("                                                            <input type=\"radio\" name=\"gender\" value=\"Female\" class = \"form-contorl\"checked=\"checked\"/>Female \n");
        out.write("                                                            <input type=\"radio\" name=\"gender\" value=\"Other\" class = \"form-contorl\"/>Other                                            ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                            <input type=\"radio\" name=\"gender\" value=\"Male\" class = \"form-contorl\"/>Male\n");
        out.write("                                                            <input type=\"radio\" name=\"gender\" value=\"Female\" class = \"form-contorl\"/>Female \n");
        out.write("                                                            <input type=\"radio\" name=\"gender\" value=\"Other\" class = \"form-contorl\"checked=\"checked\"/>Other                                            ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }
}
