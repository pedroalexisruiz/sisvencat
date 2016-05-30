<%-- 
    Document   : modificarProducto
    Created on : 29/05/2016, 05:04:12 AM
    Author     : Administrator
--%>

<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Color"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenProductoDTO"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Producto"%>
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            SisvencatFacade Fachada = (SisvencatFacade) request.getSession().getAttribute("Fachada");

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
                Producto producto = Fachada.getProducto(codigo_p);
                String imagenprincipal = (producto.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" : producto.getImagenes().get(0).getUrlImagen();
                List<Categoria> categorias = Fachada.getCategorias();
                ArrayList<Tipo> tipos = Fachada.getTipos();
        %>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Admin - Productos</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Producto</a></li>
                            <li>Detalles</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />

                    <div class="col-md-9">

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
                                    <p class="price">$<%=producto.getValor()%></p>

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

                            <div class="row">
                                <form id="formModificarProducto" action="modificadorDeProductos.jsp" method="GET">

                                    <input type="hidden" name="Codigo" id="Codigo" required value="<%=producto.getCodigo_p()%>"/>
                                    <div class="col-md-6 form-group">
                                        <label for="text">Nombre</label>
                                        <input type="text" class="form-control" name="Nombre" id="Nombre" required value="<%=producto.getNombre()%>"/>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label for="text">Valor</label>
                                        <input type="number" class="form-control" name="Valor" id="Valor" required value="<%=producto.getValor()%>"/>
                                    </div>
                                    <div class="col-xs-6 form-group">
                                        <label for="text">Cantidad</label>
                                        <input type="number" class="form-control" name="Cantidad" id="Cantidad" required value="<%=producto.getCantidad()%>"/>
                                    </div>

                                    <div class="col-xs-12 col-md-6 form-group">
                                        <label for="text">Categoría</label>
                                        <select name="Categoria" class="form-control">
                                            <%
                                                for (Categoria categoria : categorias) {
                                                    if (categoria.getId() == producto.getCategoria().getId()) {
                                            %>
                                            <option value="<%=categoria.getId()%>" selected><%=categoria.getNombre()%></option>
                                            <%
                                            } else {
                                            %>
                                            <option value="<%=categoria.getId()%>"><%=categoria.getNombre()%></option>
                                            <%
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                    <div class="col-xs-6 form-group">
                                        <label for="text">Tipo de Prenda</label>
                                        <select name="Tipo" class="form-control">
                                            <%
                                                for (Tipo tipo : tipos) {
                                                    if (tipo.getId() == producto.getTipoProducto().getId()) {
                                            %>
                                            <option value="<%=tipo.getId()%>" selected><%=tipo.getDescripcion()%></option>
                                            <%
                                            } else {
                                            %>
                                            <option value="<%=tipo.getId()%>"><%=tipo.getDescripcion()%></option>
                                            <%
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>

                                    <div class="col-xs-12">

                                        <h4>Colores</h4>

                                        <%
                                            List<Color> colores = producto.getColor();
                                            ArrayList<Color> colorestotales = Fachada.getColores();

                                            for (int i = 0; i < colorestotales.size(); i++) {
                                                if (colores.contains(colorestotales.get(i))) {
                                        %>
                                        <div class="col-xs-12 col-md-6">
                                            <div>
                                                <input type="checkbox" name="Colores" id="" value="<%=colorestotales.get(i).getId()%>" checked/>
                                                <label for=""><span></span><%=colorestotales.get(i).getNombre()%></label>
                                            </div>
                                        </div>
                                            <%
                                            } else {
                                            %>
                                        <div class="col-xs-12 col-md-6">
                                            <div>
                                                <input type="checkbox" name="Colores" id="" value="<%=colorestotales.get(i).getId()%>"/>
                                                <label for=""><span></span><%=colorestotales.get(i).getNombre()%></label>
                                            </div>
                                        </div>
                                        <%
                                                }
                                            }
                                        %>

                                    </div>

                                    <div class="col-xs-12">
                                        <h4>Tallas y medidas</h4>
                                        <%
                                            List<String> tallas = producto.getTalla();
                                            ArrayList<String> tallastotales = Fachada.getTallas();

                                            for (int i = 0; i < tallastotales.size(); i++) {
                                                if (tallas.contains(tallastotales.get(i))) {
                                        %>
                                        <div class="col-xs-12 col-md-6">
                                            <div>
                                                <input type="checkbox" name="Tallas" id="tallas" value="<%=tallastotales.get(i)%>" checked/>
                                                <label for=""><span></span><%=tallastotales.get(i)%></label>
                                            </div></div>
                                            <%
                                            } else {
                                            %>
                                        <div class="col-xs-12 col-md-6">
                                            <div>
                                                <input type="checkbox" name="Tallas" id="tallas" value="<%=tallastotales.get(i)%>" />
                                                <label for=""><span></span><%=tallastotales.get(i)%></label>
                                            </div>
                                        </div>
                                        <%
                                                }
                                            }
                                        %>
                                    </div>

                                    <div class="col-xs-12 form-group">
                                        <label for="text">Descripción</label>
                                        <blockquote>
                                            <textarea class="form-control" rows="5" name="Descripcion" id="Descripcion"><%=producto.getDescripcion()%></textarea>
                                        </blockquote>
                                    </div>

                                    <div class="col-xs-12 form-group text-center">
                                        <button type="submit" id="btnModificarProducto" class="btn btn-primary"><i class="fa fa-sign-in"></i> Guardar Cambios</button>
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
