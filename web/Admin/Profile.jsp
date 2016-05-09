

<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>

        <jsp:include page="validarAdmin.jsp"></jsp:include>
        <%
            try {
        %>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Profile - Admin</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="Profile.jsp">Inicio</a></li>
                            <li>Mi Cuenta</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">
                                    <h1>Bienvenido<h1>
                                            </div>
                                            </div>
                                            </div>


                                            </div>
                                            <!-- /.container -->
                                            </div>
                                            <!-- /#content -->

                                            <jsp:include page="../public/includes/footerLogin.jsp" />
                                            </div>
                                            <!-- /#all -->
                                            </div>

                                            <script src="../public/js/jquery-1.11.0.min.js"></script>
                                            <script src="../public/js/bootstrap/bootstrap.min.js"></script>
                                            <script src="../public/js/jquery.cookie.js"></script>
                                            <script src="../public/js/waypoints.min.js"></script>
                                            <script src="../public/js/bootstrap/bootstrap-hover-dropdown.js"></script>
                                            <script src="../public/js/owl.carousel.min.js"></script>
                                            <script src="../public/js/front.js"></script>
                                            </body>
                                            <%                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            %>
                                            <script>
                                                location = "../General/index.jsp";
                                            </script>
                                            <%
                                                }
                                            %>
                                            </html>
