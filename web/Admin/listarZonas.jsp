<%-- 
    Document   : listarZonas
    Created on : 30-abr-2016, 9:28:07
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                                    <h1 class="text-primary">Gestión de Zonas</h1>
  
                                    <div id="modificarzona">
                                        <h3>Modificar o Desactivar Zonas</h3>

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
                                               <tr>
                                                    <td>
                                                        Codigo
                                                    </td>
                                                    <td>
                                                        Nombre
                                                    </td>
                                                    <td>
                                                        <button name="zonaacambiar" type="submit" id="" class="btn btn-xs btn-info text-center"><i class="fa fa-cogs"></i></button>
                                                    </td>
                                                    <td>
                                                        <a href="" class="confirm btn btn-xs btn-danger text-center"><i class="fa fa-trash-o"></i></a>
                                                    </td>
                                                </tr>

                                            </tbody>
                                        </table>
                                        <div>
                                            <div class="form-group text-center">
                                                <button class="btnCancelar btn btn-default">Cancelar</button>
                                            </div>
                                        </div>
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
