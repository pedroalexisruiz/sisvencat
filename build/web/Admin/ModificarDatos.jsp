<%-- 
    Document   : ModificarDatos
    Created on : 22-abr-2016, 12:09:29
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Modificar Datos</title>
    </head>
    <body>
        <div class="navbar navbar-default yamm" role="navigation" id="navbar">
            <div class="container">
                <div class="navbar-header">

                    <a class="navbar-brand home" href="index.html" data-animate-hover="bounce">
                        <img src="../public/img/logo.png" alt="Obaju logo" class="hidden-xs">
                        <img src="../public/img/logo-small.png" alt="Obaju logo" class="visible-xs"><span class="sr-only">Sisvencat - Inicio</span>
                    </a>
                    <div class="navbar-buttons">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation">
                            <span class="sr-only">Panel de Navegación</span>
                            <i class="fa fa-align-justify"></i>
                        </button>
                    </div>
                </div>

            </div>
            <!-- /.container -->
        </div>
        
        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Inicio</a>
                            </li>
                            <li>Mi Cuenta</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>
                        <div class="col-md-9">
                            <div id="results" class="box">
                                <h1>Modificar Datos</h1>
                                <p class="lead">Cambia tus datos Personales o tu contraseña en esta sección.</p>
                                <p class="text-muted">Ten en cuenta que el departamento no se podrá cambiar, si te mudarás a otro contacta con tu gerente de zona <a>aquí</a>.</p>

                                <h3>Cambiar Contraseña</h3>

                                <form id="formCambiarContrasena" action="cambiarContrasena" method="post">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="password_old">Contraseña Actual</label>
                                                <input type="password" class="form-control" name="contrasena" required>
                                                <input type="hidden" class="form-control" name="Cedula" value="Cedula">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="password_1">Nueva Contraseña</label>
                                                <input type="password" class="form-control" id="contrasenamod" name="contrasenamod" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="password_2">Repite la Nueva Contraseña</label>
                                                <input type="password" class="form-control" id="contrasenamod2" name="contrasenamod2" required>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.row -->

                                    <div class="col-sm-12 text-center">
                                        <button name="btncambiarContrasena" type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Guardar Nueva Contraseña</button>
                                    </div>
                                </form>

                                <hr>
                                <form id="formActualizarDatos" action="update" method="post">
                                    <h3>Datos Personales</h3>

                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="firstname">Nombres</label>
                                                <input type="text" class="form-control" name="Nombre" value="Nombre">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="lastname">Apellidos</label>
                                                <input type="text" class="form-control" name="Apellido" value="Apellido">
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.row -->

                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="state">Cedula</label>
                                                <input type="text" class="form-control" name="Cedulamod" value="Cedula">
                                                <input type="hidden" class="form-control" name="Cedula" value=Cedula">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="street">Dirección</label>
                                                <input type="text" class="form-control" name="Direccion" value="Direccion">
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.row -->

                                    <div class="row">

                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="phone">Teléfono</label>
                                                <input type="text" class="form-control" name="Telefono" value="Telefono">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="email">Correo</label>
                                                <input type="email" class="form-control" name="Correo" value="Correo">
                                            </div>
                                        </div>
                                        <div class="col-sm-12 text-center">
                                            <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Guardar Cambios</button>

                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                                            <!-- /.container -->
                                            </div>
                                            <!-- /#content -->

                                            <jsp:include page="../public/includes/footer.jsp" />
                                            </div>
                                            <!-- /#all -->
                                            </div>

                                            <script src="../public/js/jquery-1.11.0.min.js"></script>
                                            <script src="../public/js/fileinput/fileinput.js"></script>
                                            <script src="../public/js/bootstrap/bootstrap.min.js"></script>
                                            <script src="../public/js/jquery.cookie.js"></script>
                                            <script src="../public/js/waypoints.min.js"></script>
                                            <script src="../public/js/modernizr.js"></script>
                                            <script src="../public/js/bootstrap/bootstrap-hover-dropdown.js"></script>
                                            <script src="../public/js/owl.carousel.min.js"></script>
                                            <script src="../public/js/front.js"></script>
    </body>
</html>
