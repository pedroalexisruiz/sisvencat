<div class="col-md-3">
    <!-- *** CUSTOMER MENU ***
_________________________________________________________ -->
    <div class="panel panel-default sidebar-menu">

        <div class="panel-heading">
            <h3 class="panel-title">Panel de Administración</h3>
        </div>

        <div class="panel-body">

            <ul id="listadeMenu" class="nav nav-pills nav-stacked">
                <li id="li1">
                    <a href="ModificarDatos.jsp" id="modificardatos"><i class="fa fa-credit-card"></i>Modificar Datos</a>
                </li>
                <li id="li2">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-heart"></i>Gestionar Campañas</a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="iniciarCampana.jsp">Registrar Campaña</a></li>
                        <li><a href="listarCampanas.jsp">Listado de Campañas</a></li>
                    </ul>
                </li>
                <li id="li3">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-map-marker"></i>Zonas de Venta</a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="registrarZona.jsp">Registrar Zona</a></li>
                        <li><a href="listarZonas.jsp">Listado de Zonas</a></li>
                    </ul>
                </li>
                <li id="li4">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-users"></i>Gestionar Gerentes</a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="registrarGerente.jsp">Registrar Gerente</a></li>
                        <li><a href="listarGerentes.jsp">Listado de Gerentes</a></li>
                    </ul>
                </li>
                <li id="li5">
                    <a href="listarVendedores.jsp"><i class="fa fa-user"></i>Control de Vendedores</a>
                </li>
                <li id="li6">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-shopping-cart"></i>Gestionar Productos</a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="subirProducto.jsp">Subir Productos</a></li>
                        <li><a href="listarProductos.jsp">Listado de Productos</a></li>
                    </ul>
                </li>
                <li id="li7">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-trophy"></i>Gestionar Premios</a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="subirPremio.jsp">Registrar Premio</a></li>
                        <li><a href="listarPremios.jsp">Listado de Premios</a></li>
                    </ul>
                </li>
                <li id="li8">
                    <a id="btncerrarSession" href="../cerrarSesion.jsp"><i class="fa fa-sign-out"></i> Salir</a>
                </li>
            </ul>
        </div>

    </div>
    <!-- /.col-md-3 -->

    <!-- *** CUSTOMER MENU END *** -->
</div>