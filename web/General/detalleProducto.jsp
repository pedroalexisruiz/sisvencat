
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Color"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenProductoDTO"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />

        <%
            if (!Fachada.existeNegocioGeneral()) {
        %>
        <script>
            location = "../../cerrarSesion.jsp";
        </script>
        <%
        } else if (request.getParameter("id") == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            long id = Long.parseLong(request.getParameter("id"));
            Producto producto = Fachada.getProducto(id);
            String imagenprincipal = (producto.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" : producto.getImagenes().get(0).getUrlImagen();
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto - Detalles</title>
    </head>
    <body>
        <jsp:include page="../public/includes/header.jsp" />

        <div class="navbar navbar-default yamm" role="navigation" id="navbar">
            <div class="container">
                <!--/.navbar-header -->

                <jsp:include page="../public/includes/menupublico.jsp" />
                <!--/.nav-collapse -->

                <!--/.nav-collapse -->

            </div>
            <!-- /.container -->
        </div>
        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Producto</a></li>
                            <li>Detalles</li>
                        </ul>

                    </div>

                    <div>

                        <div>
                            <div class="col-xs-12">

                                <div class="row" id="producto" codigo="<%=producto.getCodigo_p()%>">
                                    <div class="col-sm-6">
                                        <div id="mainImage">
                                            <img src="<%=imagenprincipal%>" alt="" class="img-responsive">
                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="box">
                                            <h1 class="text-center"><%=producto.getNombre()%></h1>
                                            <p class="goToDescription"><a href="#details" class="scroll-to">Desplázate hacia abajo para conocer más detalles del premio.</a>
                                            </p>
                                            <h5>Disponibles: <%=producto.getCantidad()%></h5>
                                            <p class="price">$<%=producto.getValor()%></p>


                                            <p class="text-center buttons">
                                                <%
                                                    if (producto.getCantidad() == 0) {
                                                %>
                                            <p>Agotado.</p>
                                            <button class="btn btn-primary" disabled><i class="fa fa-shopping-cart"></i>Añadir Al Carrito</button>
                                            <%
                                            } else {
                                            %>
                                            <a href="login.jsp" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Añadir Al Carrito</a>
                                            <%
                                            %>
                                            <%}
                                            %>

                                            </p>
                                        </div>

                                        <%
                                            String msg = "";
                                            for (ImagenProductoDTO imagen : producto.getImagenes()) {
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
                                    <h4>Detalles del Producto</h4>

                                    <blockquote>
                                        <p><em><%=producto.getDescripcion()%></em></p>
                                    </blockquote>
                                    
                                    <h4>Colores</h4>
                                    <ul>
                                        <%
                                            for (Color color : producto.getColor()) {
                                        %>
                                        <li><%=color.getNombre()%></li>
                                            <%
                                                }
                                            %>
                                    </ul>
                                    <h4>Tallas y medidas</h4>
                                    <ul>
                                        <%
                                            for (String talla : producto.getTalla()) {
                                        %>
                                        <li><%=talla%></li>
                                            <%
                                                }
                                            %>
                                    </ul>

                                    <hr>
                                </div>
                            </div>
                        </div>


                    </div>
                    <!-- /.container -->
                </div>
                <!-- /#content -->

                <jsp:include page="../public/includes/footer.jsp" />
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
        <script src="../public/js/Item.js" type="text/javascript"></script>
    </body>
    <%
        }
    %>
</html>
