
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenPremioDTO"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Premio"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>
            <link href="../public/css/popUp.css" rel="stylesheet" type="text/css"/>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Premio - Detalles</title>

        <%
            if (!Fachada.existeNegocioVendedor()) {
        %>
        <script>
            alert("Acceso solo para el Vendedor");
            location = "../../cerrarSesion.jsp";
        </script>
        <%
        } else if (request.getParameter("id") == null) {
            request.getRequestDispatcher("Profile.jsp").forward(request, response);
        } else {
            long id = Long.parseLong(request.getParameter("id"));
            Premio premio = Fachada.getPremio(id);
            String imagenprincipal = (premio.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" : premio.getImagenes().get(0).getUrlImagen();
        %>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="Profile.jsp">Inicio</a></li>
                            <li><a href="verPremios.jsp">Premios</a></li>
                            <li>Detalles</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/vendedor/panelVendedor.jsp" />
                    <div class="col-md-9">

                        <div class="row" id="premio" codigo="<%=premio.getCodigo_premio()%>" puntosvendedor="<%=Fachada.getVendedorLogeado().getPuntajeAcumulado()%>">
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
                                    <p class="price" id="precio" precio="<%=premio.getPuntosRequeridos()%>">$<%=premio.getPuntosRequeridos()%></p>

                                    <%
                                        if (Fachada.getCampañaActiva() == null) {
                                    %>
                                    <p>No se pueden solicitar Premios mientras que no haya campañas Activas.</p>
                                    <p class="text-center buttons">
                                        <button disabled class="btn btn-primary"><i class="fa fa-shopping-cart"></i> Solicitar</button> 
                                    </p>
                                    <%
                                    }else{
                                        if (Fachada.getVendedorLogeado().getPremio() == null) {
                                    %>
                                    <p class="text-center buttons">
                                        <button id="btnSolicitarPremio" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> Solicitar</button> 
                                    </p>
                                    <%
                                    } else {
                                    %>
                                    <p>Ya has solicitado un premio esta campaña.</p>
                                    <p class="text-center buttons">
                                        <button class="btn btn-primary" disabled><i class="fa fa-shopping-cart"></i> Solicitar</button> 
                                    </p>
                                    <%
                                        }
}
                                    %>

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

                            <p><%=premio.getDescripcion()%>.</p>

                            <hr>
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
        <script src="../public/js/Premio.js" type="text/javascript"></script>

    </body>
    <%
        }
    %>
</html>
