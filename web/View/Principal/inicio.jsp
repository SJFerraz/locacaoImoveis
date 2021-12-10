<%-- 
    Document   : inicio
    Created on : 9 de dez. de 2021, 16:02:17
    Author     : sferr
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page = "../../Includes/js-css.jsp"/>

    </head>
    <body>
        <div class="page-area">        
            <jsp:include page = "../../Includes/deslogar.jsp" />
            <h1>BEM VINDO <%=session.getAttribute("nomeUsuario")%></h1>
            <div class="page-content">
                <ul>
                    <li><a href="../../View/Cliente/listarClientes.jsp">CADASTRO DE CLIENTE</a></li>
                    <li><a href="../../View/Imovel/listarImoveis.jsp">CADASTRO DE IMOVEL</a></li>
                    <li><a href="../../View/Locacao/listarLocacoes.jsp">FAZER LOCAÇÃO DE IMOVEL</a></li>
                </ul>
            </div>
        </div>
    </body>
</html>
