
//Métodos relacionados solo con el Admin
$('#btnModificarDatos').on('click', function (e) {
    e.preventDefault();
    modificarDatos();
});

$('#btnCambiarContrasena').on('click', function (e) {
    e.preventDefault();
    cambiarContrasena();
});

function modificarDatos() {

    var Nombre = $('#Nombre').val();
    var Apellido = $('#Apellido').val();
    var Direccion = $('#Direccion').val();
    var Telefono = $('#Telefono').val();
    var Correo = $('#Correo').val();

    $.ajax({
        type: "POST",
        url: "../Admin",
        data: {metodo: "modificarDatos", Nombre: Nombre, Apellido: Apellido, Direccion: Direccion, Telefono: Telefono, Correo: Correo}
    }).done(function (respuesta) {

        alert(respuesta);

        if (respuesta === "Datos Actualizados") {
            location.reload();
        }
    });
}

function cambiarContrasena() {

    var Contrasena = $('#contrasena').val();
    var Contrasenamod = $('#contrasenamod').val();
    var Contrasenamod2 = $('#contrasenamod2').val();

    if (Contrasenamod === Contrasenamod2) {
        $.ajax({
            type: "POST",
            url: "../Admin",
            data: {metodo: "cambiarContraseña", Contrasena: Contrasena, ContrasenaNueva: Contrasenamod}
        }).done(function (respuesta) {

            alert(respuesta);

            if (respuesta === "Contraseña Actualizada") {
                location.reload();
            }
        });
    } else {
        alert("Las Contraseñas Nuevas no Coinciden");
    }
}

//Métodos Relacionados con la Gestión de Gerentes

$('#btnRegistroGerente').on('click', function (e) {
    e.preventDefault();
    registrarGerente();
});

$('[name="btnGerenteACambiar"]').on('click', function (e) {
    e.preventDefault();
    mostrarDatosGerente(this.id);
});

$('[name="btnGerenteADesactivar"]').on('click', function (e) {
    e.preventDefault();
    desactivarGerente(this.id);
});

$('[name="btnGerenteAReactivar"]').on('click', function (e) {
    e.preventDefault();
    reactivarGerente(this.id);
});

function mostrarDatosGerente(id) {

    ocultarDiv(2);

    $.ajax({
        url: "../Admin",
        type: "POST",
        data: {
            metodo: "getGerente", Cedula: id
        }
    }).done(function (respuesta) {
        $('#divModificar').html(respuesta);
    });
}

function guardarDatosGerente() {

    var cedula = $('[name="btnModificarDatosGerente"]').attr("id");
    var nombre = $('#nombre').val();
    var apellido = $('#apellido').val();
    var direccion = $('#direccion').val();
    var telefono = $('#telefono').val();
    var correo = $('#correo').val();

    $.ajax({
        url: "../Admin",
        type: "POST",
        data: {
            metodo: "modificarGerente", cedula:cedula, nombre:nombre, apellido:apellido,direccion:direccion,telefono:telefono,correo:correo
        }
    }).done(function (respuesta) {
        alert(respuesta);
        location.reload();
    });
}

function reactivarGerente(id) {

    var confirmacion = confirm("¿Está seguro de que desea reactivar el Gerente seleccionado?");

    if (confirmacion === true) {

        $.ajax({
            url: "../Admin",
            type: "POST",
            data: {
                metodo: "reactivarGerente", cedula: id
            }
        }).done(function (respuesta) {
            alert(respuesta);
            location.reload();
        });
    }
}

function desactivarGerente(id) {

    var confirmacion = confirm("¿Está seguro de que desea desactivar el Gerente seleccionado?");

    if (confirmacion === true) {

        $.ajax({
            url: "../Admin",
            type: "POST",
            data: {
                metodo: "desactivarGerente", cedula: id
            }
        }).done(function (respuesta) {
            alert(respuesta);
            location.reload();
        });
    }
}

function registrarGerente() {

    var Nombre = $('#Nombre').val();
    var Apellido = $('#Apellido').val();
    var Cedula = $('#Cedula').val();
    var Telefono = $('#Telefono').val();
    var Correo = $('#Correo').val();
    var Zona_Codigo_z = $('#Zona_Codigo_z').val();
    var Direccion = $('#Direccion').val();
    var Contrasena = $('#contrasena').val();
    var Contrasena2 = $('#contrasena2').val();

    if (Contrasena === Contrasena2) {

        $.ajax({
            type: "POST",
            url: "../Admin",
            data: {metodo: "registrarGerente", Nombre: Nombre, Apellido: Apellido, Cedula: Cedula, Direccion: Direccion,
                Telefono: Telefono, Correo: Correo, Zona_Codigo_z: Zona_Codigo_z, Contrasena: Contrasena}
        }).done(function (respuesta) {

            if (respuesta === 1062) {
                respuesta = "El Usuario Ya Se Encuentra Registrado";
            }
            alert(respuesta);

            if (respuesta === "Gerente Registrado") {
                location.reload();
            }
        });
    } else {
        alert("Las Contraseñas No Coinciden");
    }
}

