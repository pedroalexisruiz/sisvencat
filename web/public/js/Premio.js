function cargarPremios(pag) {
    $.ajax({
        url: "listadoPremios.jsp",
        type: "POST",
        data: {
            pag: pag
        }
    }).done(function (respuesta) {
        $('#results').html(respuesta);
    });
}