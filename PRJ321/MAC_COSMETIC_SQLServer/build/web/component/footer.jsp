<%-- 
    Document   : header
    Created on : Sep 11, 2019, 11:40:58 PM
    Author     : HangNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <body>
        <!-- footer 2 -->
        <div class="container">

            <!--First row-->
            <div class="row features-small mt-5 wow fadeIn">

                <!--Grid column-->
                <div class="col-xl-3 col-lg-6">
                    <!--Grid row-->
                    <div class="row">
                        <div class="col-10 mb-2 pl-3">
                            <h5 class="feature-title font-bold mb-1">
                                <strong>
                                    <fmt:message key="home.stores"/> 
                                    </a>
                                </strong>
                            </h5>
                            <p class="grey-text mt-2">
                                <a
                                    href="cuahang.jsp?language=${language}"
                                    style="color:black;">
                                    <fmt:message key="home.findthestore"/> 
                                </a>
                            </p>
                            <p class="grey-text mt-2"><a
                                    href="dichvutrangdiem.jsp?language=${language}"
                                    style="color:black;">
                                    <fmt:message key="home.makeup"/>
                                </a>
                            </p>
                            <p class="grey-text mt-2">
                                <a href="phanbietthatgia.jsp?language=${language}"
                                   style="color:black;">
                                    <fmt:message key="home.phanbiet"/> 
                                </a>
                            </p>
                        </div>
                    </div>
                    <!--/Grid row-->
                </div>
                <!--/Grid column-->

                <!--Grid column-->
                <div class="col-xl-3 col-lg-6">
                    <!--Grid row-->
                    <div class="row">
                        <div class="col-10 mb-2 pl-3">
                            <h5 class="feature-title font-bold mb-1"><strong>
                                    <fmt:message key="home.vechungtoi"/> </a></strong></h5>
                            <p class="grey-text mt-2"><a
                                    href="docthem1.jsp?language=${language}"
                                    style="color:black;"><fmt:message key="home.outstory"/> </a>
                            </p>
                            <p class="grey-text mt-2"><a
                                    href="docthem2.jsp?language=${language}"
                                    style="color:black;"><fmt:message key="home.quymac"/> </a></a>
                            </p>
                            <p class="grey-text mt-2">
                                <a href="http://www.maccosmetics.com.vn/mac-pro"
                                   style="color:black;">
                                    <fmt:message key="home.macpro"/> </a></a>
                            </p>
                            <p class="grey-text mt-2"><a
                                    href="tuyendung.jsp?language=${language}"
                                    style="color:black;"><fmt:message key="home.cohoinghenghiep"/> </a></a>
                        </div>
                    </div>
                    <!--/Grid row-->
                </div>
                <!--/Grid column-->

                <!--Grid column-->
                <div class="col-xl-3 col-lg-6">
                    <!--Grid row-->
                    <div class="row">
                        <div class="col-10 mb-2 pl-3">
                            <h5 class="feature-title font-bold mb-1"><strong>
                                    <fmt:message key="home.ketnoi"/> </a></strong></h5>
                            <a href="https://www.facebook.com/MACcosmetics/" class="nav-link" target="_blank">
                                <i class="fab fa-facebook-f mr-3"></i></a>
                            <a href="https://www.instagram.com/maccosmetics/" class="nav-link" target="_blank">
                                <i class="fab fa-instagram mr-3"></i></a>
                            <p class="grey-text mt-2"><fmt:message key="home.quocte"/> </a>
                            </p>
                        </div>
                    </div>
                    <!--/Grid row-->
                </div>
                <!--/Grid column-->

                <!--Grid column-->
                <div class="col-xl-3 col-lg-6">
                    <!--Grid row-->
                    <div class="row">
                        <div class="col-10 mb-2 pl-3">

                            <h5 class="feature-title font-bold mb-1"><strong>
                                    <fmt:message key="home.choselanguage"/> </a></strong></h5>
                            <c:choose>
                                <c:when test="${empty subID}||${empty pageID}||${empty subIDPrice}">
                                    <a class="nav-link" href="?language=vi_VN"style="color:black;">
                                        <fmt:message key="home.vietnam"/> 
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="nav-link"href="?&subID=${subID}&subIDPrice=${subIDPrice}&pageId=${pageId}&language=vi_VN"style="color:black;">
                                        <fmt:message key="home.vietnam"/> 
                                    </a>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${empty subID}||${empty pageID}">
                                    <a class="nav-link"style="color:black;" href="?language=en_US">
                                        <fmt:message key="home.english"/> 
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="nav-link"style="color:black;" href="?&subID=${subID}&subIDPrice=${subIDPrice}&pageId=${pageId}&language=en_US">
                                        <fmt:message key="home.english"/> 
                                    </a>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${empty subID}||${empty pageID}||${empty subIDPrice}">
                                    <a class="nav-link" href="?language=ja_JP"style="color:black;">
                                        <fmt:message key="home.ja"/> 
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="nav-link"href="?&subID=${subID}&subIDPrice=${subIDPrice}&pageId=${pageId}&language=ja_JP"style="color:black;">
                                        <fmt:message key="home.ja"/> 
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </div></div>
                    <!--/Grid row-->
                </div>
                <!--/Grid column-->
            </div>
        </div>
        <!--/First row-->

        <!--Footer-->
        <footer class="page-footer text-center font-small mt-4 wow fadeIn"style="color:white;">

            <!--Copyright-->
            <div class="footer-copyright py-3"> <a href="https://www.facebook.com/MACcosmetics/" target="_blank">
                    <i class="fab fa-facebook-f mr-3"></i>
                </a>
                <a href="https://www.instagram.com/maccosmetics/" target="_blank">
                    <i class="fab fa-instagram mr-3"></i>
                </a>
                © 2019 Copyright:
                <a href="#"style="color:white;">
                    mac.cosmetic.com </a>
            </div>
            <!--/.Copyright-->

        </footer>
        <!--/.Footer-->

        <!-- SCRIPTS -->
        <!-- JQuery -->
        <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Initializations -->
        <script type="text/javascript">
            // Animations initialization
            new WOW().init();

        </script>
    </body>

</html>

