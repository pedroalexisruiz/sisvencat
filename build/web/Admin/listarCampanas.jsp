<%-- 
    Document   : listarCampañas
    Created on : 30-abr-2016, 9:28:07
    Author     : Administrador
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña"%>
<%@page import="java.util.List"%>
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
            }
            try {

                List<Campaña> campañas = Fachada.getAdminN().getListadoDeCampañasPorEstado(2);
        %>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Admin - Campañas</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Campañas</a>
                            </li>
                            <li>Listado</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">
                                    <h1 class="text-primary">Gestión de Campañas</h1>

                                    <div id="modificarcampaña">
                                        <h4>Modificar o Desactivar Campañas</h4>

                                        <p>Desde esta sección podrás listar las campañas registradas y modificar la información de la campaña activa o finalizarla si es necesario.</p>

                                        <%
                                            if (Fachada.getAdminN().getCampañaActiva() != null) {
                                                Campaña campañaactiva = Fachada.getAdminN().getCampañaActiva();
                                        %>
                                        <h3 class="text-center text-primary lead">Campaña Activa</h3>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th class="text-center">Codigo campaña</th>
                                                        <th class="text-center">Fecha de Inicio</th>
                                                        <th class="text-center">Fecha de Finalización</th> 
                                                        <th class="text-center">Tema</th>
                                                        <th class="text-center" colspan="2">Acciones</th>
                                                    </tr>
                                                </thead>
                                                <tbody class="buscar">
                                                    <tr class="btn-info">
                                                        <td class="text-center"><%=campañaactiva.getCodigo_cam()%></td>
                                                        <td class="text-center"><%=campañaactiva.getFechaInicioString()%></td>
                                                        <td class="text-center"><%=campañaactiva.getFechaFinString()%></td>
                                                        <td class="text-center"><%=campañaactiva.getTema()%></td>
                                                        <td class="text-center">
                                                            <button name="modificarcampaña" type="submit" id="<%=campañaactiva.getCodigo_cam()%>" class="btn btn-xs btn-primary" data-toggle="tooltip" title="Modificar"><i class="fa fa-cogs"></i></button>
                                                        </td>
                                                        <td class="text-center">
                                                            <button name="desactivarcampaña" type="submit" id="<%=campañaactiva.getCodigo_cam()%>" class="btn btn-xs btn-success" data-toggle="tooltip" title="Desactivar"><i class="fa fa-trash-o"></i></button>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <%
                                            }
                                        %>
                                        <br>
                                        <h3 class="text-center text-aqua lead">Campañas Anteriores</h3>
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-hover">
                                                <thead>
                                                    <tr class="active">
                                                        <th class="text-center">Codigo campaña</th>
                                                        <th class="text-center">Fecha de Inicio</th>
                                                        <th class="text-center">Fecha de Finalización</th> 
                                                        <th class="text-center">Tema</th>
                                                    </tr>
                                                </thead>
                                                <tbody class="buscar">
                                                    <%
                                                        for (Campaña campaña : campañas) {
                                                    %>
                                                    <tr>
                                                        <td class="text-center"><%=campaña.getCodigo_cam()%></td>
                                                        <td class="text-center"><%=campaña.getFechaInicioString()%></td>
                                                        <td class="text-center"><%=campaña.getFechaFinString()%></td>
                                                        <td class="text-center"><%=campaña.getTema()%></td>
                                                    </tr>
                                                    <%
                                                        }
                                                    %>
                                                </tbody>
                                            </table>
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
        <script src="../public/js/bootstrap/bootstrap.min.js"></script>
        <script src="../public/js/jquery.cookie.js"></script>
        <script src="../public/js/waypoints.min.js"></script>
        <script src="../public/js/bootstrap/bootstrap-hover-dropdown.js"></script>
        <script src="../public/js/owl.carousel.min.js"></script>
        <script src="../public/js/front.js"></script>
    </body>
    <%
    } catch (SQLException e) {
    %>
    <%="Error SQL: " + e.getMessage()%>
    <%
            e.printStackTrace();
        }
    %>
</html>
