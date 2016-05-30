<%-- 
    Document   : Contacto
    Created on : 30/05/2016, 04:14:24 PM
    Author     : Administrator
--%>

<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            SisvencatFacade fachada = (SisvencatFacade) request.getSession().getAttribute("Fachada");

            if (!fachada.existeNegocioGeneral()) {
                response.sendRedirect("../cerrarSesion.jsp");
        %>

        <%
        } else {
        %>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>JSP Page</title>
    </head>
    <body>
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
                            <li>Contacto</li>
                        </ul>

                    </div>

                    <div class="col-md-12">
                        <div id="results" class="box">
                            <h1 class="text-primary">Contacto</h1>

                            <p class="lead">¿Quieres saber acerca de algo ? ¿Tiene algún tipo de problema con nuestros productos ?</p>
                            <p>Por favor no dude en contactar con nosotros , nuestro centro de atención al cliente está trabajando para usted las 24 horas del día.</p>

                            <hr>

                            <div class="row">
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-map-marker"></i> Dirección</h3>
                                    <p><strong>Sisvencat.</strong>
                                        <br>Avenida Gran Colombia # 12E - 96
                                        <br>Barrio Colsag
                                        <br>San José de Cúcuta
                                        <br>Norte de Santander
                                        <br>
                                        <strong>Colombia</strong>
                                    </p>
                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-phone"></i> Call Center</h3>
                                    <p class="text-muted">Este número es gratuito si llamas desde Colombia de lo contrario le recomendamos que utilice el formulario electrónico de comunicación.</p>
                                    <p><strong>01 8000 555 1234</strong>
                                    </p>
                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-envelope"></i> Soporte Electrónico</h3>
                                    <p class="text-muted">Por favor, siéntase libre de escribirnos un correo electrónico.</p>
                                    <strong><a href="mailto:">CorporacionSisvencat@gmail.com</a></strong>

                                </div>
                                <!-- /.col-sm-4 -->
                            </div>
                            <!-- /.row -->

                            <hr>

                            <div id="map">

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
        <script src="../public/js/bootstrap/bootstrap.min.js"></script>
        <script src="../public/js/bootstrap/bootstrap-hover-dropdown.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=false"></script>

        <script>
            function initialize() {
                var mapOptions = {
                    zoom: 15,
                    center: new google.maps.LatLng(7.898862,-72.4874143),
                    mapTypeId: google.maps.MapTypeId.ROAD,
                    scrollwheel: false
                }
                var map = new google.maps.Map(document.getElementById('map'),
                        mapOptions);

                var myLatLng = new google.maps.LatLng(7.898862,-72.4874143);
                var marker = new google.maps.Marker({
                    position: myLatLng,
                    map: map
                });
            }

            google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </body>
    <%
        }
    %>
</html>
