<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Zona"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Registro Gerentes</title>
    </head>
    <body>
        <%
            SisvencatFacade Fachada = (SisvencatFacade) request.getSession().getAttribute("Fachada");

            if (Fachada == null) {
        %>
        <script>
            alert("Debe Iniciar Sesión");
            location = "../General/login.jsp";
        </script>
        <%
        } else if (Fachada.getAdminN() == null) {
        %>
        <script>
            alert("Acceso solo para el Administrador");
            location = "../../cerrarSesion.jsp";
        </script>
        <%
            }
        %>
        <%
            try {
                List<Zona> zonas = Fachada.getAdminN().getListadoDeZonasPorEstado(1);
        %>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="Profile.sp">Inicio</a></li>
                            <li>Mi Cuenta</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/admin/panelAdmin.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">

                                    <h1 class="text-primary">Gerentes de Zona</h1>

                                    <p class="lead text-muted">Registro</p>

                                    <hr>

                                    <form id="formRegistro" action="registrarGerente" method="post">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="name">Nombre</label>
                                                    <input type="text" class="form-control" id="Nombre" name="Nombre" required>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="name">Apellido</label>
                                                    <input type="text" class="form-control" id="Apellido" name="Apellido" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="name">Cédula</label>
                                                    <input type="text" class="form-control" id="Cedula" name="Cedula" required>
                                                </div>
                                            </div>

                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="name">Teléfono</label>
                                                    <input type="text" class="form-control" id="Telefono" name="Telefono" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="email">Email</label>
                                                    <input type="text" class="form-control" id="Correo" name="Correo" required>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="zona">Departamento</label>
                                                    <select name="Zona_Codigo_z" id="Zona_Codigo_z" class="form-control">
                                                        <%
                                                            for (Zona zona : zonas) {


                                                        %>
                                                        <option value="<%=zona.getCodigo_z() %>"><%=zona.getNombre() %></option>
                                                        <%
                                                    }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="name">Dirección</label>
                                                    <input type="text" class="form-control" name="Direccion" id="Direccion" required/>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="password">Contraseña</label>
                                                    <input type="password" class="form-control" name="contrasena" id="contrasena" required/>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="password">Confirmar Contraseña</label>
                                                    <input type="password" class="form-control" name="contrasena2" id="contrasena2" required/>
                                                </div>
                                            </div>
                                        </div>

                                        <br>
                                        <div class="row">
                                            <div class="col-sm-12 text-center">
                                                <button class="btnCancelar btn btn-default">Cancelar</button>
                                                <button id="btnRegistroGerente" class="btn btn-primary" type="submit"><i class="fa fa-user-md"></i>Registrar Gerente</button>
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
        <script src="../public/js/Administrador.js" type="text/javascript"></script>
    </body>

    <%
       }catch(SQLException e){
    %>
    <%="Error SQL: "+e.getMessage() %>
    <%
            e.printStackTrace();
    }
    %>
</html>
