<%-- 
    Document   : modificarPremio
    Created on : 29/05/2016, 05:04:12 AM
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenPremioDTO"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Premio"%>
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
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
                String imagenprincipal = (premio.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" : premio.getImagenes().get(0).getUrlImagen();
        %>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Admin - Premios</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Premio</a></li>
                            <li>Detalles</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />

                    <div class="col-md-9">

                        <div class="row" id="premio" codigo="<%=premio.getCodigo_premio()%>">
                            <div class="col-sm-6">
                                <div id="mainImage">
                                    <img src="<%=imagenprincipal%>" alt="" class="img-responsive">
                                </div>

                            </div>
                            <div class="col-sm-6">
                                <div class="box">
                                    <h1 class="text-center"><%=premio.getNombre()%></h1>
                                    <p class="goToDescription"><a href="#details" class="scroll-to">Desplázate hacia abajo para conocer más detalles del premio.</a>
                                    </p>
                                    <p class="price">Puntaje Requerido: $<%=premio.getPuntosRequeridos()%></p>

                                </div>

                                <%
                                    String msg = "";
                                    for (ImagenPremioDTO imagen : premio.getImagenes()) {
                                        msg += "<div class='col-xs-4'>"
                                                + "<a href='" + imagen.getUrlImagen() + "' class='thumb'>"
                                                + "<img src='" + imagen.getUrlImagen() + "' alt='' class='img-responsive'>"
                                                + "</a>"
                                                + "</div>";
                                    }
                                %>
                                <div class="row" id="thumbs">
                                    <%=msg%>
                                </div>
                            </div>

                        </div>


                        <div class="box" id="details">
                            <p>
                            <h4>Detalles del Premio</h4>

                            <div class="row">
                                <form id="formModificarPremio" action="modificadorDePremios.jsp" method="GET">

                                    <input type="hidden" name="Codigo" id="Codigo" required value="<%=premio.getCodigo_premio()%>"/>
                                    <div class="col-md-6 form-group">
                                        <label for="text">Nombre</label>
                                        <input type="text" class="form-control" name="Nombre" id="Nombre" required value="<%=premio.getNombre()%>"/>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label for="text">Valor</label>
                                        <input type="number" class="form-control" name="Puntos_requeridos" id="Valor" required value="<%=premio.getPuntosRequeridos()%>"/>
                                    </div>
                                    <div class="col-xs-6 form-group">
                                        <label for="text">Cantidad</label>
                                        <input type="number" class="form-control" name="Cantidad" id="Cantidad" required value="<%=premio.getCantidadDisponible()%>"/>
                                    </div>

                                    <div class="col-xs-12 form-group">
                                        <label for="text">Descripción</label>
                                        <blockquote>
                                            <textarea class="form-control" rows="5" name="Descripcion" id="Descripcion"><%=premio.getDescripcion()%></textarea>
                                        </blockquote>
                                    </div>

                                    <div class="col-xs-12 form-group text-center">
                                        <button type="submit" id="btnModificarPremio" class="btn btn-primary"><i class="fa fa-sign-in"></i> Guardar Cambios</button>
                                    </div>

                                </form>
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
        <script src="../public/js/jquery.cookie.js" type="text/javascript"></script>
        <script src="../public/js/waypoints.min.js" type="text/javascript"></script>
        <script src="../public/js/modernizr.js" type="text/javascript"></script>
        <script src="../public/js/owl.carousel.min.js" type="text/javascript"></script>
        <script src="../public/js/front.js" type="text/javascript"></script>
    </body>
    <%} catch (SQLException e) {
    %>
    <%=e.getMessage()%>
    <%
            }
        }
    %>
</html>
