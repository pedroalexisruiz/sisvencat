<%-- 
    Document   : verPremios
    Created on : 29-abr-2016, 12:03:58
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../public/includes/importarlibrerias.jsp" />


        <!-- Add fancyBox -->
        <link rel="stylesheet" href="../public/js/fancybox/source/jquery.fancybox.css?v=2.1.5" type="text/css" media="screen" />
        <!-- Optionally add helpers - button, thumbnail and/or media -->
        <link rel="stylesheet" href="../public/js/fancybox/source/helpers/jquery.fancybox-buttons.css?v=1.0.5" type="text/css" media="screen" />
        <link rel="stylesheet" href="../public/js/fancybox/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7" type="text/css" media="screen" />
        <title>Ver Premios</title>
    </head>
    <body>
        <jsp:include page="../public/includes/admin/header.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="Profile.jsp">Inicio</a>
                            </li>
                            <li>Premios</li>
                        </ul>

                    </div>

                    <jsp:include page="../public/includes/vendedor/panelVendedor.jsp" />
                    <div>

                        <div>
                            <div class="col-md-9">
                                <div id="results" class="box">
                                    <h1 class="text-primary text-center">Premios</h1>
                                    <p class="lead text-center">¡Te premiamos por tus ventas!</p>

                                    <div class="row">
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="item">
                                                <div class="product">
                                                    <div class="flip-container">
                                                        <div class="flipper">
                                                            <div class="front">
                                                                <a href="detail.html">
                                                                    <img src="../public/imgpremiosyproductos/imgnormal/Xbox-360-Slim.jpg" alt="" class="img-responsive">
                                                                </a>
                                                            </div>
                                                            <div class="back">
                                                                <a href="detail.html">
                                                                    <img src="../public/imgpremiosyproductos/imgnormal/xbox360slim11.jpg" alt="" class="img-responsive">
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a href="detail.html" class="invisible">
                                                        <img src="../public/imgpremiosyproductos/imgnormal/Xbox-360-Slim.jpg" alt="" class="img-responsive">
                                                    </a>
                                                    <div class="text">
                                                        <h3><a href="detail.html">Xbox 360 Slim</a></h3>
                                                        <p class="price">$800.000</p>
                                                    </div>
                                                    <!-- /.text -->
                                                </div>
                                                <!-- /.product -->
                                            </div>
                                        </div>

                                        <div class="col-xs-12 col-sm-4">
                                            <div class="item">
                                                <div class="product">
                                                    <div class="flip-container">
                                                        <div class="flipper">
                                                            <div class="front">
                                                                <a href="detail.html" class="fancybox-thumb" caption="Premio">
                                                                    <img src="../public/imgpremiosyproductos/imgnormal/televisor.jpg" alt="" class="img-responsive">
                                                                </a>
                                                            </div>
                                                            <div class="back">
                                                                <a href="detail.html" class="fancybox-thumb" caption="Premio">
                                                                    <img src="../public/imgpremiosyproductos/imgnormal/LG-LED-TV.jpg" alt="" class="img-responsive">
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a href="detail.html" class="invisible">
                                                        <img src="../public/imgpremiosyproductos/imgnormal/televisor.jpg" alt="" class="img-responsive">
                                                    </a>
                                                    <div class="text">
                                                        <h3><a href="detail.html">Xbox 360 Slim</a></h3>
                                                        <p class="price">$800.000</p>
                                                    </div>
                                                    <!-- /.text -->
                                                </div>
                                                <!-- /.product -->
                                            </div>
                                        </div>
                                        
                                        <div class="col-xs-12 col-sm-4">
                                            <div class="item">
                                                <div class="product">
                                                    <div class="flip-container">
                                                        <div class="flipper">
                                                            <div class="front">
                                                                <a href="detail.html">
                                                                    <img src="../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" alt="" class="img-responsive">
                                                                </a>
                                                            </div>
                                                            <div class="back">
                                                                <a href="detail.html">
                                                                    <img src="../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" alt="" class="img-responsive">
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a href="detail.html" class="invisible">
                                                        <img src="../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" alt="" class="img-responsive">
                                                    </a>
                                                    <div class="text">
                                                        <h3><a href="detail.html">Xbox 360 Slim</a></h3>
                                                        <p class="price">$800.000</p>
                                                    </div>
                                                    <!-- /.text -->
                                                </div>
                                                <!-- /.product -->
                                            </div>
                                        </div>
                                        
                                    </div>

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
        <script type="text/javascript" src="../public/js/fancybox/lib/jquery.mousewheel-3.0.6.pack.js"></script>
        <script type="text/javascript" src="../public/js/fancybox/source/jquery.fancybox.pack.js?v=2.1.5"></script>
        <script type="text/javascript" src="../public/js/fancybox/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>
        <script type="text/javascript" src="../public/js/fancybox/source/helpers/jquery.fancybox-media.js?v=1.0.6"></script>
        <script type="text/javascript" src="../public/js/fancybox/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>

        <script>

            $(document).ready(function () {
                $(".fancybox").fancybox({
                    openEffect: 'elastic',
                    closeEffect: 'elastic',
                    prevEffect: 'fade',
                    nextEffect: 'fade',
                    helpers: {
                        thumbs: {
                            width: 50,
                            height: 50
                        }
                    },
                    beforeLoad: function () {
                        this.title = $(this.element).attr('caption');
                    }
                });
            });
        </script>
    </body>
</html>
