<%-- 
    Document   : listarLocacoes
    Created on : 8 de dez. de 2021, 18:43:32
    Author     : sferr
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.com.DTO.LocacaoDTO"%>
<%@page import="br.com.DAO.LocacaoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Locacoes</title>
        <jsp:include page = "../../Includes/js-css.jsp"/>
    </head>
    <body>
        <div class="page-area">
            <jsp:include page = "../../Includes/mensagemSistema.jsp" />
            <jsp:include page = "../../Includes/deslogar.jsp" />

            <h1>LISTA DE LOCACOES</h1>
            <div class="page-content">
                <table border=1>
                    <thead>
                        <tr><th>ID</th><th>Descricao</th><th>Imovel Locado</th><th>Locado por</th><th>-</th><tr>
                    </thead>
                    <tbody>
                <%
                   try{
                       LocacaoDAO cDAO = new LocacaoDAO();
                       List<LocacaoDTO> listaLocacaoDTO = cDAO.listarLocacoes();
                       for(LocacaoDTO locacaoDTO : listaLocacaoDTO){
                           //out.println(locacaoDTO);
                          out.print("<tr><td>"+locacaoDTO.getId()+"</td><td>"+locacaoDTO.getDescricao()+"</td><td>"+
                                    locacaoDTO.getImovel().getDescricao()+"</td><td>"+locacaoDTO.getCliente().getNome()+"</td><td><a href=\"pgLocacao.jsp?id="+locacaoDTO.getId()+"\">Editar</a></td></tr>");
                       }

                   }catch(Exception ex){
                       ex.printStackTrace();               
                       JOptionPane.showMessageDialog(null, "Erro: " + ex.toString());
                   }

                %>
                    </tbody>
                </table>
                <div class="form-group"><button type="button" onclick="window.location.reload (true); window.location.href = 'pgLocacao.jsp'">CRIAR NOVO</button>
                   <button type="button" onclick="window.location.reload (true); window.location.href = '../../View/Principal/inicio.jsp'">VOLTAR</button></div>
             </div>
        </div>
    </body>
</html>
