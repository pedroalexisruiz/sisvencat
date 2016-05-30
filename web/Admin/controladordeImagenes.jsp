<%-- 
    Document   : controladordeImagenes
    Created on : 29/05/2016, 03:11:09 PM
    Author     : Administrator
--%>

<%@page import="co.edu.ufps.Sisvencat.models.util.ImageResizer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>
<%

    String ruta = request.getServletContext().getRealPath("/public/imgpremiosyproductos/imgnormal/");
    FileItemFactory file_factory = new DiskFileItemFactory();
    long codigo_p = 0;
    ImageResizer reductor = new ImageResizer();
    String aux = "";
    /*ServletFileUpload esta clase convierte los input file a FileItem*/
    ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
    /*sacando los FileItem del ServletFileUpload en una lista */
    List items = servlet_up.parseRequest(request);

    ArrayList<String> urls = new ArrayList();

    for (int i = 0; i < items.size(); i++) {
        /*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/
        FileItem item = (FileItem) items.get(i);
        /*item.isFormField() false=input file; true=text field*/
        if (!item.isFormField()) {
            /*cual sera la ruta al archivo en el servidor*/
            File directorioproyecto = new File(ruta);

            if (!directorioproyecto.exists()) {
                directorioproyecto.mkdirs();
            }

            File archivo = new File(ruta + "/" + item.getName());
            /*y lo escribimos en el servido*/
            item.write(archivo);
            aux = archivo.getAbsolutePath();
            aux = aux.replace("imgnormal", "miniatura");
            reductor.copyImage(archivo.getAbsolutePath(), aux);
            urls.add("http://localhost:8080/Sisvencat/public/imgpremiosyproductos/imgnormal/" + item.getName());
        } else {
            codigo_p = Long.parseLong(item.getString());
        }
    }

    try {
        Fachada.insertarImagenDeProducto(urls, codigo_p);
%>
<script>
    alert("Imagenes Subidas Correctamente");
    location = "listarProductos.jsp";
</script>
<%
} catch (SQLException e) {
%>
<script>
    alert("<%=e.getMessage() + "-" + codigo_p%>");
</script>
<%
        e.printStackTrace();
    }


%>