<%-- 
    Document   : listarCampañas
    Created on : 30-abr-2016, 9:28:07
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                                        <h3>Modificar o Desactivar Campañas</h3>

                                        <p class="lead">Desde esta sección podrás modificar la información de cualquier campaña o desacivarla si es necesario.</p>
                                        <p class="text-muted">Digita la fecha de la campaña y te simplificaremos la búsqueda.</p>

                                        <div class="input-group"> <span class="input-group-addon">Buscar</span>
                                            <input id="campañaabuscar" type="text" class="form-control" placeholder="Ingresa el Código o La Fecha de Inicio de la campaña que deseas Buscar...">
                                        </div>
                                        
                                        <br><br>
                                        
                                        <div class="table-responsive">
                                            <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>Codigo campaña</th>
                                                <th>Fecha de Inicio</th>
                                                <th>Fecha de Finalización</th>          
                                            </tr>
                                        </thead>
                                        <tbody class="buscar">
                                            <tr>
                                                    <td>
                                                        Codigo
                                                    </td>
                                                    <td>
                                                        Fecha Inicio
                                                    </td>
                                                    <td>
                                                        Fecha Fin
                                                    </td>
                                                    <td>
                                                        <button name="campañaacambiar" type="submit" id="" class="btn btn-info"><i class="fa fa-cogs"></i></button>
                                                        <button name="campañaadesactivar" type="submit" id="" class="btn btn-danger"><i class="fa fa-trash-o"></i></button>
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
