<%-- 
    Document   : modificadorDePremios
    Created on : 29/05/2016, 11:31:43 AM
    Author     : Administrator
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria"%>
<%@page import="java.util.Arrays"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Color"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Premio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    long codigo_p = Long.parseLong(request.getParameter("Codigo"));
    String nombre = request.getParameter("Nombre");
    int puntos_requeridos = Integer.parseInt(request.getParameter("Puntos_requeridos"));
    int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
    String descripcion = request.getParameter("Descripcion");

    Premio p = new Premio(codigo_p, nombre, descripcion, puntos_requeridos, cantidad, null);

    try {
        if (Fachada.modificarPremio(p)) {
%>
<script>
    alert("Premio Modificado Correctamente");
    location = "listarPremios.jsp";
</script>
<%
} else {
%>
<script>
    alert("No se pudo modificar el premio");
    location = "listarPremios.jsp";
</script>
<%
    }
} catch (SQLException e) {
%>
<%=e.getMessage()%>
<%
    }

%>
