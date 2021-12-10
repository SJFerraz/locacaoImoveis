<%@page import="javax.swing.JOptionPane"%>
<%
    String mensagemSistema = (String) session.getAttribute("mensagemSistema");
    String statusMsgSistema = (String) session.getAttribute("statusMsgSistema");
    
    
    if(mensagemSistema != null){
  %>
  <div class="alert <%=(statusMsgSistema.equals("2")?"red-message":"green-alert")%>"><%=mensagemSistema%><a href="" onClick="fechaCaixaMsg();" id="simboloFechar" class="simboloFechar">X</a></div>
  <script>
      function fecharCaixaMsg(){
          document.getElementById("simboloFechar").hidden;
      }
  </script>
  <%
    }
    session.removeAttribute("mensagemSistema");
    session.removeAttribute("statusMsgSistema");
%>