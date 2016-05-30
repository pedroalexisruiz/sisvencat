<%-- 
    Document   : registrarCampaña
    Created on : 30/05/2016, 01:01:34 PM
    Author     : Administrator
--%>

<%@page import="java.text.ParseException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    String fecha_inicio = request.getParameter("Fecha_inicio");
    String fecha_fin = request.getParameter("Fecha_fin");
    String tema = request.getParameter("Tema");

    Calendar fi = Calendar.getInstance();
    fi.setTime(formater.parse(fecha_inicio));
    Calendar ff = Calendar.getInstance();
    ff.setTime(formater.parse(fecha_fin));
    Campaña campaña = new Campaña(fi, ff, tema);

    try {
        Fachada.iniciarCampaña(campaña);
%>
<script>
    alert("Campaña Iniciada.");
    location = "subirProducto.jsp";
</script>
<%
} catch (SQLException e) {
%>
<script>
    alert("No se pudo Iniciar la Campaña."<%=e.getMessage() %>);
    location = "subirProducto.jsp";
</script>
<%
    e.printStackTrace();
} catch (ParseException e) {
%>
<script>
    alert("No se pudo Iniciar la Campaña."<%=e.getMessage() %>);
    location = "subirProducto.jsp";
</script>
<%
    e.printStackTrace();
    }
%>
%>
