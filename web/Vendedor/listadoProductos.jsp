
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    Campaña campañactiva = Fachada.getCampañaActiva();
    List<Producto> productos = campañactiva.getProductos();
    int pagina = (request.getParameter("pagina") != null) ? Integer.parseInt(request.getParameter("pagina")) : 1;
    int cant = 2;
    int contproducto = cant * (pagina - 1);
    String msg = "";

    for (int i = contproducto; i < cant && i < productos.size(); i++) {
        Producto producto = productos.get(i);

        if ((i + 1) % 2 == 1) {
            msg += "<div class='row'>";
        }

        msg += "<div class='col-xs-12 col-md-6'>"
                + "<div class='item'>"
                + "<div class='product'>"
                + "<div class='flip-container'>"
                + "<div class='flipper'>"
                + "<div class='front'>"
                + "<a href='detail.html'>"
                + "<img src='../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg' alt='' class='img-responsive'>"
                + "</a>"
                + "</div>"
                + "<div class='back'>"
                + "<a href='detail.html'>"
                + "<img src='../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg' alt='' class='img-responsive'>"
                + "</a>"
                + "</div>"
                + "</div>"
                + "</div>"
                + "<a href='detail.html' class='invisible'>"
                + "<img src='../public/imgpremiosyproductos/imgnormal/Blusa_vestido.jpg' alt='' class='img-responsive'>"
                + "</a>"
                + "<div class='text'>"
                + "<h3><a href='detail.html'>" + producto.getNombre() + "</a></h3>"
                + "<p class='price'>" + producto.getValor() + "</p>"
                + "</div>"
                + "<!-- /.text -->"
                + "</div>"
                + "<!-- /.product -->"
                + "</div>"
                + "</div>";

        if ((i + 1) % 2 == 0) {
            msg += "</div>";
        }
    }
    if (productos.size() % 2 != 0) {
        msg += "</div>";
    }
    msg += "<div class='text-center'>"
            + "<ul class='pagination'>"
            + "<li class='active'><a href='#'>&laquo;</a></li>"
            + "<li><a href='#'>1</a></li>"
            + "<li><a href='#'>2</a></li>"
            + "<li><a href='#'>3</a></li>"
            + "<li><a href='#'>4</a></li>"
            + "<li><a href='#'>5</a></li>"
            + "<li><a href='#'>&raquo;</a></li>"
            + "</ul>"
            + "</div>";
%>
<%=msg%>