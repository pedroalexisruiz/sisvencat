function cargarProductos() {
    $.ajax({
        url: "listadoProductos.jsp",
        type: "POST",
        data: {
            pagina: 1
        }
    }).done(function (respuesta) {
        $('#results').append(respuesta);
    });
}