//Métodos de la gestión de Vendedores

$('[name="btnVendedorACambiar"]').on('click', function (e) {
    e.preventDefault();
    mostrarDatosVendedor(this.id);
});

$('[name="btnVendedorADesactivar"]').on('click', function (e) {
    e.preventDefault();
    desactivarVendedor(this.id);
});

$('[name="btnVendedorAReactivar"]').on('click', function (e) {
    e.preventDefault();
    reactivarVendedor(this.id);
});

function reactivarVendedor(id) {

    var confirmacion = confirm("¿Está seguro de que desea reactivar el Vendedor seleccionado?");

    if (confirmacion === true) {

        $.ajax({
            url: "../Admin",
            type: "POST",
            data: {
                metodo: "reactivarVendedor", cedula: id
            }
        }).done(function (respuesta) {
            alert(respuesta);
            location.reload();
        });
    }
}
function mostrarDatosVendedor(id) {

    ocultarDiv(2);

    $.ajax({
        url: "../Admin",
        type: "POST",
        data: {
            metodo: "getVendedor", Cedula: id
        }
    }).done(function (respuesta) {
        $('#divModificar').html(respuesta);
    });
}

function guardarDatosVendedor() {

    var cedula = $('[name="btnModificarDatosVendedor"]').attr("id");
    var nombre = $('#nombre').val();
    var apellido = $('#apellido').val();
    var direccion = $('#direccion').val();
    var telefono = $('#telefono').val();
    var correo = $('#correo').val();

    $.ajax({
        url: "../Admin",
        type: "POST",
        data: {
            metodo: "modificarVendedor", cedula:cedula, nombre:nombre, apellido:apellido,direccion:direccion,telefono:telefono,correo:correo
        }
    }).done(function (respuesta) {
        alert(respuesta);
        location.reload();
    });
}

function desactivarVendedor(id) {

    var confirmacion = confirm("¿Está seguro de que desea desactivar el Vendedor seleccionado?");

    if (confirmacion === true) {

        $.ajax({
            url: "../Admin",
            type: "POST",
            data: {
                metodo: "desactivarVendedor", cedula: id
            }
        }).done(function (respuesta) {
            alert(respuesta);
            location.reload();
        });
    }
}

//Métodos de la gestión de Zonas

$('[name="btnZonaaCambiar"]').on('click', function (e) {
    e.preventDefault();
    mostrarDatosZona(this.id);
});

$('[name="btnZonaaDesactivar"]').on('click', function (e) {
    e.preventDefault();
    desactivarZona(this.id);
});

function mostrarDatosZona(id) {

    var codigoZ = id;
    ocultarDiv(2);

    $.ajax({
        url: "../Admin",
        type: "POST",
        data: {
            metodo: "getZona", Zona_Codigo_z: codigoZ
        }
    }).done(function (respuesta) {
        $('#divModificar').html(respuesta);
    });
}

function desactivarZona(id) {

    var confirmacion = confirm("¿Está seguro de que desea desactivar la zona seleccionada?");

    if (confirmacion === true) {

        $.ajax({
            url: "../Admin",
            type: "POST",
            data: {
                metodo: "desactivarZona", Zona_Codigo_z: id
            }
        }).done(function (respuesta) {
            alert(respuesta);
            location.reload();
        });
    }
}

function guardarDatosZona() {

    var Zona_Codigo_z = $('[name="NombreNuevoZona"]').attr("valor");
    var nombreNuevo = $('[name="NombreNuevoZona"]').val();

    $.ajax({
        url: "../Admin",
        type: "POST",
        data: {
            metodo: "modificarZona", Zona_Codigo_z: Zona_Codigo_z, nombreNuevo: nombreNuevo
        }
    }).done(function (respuesta) {
        alert(respuesta);
        location.reload();
    });
}


function ocultarDiv(num) {

    if (num === 1) {
        $('#divListado').show();
        $('#divModificar').hide();
    }
    if (num === 2) {
        $('#divListado').hide();
        $('#divModificar').show();
    }

}
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
});
