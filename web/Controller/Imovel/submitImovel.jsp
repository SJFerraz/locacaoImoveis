<%@page import="br.com.util.NumberUtils"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="br.com.util.StringUtils"%>
<%@page import="br.com.DAO.ImovelDAO"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.com.util.DateUtils"%>
<%@page import="br.com.DTO.ImovelDTO"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""  %>
<jsp:directive.include file = "../../Includes/validaSessao.jsp" />
<%
  // Limpando mensagens do estado de sessão  
  session.removeAttribute("mensagemSistema");
  session.removeAttribute("statusMsgSistema");

  try {
        ImovelDTO imovelDTO = new ImovelDTO();
        request.setCharacterEncoding("UTF-8");

        // Carregando o objeto com os dados do form
        if (request.getParameter("id").trim() != null && !"".equals(request.getParameter("id").trim())) {
            imovelDTO.setId(Long.parseLong(request.getParameter("id")));
        }

        imovelDTO.setDescricao(request.getParameter("descricao"));
        imovelDTO.setValor(NumberUtils.stringToDecimal(request.getParameter("valor")));
        imovelDTO.setIdCategoria(Long.parseLong(request.getParameter("categoria")));
        imovelDTO.setEndereco(request.getParameter("endereco"));
        imovelDTO.setNumeroEndereco(request.getParameter("numeroEndereco"));
        imovelDTO.setBairro(request.getParameter("bairro"));
        imovelDTO.setCidade(request.getParameter("cidade"));
        imovelDTO.setUf(request.getParameter("uf"));
        imovelDTO.setCep(StringUtils.tiraMascara(request.getParameter("cep")));

        ImovelDAO imovelDAO = new ImovelDAO();

        // Se id for preenchido o sistema ira fazer update, senão, criará um novo imovel
        if (imovelDTO.getId() == null) {
            imovelDAO.inserirImovel(imovelDTO);
            session.setAttribute("mensagemSistema", "Imovel criado com sucesso");
        } else {                  
            imovelDAO.atualizarImovel(imovelDTO);
            session.setAttribute("mensagemSistema", "Imovel alterado com sucesso");
        }                

        session.setAttribute("statusMsgSistema", "1");

    } catch (Exception ex) {
        ex.printStackTrace();

        // Seta mensagem de erro do exception
        session.setAttribute("mensagemSistema", "Erro: " + ex.toString());
        session.setAttribute("statusMsgSistema", "2");
    }

    response.sendRedirect("../../View/Imovel/listarImoveis.jsp");
%>