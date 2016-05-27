
<%@page import="java.text.NumberFormat"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

        <%
            if (!Fachada.existeNegocioVendedor()) {
        %>
        <script>
            alert("Acceso solo para el Administrador");
            location = "../../cerrarSesion.jsp";
        </script>
        <%
        } else {
            Vendedor vendedor = Fachada.getVendedorLogeado();
            NumberFormat formateador = NumberFormat.getInstance();
        %>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Profile - Admin</title>
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

                    <div class="col-md-9">
                        <div id="results" class="box">
                            <h1 class="text-center text-primary">Bienvenido</h1>
                            <br>

                            <table class="table borderless">
                                <tbody>
                                    <tr>
                                        <td>
                                            <h4 class="text-primary">Nombre</h4>
                                        </td>
                                        <td>
                                            <h5><%=vendedor.getNombre()%></h5>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <h4 class="text-primary">Apellidos</h4>
                                        </td>
                                        <td>
                                            <h5><%=vendedor.getApellido()%></h5>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <h4 class="text-primary">Cédula</h4>
                                        </td>
                                        <td>
                                            <h5><%=formateador.format(Long.parseLong(vendedor.getCedula()))%></h5>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <h4 class="text-primary">Correo</h4>
                                        </td>
                                        <td>
                                            <h5><%=vendedor.getCorreo()%></h5>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <h4 class="text-primary">Dirección</h4>
                                        </td>
                                        <td>
                                            <h5><%=vendedor.getDireccion()%></h5>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <h4 class="text-primary">Teléfono</h4>
                                        </td>
                                        <td>
                                            <h5><%=vendedor.getTelefono()%></h5>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <h4 class="text-primary">Puntaje Acumulado</h4>
                                        </td>
                                        <td>
                                            <%
                                                formateador = NumberFormat.getCurrencyInstance();
                                            %>
                                            <h5><%=formateador.format(vendedor.getPuntajeAcumulado())%></h5>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <h4 class="text-primary">Premio</h4>
                                        </td>
                                        <td>
                                            <%
                                                if (vendedor.getPremio() == null) {
                                            %>
                                            No posees solicitudes de premio en esta campaña.
                                            <%
                                            } else {
                                            %>
                                            <a href="detallePremio.jsp?id=<%=vendedor.getPremio().getCodigo_premio()%>"><%=vendedor.getPremio().getNombre()%></a>
                                            <%
                                                }
                                            %>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
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
    <%                                                }
    %>
</html>
