
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria"%>
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>

        <%
            SisvencatFacade fachada = (SisvencatFacade) request.getSession().getAttribute("Fachada");

            if (!fachada.existeNegocioGeneral()) {
                response.sendRedirect("../cerrarSesion.jsp");
        %>

        <%
        } else {
            int cat = (request.getParameter("cat") != null) ? Integer.parseInt(request.getParameter("cat")) : 1;
            int tipo = (request.getParameter("tipo") != null) ? Integer.parseInt(request.getParameter("tipo")) : 1;
            Categoria categoria = fachada.getCategoria(cat);
        %>
        <title>Sisvencat</title>

        <jsp:include page="../public/includes/importarlibrerias.jsp" />
    </head>
    <body onload="listarPorCategoria()">
        <jsp:include page="../public/includes/header.jsp" />
        <!-- *** TOP BAR END *** -->

        <!-- *** NAVBAR ***
     _________________________________________________________ -->

        <div class="navbar navbar-default yamm" role="navigation" id="navbar">
            <div class="container">
                <!--/.navbar-header -->

                <jsp:include page="../public/includes/menupublico.jsp" />
                <!--/.nav-collapse -->

                <!--/.nav-collapse -->

            </div>
            <!-- /.container -->
        </div>

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="index.jsp">Inicio</a></li>
                            <li><%=categoria.getNombre() %></li>
                        </ul>

                        <div class="box">
                            <h1><%=categoria.getNombre() %></h1>
                            <p>En nuestra sección para <%=categoria.getNombre() %> ofrecemos la selección de los mejores productos que hemos encontrado y seleccionado cuidadosamente a nivel mundial.</p>
                        </div>

                        <div id="results">
                        </div>

                        <!-- /.col-md-9 -->

                    </div>
                    <!-- /.container -->
                </div>
                <!-- /#content -->


                <!-- *** FOOTER ***
         _________________________________________________________ -->
                <jsp:include page="../public/includes/footer.jsp" />
                <!-- /#footer -->

                <!-- *** FOOTER END *** -->
                <!-- *** COPYRIGHT END *** -->
                <!-- *** SCRIPTS TO INCLUDE ***
         _________________________________________________________ -->
                <script src="../public/js/jquery-1.11.0.min.js"></script>
                <script src="../public/js/bootstrap/bootstrap.min.js"></script>
                <script src="../public/js/jquery.cookie.js"></script>
                <script src="../public/js/waypoints.min.js"></script>
                <script src="..//public/js/modernizr.js"></script>
                <script src="../public/js/bootstrap/bootstrap-hover-dropdown.js"></script>
                <script src="../public/js/owl.carousel.min.js"></script>
                <script src="../public/js/front.js"></script>
                <script src="../public/js/Producto.js" type="text/javascript"></script>
            </div>
    </body>
    <%        }
    %>
</html>
