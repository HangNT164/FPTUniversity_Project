<%-- 
    Document   : header
    Created on : Nov 1, 2019, 9:29:00 PM
    Author     : HangNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <nav class="navbar navbar-expand navbar-dark  static-top" style="background-color:forestgreen">

            <a class="navbar-brand mr-1" href="index.jsp">Admin MAC COSMETIC </a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">

                    </button>
                </div>
                </div>
            </form>

 
            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">         
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown"
                       role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="${sessionScope.avataAccount.imageLink}"
                             style="width:32px;height:32px;border-radius: 50%;"class="mr-3">
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="setting">Settings</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="logout">Logout</a>
                    </div>
                </li>
            </ul>
        </nav>
    </body>
</html>
