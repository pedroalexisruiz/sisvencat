<%-- 
    Document   : cargadorDeProductos
    Created on : 30/05/2016, 03:13:11 PM
    Author     : Administrator
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="org.apache.poi.ss.usermodel.Row"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFSheet"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria"%>
<%@page import="co.edu.ufps.Sisvencat.models.ClasesDTO.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="co.edu.ufps.Sisvencat.facade.SisvencatFacade" id="Fachada" scope="session"></jsp:useBean>

<%

    String ruta = request.getServletContext().getRealPath("/");
    FileItemFactory file_factory = new DiskFileItemFactory();
    /*ServletFileUpload esta clase convierte los input file a FileItem*/
    ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
    /*sacando los FileItem del ServletFileUpload en una lista */
    List items = servlet_up.parseRequest(request);
    File archivo = null;
    ArrayList<Producto> productos = new ArrayList();
    Producto producto = null;
    Categoria cat = null;
    Tipo tipo = null;

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

            archivo = new File(ruta + "/" + item.getName());
            /*y lo escribimos en el servido*/
            item.write(archivo);
        }
    }

    try {

        FileInputStream file = new FileInputStream(archivo);

        //Get the workbook instance for XLS file 
        HSSFWorkbook workbook = new HSSFWorkbook(file);

        //Get first sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(0);

        //Iterate through each rows from first sheet
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            cat = new Categoria();
            cat.setId((int) row.getCell(4).getNumericCellValue());
            tipo = new Tipo();
            tipo.setId((int) row.getCell(5).getNumericCellValue());
            producto = new Producto(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), (int) row.getCell(2).getNumericCellValue(), (int) row.getCell(3).getNumericCellValue(), cat, tipo, null);
            productos.add(producto);
        }
        file.close();
        archivo.delete();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    try {
        Fachada.subirProductos(productos);
%>
<script>
    alert("Productos Subidos Correctamente.");
    location="listarProductos.jsp";
</script>
<%
} catch (SQLException e) {
%>
<script>
    alert("Error Subiendo los productos: "<%=e.getMessage()%>);
    location="listarProductos.jsp";
</script>
<%
    }
%>