<%-- 
    Vista de las Zonas Activas en el Sistema
--%>

<%@page import="java.text.ParseException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Zona"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
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

                List<Zona> zonas = Fachada.getAdminN().getListadoDeZonasPorEstado(1);
        %>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Admin - Zonas</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Zonas</a>
                            </li>
                            <li>Listado</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">

                                    <div id="divListado">
                                        
                                        <h1 class="text-primary text-center">Gestión de Zonas</h1>
                                        
                                        <h3 class='text-center'>Modificar o Desactivar Zonas</h3>

                                        <p class="lead">Desde esta sección podrás modificar la información de cualquier zona o desacivarla si es necesario.</p>
                                        <p class="text-muted">Digita el nombre de la zona y te simplificaremos la búsqueda.</p>

                                        <div class="input-group"> <span class="input-group-addon">Buscar</span>
                                            <input id="zonaabuscar" type="text" class="form-control" placeholder="Ingresa el Nombre o el Código del zona que deseas Buscar...">
                                        </div>

                                        <br><br>

                                        <div class="table-responsive">
                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>Codigo zona</th>
                                                        <th>Nombre</th>
                                                        <th class="text-center" colspan="2">Acciones</th>
                                                    </tr>
                                                </thead>
                                                <tbody class="buscar">
                                                    <%
                                                        for (Zona zona : zonas) {


                                                    %>
                                                    <tr>
                                                        <td><%=zona.getCodigo_z()%></td>
                                                        <td><%=zona.getNombre()%></td>
                                                        <td class="text-center">
                                                            <button name="btnZonaaCambiar" type="submit" id="<%=zona.getCodigo_z()%>" class="btn btn-xs btn-info text-center" data-toggle="tooltip" title="Modificar"><i class="fa fa-cogs"></i></button>
                                                        </td>
                                                        <td class="text-center">
                                                            <button name="btnZonaaDesactivar" id="<%=zona.getCodigo_z()%>" class="confirm btn btn-xs btn-danger text-center" data-toggle="tooltip" title="Desactivar"><i class="fa fa-trash-o"></i></button>
                                                        </td>
                                                    </tr>
                                                    <%
                                                        }
                                                    %>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>

                                    <div id="divModificar" hidden>
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
        <script src="../public/js/bootstrap/bootstrap-hover-dropdown.js"></script>
        <script src="../public/js/Administrador.js" type="text/javascript"></script>

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
