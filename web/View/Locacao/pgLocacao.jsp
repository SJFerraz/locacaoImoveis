<%-- 
    Document   : pgLocacao
    Created on : 8 de dez. de 2021, 19:41:10
    Author     : sferr
--%>

<%@page import="br.com.util.NumberUtils"%>
<%@page import="br.com.DTO.ImovelDTO"%>
<%@page import="br.com.DAO.ImovelDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.DTO.ClienteDTO"%>
<%@page import="br.com.DAO.ClienteDAO"%>
<%@page import="br.com.util.DateUtils"%>
<%@page import="br.com.util.StringUtils"%>
<%@page import="br.com.DTO.LocacaoDTO"%>
<%@page import="br.com.DAO.LocacaoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />
<!DOCTYPE html>

<html>
    <head>
        <title>Cadastro de Locacao</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <jsp:include page = "../../Includes/js-css.jsp"/>
    </head>
    <body>
        <div class="page-area">             
             <jsp:include page = "../../Includes/deslogar.jsp" />
             <h1>Cadastro de Locacao</h1>
             <div class="page-content">
                 <%
                     LocacaoDAO lDAO = new LocacaoDAO();
                     LocacaoDTO locacao =  lDAO.buscarLocacao(Long.parseLong(StringUtils.nvlStr(request.getParameter("id"),0)));
                     
                     ClienteDAO cDAO = new ClienteDAO();
                     List<ClienteDTO> listaClientes = cDAO.listarClientes();
                     
                     ImovelDAO iDAO = new ImovelDAO();
                     List<ImovelDTO> listaImoveis = iDAO.listarImoveis();                     
                 %>
                 <form id="formulario" action="../../Controller/Locacao/submitLocacao.jsp" method="POST">
                    
                    <input type="hidden" name="id" id="id" value="<%=StringUtils.nvl(locacao.getId())%>" />
                    
                    
                    <div class="form-group">
                    <label>Cliente que irá locar *</label><br/>
                    <select name="cliente" id="cliente"  required>
                        <option value="">-- Escolha um Cliente --</option>
                    <% for(ClienteDTO cli : listaClientes){ %>
                        <option value="<%=StringUtils.nvl(cli.getId())%>" <%=((locacao.getCliente() != null && cli.getId()==locacao.getCliente().getId())?"selected":"")%> ><%=StringUtils.nvl(cli.getNome())+" - "+StringUtils.nvl(cli.getCpf())%></option>
                    <% }%>    
                    </select><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>Imóvel à locar*</label><br/>
                    <select name="imovel" id="imovel" required>
                        <option value="">-- Escolha um Imóvel --</option>
                    <% for(ImovelDTO imo : listaImoveis){ %>
                        <option value="<%=StringUtils.nvl(imo.getId())%>" <%=((locacao.getImovel() != null && imo.getId()==locacao.getImovel().getId())?"selected":"")%> ><%=StringUtils.nvl(imo.getDescricao())+" - "+StringUtils.nvl(imo.getCidade())%></option>
                    <% }%>    
                    </select><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>Descricao da locação *</label><br/>
                    <textarea name="descricao" id="descricao" rows="3" cols="100" maxlength="300" required ><%=StringUtils.nvl(locacao.getDescricao())%></textarea><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>Data Inicio Locação *</label><br/>
                    <input type="date" name="inicioLocacao" id="inicioLocacao" required value="<%=StringUtils.nvl(DateUtils.dateToString(locacao.getInicioLocacao(),"yyyy-MM-dd"))%>"/><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>Data Fim Locação</label><br/>
                    <input type="date" name="fimLocacao" id="fimLocacao" value="<%=StringUtils.nvl(DateUtils.dateToString(locacao.getFimLocacao(),"yyyy-MM-dd"))%>"/><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>Valor da locacao</label><br/>
                    <input type="text" name="valor" id="valor" maxlength="13" size="13" value="<%=StringUtils.nvl(NumberUtils.decimalToString(locacao.getValor()))%>"/><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <button type="submit">CONFIRMAR</button>
                    <%  if(locacao.getId() !=  null){ %>
                        <button type="button" onClick="javascript:toDelete()">EXCLUIR</button>
                    <% }%> 
                    <button type="button" onclick="window.location.reload (true); window.location.href = 'listarLocacoes.jsp'">VOLTAR</button>
                    </div>
                    
                 </form>
             </div>
        </div>      <script>
                          
                         function toDelete(){
                             console.log("passei.");
                             if(confirm("Deseja deletar este Locacao ?")){
                                 formulario = document.getElementById("formulario");
                                 formulario.action = '../../Controller/Locacao/excluirLocacao.jsp';
                                 formulario.submit();
                             }
                         }
                         
                    </script>
                    <jsp:include page = "../../Includes/js-css.jsp"/>
    </body>
</html>
