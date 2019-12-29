<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : header
    Created on : Sep 11, 2019, 11:40:58 PM
    Author     : HangNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<c:if test="${not empty param.language}">
    <c:set var="language" value="${param.language}" scope="session"/>
</c:if>
<c:if test="${empty param.language}">
    <c:set var="language" value="en_US" scope="session"/>
</c:if>
<c:set var="pageId" value="${empty param.pageId ? 1:param.pageId}" scope="session"/>
<c:set var="subID" value="${empty param.subID ? 0:param.subID}" scope="session"/>
<c:set var="subIDPrice" value="${empty param.subIDPrice ? 0:param.subIDPrice}" scope="session"/>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resourceBundle.languages" />

<!DOCTYPE html>
<html lang="en">
    <body>

        <!-- Navbar -->
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar">
            <div class="container">

                <!-- Brand -->
                <a class="navbar-brand"
                   href="index.jsp?language=${language}">
                    <h2>MAC</h2>
                </a>

                <!-- Collapse -->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <!-- Links -->
                <div class="collapse navbar-collapse" id="navbarSupportedContent">

                    <!-- Left -->
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item"style="font-size:13px;">
                            <a class="nav-link"
                               href="docthem1.jsp?language=${language}">
                                <b>
                                    <strong>
                                        <fmt:message key="home.outstory"/>
                                    </strong>
                                </b>
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item"style="font-size:13px;">
                            <a class="nav-link"
                               href="get-all-product?pageId=${pageId}&language=${language}">
                                <b>
                                    <strong> 
                                        <fmt:message key="home.newproduct"/>
                                    </strong>
                                </b>
                                <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item"style="font-size:13px;">
                            <a class="nav-link"
                               href="filter-product?pageId=${pageId}&language=${language}">
                                <b>
                                    <strong> 
                                        <fmt:message key="home.filterproduct"/> 
                                    </strong>
                                </b>
                                <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item"style="font-size:13px;">
                            <a class="nav-link"
                               href="hot-product?pageId=${pageId}&language=${language}">
                                <b>
                                    <strong> 
                                        <fmt:message key="home.sellingproduct"/> 
                                    </strong>
                                </b>
                                <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item"style="font-size:13px;">
                            <a class="nav-link"
                               href="cuahang.jsp?language=${language}">
                                <b>
                                    <strong> 
                                        <fmt:message key="home.store"/> 
                                    </strong>
                                </b>
                                <span class="sr-only">(current)</span></a>
                        </li>
                    </ul>

                    <!-- Right -->
                    <ul class="navbar-nav nav-flex-icons"style="padding-top: 1%;">

                        <li class="nav-item">
                            <div class="dropdown" style="display: block;">
                                <button class="btn" id="dropdownMenuButton" data-toggle="dropdown">
                                    <a href="#" class="nav-link" style="display: block;">
                                        <i class="fa fa-search"></i>
                                    </a>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                    <form class="form-inline" action="search-product">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="search"
                                                   placeholder="Search by name">
                                            <button type="submit" class="btn">
                                                <i class="fa fa-search"></i>                                               
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </li>

                        <li class="nav-item">
                            <div class="dropdown"style="margin-top:1%;">                               
                                <c:if test="${sessionScope.listCard.size()==null}">
                                    <a href="themgiohangnull.jsp" class="nav-link">
                                        <i class="fas fa-shopping-cart"></i>
                                    </a>
                                </c:if>                                
                                <c:if test="${sessionScope.listCard.size()!=null}">
                                    <a href="themgiohang.jsp" class="nav-link">
                                        <i class="fas fa-shopping-cart"></i>
                                        <span class="badge badge-light">
                                            ${sessionScope.listCard.size()}</span>
                                    </a>
                                </c:if>
                            </div>
                        </li>

                        <li class="nav-item">
                            <div class="dropdow"style="margin-top:1%;">
                                <c:if test="${empty sessionScope.user.name}">
                                    <a href="login1" class="nav-link">
                                        <i class="fas fa-user"></i>
                                    </a>
                                </c:if>
                            </div>
                        </li>
                        <div class="dropdown"> 
                            <div class="media">
                                <c:if test="${not empty sessionScope.user.name}">
                                    <!--Khi co avata roi-->      
                                    <img src="${sessionScope.avataAccount.imageLink}"
                                         style="width:32px;height:32px;border-radius: 45%;"class="mr-3">
                                </c:if>
                                <div class="media-body" style="padding-top:10%;">
                                    <a href="your-info">
                                        <p style="color:white;font-size:15px;">
                                            ${sessionScope.user.name}</p>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </ul>
                    <!--/.Right-->
                </div>
            </div>
        </nav>
        <!-- Navbar -->
    </body>

</html>

