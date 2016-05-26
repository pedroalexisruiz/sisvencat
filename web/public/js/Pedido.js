$('#btnEnviarPedido').click(function (e) {
    e.preventDefault();
    enviarPedido();
});

$('#btnEliminarItem').click(function(e){
    e.preventDefault();
    eliminarItem();
});

function enviarPedido() {

    var confirmar = confirm("Está seguro de Realizar el Pedido. Tenga en cuenta que no podrá ser cancelado.");

    if (confirmar==true) {
        $.ajax({
            url: "enviarPedidoAjax.jsp",
            type: "GET"
        }).done(function (respuesta) {
            alert(respuesta);
        });
    }
}

function eliminarItem(id){
        
    $.ajax({
        url:"agregarItemAjax.jsp",
        type:"POST",
        data:{
            accion:"eliminar",Codigo_item:id
        }
    }).done(function(respuesta){
       alert(respuesta); 
       location.reload();
    });
}