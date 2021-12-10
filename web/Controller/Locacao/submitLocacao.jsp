<%@page import="br.com.util.NumberUtils"%>
<%@page import="br.com.util.StringUtils"%>
<%@page import="br.com.DAO.LocacaoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.com.util.DateUtils"%>
<%@page import="br.com.DTO.LocacaoDTO"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""  %>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />
<%
    // Limpando mensagens do estado de sessão  
    session.removeAttribute("mensagemSistema");
    session.removeAttribute("statusMsgSistema");

    try {
        LocacaoDTO locacaoDTO = new LocacaoDTO();
        request.setCharacterEncoding("UTF-8");

        // Carregando o objeto com os dados do form
        if (request.getParameter("id").trim() != null && !"".equals(request.getParameter("id").trim())) {
            locacaoDTO.setId(Long.parseLong(request.getParameter("id")));
        }

        locacaoDTO.setDescricao(request.getParameter("descricao"));
        locacaoDTO.setValor((request.getParameter("valor")!= null) ? NumberUtils.stringToDecimal(request.getParameter("valor")):null);
        locacaoDTO.setInicioLocacao(DateUtils.stringToDateSql(request.getParameter("inicioLocacao")));
        locacaoDTO.setFimLocacao(DateUtils.stringToDateSql(request.getParameter("fimLocacao")));
        locacaoDTO.setIdCliente(Long.parseLong(request.getParameter("cliente")));
        locacaoDTO.setIdImovel(Long.parseLong(request.getParameter("imovel")));

        LocacaoDAO locacaoDAO = new LocacaoDAO();

        // Se id for preenchido o sistema ira fazer update, senão, criará uma nova locação
        if (locacaoDTO.getId() == null) {
            locacaoDAO.inserirLocacao(locacaoDTO);
            session.setAttribute("mensagemSistema", "Locação feita com sucesso");
        } else {                    
            locacaoDAO.atualizarLocacao(locacaoDTO);          
            session.setAttribute("mensagemSistema", "Locação atualizada com sucesso");
        }

        session.setAttribute("statusMsgSistema", "1");

    } catch (Exception ex) {
        ex.printStackTrace();

        // Seta mensagem de erro do exception
        session.setAttribute("mensagemSistema", "Erro: " + ex.toString());
        session.setAttribute("statusMsgSistema", "2");
    }

    // Redireciona para lista de locações
    response.sendRedirect("../../View/Locacao/listarLocacoes.jsp");

%>