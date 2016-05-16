

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <link href="../public/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
        <title>Admin - Campaña</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Campaña</a>
                            </li>
                            <li>Iniciar</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">
                                    <h1 class="text-primary">Gestión de Campañas</h1>

                                    <h3>Agregar Campaña</h3>

                                    <p class="lead text-muted">Desde esta sección podrás añadir las campañas nuevas.</p>

                                    <form id="registroCampaña" action="crearCampaña" method="post">

                                        <div class="row">
                                            <div class="col-md-4 form-group">
                                                <label for="text">Fecha de Inicio</label>
                                                <input type="text" class="form-control" id="datepicker" name="Fecha_inicio" required>
                                            </div>
                                            <div class="col-md-4 form-group">
                                                <label for="text">Fecha de Finalización</label>
                                                <input type="text" class="form-control" id="datepicker" name="Fecha_fin" required>
                                            </div>
                                            <div class="col-md-4 form-group">
                                                <label for="text">Tema</label>
                                                <input type="text" class="form-control" name="Tema" required>
                                            </div>
                                        </div>
                                        <div class="row">

                                            <div class="col-sm-12 form-group" align="center">
                                                <button class="btnCancelar btn btn-default">Cancelar</button>
                                                <input name="enviar" class="btn btn-primary" type="submit" value="Registrar Campaña" />
                                            </div>
                                        </div>

                                    </form>
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
        <script src="../public/js/bootstrap/bootstrap-datepicker.js" type="text/javascript"></script>
        <script src="../public/js/bootstrap/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
        <script>

            var f = new Date();
            $('#registroCampaña #datepicker').datepicker({
                format: "yyyy-mm-dd",
                startDate: "" + f.getFullYear(),
                language: "es"
            });
        </script>
    </body>
</html>