
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

<%
    SisvencatFacade Fachada = (SisvencatFacade) request.getSession().getAttribute("Fachada");

    if (Fachada == null) {
%>
<script>
    alert("Debe Iniciar Sesión");
    location = "../General/login.jsp";
</script>
<%
} else if (Fachada.getAdminN() == null) {
%>
<script>
    alert("Acceso solo para el Administrador");
    location = "../../cerrarSesion.jsp";
</script>
<%
    }
%>