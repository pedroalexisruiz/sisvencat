<%-- 
    Document   : enviarPedidoAjax
    Created on : 25/05/2016, 11:24:22 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    if(Fachada.registrarPedido()){
        %>
        <%="Pedido Realizado Correctamente"; %>
<%
    }else{
%>
        <%="No se Pudo Realizar el Pedido"; %>
<%
}
%>