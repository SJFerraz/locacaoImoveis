<%@page import="br.com.util.StringUtils"%>
<%@page import="br.com.DAO.ClienteDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.com.util.DateUtils"%>
<%@page import="br.com.DTO.ClienteDTO"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""  %>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />
<%
    // Limpando mensagens do estado de sessão  
    session.removeAttribute("mensagemSistema");
    session.removeAttribute("statusMsgSistema");

    try {
        ClienteDTO clienteDTO = new ClienteDTO();
        request.setCharacterEncoding("UTF-8");

        // Carregando o objeto com os dados do form
        if (request.getParameter("id").trim() != null && !"".equals(request.getParameter("id").trim())) {
            clienteDTO.setId(Long.parseLong(request.getParameter("id")));
        }
        
        clienteDTO.setNome(request.getParameter("nome"));
        clienteDTO.setCpf(StringUtils.tiraMascara(request.getParameter("cpf")));
        clienteDTO.setDtNascimento(DateUtils.stringToDateSql(request.getParameter("dtNascimento")));
        clienteDTO.setEndereco(request.getParameter("endereco"));
        clienteDTO.setNumeroEndereco(request.getParameter("numeroEndereco"));
        clienteDTO.setBairro(request.getParameter("bairro"));
        clienteDTO.setCidade(request.getParameter("cidade"));
        clienteDTO.setUf(request.getParameter("uf"));
        clienteDTO.setCep(StringUtils.tiraMascara(request.getParameter("cep")));

        ClienteDAO clienteDAO = new ClienteDAO();

        // Se id for preenchido o sistema ira fazer update, senão, criará um novo cliente
        if (clienteDTO.getId() == null) {
            clienteDAO.inserirCliente(clienteDTO);
            session.setAttribute("mensagemSistema", "Cliente criado com sucesso");
        } else {                   
            clienteDAO.atualizarCliente(clienteDTO);
            session.setAttribute("mensagemSistema", "Cliente alterado com sucesso");
        }

        session.setAttribute("statusMsgSistema", "1");

    } catch (Exception ex) {
        ex.printStackTrace();

        // Seta mensagem de erro do exception
        session.setAttribute("mensagemSistema", "Erro: " + ex.toString());
        session.setAttribute("statusMsgSistema", "2");
    }

   // Redireciona para lista de clientes
   response.sendRedirect("../../View/Cliente/listarClientes.jsp");

%>