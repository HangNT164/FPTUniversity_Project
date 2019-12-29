<%-- 
    Document   : menu
    Created on : Nov 1, 2019, 9:29:15 PM
    Author     : HangNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <!-- Sidebar -->
        <ul class="sidebar navbar-nav" style="position: absolute">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp" style="background: black">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span>
                </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Product</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <a class="dropdown-item" href="get-all-productt">Get All Product</a>
                    <a class="dropdown-item" href="get-all-category">Create category </a>
                    <a class="dropdown-item" href="get-sub-category">Create subcategory </a>
                    <!--<a class="dropdown-item" href="addProduct.jsp">Tao san pham </a>-->
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="get-all-order">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Order</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="get-all-account">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Account</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="chart">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Chart</span></a>
            </li>
        </ul>
    </body>
</html>
