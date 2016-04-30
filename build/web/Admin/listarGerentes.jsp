<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Admin - Gerentes</title>
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
                            <li>Gerentes</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">
                                    <h1 class="text-primary">Listado de Gerentes</h1>

                                    <p class="lead">Desde esta sección podrás desactivar o modificar la información de cualquier gerente que desees.</p>

                                    </br>
                                    </br>
                                    <p class="text-muted">Digita el nombre del Gerente o su Cédula y te simplificaremos la búsqueda.</p>

                                    <div class="row">
                                        <div class="col-xs-12 col-md-8">
                                            <div class="input-group"> <span class="input-group-addon">Buscar</span>
                                                <input id="gerenteabuscar" type="text" class="form-control" placeholder="Ingresa el Nombre o la Cédula del gerente que deseas Buscar...">
                                            </div>
                                        </div>
                                    </div>

                                    </br>
                                    </br>
                                    <div class="row">
                                        <div class="table-responsive">
                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th class="text-center">Cédula</th>
                                                        <th class="text-center">Nombre</th>  
                                                        <th class="text-center">Apellido</th>
                                                        <th class="text-center">Zona</th> 
                                                        <th class="text-center" colspan="2">Acciones</th> 
                                                    </tr>
                                                </thead>
                                                <tbody class="buscar">
                                                    <tr>
                                                        <td>1090474434</td>
                                                        <td>Pedro Alexis</td>
                                                        <td>Ruiz Martinez</td>
                                                        <td>Norte de Santander</td>
                                                        <td class="text-center">
                                                            <button name="gerenteacambiar" type="submit" id="" class="btn btn-sm btn-info" data-toggle="tooltip" title="Modificar"><i class="fa fa-cogs"></i></button>
                                                        </td>
                                                        <td class="text-center">
                                                            <button name="gerenteadesactivar" type="submit" id="" class="btn btn-sm btn-danger" data-toggle="tooltip" title="Desactivar"><i class="fa fa-trash-o"></i></button>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="form-group text-center">
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
            <script src="../public/js/jquery-1.11.0.min.js"></script>
            <script src="../public/js/bootstrap/bootstrap.min.js"></script>
            <script>
                $(document).ready(function () {
                    $('[data-toggle="tooltip"]').tooltip();
                });
            </script>
        </div>
    </body>
</html>
