$(function() {
    //----- OPEN
    $('[data-popup-open]').on('click', function(e)  {
        var targeted_popup_class = jQuery(this).attr('data-popup-open');
        $('[data-popup="' + targeted_popup_class + '"]').fadeIn(350);
 
        e.preventDefault();
    });
 
    //----- CLOSE
    $('[data-popup-close]').on('click', function(e)  {
        var targeted_popup_class = jQuery(this).attr('data-popup-close');
        $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);
 
        e.preventDefault();
    });
});

$('#btnAgregarItem').click(function(e){
    e.preventDefault();
    agregarItem();
});

$('#btnEliminarItem').click(function(e){
    e.preventDefault();
    eliminarItem();
});

function agregarItem(){
    
    var codigo_p = $('#producto').attr("codigo");
    var cantidad = $('#cantidad').val();
    
    $.ajax({
        url:"agregarItemAjax.jsp",
        type:"POST",
        data:{
            accion:"agregar",Codigo_p:codigo_p,cantidad:cantidad
        }
    }).done(function(respuesta){
       alert(respuesta); 
       $('#popup').hide("slow");
       $('#btnAgregarItem').attr("disabled",true);
    });
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
       $('#popup').hide("slow");
    });
}