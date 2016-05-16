<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Registro Vendedores</title>
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
                            <li>Registro de Vendedores</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/gerente/panelGerente.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">

                                    <h1 class="text-primary">Vendedores</h1>

                                    <p class="lead text-muted">Registro</p>

                                    <hr>

                                    <form id="formRegistro" action="registrarVendedor" method="post">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="name">Nombre</label>
                                                    <input type="text" class="form-control" name="Nombre" required>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="name">Apellido</label>
                                                    <input type="text" class="form-control" name="Apellido" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="name">Cédula</label>
                                                    <input type="text" class="form-control" name="Cedula" required>
                                                </div>
                                            </div>

                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="name">Teléfono</label>
                                                    <input type="text" class="form-control" name="Telefono" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="email">Email</label>
                                                    <input type="text" class="form-control" name="Correo" required>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="zona">Departamento</label>
                                                    <select name="Zona_Codigo_z" class="form-control">
                                                        <option>Norte de Santander</option>
                                                        <option>Quindío</option>
                                                        <option>Cundinamarca</option>
                                                        <option>Antioquia</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="name">Dirección</label>
                                                    <input type="text" class="form-control" name="Direccion" required>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="password">Contraseña</label>
                                                    <input type="password" class="form-control" name="contrasena" id="contrasena" required>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="password">Confirmar Contraseña</label>
                                                    <input type="password" class="form-control" name="contrasena2" id="contrasena2" required>
                                                </div>
                                            </div>
                                        </div>

                                        <br>
                                        <div class="row">
                                            <div class="col-sm-12 text-center">
                                                <button class="btnCancelar btn btn-default">Cancelar</button>
                                                <button name="btnRegistroV" class="btn btn-primary" type="submit"><i class="fa fa-user-md"></i>Registrar Gerente</button>
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
    </body>
</html>
