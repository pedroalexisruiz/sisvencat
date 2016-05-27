<%-- 
    Document   : solicitarPremio
    Created on : 27/05/2016, 08:59:43 AM
    Author     : Administrator
--%>

<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    long codigo_prem = Long.parseLong(request.getParameter("codigo_prem"));

    try {
        if (Fachada.solicitarPremio(codigo_prem)) {
%>
<%="Solicitud Enviada"%>
<%
} else {
%>
<%="No se pudo Enviar la Solicitud"%>
<%
        }
}catch(SQLException e){
%>
<%=e.getMessage() %>
<%
}
%>