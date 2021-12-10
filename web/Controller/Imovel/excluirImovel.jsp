<%@page import="br.com.DAO.ImovelDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />

<%
     // Limpando mensagem em estado de sessão
    session.removeAttribute("mensagemSistema");
    session.removeAttribute("statusMsgSistema");

    try{
        ImovelDAO cDAO = new ImovelDAO();
        cDAO.excluirImovel(Long.parseLong(request.getParameter("id")));

         // Setando mensagem de sucesso de exclusao
        session.setAttribute("mensagemSistema","Imovel excluido com sucesso");
        session.setAttribute("statusMsgSistema","1");

    }catch(Exception e){
        e.printStackTrace();

        // Setando mensagem de sucesso de exclusao
        session.setAttribute("mensagemSistema","Erro: "+e);
        session.setAttribute("statusMsgSistema","2");
    }

    // Redirecionando para lista de imoveis
    response.sendRedirect("../../View/Imovel/listarImoveis.jsp");            
%>
