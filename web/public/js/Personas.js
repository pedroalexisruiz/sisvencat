$('#btnAcceder').on('click', function (e) {
    e.preventDefault();
    iniciarSesion();
});

function iniciarSesion() {

    var cedula = $('#cedula').val();
    var password = $('#password').val();

    $.ajax({
        type: "POST",
        url: "../LoginServlet",
        data: {cedula: cedula, password: password}
    }).done(function (respuesta) {

        if (respuesta != 0) {
            
            if(respuesta=="Datos Erróneos"){
                alert(respuesta);
            }else{
                location = "../"+respuesta;
            }         
        }

    });

}