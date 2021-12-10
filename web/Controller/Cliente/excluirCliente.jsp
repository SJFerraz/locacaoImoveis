<%@page import="br.com.DAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />

<%
    // Limpando mensagem em estado de sessão
    session.removeAttribute("mensagemSistema");
    session.removeAttribute("statusMsgSistema");

    try{
        ClienteDAO cDAO = new ClienteDAO();
        cDAO.excluirCliente(Long.parseLong(request.getParameter("id")));

        // Setando mensagem de sucesso de exclusao
        session.setAttribute("mensagemSistema","Cliente excluido com sucesso");
        session.setAttribute("statusMsgSistema","1");

    }catch(Exception e){
        e.printStackTrace();

        // Setando mensagem de sucesso de exclusao
        session.setAttribute("mensagemSistema","Erro: "+e);
        session.setAttribute("statusMsgSistema","2");
    }

    // Redirecionando para lista de clientes
    response.sendRedirect("../../View/Cliente/listarClientes.jsp");            
%>

