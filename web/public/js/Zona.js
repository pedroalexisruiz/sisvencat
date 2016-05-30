$('#btnRegistrarZona').click(function(e){
    e.preventDefault();
    registrarZona();
});

function registrarZona(){
    var nombre = $('#nombre').val();
    
    $.ajax({
        url:"controladorZona.jsp",
        type:"POST",
        data:{
            nombre:nombre
        }
    }).done(function(respuesta){
        alert(respuesta);
        location.reload();
    });
}