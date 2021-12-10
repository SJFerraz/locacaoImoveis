<%-- 
    Document   : deslogarSistema
    Created on : 9 de dez. de 2021, 21:06:12
    Author     : sferr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String deslogar = (String) request.getParameter("deslogar");
            if(deslogar != null){
                session.invalidate();
                response.sendRedirect("../../");
            }
        %>
    </body>
</html>
