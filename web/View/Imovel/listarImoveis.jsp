<%-- 
    Document   : listarImoveis
    Created on : 8 de dez. de 2021, 18:43:32
    Author     : sferr
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.com.DTO.ImovelDTO"%>
<%@page import="br.com.DAO.ImovelDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Imoveis</title>
        <jsp:include page = "../../Includes/js-css.jsp"/>
    </head>
    <body>
        <div class="page-area">
            <jsp:include page = "../../Includes/mensagemSistema.jsp" />
            <jsp:include page = "../../Includes/deslogar.jsp" />

            <h1>LISTA DE IMOVEIS</h1>
            <div class="page-content">
                <table border=1>
                    <thead>
                        <tr><th>Descricao</th><th>Categoria</th><th>Cidade</th><th>-</th><tr>
                    </thead>
                    <tbody>
                <%
                   try{
                       ImovelDAO cDAO = new ImovelDAO();
                       List<ImovelDTO> listaImovelDTO = cDAO.listarImoveis();
                       for(ImovelDTO imovelDTO : listaImovelDTO){
                           //out.println(imovelDTO);
                          out.print("<tr><td>"+imovelDTO.getDescricao()+"</td><td>"+imovelDTO.getCategoria().getDescricao()+"</td><td>"+
                                    imovelDTO.getCidade()+"</td><td><a href=\"pgImovel.jsp?id="+imovelDTO.getId()+"\">Editar</a></td></tr>");
                       }

                   }catch(Exception ex){
                       ex.printStackTrace();               
                       JOptionPane.showMessageDialog(null, "Erro: " + ex.toString());
                   }

                %>
                    </tbody>
                </table>
                    <div class="form-group"><button type="button" onclick="window.location.reload (true); window.location.href = 'pgImovel.jsp'">CRIAR NOVO</button>
                       <button type="button" onclick="window.location.reload (true); window.location.href = '../../View/Principal/inicio.jsp'">VOLTAR</button></div>
            </div>
        </div>
    </body>
</html>
