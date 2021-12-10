<%-- 
    Document   : listarClientes
    Created on : 8 de dez. de 2021, 18:43:32
    Author     : sferr
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.com.DTO.ClienteDTO"%>
<%@page import="br.com.DAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        <jsp:include page = "../../Includes/js-css.jsp"/>
    </head>
    <body>
        <div class="page-area">
            <jsp:include page = "../../Includes/mensagemSistema.jsp" />
            <jsp:include page = "../../Includes/deslogar.jsp" />

            <h1>LISTA DE CLIENTES</h1>
            <div class="page-content">
                <table border=1>
                    <thead>
                        <tr><th>Nome</th><th>CPF</th><th>Cidade</th><th>-</th><tr>
                    </thead>
                    <tbody>

                <%
                   try{
                       ClienteDAO cDAO = new ClienteDAO();
                       List<ClienteDTO> listaClienteDTO = cDAO.listarClientes();
                       for(ClienteDTO clienteDTO : listaClienteDTO){
                           //out.println(clienteDTO);
                          out.print("<tr><td>"+clienteDTO.getNome()+"</td><td>"+clienteDTO.getCpf()+"</td><td>"+
                                    clienteDTO.getCidade()+"</td><td><a href=\"pgCliente.jsp?id="+clienteDTO.getId()+"\">Editar</a></td></tr>");
                       }

                   }catch(Exception ex){
                       ex.printStackTrace();               
                       JOptionPane.showMessageDialog(null, "Erro: " + ex.toString());
                   }

                %>
                    </tbody>
                </table>
                <p><button type="button" onclick="window.location.reload (true); window.location.href = 'pgCliente.jsp'">Criar Novo</button>
                   <button type="button" onclick="window.location.reload (true); window.location.href = '../../View/Principal/inicio.jsp'">VOLTAR</button></p>
            </div>
        </div>
    </body>
</html>
