<%-- 
    Document   : pgCliente
    Created on : 8 de dez. de 2021, 19:41:10
    Author     : sferr
--%>

<%@page import="br.com.util.DateUtils"%>
<%@page import="br.com.util.StringUtils"%>
<%@page import="br.com.DTO.ClienteDTO"%>
<%@page import="br.com.DAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />
<!DOCTYPE html>

<html>
    <head>
        <title>Cadastro de Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <jsp:include page = "../../Includes/js-css.jsp"/>
    </head>
    <body>
        <div class="page-area">
             <jsp:include page = "../../Includes/deslogar.jsp" />
             <h1>Cadastro de Cliente</h1>
             <div class="page-content">
                 <%
                     ClienteDAO cDAO = new ClienteDAO();
                     ClienteDTO cliente =  cDAO.buscarCliente(Long.parseLong(StringUtils.nvlStr(request.getParameter("id"),0)));
                 %>
                 <form id="formulario" action="../../Controller/Cliente/submitCliente.jsp" method="POST">
                    
                    <input type="hidden" name="id" id="id" value="<%=StringUtils.nvl(cliente.getId())%>" />
                    
                    <div class="form-group">
                    <label>Nome *</label><br/>
                    <input type="text" name="nome" id="nome" required value="<%=StringUtils.nvl(cliente.getNome())%>" maxlength="250" size="45" /><br/><br/>
                    </div>
                    
                    <div class="form-group">
                    <label>CPF *</label><br/>
                    <input type="text" name="cpf" id="cpf" required value="<%=StringUtils.nvl(cliente.getCpf())%>" size="18" /><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>Data Nascimento *</label><br/>
                    <input type="date" name="dtNascimento" required id="dtNascimento" value="<%=StringUtils.nvl(DateUtils.dateToString(cliente.getDtNascimento(),"yyyy-MM-dd"))%>"/><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>CEP</label><br/>
                    <input type="text" name="cep" id="cep" onBlur="javascript:buscaDadosPorCep(this.value);" value="<%=StringUtils.nvl(cliente.getCep())%>" size="10"/><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>Endereço</label><br/>
                    <textarea name="endereco" id="endereco" rows="5" cols="71" maxlength="355" ><%=StringUtils.nvl(cliente.getEndereco())%></textarea><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>Número</label><br/>
                    <input type="text" name="numeroEndereco" id="numeroEndereco" value="<%=StringUtils.nvl(cliente.getNumeroEndereco())%>" maxlength="8" size="8"/><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>Bairro</label><br/>
                    <input type="text" name="bairro" id="bairro" value="<%=StringUtils.nvl(cliente.getBairro())%>" maxlength="50" size="30"/><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>Cidade</label><br/>
                    <input type="text" name="cidade" id="cidade" value="<%=StringUtils.nvl(cliente.getCidade())%>"  maxlength="50" size="25"/><br/><br/>
                    </div>
                    
                    
                    <div class="form-group">
                    <label>UF</label><br/>
                    <input type="text" name="uf" id="uf" value="<%=StringUtils.nvl(cliente.getUf())%>"  maxlength="2" size="2" onkeyup="this.value = this.value.toUpperCase();"/><br/><br/>
                    </div>
                    
                    <div class="form-group">
                    <button type="submit">CONFIRMAR</button>
                    <%  if(cliente.getId() !=  null){ %>
                        <button type="button" onClick="javascript:toDelete()">EXCLUIR</button>
                    <% }%> 
                    <button type="button" onclick="window.location.reload (true); window.location.href = 'listarClientes.jsp'">VOLTAR</button>
                    </div>
                 </form>
             </div>
        </div>      <script type="text/javascript">
                          
                         function toDelete(){
                             console.log("passei.");
                             if(confirm("Deseja deletar este Cliente ?")){
                                 formulario = document.getElementById("formulario");
                                 formulario.action = '../../Controller/Cliente/excluirCliente.jsp';
                                 formulario.submit();
                             }
                         }                       
                         
                         
                    </script>
                    
                    <script type="text/javascript">
                        
                        $(document).ready(function(){
                            $('#cep').mask("99.999-999");
                            $('#cpf').mask("999.999.999-99");
                            //$('#uf').mask("aa");
                         });
                         
                    </script>
                    
                    <script type="text/javascript" src="../../Scripts/webserviceCEP.js"></script>
    </body>
</html>
