<%-- 
    Document   : logar
    Created on : 9 de dez. de 2021, 16:16:39
    Author     : sferr
--%>

<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="br.com.util.StringUtils"%>
<%@page import="br.com.DTO.UsuarioDTO"%>
<%@page import="br.com.DAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processando login</title>
    </head>
    <body>
        <%
           String loginInformado = request.getParameter("usuario");
           String senhaInformada = request.getParameter("senha");
           
           if(loginInformado != null && !loginInformado.isEmpty()){
               UsuarioDAO uDAO = new UsuarioDAO();
               UsuarioDTO usuario = uDAO.buscarUsuario(loginInformado);
              
               
               if(usuario.getLoginUsuario()!= null){
                    String senhaInformadaSHA256 = DigestUtils.sha256Hex(usuario.getLoginUsuario()+StringUtils.nvlStr(senhaInformada));
                    String senhaBD = StringUtils.nvlStr(usuario.getSenha());
                    
                    if(senhaInformadaSHA256.equals(senhaBD)){
                        session.setAttribute("nomeUsuario", usuario.getNome());
                        session.setAttribute("loginUsuario", usuario.getLoginUsuario());
                        
                        response.sendRedirect("../../View/Principal/inicio.jsp");
                        return;
                    }
               }
           }
           response.sendRedirect("../../View/Principal/login.html");
           
        %>
    </body>
</html>
