<%-- 
    Document   : pgImovel
    Created on : 8 de dez. de 2021, 19:41:10
    Author     : sferr
--%>

<%@page import="br.com.util.NumberUtils"%>
<%@page import="java.util.List"%>
<%@page import="br.com.DTO.CategoriaDTO"%>
<%@page import="br.com.DAO.CategoriaDAO"%>
<%@page import="br.com.util.DateUtils"%>
<%@page import="br.com.util.StringUtils"%>
<%@page import="br.com.DTO.ImovelDTO"%>
<%@page import="br.com.DAO.ImovelDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />
<!DOCTYPE html>

<html>
    <head>
        <title>Cadastro de Imovel</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <jsp:include page = "../../Includes/js-css.jsp"/>
    </head>
    <body>
        <div class="page-area">             
             <jsp:include page = "../../Includes/deslogar.jsp" />
             <h1>Cadastro de Imovel</h1>
             <div class="page-content">
                 <%
                     ImovelDAO iDAO = new ImovelDAO();
                     ImovelDTO imovel =  iDAO.buscarImovel(Long.parseLong(StringUtils.nvlStr(request.getParameter("id"),0)));
                     
                     CategoriaDAO cDAO = new CategoriaDAO();
                     List<CategoriaDTO> listaCategorias = cDAO.listarCategorias();
                     
                 %>
                 <form id="formulario" action="../../Controller/Imovel/submitImovel.jsp" method="POST">
                    
                    <input type="hidden" name="id" id="id" value="<%=StringUtils.nvl(imovel.getId())%>" />
                    
                    <div class="form-group">
                        <label>Descricao *</label><br/>
                        <textarea name="descricao" id="descricao" required rows="5" cols="71" maxlength="355"><%=StringUtils.nvl(imovel.getDescricao())%></textarea><br/><br/>
                    </div>
                    
                    <div class="form-group">
                    <label>Valor *</label><br/>
                    <input type="text" name="valor" id="valor" required value="<%=StringUtils.nvl(NumberUtils.decimalToString(imovel.getValor()))%>" maxlength="12" size="12"/><br/><br/>
                    </div>
                    
                    <div class="form-group">
                    <label>Categoria *</label><br/>
                    <select name="categoria" id="categoria" >
                        <option value="">-- Escolha uma Categoria --</option>
                    <% for(CategoriaDTO cat : listaCategorias){ %>
                    <option value="<%=StringUtils.nvl(cat.getId())%>" <%=((imovel.getCategoria() != null && cat.getId()==imovel.getCategoria().getId())?"selected":"")%> ><%=StringUtils.nvl(cat.getDescricao())%></option>
                    <% }%>    
                    </select><br/><br/>
                    </div>
                    
                    <div class="form-group">
                    <label>CEP</label><br/>
                    <input type="text" name="cep" id="cep" onBlur="javascript:buscaDadosPorCep(this.value);" value="<%=StringUtils.nvl(imovel.getCep())%>" size="11" /><br/><br/>
                    </div>
                    
                    <div class="form-group">
                    <label>Endereço</label><br/>
                    <textarea name="endereco" id="endereco" rows="5" cols="71" maxlength="355"><%=StringUtils.nvl(imovel.getEndereco())%></textarea><br/><br/>
                    </div>
                    
                    <div class="form-group">
                    <label>Número</label><br/>
                    <input type="text" name="numeroEndereco" id="numeroEndereco" value="<%=StringUtils.nvl(imovel.getNumeroEndereco())%>" maxlength="8" size="8"/><br/><br/>
                    </div>
                    
                    <div class="form-group">
                    <label>Bairro</label><br/>
                    <input type="text" name="bairro" id="bairro" value="<%=StringUtils.nvl(imovel.getBairro())%>"  maxlength="50" size="30"/><br/><br/>
                    </div>
                    
                    <div class="form-group">
                    <label>Cidade</label><br/>
                    <input type="text" name="cidade" id="cidade" value="<%=StringUtils.nvl(imovel.getCidade())%>"  maxlength="50" size="25"/><br/><br/>
                    </div>
                    
                    <div class="form-group">
                    <label>UF</label><br/>
                    <input type="text" name="uf" id="uf" value="<%=StringUtils.nvl(imovel.getUf())%>"  maxlength="2" size="2" onkeyup="this.value = this.value.toUpperCase();" /><br/><br/>
                    </div>
                    
                    <div class="form-group">
                    <button type="submit">CONFIRMAR</button>
                    <%  if(imovel.getId() !=  null){ %>
                        <button type="button" onClick="javascript:toDelete()">EXCLUIR</button>
                    <% }%> 
                    <button type="button" onclick="window.location.reload (true); window.location.href = 'listarImoveis.jsp'">VOLTAR</button>
                    </div>
                 </form>
                    
             </div>
        </div>      <script>
                          
                         function toDelete(){
                             console.log("passei.");
                             if(confirm("Deseja deletar este Imovel ?")){
                                 formulario = document.getElementById("formulario");
                                 formulario.action = '../../Controller/Imovel/excluirImovel.jsp';
                                 formulario.submit();
                             }
                         }
                         
                    </script>
                    
                    <script type="text/javascript">
                        
                        $(document).ready(function(){
                            $('#cep').mask("99.999-999");
                        });
                         
                    </script>
                    
                    <script type="text/javascript" src="../../Scripts/webserviceCEP.js"></script>
                    
    </body>
</html>
