$('#btnAcceder').on('click', function (e) {
    e.preventDefault();
    $('#divCargando').html('<div><img src="../public/img/AjaxLoader.gif"/></div>');
    $('#btnAcceder').attr("disabled",true);
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
                $('#btnAcceder').removeAttr("disabled")
            }else{
                location = "../"+respuesta;
            }         
        }

    });
}