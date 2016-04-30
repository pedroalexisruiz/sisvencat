<%-- 
    Document   : listarProductos
    Created on : 29-abr-2016, 11:20:53
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                                        <table class="table table-hover">
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
                                                <tr>
                                                    <td>
                                                        Codigo
                                                    </td>
                                                    <td>
                                                        Nombre
                                                    </td>
                                                    <td>
                                                        Descripcion
                                                    </td>
                                                    <td>
                                                        Valor
                                                    </td>
                                                    <td>
                                                        Cantidad
                                                    </td>
                                                    <td>
                                                        <button name="productoacambiar" type="submit" id="" class="btn btn-xs btn-info" data-toggle="tooltip" title="Cambiar Datos"><i class="fa fa-cogs"></i></button>
                                                    </td>
                                                    <td>
                                                        <button name="BtnproductoImg" type="submit" id="" class="btn btn-xs btn-success" data-toggle="tooltip" title="Subir Imagenes"><i class="fa fa-file-o"></i></button>
                                                    </td>
                                                    <td>
                                                        <button name="productoaborrar" type="submit" id="" class="btn btn-xs btn-danger" data-toggle="tooltip" title="Eliminar"><i class="fa fa-trash-o"></i></button>
                                                    </td>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12 text-center">
                                            <button class="btnCancelar btn btn-default">Cancelar</button>
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
</html>