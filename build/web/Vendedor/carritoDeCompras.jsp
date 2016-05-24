<%-- 
    Document   : carritoDeCompras
    Created on : 30-abr-2016, 8:12:09
    Author     : Administrador
--%>

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
            Pedido pedido = Fachada.getVendedorLogeado().getPedido();
            ArrayList<Item> items = pedido.getItems();
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
                                <p class="text-muted">Actualmente tienes <%=items.size() %> item(s) en tu carrito.</p>
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
                                                for(Item item:items){
                                                    p = item.getProducto();
                                                    String rutaimagen ="public/imgpremiosyproductos/imgnormal/nodisponible.jpg";
                                            %>
                                            <tr>
                                                <td>
                                                    <a href="#">
                                                        <img src="<%=rutaimagen %>" alt="White Blouse Armani">
                                                    </a>
                                                </td>
                                                <td><a href="#"><%=p.getNombre() %></a>
                                                </td>
                                                <td>
                                                    <input type="number" value="<%=item.getCantidad() %>" class="form-control">
                                                </td>
                                                <td>$<%=p.getValor() %></td>
                                                <td>$<%=item.getValorTotal() %></td>
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
                                                <th colspan="2">$220.000</th>
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
                                        <button type="submit" class="btn btn-primary">Confirmar Pedido <i class="fa fa-chevron-right"></i>
                                        </button>
                                    </div>
                                </div>

                            </form>

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
    </body>
</html>
