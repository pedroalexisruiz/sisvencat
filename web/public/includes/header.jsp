<div id="top">
            <div class="container">
                <div class="col-md-6 offer" data-animate="fadeInDown">
                    <a href="#" class="btn btn-info btn-sm" data-animate-hover="shake">Oferta del D�a</a>  <a href="#">Obt�n un 35% m�s de puntos en pedidos superiores a $300.00</a>
                </div>
                <div class="col-md-6" data-animate="fadeInDown">
                    <ul class="menu">
                        <li><a href="#" data-toggle="modal" data-target="#login-modal">Acceder</a>
                        </li>
                        <li><a href="javaScript:openVentanaRegistro();">Registro</a>
                        </li>
                        <li><a href="contact.html">Cont�ctanos</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
                <div class="modal-dialog modal-sm">

                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="Login">Acceder</h4>
                        </div>
                        <div class="modal-body">
                            <form name="signIn" method="post">
                                <div class="form-group">
                                    <input type="text" name="username" class="form-control" id="email-modal" placeholder="C�dula" required>
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" class="form-control" id="password-modal" placeholder="Contrase�a" required>
                                </div>

                                <p class="text-center">
                                    <button type="submit" id="signInBtn" class="btn btn-primary"><i class="fa fa-sign-in"></i> Acceder</button>
                                </p>

                            </form>

                            <p class="text-center text-muted">A�n no te has registrado?</p>
                            <p class="text-center text-muted"><a href="javascript:openVentanaRegistro();"><strong>Registrate Ahora</strong></a>! Es muy f�cil, en 1&nbsp;minuto podr�s formar parte de nuestro equipo!</p>

                        </div>
                    </div>
                </div>
            </div>

        </div>