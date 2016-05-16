
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

<%
    HttpSession sesionOk = request.getSession();

    sesionOk.invalidate();

    request.getRequestDispatcher("index.jsp").forward(request, response);
%>