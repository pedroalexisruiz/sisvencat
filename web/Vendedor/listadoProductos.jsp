
<%@page import="java.text.NumberFormat"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    Campaña campañactiva = Fachada.getCampañaActiva();
    if (campañactiva == null) {
%>
<%="<h2 class='text-primary text-center'>No existe Campaña Activa en Estos Momentos.</h2>"%>
<%
} else {
    List<Producto> productos = campañactiva.getProductos();
    int pagina = (request.getParameter("pagina") != null) ? Integer.parseInt(request.getParameter("pagina")) : 1;
    int cant = 3;
    int contproducto = cant * (pagina - 1);
    int numpags = (int) Math.ceil((float) productos.size() / cant);
    String msg = "";
    Producto producto = null;
    String imgprincipal = "";
    String imgsegundaria = "";
    NumberFormat formateador = NumberFormat.getCurrencyInstance();

    for (int i = contproducto, j = 0; j < cant && i < productos.size(); i++, j++) {
        producto = productos.get(i);

        if ((j + 1) % cant == 1) {
            msg += "<div class='row'>";
        }

        imgprincipal = (producto.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" : producto.getImagenes().get(0).getUrlImagen();
        imgsegundaria = (producto.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" : producto.getImagenes().get(producto.getImagenes().size() - 1).getUrlImagen();
        imgprincipal = imgprincipal.replace("imgnormal", "miniatura");
        imgsegundaria = imgsegundaria.replace("imgnormal", "miniatura");
        msg += "<div class='col-xs-12 col-md-4'>"
                + "<div class='item'>"
                + "<div class='product'>"
                + "<div class='flip-container'>"
                + "<div class='flipper'>"
                + "<div class='front'>"
                + "<a href='detalleProducto.jsp?id=" + producto.getCodigo_p() + "'>"
                + "<img src='" + imgprincipal + "' alt='' class='img-responsive'>"
                + "</a>"
                + "</div>"
                + "<div class='back'>"
                + "<a href='detalleProducto.jsp?id=" + producto.getCodigo_p() + "'>"
                + "<img src='" + imgprincipal + "' alt='' class='img-responsive'>"
                + "</a>"
                + "</div>"
                + "</div>"
                + "</div>"
                + "<a href='detalleProducto.jsp?id=" + producto.getCodigo_p() + "' class='invisible'>"
                + "<img src='" + imgsegundaria + "' alt='' class='img-responsive'>"
                + "</a>"
                + "<div class='text'>"
                + "<h3><a href='detalleProducto.jsp?id=" + producto.getCodigo_p() + "'>" + producto.getNombre() + "</a></h3>"
                + "<p class='price'>" + formateador.format(producto.getValor()) + "</p>"
                + "</div>"
                + "<!-- /.text -->"
                + "</div>"
                + "<!-- /.product -->"
                + "</div>"
                + "</div>";

        if ((j + 1) % cant == 0) {
            msg += "</div>";
        }
    }
    if (productos.size() % cant != 0) {
        msg += "</div>";
    }
    msg += "<div class='text-center'>"
            + "<ul class='pagination'>"
            + "<li class='active'><a href='#'>&laquo;</a></li>";
    for (int i = 1; i <= numpags; i++) {
        msg += "<li><a onclick='cargarProductos(" + i + ")'>" + i + "</a></li>";
    }
    msg += "<li><a href='#'>&raquo;</a></li>"
            + "</ul>"
            + "</div>";
%>
<%=msg%>
<%}
%>