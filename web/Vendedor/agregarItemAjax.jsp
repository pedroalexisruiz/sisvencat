<%-- 
    Document   : agregarItemAjax
    Created on : 25/05/2016, 10:45:36 PM
    Author     : Administrator
--%>

<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Item"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%

    String accion = request.getParameter("accion");

    if (accion.equals("agregar")) {
        long codigo_p = Long.parseLong(request.getParameter("Codigo_p"));
        Producto producto = Fachada.getProducto(codigo_p);
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        Item item = new Item(producto, cantidad, producto.getValor() * cantidad);

        boolean estado = Fachada.agregarItemAlPedido(item);

        if (estado) {
%>
<%="Item Agregado"%>
<%
} else {
%>
<%="No se pudo agregar el item"%>
<%
        }
    }
    if (accion.equals("eliminar")) {
        long codigo_item = Long.parseLong(request.getParameter("Codigo_item"));
    }


%>