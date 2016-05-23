
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
    }
%>