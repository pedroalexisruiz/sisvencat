<%-- 
    Document   : subirImagenesPremio
    Created on : 29/05/2016, 02:43:08 PM
    Author     : Administrator
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Premio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

        <%
            if (Fachada == null) {
        %>
        <script>
            alert("Debe Iniciar Sesión");
            location = "../General/login.jsp";
        </script>
        <%
        } else if (Fachada.getAdminN() == null) {
        %>
        <script>
            alert("Acceso solo para el Administrador");
            location = "../../cerrarSesion.jsp";
        </script>
        <%
        } else {
            try {
                long codigo_p = Long.parseLong(request.getParameter("id"));
                Premio premio = Fachada.getPremio(codigo_p);
        %>
        <link href="../public/css/fileinput.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/blitzer/jquery-ui.css" type="text/css" />
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        
        <title>JSP Page</title>
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

                                    <div class="row">
                                        <div class="col-xs-12">
                                            <h2 class="text-primary text-center">Subir Imagenes</h2>
                                            <h4 class="text-muted">Puedes Subir Varias Imagenes a  la vez si lo deseas.</h4>
                                            <form action="controladordeImagenesPremio.jsp" method="POST" enctype="multipart/form-data">
                                                <div align="center" class="form-group">

                                                    <input type="file" name="imagen" id="imagen"  multiple="multiple"/>
                                                    <input type="hidden" class="form-control" name="Codigo_pImg" value="<%=premio.getCodigo_premio()%>">
                                                    <br>
                                                    <input type="submit" class="btn btn-default" value="Subir"/>
                                                </div>
                                            </form>
                                        </div>
                                    </div>

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
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <script src="../public/js/fileinput/fileinput.js" type="text/javascript"></script>
        <script src="../public/js/bootstrap/bootstrap.min.js"></script>
        
        
        <script src="../public/js/Imagenes.js" type="text/javascript"></script>
    </body>
    <%} catch (Exception e) {
    %>
    <%=e.getMessage()%>
    <%
            }
        }
    %>
</html>
