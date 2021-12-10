/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.CRUD;

import br.com.DAO.ClienteDAO;
import br.com.DTO.ClienteDTO;
import br.com.util.DateUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sferr
 */
public class ClienteCRUDTest {
    
    private static final Long ID_TESTE = 1L;
    
    @Test
    public void testeCRUDCliente() throws ClassNotFoundException, InterruptedException{
        ClienteDAO  cDAO = new ClienteDAO();
        System.out.println("-- TESTE DE CRUD PARA O MÓDULO CLIENTE --");
        System.out.println("Inserindo...");
        System.out.println("Criando a estrutura para a inserção no bd...");
        ClienteDTO cli = new ClienteDTO(ID_TESTE,
                                       "Afranio lucas",
                                       "13210022200",
                                       DateUtils.stringToDateSql("1990-01-01"),
                                       "R. Martins",
                                       "132",
                                       "Sao joao",
                                       "Belo Horizonte",
                                       "MG",
                                       "31000222");
        System.out.println("Salvando no bd...");
        cDAO.inserirCliente(cli);
        
        Thread.sleep(3000);
        System.out.println("Feito.");
        
        System.out.println("Mostrando os dados do banco...");
        
        ClienteDTO expected = cli;       
        ClienteDTO atual = cDAO.buscarCliente(ID_TESTE);
        
        System.out.println("EXPECTED: "+expected);
        System.out.println("ATUAL: "+atual);
        
        System.out.println("RESULTADO: "+expected.equals(atual));
        
        assertEquals("INSERÇÃO.",expected, atual);
        
        System.out.println("------------------------------------------------");
        
        System.out.println("Alterando...");
        
        cli.setNome("Bill Lammas");
        cli.setEndereco("Rua Capixaba");
        cli.setNumeroEndereco("123");
        
        System.out.println("Salvando alteração no BD...");
        cDAO.atualizarCliente(cli);
        
        Thread.sleep(3000);
        System.out.println("Feito.");
        
        System.out.println("Mostrando os dados do banco...");
        
        expected = cli;       
        atual = cDAO.buscarCliente(ID_TESTE);
        
        
        System.out.println("EXPECTED: "+expected);
        System.out.println("ATUAL: "+atual);
        
        System.out.println("RESULTADO: "+expected.equals(atual));
        
        assertEquals("ALTERACAO.",expected, atual);
        
        System.out.println("------------------------------------------------");
        
        System.out.println("Excluindo....");
        
        cDAO.excluirCliente(ID_TESTE);
        
        Thread.sleep(3000);
        System.out.println("Feito.");
        
        System.out.println("Mostrando os dados do banco...");
        
        ClienteDTO unexpected = cli;       
        atual = cDAO.buscarCliente(ID_TESTE);
        
        System.out.println("UNEXPECTED: "+unexpected);
        System.out.println("ATUAL: "+atual);
        
        System.out.println("RESULTADO: "+!unexpected.equals(atual));
        
        assertNotEquals("EXCLUSAO.",unexpected, atual);
    }
}
