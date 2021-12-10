
<form id="deslogarSistema" action="../../Controller/Sessao/deslogarSistema.jsp" method="post">
     <input type="hidden" value="SIM" name="deslogar"/>
     <a onclick="javascript:confirmaLogoff()" href="#" >Deslogar</a>
</form>
<script>
    function confirmaLogoff(){
        if(confirm("Deseja deslogar-se do sistema?")){
            let formDeslogar = document.getElementById("deslogarSistema");            
            formDeslogar.submit();
        }
    }    
</script>
