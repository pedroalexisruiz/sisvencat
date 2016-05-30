
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <%
            SisvencatFacade fachada = (SisvencatFacade) request.getSession().getAttribute("Fachada");

            if (!fachada.existeNegocioGeneral()) {
                response.sendRedirect("../cerrarSesion.jsp");
        %>

        <%
        } else {
        %>
        <title>Sisvencat</title>

        <jsp:include page="../public/includes/importarlibrerias.jsp" />
    </head>

    <body>

        <!-- *** TOPBAR ***
     _________________________________________________________ -->

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
        <!-- /#navbar -->

        <!-- *** NAVBAR END *** -->

        <div id="all">

            <div id="content">

                <div class="container">
                    <div class="col-md-12">
                        <div id="main-slider">
                            <div class="item">
                                <img src="../public/img/main-slider1.jpg" alt="" class="img-responsive">
                            </div>
                            <div class="item">
                                <img class="img-responsive" src="../public/img/main-slider2.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive" src="../public/img/main-slider3.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive" src="../public/img/main-slider4.jpg" alt="">
                            </div>
                        </div>
                        <!-- /#main-slider -->
                    </div>
                </div>

                <!-- *** ADVANTAGES HOMEPAGE ***
     _________________________________________________________ -->
                <div id="advantages">

                    <div class="container">
                        <div class="same-height-row">
                            <div class="col-sm-4">
                                <div class="box same-height clickable">
                                    <div class="icon"><i class="fa fa-heart"></i>
                                    </div>

                                    <h3><a href="#">Amamos nuestros Clientes</a></h3>
                                    <p>Somos conocidos por proporcionar el mejor servicio posible siempre</p>
                                </div>
                            </div>

                            <div class="col-sm-4">
                                <div class="box same-height clickable">
                                    <div class="icon"><i class="fa fa-tags"></i>
                                    </div>

                                    <h3><a href="#">Mejores Precios</a></h3>
                                    <p>Las mejores prendas de vestir para dama, caballeros y niños con los mejores precios.</p>
                                </div>
                            </div>

                            <div class="col-sm-4">
                                <div class="box same-height clickable">
                                    <div class="icon"><i class="fa fa-thumbs-up"></i>
                                    </div>

                                    <h3><a href="#">100% Satisfacción garantizada</a></h3>
                                    <p>Recompensamos tu labor como vendedor con premios increíbles de nuestro catálogo.</p>
                                </div>
                            </div>
                        </div>
                        <!-- /.row -->

                    </div>
                    <!-- /.container -->

                </div>
                <!-- /#advantages -->

                <!-- *** ADVANTAGES END *** -->

                <!-- *** HOT PRODUCT SLIDESHOW ***
     _________________________________________________________ -->
                <div id="hot">

                    <div class="box">
                        <div class="container">
                            <div class="col-md-12">
                                <h2>Lo más visto esta semana</h2>
                            </div>
                        </div>
                    </div>

                    <div class="container">
                        <div class="product-slider">
                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="../public/img/product1.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="../public/img/product1_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="../public/img/product1.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Abrigo de Pieles The Dick of Tiger</a></h3>
                                        <p class="price">$150.000</p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="../public/img/product2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="../public/img/product2_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="../public/img/product2.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Blusa Blanca Armani</a></h3>
                                        <p class="price"><del>$70.000</del> $143.000</p>
                                    </div>
                                    <!-- /.text -->

                                    <div class="ribbon sale">
                                        <div class="theribbon">VENTA</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->

                                    <div class="ribbon new">
                                        <div class="theribbon">NUEVO</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->

                                    <div class="ribbon gift">
                                        <div class="theribbon">PREMIO</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="../public/img/product3.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="../public/img/product3_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="../public/img/product3.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Blusa Negra Versace</a></h3>
                                        <p class="price">$143.000</p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="../public/img/product3.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="../public/img/product3_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="../public/img/product3.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Blusa Negra Versace</a></h3>
                                        <p class="price">$143.000</p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="../public/img/product2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="../public/img/product2_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="../public/img/product2.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Blusa Blanca Armani</a></h3>
                                        <p class="price">$143.000</p>
                                    </div>
                                    <!-- /.text -->

                                    <div class="ribbon new">
                                        <div class="theribbon">NUEVO</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="../public/img/product1.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="../public/img/product1_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="../public/img/product1.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Fur coat</a></h3>
                                        <p class="price">$143.00</p>
                                    </div>
                                    <!-- /.text -->

                                    <div class="ribbon gift">
                                        <div class="theribbon">GIFT</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->

                                </div>
                                <!-- /.product -->
                            </div>
                            <!-- /.col-md-4 -->

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="../public/img/product2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="../public/imgpremiosyproductos/miniatura/12744133_10208947874082376_4092073630596462574_n.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="../public/img/product2.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">White Blouse Armani</a></h3>
                                        <p class="price"><del>$280</del> $143.00</p>
                                    </div>
                                    <!-- /.text -->

                                    <div class="ribbon sale">
                                        <div class="theribbon">SALE</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->

                                    <div class="ribbon new">
                                        <div class="theribbon">NEW</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->

                                    <div class="ribbon gift">
                                        <div class="theribbon">GIFT</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="../public/img/product3.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="../public/img/product3_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="../public/img/product3.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Black Blouse Versace</a></h3>
                                        <p class="price">$143.00</p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                        </div>
                        <!-- /.product-slider -->
                    </div>
                    <!-- /.container -->

                </div>
                <!-- /#hot -->

                <!-- *** HOT END *** -->

                <!-- *** GET INSPIRED ***
     _________________________________________________________ -->
                <div class="container" data-animate="fadeInUpBig">
                    <div class="col-md-12">
                        <div class="box slideshow">
                            <h3>Inspírate</h3>
                            <p class="lead">Obtén la inspiración de nuestros diseñadores de clase mundial</p>
                            <div id="get-inspired" class="owl-carousel owl-theme">
                                <div class="item">
                                    <a href="#">
                                        <img src="../public/img/getinspired1.jpg" alt="Get inspired" class="img-responsive">
                                    </a>
                                </div>
                                <div class="item">
                                    <a href="#">
                                        <img src="../public/img/getinspired2.jpg" alt="Get inspired" class="img-responsive">
                                    </a>
                                </div>
                                <div class="item">
                                    <a href="#">
                                        <img src="../public/img/getinspired3.jpg" alt="Get inspired" class="img-responsive">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- *** GET INSPIRED END *** -->

                <!-- *** BLOG HOMEPAGE ***
     _________________________________________________________ -->

                <div class="box text-center" data-animate="fadeInUp">
                    <div class="container">
                        <div class="col-md-12">
                            <h3 class="text-uppercase">Nuestro blog</h3>

                            <p class="lead">Que hay de nuevo en el mundo de la moda? <a href="blog.html">Checkea nuestro blog!</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="container">

                    <div class="col-md-12" data-animate="fadeInUp">

                        <div id="blog-homepage" class="row">
                            <div class="col-sm-6">
                                <div class="post">
                                    <h4><a href="post.html">Moda Ahora</a></h4>
                                    <p class="author-category">De <a href="#">John Slim</a> en <a href="">Fashion y Estilo</a>
                                    </p>
                                    <hr>
                                    <p class="intro">"Yo amo la feminidad sin estridencias, con un estilo elegante que se fija en los detalles importantes".</p>

                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="post">
                                    <h4><a href="post.html">Frase del Día</a></h4>
                                    <p class="author-category">De <a href="#">Marlen Dietris</a> 
                                    </p>
                                    <hr>
                                    <p class="intro">"Nos reímos de la moda de ayer, pero nos emocionamos con la de antes de ayer, cuando está en vía de convertirse en la de mañana".</p>

                                </div>

                            </div>

                        </div>
                        <!-- /#blog-homepage -->
                    </div>
                </div>
                <!-- /.container -->

                <!-- *** BLOG HOMEPAGE END *** -->

            </div>
            <!-- /#content -->

            <jsp:include page="../public/includes/footer.jsp" />

            <!-- /#content -->
        </div>
        <!-- /#all -->
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
    </body>
    <%
        }
    %>
</html>