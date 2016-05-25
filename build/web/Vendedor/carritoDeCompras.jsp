<%-- 
    Document   : carritoDeCompras
    Created on : 30-abr-2016, 8:12:09
    Author     : Administrador
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Producto"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

        <%
            if (!Fachada.existeNegocioVendedor()) {
        %>
        <script>
            alert("Acceso solo para el Administrador");
            location = "../../cerrarSesion.jsp";
        </script>
        <%
        } else {

        %>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Vendedor - Pedido</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Pedido</a></li>
                            <li>Carrito de Compras</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/vendedor/panelVendedor.jsp" />
                    <div class="col-md-9" id="basket">

                        <div class="box">

                            <form method="post" action="checkout1.html">

                                <h1>Carrito de Compras</h1>
                                <%                                    Pedido pedido = Fachada.getVendedorLogeado().getPedido();
                                    if (pedido == null) {
                                %>
                                <p class="text-muted">Actualmente no haz realizado ningún pedido.</p>
                                <%
                                } else {

                                    ArrayList<Item> items = pedido.getItems();
                                    NumberFormat formateador = NumberFormat.getCurrencyInstance();
                                %>
                                <p class="text-muted">Actualmente tienes <%=items.size()%> item(s) en tu carrito.</p>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th colspan="2">Producto</th>
                                                <th>Cantidad</th>
                                                <th>Precio Unidad</th>
                                                <th colspan="2">Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                Producto p = null;
                                                for (Item item : items) {
                                                    p = item.getProducto();
                                                    String rutaimagen = (p.getImagenes().isEmpty()) ? "public/imgpremiosyproductos/imgnormal/lacoste-tenis-casuales-misano-22.jpg" : p.getImagenes().get(0).getUrlImagen();
                                            %>
                                            <tr>
                                                <td>
                                                    <a href="#">
                                                        <img src="<%=rutaimagen%>" alt="White Blouse Armani">
                                                    </a>
                                                </td>
                                                <td><a href="#" id="item" valor="<%=item.getCodigo_item() %>"><%=p.getNombre()%></a>
                                                </td>
                                                <td>
                                                    <input type="number" value="<%=item.getCantidad()%>" class="form-control">
                                                </td>
                                                <td><%=formateador.format(p.getValor()) %></td>
                                                <td><%=formateador.format(item.getValorTotal()) %></td>
                                                <td><a href="#"><i class="fa fa-trash-o"></i></a>
                                                </td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th colspan="5">Total</th>
                                                <th colspan="2"><%=formateador.format(pedido.getValorTotal()) %></th>
                                            </tr>
                                        </tfoot>
                                    </table>

                                </div>
                                <!-- /.table-responsive -->

                                <div class="box-footer">
                                    <div class="pull-left">
                                        <a href="category.html" class="btn btn-default"><i class="fa fa-chevron-left"></i> Continuar Comprando</a>
                                    </div>
                                    <div class="pull-right">
                                        <button id="btnEnviarPedido" class="btn btn-primary">Confirmar Pedido <i class="fa fa-chevron-right"></i>
                                        </button>
                                    </div>
                                </div>

                            </form>
                            <%
                                }
                            %>
                        </div>
                        <!-- /.box -->
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
        <script src="../public/js/Pedido.js" type="text/javascript"></script>
        <%
            }
        %>
    </body>
</html>
