
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="co.edu.ufps.Sisvencat.facade.SisvencatFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%

    SisvencatFacade fachada = new SisvencatFacade();

    try {
        fachada.iniciarNegocioGeneral();
        request.getSession().setAttribute("Fachada", fachada);
        response.sendRedirect("General/index.jsp");

    } catch (SQLException e) {
%>
<h2><%=e.getMessage()%></h2>
<%
    e.printStackTrace();
} catch (ParseException e) {
%>
<h2><%=e.getMessage()%></h2>
<%
    e.printStackTrace();
} catch (NullPointerException e) {
    StringWriter errors = new StringWriter();
    e.printStackTrace(new PrintWriter(errors));
%>
<h2>Error Cargando el Negocio.</h2>
<p><%=errors.toString() %><p>
<%
        e.printStackTrace();
    }
%>