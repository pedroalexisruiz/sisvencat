

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />
        <title>Producto - Detalles</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Producto</a></li>
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
                                            <img src="../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg" alt="" class="img-responsive">
                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="box">
                                            <h1 class="text-center">Blusa Vestido Leonisa</h1>
                                            <p class="goToDescription"><a href="#details" class="scroll-to">Desplázate hacia abajo para conocer más detalles del premio.</a>
                                            </p>
                                            <p class="price">$80.000</p>

                                            <p class="text-center buttons">
                                                <a href="basket.html" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Añadir Al Carrito</a> 
                                            </p>


                                        </div>

                                        <div class="row" id="thumbs">
                                            <div class="col-xs-4">
                                                <a href="../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg" class="thumb">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="col-xs-4">
                                                <a href="../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg" class="thumb">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="col-xs-4">
                                                <a href="../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg" class="thumb">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>

                                </div>


                                <div class="box" id="details">
                                    <p>
                                    <h4>Detalles del Producto</h4>
                                    
                                    <p>Hermosa Blusa-Vestido color negro.</p>
                                    <h4>Material y Cuidado</h4>
                                    <ul>
                                        <li>Poliéster</li>
                                        <li>Lavar a Máquina</li>
                                    </ul>
                                    <h4>Tallas y medidas</h4>
                                    <ul>
                                        <li>Corte clásico</li>
                                        <li>El modelo (altura de 5'8 "y el pecho 33") lleva una talla S</li>
                                    </ul>

                                    <blockquote>
                                        <p><em>Define el estilo de esta temporada con una nueva gama 
                                                de Armani con sus Blusas-Vestidos de moda, hechos a mano
                                                con detalles intrincados. Crean una apariencia elegante
                                                combinándolos con vaqueros ajustados.</em>
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
