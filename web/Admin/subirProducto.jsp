
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <link href="../public/css/fileinput.css" rel="stylesheet" id="theme-stylesheet">
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
                            <li>Registrar</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">
                                    <h1 class="text-primary">Subir Listado de Productos</h1>

                                    <p class="lead">Desde esta sección podrás añadir listados de productos.</p>
                                    <p class="text-muted">Ten en cuenta que para subir el listado de productos deben estar en formato xls (excel) y siguiendo el modelo de la imagen a continuación.</p>

                                    <div class="row">
                                        <div class="col-xs-12">
                                        <form enctype="multipart/form-data" action="cargadorDeProductos.jsp" method="post">
                                            <div class="form-group text-center">
                                                <input name="archivo" id="file-3" type="file" size="35" required>
                                            </div>
                                            <div class="form-group text-center">
                                                <input name="enviar" class="btn btn-primary" type="submit" value="Subir Archivo" />
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
        <script src="../public/js/fileinput/fileinput.js"></script>
        <script src="../public/js/jquery.cookie.js"></script>
        <script src="../public/js/waypoints.min.js"></script>
        <script src="../public/js/bootstrap/bootstrap-hover-dropdown.js"></script>
        <script src="../public/js/owl.carousel.min.js"></script>
        <script src="../public/js/front.js"></script>

        <script>
            $("#file-3").fileinput({
                showCaption: false,
                browseClass: "btn btn-primary btn-lg",
                fileType: "any"
            });

            $("#imagen").fileinput({
                showCaption: false,
                browseClass: "btn btn-primary btn-lg",
                fileType: "any"
            });
        </script>
    </body>
</html>