<%@page import="java.sql.SQLException"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor"%>
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

                List<Vendedor> vendedores = Fachada.getAdminN().getListadoDeVendedoresPorEstado(1);
        %>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Admin - Vendedores</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Inicio</a>
                            </li>
                            <li>Vendedores</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">

                                    <div id="divListado">
                                        <h1 class="text-primary">Listado de Vendedores</h1>

                                        <p class="lead">Desde esta sección podrás desactivar o modificar la información de cualquier vendor que desees.</p>

                                        </br>
                                        </br>
                                        <%
                                            if (vendedores.isEmpty()) {
                                        %>
                                        <h4 class="text-center text-info">NO SE ENCUENTRAN VENDEDORES ACTIVOS</h4>
                                        <%
                                        } else {
                                        %>
                                        <p class="text-muted">Digita el nombre del Vendedor o su Cédula y te simplificaremos la búsqueda.</p>

                                        <div class="row">
                                            <div class="col-xs-12 col-md-8">
                                                <div class="input-group"> <span class="input-group-addon">Buscar</span>
                                                    <input id="gerenteabuscar" type="text" class="form-control" placeholder="Ingresa el Nombre o la Cédula del Vendedor que deseas Buscar...">
                                                </div>
                                            </div>
                                        </div>

                                        </br>
                                        </br>
                                        <div class="row">
                                            <div class="table-responsive">
                                                <table class="table table-striped table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th class="text-center">Cédula</th>
                                                            <th class="text-center">Nombre</th>  
                                                            <th class="text-center">Apellido</th>
                                                            <th class="text-center">Puntaje</th> 
                                                            <th class="text-center" colspan="2">Acciones</th> 
                                                        </tr>
                                                    </thead>
                                                    <tbody class="buscar">

                                                        <%
                                                            for (Vendedor vendedor : vendedores) {
                                                        %>
                                                        <tr>
                                                            <td class="text-center"><%=vendedor.getCedula()%></td>
                                                            <td class="text-center"><%=vendedor.getNombre()%></td>
                                                            <td class="text-center"><%=vendedor.getApellido()%></td>
                                                            <td class="text-center"><%=vendedor.getPuntajeAcumulado()%></td>
                                                            <td class="text-center">
                                                                <button name="btnVendedorACambiar" type="submit" id="<%=vendedor.getCedula()%>" class="btn btn-xs btn-info" data-toggle="tooltip" title="Modificar"><i class="fa fa-cogs"></i></button>
                                                            </td>
                                                            <td class="text-center">
                                                                <button name="btnVendedorADesactivar" type="submit" id="<%=vendedor.getCedula()%>" class="btn btn-xs btn-danger" data-toggle="tooltip" title="Desactivar"><i class="fa fa-trash-o"></i></button>
                                                            </td>
                                                        </tr>
                                                        <%
                                                            }
                                                        %>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                    <div id="divModificar" hidden>

                                    </div>
                                    <%
                                        }
                                    %>
                                </div>
                            </div>
                        </div>


                    </div>
                    <!-- /.container -->
                </div>
                <!-- /#content -->
            </div>
            <jsp:include page="../public/includes/footerLogin.jsp" />
            <!-- /#all -->
            <script src="../public/js/jquery-1.11.0.min.js"></script>
            <script src="../public/js/bootstrap/bootstrap.min.js"></script>
            <script src="../public/js/Administrador.js" type="text/javascript"></script>

        </div>
    </body>
    <%
    } catch (SQLException e) {
    %>
    <%="Error  " + e.getMessage()%>
    <%
        e.printStackTrace();
    } catch (Exception e) {
    %>
    <%="Error: " + e.getMessage()%>
    <%
            e.printStackTrace();
        }
    %>
</html>
