$('#btnEnviarPedido').click(function (e) {
    e.preventDefault();
    enviarPedido();
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