<%-- 
    Document   : modificadorDeProductos
    Created on : 29/05/2016, 11:31:43 AM
    Author     : Administrator
--%>

<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria"%>
<%@page import="java.util.Arrays"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Color"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%
    long codigo_p = Long.parseLong(request.getParameter("Codigo"));
    String nombre = request.getParameter("Nombre");
    int valor = Integer.parseInt(request.getParameter("Valor"));
    int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
    int idtipo = Integer.parseInt(request.getParameter("Tipo"));
    int idcategoria = Integer.parseInt(request.getParameter("Categoria"));
    String[] stringcolores = request.getParameterValues("Colores");
    String[] stringtallas = request.getParameterValues("Tallas");
    String descripcion = request.getParameter("Descripcion");

    List<String> tallas = Arrays.asList(stringtallas);
    List<Color> colores = new ArrayList();
    Categoria categoria = new Categoria();
    categoria.setId(idcategoria);
    Tipo tipo = new Tipo();
    tipo.setId(idtipo);
    Color color = null;
    for (String string : stringcolores) {
        color = new Color();
        color.setId(Integer.parseInt(string));
        colores.add(color);
    }

    Producto p = new Producto(codigo_p, nombre, descripcion, valor, cantidad, categoria, tipo, null);
    p.setTalla(tallas);
    p.setColor(colores);

    if (Fachada.modificarProducto(p)) {
%>
<script>
    alert("Producto Modificado Correctamente");
    location="listarProductos.jsp";
</script>
<%
} else {
%>
<script>
    alert("No se pudo modificar el producto");
    location="listarProductos.jsp";
</script>
<%
}
%>
