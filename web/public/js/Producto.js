
function cargarProductos(pagina) {
    $.ajax({
        url: "listadoProductos.jsp",
        type: "POST",
        data: {
            pagina: pagina
        }
    }).done(function (respuesta) {
        $('#results').html(respuesta);
    });
}

function listarPorCategoria() {

    var cat = getParameterByName('cat');
    var tipo = getParameterByName('tipo');
    var pagina = getParameterByName('pagina');
    $.ajax({
        url: "listarPorCategoria.jsp",
        type: "POST",
        data: {
            pagina: pagina, cat: cat, tipo: tipo
        }
    }).done(function (respuesta) {
        $('#results').html(respuesta);
    });
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}