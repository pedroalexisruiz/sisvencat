function cargarPremios() {
    $.ajax({
        url: "listadoPremios.jsp",
        type: "POST",
        data: {
            pagina: 1
        }
    }).done(function (respuesta) {
        $('#results').append(respuesta);
    });
}