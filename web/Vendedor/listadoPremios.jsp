
<%@page import="java.text.NumberFormat"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Premio"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    Campaña campañactiva = Fachada.getCampañaActiva();
    List<Premio> premios = Fachada.listarPremios();
    int pagina = (request.getParameter("pagina") != null) ? Integer.parseInt(request.getParameter("pagina")) : 1;
    int cant = 3;
    int contpremio = cant * (pagina - 1);
    String msg = "";
    Premio premio = null;
    String imgprincipal = "";
    String imgsegundaria = "";
    
    NumberFormat formateador = NumberFormat.getCurrencyInstance();
    
    for (int i = contpremio; i < cant && i < premios.size(); i++) {
        premio = premios.get(i);

        if ((i + 1) % cant == 1) {
            msg += "<div class='row'>";
        }
        imgprincipal= (premio.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/lacoste-tenis-casuales-misano-22.jpg" : premio.getImagenes().get(0).getUrlImagen();
        imgsegundaria= (premio.getImagenes().isEmpty()) ? "../public/imgpremiosyproductos/imgnormal/lacoste-tenis-casuales-misano-22.jpg" : premio.getImagenes().get(premio.getImagenes().size()-1).getUrlImagen();
        msg+="<div class='col-xs-12 col-sm-4'>"
                                            +"<div class='item'>"
                                                +"<div class='product'>"
                                                    +"<div class='flip-container'>"
                                                        +"<div class='flipper'>"
                                                            +"<div class='front'>"
                                                                +"<a href='detail.html'>"
                                                                    +"<img src='"+imgprincipal+"' alt='' class='img-responsive'>"
                                                                +"</a>"
                                                            +"</div>"
                                                            +"<div class='back'>"
                                                                +"<a href='detail.html'>"
                                                                    +"<img src='"+imgprincipal+"' alt='' class='img-responsive'>"
                                                                +"</a>"
                                                            +"</div>"
                                                        +"</div>"
                                                    +"</div>"
                                                    +"<a href='detail.html' class='invisible'>"
                                                        +"<img src='"+imgsegundaria+"' alt='' class='img-responsive'>"
                                                    +"</a>"
                                                    +"<div class='text'>"
                                                        +"<h3><a href='detail.html'>"+premio.getNombre()+"</a></h3>"
                                                        +"<p class='price'>"+formateador.format(premio.getPuntosRequeridos())+"</p>"
                                                    +"</div>"
                                                    +"<!-- /.text -->"
                                                +"</div>"
                                                +"<!-- /.premio -->"
                                            +"</div>"
                                        +"</div>";
        if ((i + 1) % cant == 0) {
            msg += "</div>";
        }
    }
    if (premios.size() % 2 != 0) {
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