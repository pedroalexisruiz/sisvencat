<%-- 
    Document   : controladorZona
    Created on : 31/05/2016, 01:35:49 AM
    Author     : Administrator
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Zona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    String nombre = request.getParameter("nombre");
    Zona zona = new Zona();
    zona.setNombre(nombre);

    try {
        Fachada.registrarZona(zona);
%>
<%="Zona Registrada"%>
<%
} catch (SQLException e) {
%>
<%="No se pudo Registrar la Zona" %>  
<%
    }
%>