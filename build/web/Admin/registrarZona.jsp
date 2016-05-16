

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Admin - Registrar Zona</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Zona</a></li>
                            <li>Registro</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">
                                    <h1 class="text-primary">Gestión de Zonas</h1>


                                    <h3>Agregar Zona</h3>

                                    <p class="lead">Desde esta sección podrás añadir las zonas nuevas.</p>
                                    <p class="text-muted">Ten en cuenta que para poder asignar un Gerente de Zona o Vendedor debe primero agregarse su zona.</p>



                                    <form action="registrarZona" method="post">
                                        <div class="row">
                                            <div class="col-xs-12 col-sm-6 col-sm-offset-3">
                                                <input class="form-control" type="text" name="Nombrezona" placeholder="Nombre de la Zona" required/>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="form-group text-center">
                                                <input name="enviar" class="btn btn-primary" type="submit" value="Registrar Zona" />
                                                <button class="btnCancelar btn btn-default">Cancelar</button>
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
        <script src="../public/js/jquery.cookie.js"></script>
        <script src="../public/js/waypoints.min.js"></script>
        <script src="../public/js/bootstrap/bootstrap-hover-dropdown.js"></script>
        <script src="../public/js/owl.carousel.min.js"></script>
        <script src="../public/js/front.js"></script>
    </body>
</html>
