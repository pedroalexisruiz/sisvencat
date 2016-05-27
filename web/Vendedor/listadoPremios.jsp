
<%@page import="java.text.NumberFormat"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Premio"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    List<Premio> premios = Fachada.listarPremios();
    int pagina = (request.getParameter("pag") != null) ? Integer.parseInt(request.getParameter("pag")) : 1;
    int cant = 3;
    int contpremio = cant * (pagina - 1);
    int numpags = (int)Math.ceil((float)premios.size() / cant);
    String msg = "";
    Premio premio = null;
    String imgprincipal = "";
    String imgsegundaria = "";

    NumberFormat formateador = NumberFormat.getCurrencyInstance();

    for (int i = contpremio, j = 0; j < cant && i < premios.size(); j++, i++) {
        premio = premios.get(i);

        if ((j + 1) % cant == 1) {
            msg += "<div class='row'>";
        }
        imgprincipal = (premio.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" : premio.getImagenes().get(0).getUrlImagen();
        imgsegundaria = (premio.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/nodisponible.jpg" : premio.getImagenes().get(premio.getImagenes().size() - 1).getUrlImagen();
        msg += "<div class='col-xs-12 col-sm-4'>"
                + "<div class='item'>"
                + "<div class='product'>"
                + "<div class='flip-container'>"
                + "<div class='flipper'>"
                + "<div class='front'>"
                + "<a href='detallePremio.jsp?id=" + premio.getCodigo_premio() + "'>"
                + "<img src='" + imgprincipal + "' alt='' class='img-responsive'>"
                + "</a>"
                + "</div>"
                + "<div class='back'>"
                + "<a href='detallePremio.jsp?id=" + premio.getCodigo_premio() + "'>"
                + "<img src='" + imgprincipal + "' alt='' class='img-responsive'>"
                + "</a>"
                + "</div>"
                + "</div>"
                + "</div>"
                + "<a href='detallePremio.jsp?id=" + premio.getCodigo_premio() + "' class='invisible'>"
                + "<img src='" + imgsegundaria + "' alt='' class='img-responsive'>"
                + "</a>"
                + "<div class='text'>"
                + "<h3><a href='detallePremio.jsp?id=" + premio.getCodigo_premio() + "'>" + premio.getNombre() + "</a></h3>"
                + "<p class='price'>" + formateador.format(premio.getPuntosRequeridos()) + "</p>"
                + "</div>"
                + "<!-- /.text -->"
                + "</div>"
                + "<!-- /.premio -->"
                + "</div>"
                + "</div>";
        if ((j + 1) % cant == 0) {
            msg += "</div>";
        }
    }
    if (premios.size() % cant != 0) {
        msg += "</div>";
    }
    msg += "<div class='text-center'>"
            + "<ul class='pagination'>"
            + "<li class='active'><a href='#'>&laquo;</a></li>";
    for (int i = 1; i <= numpags; i++) {
        msg += "<li><a onclick='cargarPremios("+i+")'>"+i+"</a></li>";
    }
    msg += "<li><a href='#'>&raquo;</a></li>"
            + "</ul>"
            + "</div>";
%>
<%=msg%>