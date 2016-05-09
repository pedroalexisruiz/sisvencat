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

        if (respuesta == "Datos Actualizados") {
            location.reload();
        }
    });
}

function cambiarContrasena() {

    var Contrasena = $('#contrasena').val();
    var Contrasenamod = $('#contrasenamod').val();
    var Contrasenamod2 = $('#contrasenamod2').val();

    if (Contrasenamod == Contrasenamod2) {
        $.ajax({
            type: "POST",
            url: "../Admin",
            data: {metodo: "cambiarContraseña", Contrasena:Contrasena, ContrasenaNueva:Contrasenamod}
        }).done(function (respuesta) {

            alert(respuesta);

            if (respuesta == "Contraseña Actualizada") {
                location.reload();
            }
        });
    }else{
        alert("Las Contraseñas Nuevas no Coinciden");
    }

}