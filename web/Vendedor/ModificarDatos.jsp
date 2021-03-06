
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor"%>
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            SisvencatFacade Fachada = (SisvencatFacade) request.getSession().getAttribute("Fachada");

            if (Fachada == null) {
        %>
        <script>
            alert("Debe Iniciar Sesión");
            location = "../General/login.jsp";
        </script>
        <%
        } else if (!Fachada.existeNegocioVendedor()) {
        %>
        <script>
            alert("Acceso solo para Vendedores");
            location = "../cerrarSesion.jsp";
        </script>
        <%
            }
        %>
        <%
            try {

                Vendedor vendedor = Fachada.getVendedorLogeado();
        %>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Modificar Datos</title>
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
                            <li>Mi Cuenta</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/vendedor/panelVendedor.jsp" />
                    <div>
                        <div class="col-md-9">
                            <div id="results" class="box">
                                <h1 class="text-center text-primary">Modificar Datos</h1>
                                <p class="lead">Cambia tus datos Personales o tu contraseña en esta sección.</p>
                                <p class="text-muted">Ten en cuenta que el departamento no se podrá cambiar, si te mudarás a otro contacta con tu gerente de zona <a>aquí</a>.</p>

                                <h3>Cambiar Contraseña</h3>

                                <form id="formCambiarContrasena" action="cambiarContrasena" method="post">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="password_old">Contraseña Actual</label>
                                                <input type="password" class="form-control" id="contrasena" name="contrasena" required>
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
                                        <button name="btnCambiarContrasena" id="btnCambiarContrasena" type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Guardar Nueva Contraseña</button>
                                    </div>
                                </form>

                                <hr>
                                <form id="formActualizarDatos" action="update" method="post">
                                    <h3>Datos Personales</h3>

                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="firstname">Nombres</label>
                                                <input type="text" class="form-control" id="Nombre" name="Nombre" value="<%=vendedor.getNombre() %>">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="lastname">Apellidos</label>
                                                <input type="text" class="form-control" id="Apellido" name="Apellido" value="<%=vendedor.getApellido()%>">
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.row -->

                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="street">Dirección</label>
                                                <input type="text" class="form-control" name="Direccion" id="Direccion" value="<%=vendedor.getDireccion()%>" required />
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="phone">Teléfono</label>
                                                <input type="number" class="form-control" name="Telefono" id="Telefono" value="<%=vendedor.getTelefono()%>" required />
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.row -->

                                    <div class="row">

                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="email">Correo</label>
                                                <input type="email" name="Correo" id="Correo" value="<%=vendedor.getCorreo()%>" class="form-control" required title="Correo No Válido" />
                                            </div>
                                        </div>
                                        <div class="col-sm-12 text-center">
                                            <button id="btnModificarDatos" type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Guardar Cambios</button>
                                        </div>
                                    </div>
                                </form>
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
                                            <script src="../public/js/Vendedor.js" type="text/javascript"></script>
    </body>
    <%                                            } catch (Exception e) {
        e.printStackTrace();
    %>
    <script>
            location = "../General/index.jsp";
    </script>
    <%
        }
    %>
</html>
