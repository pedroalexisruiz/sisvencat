
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                            <li><a href="#">Premio</a></li>
                            <li>Detalles</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/vendedor/panelVendedor.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">

                                <div class="row" id="productMain">
                                    <div class="col-sm-6">
                                        <div id="mainImage">
                                            <img src="../public/imgpremiosyproductos/imgnormal/xbox360slim11.jpg" alt="" class="img-responsive">
                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="box">
                                            <h1 class="text-center">Xbox 360 Slim</h1>
                                            <p class="goToDescription"><a href="#details" class="scroll-to">Desplázate hacia abajo para conocer más detalles del premio.</a>
                                            </p>
                                            <p class="price">$1'200.000</p>

                                            <p class="text-center buttons">
                                                <a href="basket.html" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> Solicitar</a> 
                                            </p>


                                        </div>

                                        <div class="row" id="thumbs">
                                            <div class="col-xs-4">
                                                <a href="../public/imgpremiosyproductos/imgnormal/xbox.jpg" class="thumb">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/xbox.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="col-xs-4">
                                                <a href="../public/imgpremiosyproductos/imgnormal/Xbox-360-Slim.jpg" class="thumb">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/Xbox-360-Slim.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="col-xs-4">
                                                <a href="../public/imgpremiosyproductos/imgnormal/xbox360slim11.jpg" class="thumb">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/xbox360slim11.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>

                                </div>


                                <div class="box" id="details">
                                    <p>
                                    <h4>Detales del Premio</h4>
                                    
                                    <p>Lo más importante y novedoso de la nueva Xbox 360 Slim se encuentra en su interior. 
                                        Los principales cambios afectan a su capacidad de almacenamiento: antes 120 GB para Xbox Elite y ahora 250 GB.</p>
                                    <h4>Características</h4>
                                    <ul>
                                        <li>Disco Duro de 4GB</li>
                                        <li>Compatible con Sensor Kinect</li>
                                        <li>Control Inalámbrico</li>
                                        <li>Conecta Hasta 4 Controles ala vez</li>
                                    </ul>
                                    <h4>Accesorios</h4>
                                    <ul>
                                        <li>Consola</li>
                                        <li>Fuente de Poder</li>
                                        <li>Cable de Corriente</li>
                                        <li>Cable de Audio y Video</li>
                                        <li>1 Control original Inalámbrico</li>
                                    </ul>

                                    <blockquote>
                                        <p><em>La nueva Xbox 360 Slim tiene como principal cambio (a la vista) un nuevo diseño mucho más compacto y serio. 
                                        Microsoft ha cambiado el color de Xbox 360 Slim a negro brillante, dejando atrás el color blanco de la Xbox 360 
                                        actual.</em>
                                        </p>
                                    </blockquote>

                                    <hr>
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
