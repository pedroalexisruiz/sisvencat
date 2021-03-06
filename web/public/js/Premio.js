$('#btnSolicitarPremio').click(function (e) {
    e.preventDefault();
    solicitarPremio();
});

$('#btnRegistrarPremio').click(function (e) {
    e.preventDefault();
    registrarPremio();
});

function registrarPremio(){
    var nombre = $('#Nombre').val();
    var descripcion = $('#Descripcion').val();
    var punto_requerido = $('#Punto_requerido').val();
    var cantDisponible = $('#CantDisponible').val();
    
    $.ajax({
        url:"registrarPremio.jsp",
        type:"POST",
        data:{
            nombre:nombre, descripcion:descripcion, punto_requerido:punto_requerido, cantDisponible:cantDisponible
        }
    }).done(function(respuesta){
        alert(respuesta);
        location.reload();
    });
}
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

function solicitarPremio() {

    var precio = $('#precio').attr("precio");
    var puntajevendedor = $('#premio').attr("puntosvendedor");

    if (parseInt(precio,10) > parseInt(puntajevendedor,10)) {
        alert("No posees el puntaje suficiente para solicitar el premio.");
    } else {
        var confirmar = confirm("¿Está seguro de Solicitar el Premio?. Tenga en cuenta que no podrá ser cancelado y el monto se descontará de sus puntos actuales.");
        var codigo_prem = $('#premio').attr("codigo");
        
        if (confirmar === true) {
            $.ajax({
                url: "solicitarPremio.jsp",
                type: "GET",
                data: {
                    codigo_prem: codigo_prem
                }
            }).done(function (respuesta) {
                alert(respuesta);
                location.reload();
            });
        }
    }
}