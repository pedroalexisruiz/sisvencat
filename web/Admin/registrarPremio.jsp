<%-- 
    Document   : registrarPremio
    Created on : 31/05/2016, 01:03:47 AM
    Author     : Administrator
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Premio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    String nombre = request.getParameter("nombre");
    String descripcion = request.getParameter("descripcion");
    int puntos = Integer.parseInt(request.getParameter("punto_requerido"));
    int cantidad = Integer.parseInt(request.getParameter("cantDisponible"));
    Premio premio = new Premio(nombre, descripcion, puntos, cantidad, null);

    try {
        Fachada.registrarPremio(premio);
%>
<%="Premio Registrado"%>
<%
} catch (SQLException e) {
%>
<%="No se pudo registrar el Premio. " + e.getMessage()%>
<%
    }

%>