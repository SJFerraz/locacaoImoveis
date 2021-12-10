<%@page import="javax.swing.JOptionPane"%>
<%
    String loginUsuario = (String)  session.getAttribute("loginUsuario");
    if(loginUsuario == null){
        response.sendRedirect("../../View/Principal/login.html");
        return;
    }
%>