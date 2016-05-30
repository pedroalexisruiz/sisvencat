<%-- 
    Document   : listarPedidos
    Created on : 29/05/2016, 07:24:49 PM
    Author     : Administrator
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

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
    }
    try {

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Lista de Pedidos</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="Profile.jsp">Inicio</a></li>
                            <li>Pedidos</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />

                    <div class="col-md-9">
                        <div id="results" class="box">
                            <%                                
                                if (Fachada.getCampañaActiva() == null) {
                            %>
                            <h2 class="text-primary text-center">No existe Campaña Activa</h2>
                            <%
                            } else {

                                List<Pedido> pedidos = Fachada.getPedidos();
                                DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                            %>
                            <h1 class="text-primary text-center">Listado de Pedidos</h1>

                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th class="text-center">Cédula Vendedor</th>
                                            <th class="text-center">Valor Total</th>
                                            <th class="text-center">Fecha de Solicitud</th> 
                                            <th class="text-center">Estado</th>
                                        </tr>
                                    </thead>
                                    <tbody class="buscar">

                                        <%
                                            String estado = "";
                                            for (Pedido pedido : pedidos) {
                                                estado = (pedido.getEstado() == 1) ? "En Espera" : "Enviado";
                                        %>
                                        <tr>
                                            <td class="text-center"><%=pedido.getCedulaVendedor()%></td>
                                            <td class="text-center"><%=pedido.getValorTotal()%></td>
                                            <td class="text-center"><%=formater.format(pedido.getFecha().getTime())%></td>
                                            <td class="text-center"><%=estado%></td>
                                        </tr>
                                        <%
                                            }
                                        %>

                                    </tbody>
                                </table>
                            </div>
                                        <%}
                                        %>
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
        <script src="../public/js/Pedido.js" type="text/javascript"></script>
    </body>
    <%                                         
    } catch (Exception e) {
        e.printStackTrace();
    %>
    <script>
    location = "../General/index.jsp";
    </script>
    <%
        }
    %>
</html>
