function carregaCampos() {
    campoEndereco = document.getElementById("endereco");
    campoNumero = document.getElementById("numeroEndereco");
    campoBairro = document.getElementById("bairro");
    campoCidade = document.getElementById("cidade");
    campoUF = document.getElementById("uf");
}

// Função para retornar os dados em callback após consulta.
function retornaDadosCep(dados) {
    if (!("erro") in dados || dados.erro !== true) {
        campoEndereco.value = dados.logradouro;
        campoNumero.value = "";
        campoBairro.value = dados.bairro;
        campoCidade.value = dados.localidade;
        campoUF.value = dados.uf;
    } else {
        console.log(dados);
        apagaDadosCep();
        campoEndereco.value = "ERRO EM CONSULTA";
    }
}

// Função que apaga os dados caso o CEP não está correto
function apagaDadosCep() {
    campoEndereco.value = "";
    campoNumero.value = "";
    campoBairro.value = "";
    campoCidade.value = "";
    campoUF.value = "";
}


// Função para fazer todo o procedimento da busca de dados por CPF
function buscaDadosPorCep(cep) {
    console.log("executei..");
    var cep = cep.replace(/\D/g, '');
    // Carrega os campos antes de tomar as decisoes
    carregaCampos();
    //Se CEP está com informação após remoção de caracteres.
    if (cep != null) {
        // informa-se  a expressão regular para validar o cep informado.
        regexValidador = /^[0-9]{8}$/;
        if (regexValidador.test(cep)) {

            // Coloca reticencias para sinalizar busca de dados até encontra-los.
            campoEndereco.value = "...";
            campoEndereco.value = "...";
            campoNumero.value = "";
            campoCidade.value = "...";
            campoUF.value = "...";
            console.log("passei1");
            //  Roda o  script de webservice na pagina.
            var scriptCep = document.createElement('script');
            scriptCep.src = 'https://viacep.com.br/ws/' + cep + '/json/?callback=retornaDadosCep';
            document.body.appendChild(scriptCep);
            console.log("passei2");
        } else {
            // Cep não passou pela validação de expressão regular
            apagaDadosCep();
            campoEndereco.value = "CEP INVÁLIDO";
        }
    } else {
        // Cep sem informações
        apagaDadosCep();
    }
    console.log("fim");
}