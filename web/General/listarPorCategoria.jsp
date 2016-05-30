<%-- 
    Document   : listarPorCategoria
    Created on : 29/05/2016, 10:01:27 PM
    Author     : Administrator
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    int cat = (request.getParameter("cat") != null) ? Integer.parseInt(request.getParameter("cat")) : 1;
    int tipo = (request.getParameter("tipo") != null) ? Integer.parseInt(request.getParameter("tipo")) : 1;
    if (Fachada.getCampañaActiva() == null) {
%>
<%="<div class='box'><h2 class='text-primary text-center'>No existe Campaña Activa en Estos Momentos.</h2></div>"%>
<%
} else {
    List<Producto> productos = Fachada.getProductosCampañaCategoriaYTipo(cat, tipo);
    int pagina = (request.getParameter("pagina") != null) ? Integer.parseInt(request.getParameter("pagina")) : 1;
    int cant = 8;
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
            msg += "<div class='row products'>";
        }

        imgprincipal = (producto.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" : producto.getImagenes().get(0).getUrlImagen();
        imgsegundaria = (producto.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" : producto.getImagenes().get(producto.getImagenes().size() - 1).getUrlImagen();
        imgprincipal = imgprincipal.replace("imgnormal", "miniatura");
        imgsegundaria = imgsegundaria.replace("imgnormal", "miniatura");
        msg += "<div class='col-xs-12 col-md-3 col-sm-4'>"
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
                + "<p class='buttons'>"
                + "<a href='detalleProducto.jsp?id=" + producto.getCodigo_p() + "' class='btn btn-primary'> Ver Detalles</a>"
                + "</p>"
                + "</div>"
                + "<!-- /.text -->"
                + "</div>"
                + "<!-- /.product -->"
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
        msg += "<li><a href='Categoria.jsp?cat=" + cat + "&tipo=" + tipo + "&pagina=" + i + "'>" + i + "</a></li>";
    }
    msg += "<li><a href='#'>&raquo;</a></li>"
            + "</ul>"
            + "</div>";
%>
<%=msg%>
<%
    }
%>
