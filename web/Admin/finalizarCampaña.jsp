<%-- 
    Document   : finalizarCampaña
    Created on : 30/05/2016, 11:57:27 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>
<%
    boolean estado = Fachada.finalizarCampaña();

    if (estado) {
%>
<%="Campaña Finalizada"%>
<%
} else {
%>
<%="No se pudo finalizar la campaña"%>
<%
    }
%>