$('#btnDesactivarCampaña').click(function (e) {
    e.preventDefault();
    finalizarCampaña();
});

$('#btnModificarCampaña').click(function (e) {
    e.preventDefault();
    modificarCampaña();
});

function finalizarCampaña() {
    var codigo_cam = $('#btnDesactivarCampaña').attr("valor");
    var confirm = confirm("Está Seguro de Finalizar la Campaña?");

    if (confirm === true) {
        $.ajax({
            url: "finalizarCampaña.jsp",
            type: "POST",
            data: {
                codigo_cam: codigo_cam
            }
        }).done(function (respuesta) {
            alert(respuesta);
            location.reload();
        });
    }
}