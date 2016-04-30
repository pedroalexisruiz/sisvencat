
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sisvencat</title>

        <jsp:include page="../public/includes/importarlibrerias.jsp" />
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
                            <li><a href="<?php echo URL; ?>">Inicio</a>
                            </li>
                            <li>Mujeres</li>
                        </ul>

                        <div class="box">
                            <h1>Mujeres</h1>
                            <p>En nuestra sección para Mujeres ofrecemos la selección de los mejores productos que hemos encontrado y seleccionado cuidadosamente a nivel mundial.</p>
                        </div>

                        <div class="box info-bar">
                            <div class="row">
                                <div class="col-sm-12 col-md-4 products-showing">
                                    Mostrando <strong>8</strong> de <strong>24</strong> productos
                                </div>

                                <div class="col-sm-12 col-md-8  products-number-sort">
                                    <div class="row">
                                        <form class="form-inline">
                                            <div class="col-md-6 col-sm-6">
                                                <div class="products-number">
                                                    <strong>Mostrar</strong>  <a href="#" class="btn btn-default btn-sm btn-primary">8</a>  <a href="#" class="btn btn-default btn-sm">12</a>  <a href="#" class="btn btn-default btn-sm">Todos</a> productos
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-sm-6">
                                                <div class="products-sort-by">
                                                    <strong>Ordenar Por</strong>
                                                    <select name="sort-by" class="form-control">
                                                        <option>Precio</option>
                                                        <option>Nombre</option>
                                                        <option>Más Vendido</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row products">
                            <div class="col-md-3 col-sm-4">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/chaquetanaranja.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/chaquetanaranja.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="#" class="invisible">
                                        <img src="../public/imgpremiosyproductos/imgnormal/chaquetanaranja.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="#">Chaqueta Huan Zu Naranja</a></h3>
                                        <p class="price">$80.000</p>
                                        <p class="buttons">
                                            <a href="#" class="btn btn-primary">Ver Detalles</a>
                                        </p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="col-md-3 col-sm-4">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="#" class="invisible">
                                        <img src="../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="#">Chaqueta Huan Zu Naranja</a></h3>
                                        <p class="price">$80.000</p>
                                        <p class="buttons">
                                            <a href="#" class="btn btn-primary">Ver Detalles</a>
                                        </p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="col-md-3 col-sm-4">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/Vestido_bata.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/Vestido_bata.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="#" class="invisible">
                                        <img src="../public/imgpremiosyproductos/imgnormal/Vestido_bata.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="#">Chaqueta Huan Zu Naranja</a></h3>
                                        <p class="price">$80.000</p>
                                        <p class="buttons">
                                            <a href="#" class="btn btn-primary">Ver Detalles</a>
                                        </p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="col-md-3 col-sm-4">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/abrigodecortocircuito.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/abrigodecortocircuito.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="#" class="invisible">
                                        <img src="../public/imgpremiosyproductos/imgnormal/abrigodecortocircuito.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="#">Chaqueta Huan Zu Naranja</a></h3>
                                        <p class="price">$80.000</p>
                                        <p class="buttons">
                                            <a href="#" class="btn btn-primary">Ver Detalles</a>
                                        </p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>
                        </div>

                        <div class="row products">
                            <div class="col-md-3 col-sm-4">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/chaqueta_Pure.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/chaqueta_Pure.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="#" class="invisible">
                                        <img src="../public/imgpremiosyproductos/imgnormal/chaqueta_Pure.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="#">Chaqueta Huan Zu Naranja</a></h3>
                                        <p class="price">$80.000</p>
                                        <p class="buttons">
                                            <a href="#" class="btn btn-primary">Ver Detalles</a>
                                        </p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="col-md-3 col-sm-4">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/chaquetanaranja.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/chaquetanaranja.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="#" class="invisible">
                                        <img src="../public/imgpremiosyproductos/imgnormal/chaquetanaranja.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="#">Chaqueta Huan Zu Naranja</a></h3>
                                        <p class="price">$80.000</p>
                                        <p class="buttons">
                                            <a href="#" class="btn btn-primary">Ver Detalles</a>
                                        </p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>
                            
                            <div class="col-md-3 col-sm-4">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/chaqueta_Pure.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/chaqueta_Pure.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="#" class="invisible">
                                        <img src="../public/imgpremiosyproductos/imgnormal/chaqueta_Pure.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="#">Chaqueta Huan Zu Naranja</a></h3>
                                        <p class="price">$80.000</p>
                                        <p class="buttons">
                                            <a href="#" class="btn btn-primary">Ver Detalles</a>
                                        </p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="col-md-3 col-sm-4">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/chaquetanaranja.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="#">
                                                    <img src="../public/imgpremiosyproductos/imgnormal/chaquetanaranja.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="#" class="invisible">
                                        <img src="../public/imgpremiosyproductos/imgnormal/chaquetanaranja.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="#">Chaqueta Huan Zu Naranja</a></h3>
                                        <p class="price">$80.000</p>
                                        <p class="buttons">
                                            <a href="#" class="btn btn-primary">Ver Detalles</a>
                                        </p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                        </div>

                        <!-- /.products -->

                        <div class="pages">

                            <ul class="pagination">
                                <li><a href="#">&laquo;</a>
                                </li>
                                <li class="active"><a href="#">1</a>
                                </li>
                                <li><a href="#">2</a>
                                </li>
                                <li><a href="#">3</a>
                                </li>
                                <li><a href="#">4</a>
                                </li>
                                <li><a href="#">5</a>
                                </li>
                                <li><a href="#">&raquo;</a>
                                </li>
                            </ul>
                        </div>


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
        </div>
    </body>
</html>
