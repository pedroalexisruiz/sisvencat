
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <link href="../public/css/fileinput.css" rel="stylesheet" id="theme-stylesheet">
        <title>Admin - Premios</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Premios</a>
                            </li>
                            <li>Registrar</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">
                                    <h1 class="text-primary">Registrar Premio</h1>

                                    <p class="lead">Desde esta sección podrás añadir premios.</p>
                                    <p class="text-muted">Si solo deseas aumentar la cantidad disponible de un premio debes ir a modificar, no volver a agregarlo.</p>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <form>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div clas="form.group">
                                                            <label for="Nombre">Nombre</label>
                                                            <input class="form-control" type="text" name="Nombre" id="Nombre"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div clas="form.group">
                                                            <label for="Descripcion">Descripcion</label>
                                                            <input class="form-control" type="text" name="Descripcion" id="Descripcion"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div clas="form.group">
                                                            <label for="Punto_requerido">Acumulado Requerido</label>
                                                            <input class="form-control" type="text" name="Punto_requerido" id="Punto_requerido"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div clas="form.group">
                                                            <label for="CantDisponible">Cantidad Disponible</label>
                                                            <input class="form-control" type="text" name="CantDisponible" id="CantDisponible"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-sm-12 text-center">
                                                        <input id="btnRegistrarPremio" class="btn btn-primary" type="submit" value="Registrar premio" />
                                                    </div>
                                                </div>
                                            </form>
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
        <script src="../public/js/bootstrap/bootstrap-hover-dropdown.js"></script>
        <script src="../public/js/Premio.js" type="text/javascript"></script>

    </body>
</html>