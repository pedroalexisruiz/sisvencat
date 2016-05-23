
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="en">

    <head>

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

            <div class="container">

                <div class="col-md-12">

                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li>Registro / Acceder</li>
                    </ul>

                </div>

                <div class="col-md-6 col-md-offset-3">
                    <div class="box">
                        <h1>Acceder</h1>

                        <p class="lead">Ya perteneces a nuestra organización?</p>
                        <p class="text-muted">Por favor accede a tu panel de control.</p>

                        <hr>

                        <form action="<%=request.getContextPath() %>/LoginServlet" method="post">
                            <div class="form-group">
                                <label for="email">Cédula</label>
                                <input type="text" class="form-control" name="cedula" id="cedula">
                            </div>
                            <div class="form-group">
                                <label for="password">Contraseña</label>
                                <input type="password" class="form-control" name="password" id="password">
                            </div>
                            <div class="text-center">
                                <button id="btnAcceder" type="submit" class="btn btn-primary"><i class="fa fa-sign-in"></i> Acceder</button>
                            </div>
                        </form>
                    </div>
                </div>
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
        <script src="../public/js/Personas.js" type="text/javascript"></script>
    </body>
</html>