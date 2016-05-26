<%-- 
    Document   : listarProductos
    Created on : 29-abr-2016, 11:20:53
    Author     : Administrador
--%>

<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Producto"%>
<%@page import="java.sql.SQLException"%>
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

                List<Producto> productos = Fachada.getAdminN().getCampañaActiva().getProductos();
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
                            <li><a href="#">Productos</a>
                            </li>
                            <li>Listado</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">
                                    <h1 class="text-primary">Listado de Productos</h1>
                                    <p class="lead">Desde esta sección podrás modificar o eliminar productos.</p>

                                    </br>
                                    <div class="input-group"> <span class="input-group-addon">Buscar</span>
                                        <input id="productoabuscar" type="text" class="form-control" placeholder="Ingresa el Nombre o el Código del Producto que deseas Buscar...">
                                    </div>

                                    </br>
                                    </br>
                                    <div class="table-responsive">
                                        <table class="table table-striped table-hover">
                                            <thead>
                                                <tr>
                                                    <th class="text-center">Codigo</th>
                                                    <th class="text-center">Nombre</th>
                                                    <th class="text-center">Descripcion</th>
                                                    <th class="text-center">Valor</th>  
                                                    <th class="text-center">Disponibles</th>
                                                    <th class="text-center" colspan="3">Acciones</th>
                                                </tr>
                                            </thead>
                                            <tbody class="buscar">
                                                
                                                <%
                                                    for(Producto producto:productos){
                                                %>
                                                <tr>
                                                    <td><%=producto.getCodigo_p() %></td>
                                                    <td><%=producto.getNombre()%></td>
                                                    <td><%=producto.getDescripcion()%></td>
                                                    <td><%=producto.getValor()%></td>
                                                    <td><%=producto.getCantidad()%></td>
                                                    <td>
                                                        <button name="productoacambiar" type="submit" id="<%=producto.getCodigo_p() %>" class="btn btn-xs btn-info" data-toggle="tooltip" title="Cambiar Datos"><i class="fa fa-cogs"></i></button>
                                                    </td>
                                                    <td>
                                                        <button name="BtnproductoImg" type="submit" id="<%=producto.getCodigo_p() %>" class="btn btn-xs btn-success" data-toggle="tooltip" title="Subir Imagenes"><i class="fa fa-file-o"></i></button>
                                                    </td>
                                                    <td>
                                                        <button name="productoaborrar" type="submit" id="<%=producto.getCodigo_p() %>" class="btn btn-xs btn-danger" data-toggle="tooltip" title="Eliminar"><i class="fa fa-trash-o"></i></button>
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

    </body>
    <%
    } catch (Exception e) {
    %>
    <%="Error" + e.getMessage()%>
    <%
            e.printStackTrace();
        }
    %>
</html>