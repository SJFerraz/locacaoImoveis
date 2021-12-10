/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.CRUD;

import br.com.DAO.LocacaoDAO;
import br.com.DTO.ClienteDTO;
import br.com.DTO.ImovelDTO;
import br.com.DTO.LocacaoDTO;
import br.com.util.DateUtils;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sferr
 */
public class LocacaoCRUDTest {
    
    private static final Long ID_TESTE = 1L;
    
    @Test
    public void testeCRUDLocacao() throws ClassNotFoundException, InterruptedException{
        LocacaoDAO  lDAO = new LocacaoDAO();
        System.out.println("-- TESTE DE CRUD PARA O MÓDULO LOCAÇÃO --");
        System.out.println("Inserindo...");
        System.out.println("Criando a estrutura para a inserção no bd...");
        LocacaoDTO loc = new LocacaoDTO(ID_TESTE,
                                       new BigDecimal("1200.00"),
                                       "Boa moradia",
                                       DateUtils.stringToDateSql("2021-12-21"),
                                       DateUtils.stringToDateSql("2022-01-01"),
                                       2L,
                                       2L,
                                       new ClienteDTO(),
                                       new ImovelDTO());
        System.out.println("Salvando no bd...");
        lDAO.inserirLocacao(loc);
        
        Thread.sleep(3000);
        System.out.println("Feito.");
        
        System.out.println("Mostrando os dados do banco...");
        
        LocacaoDTO expected = loc;       
        LocacaoDTO atual = lDAO.buscarLocacao(ID_TESTE);
        
        System.out.println("EXPECTED: "+expected);
        System.out.println("ATUAL: "+atual);
        
        System.out.println("RESULTADO: "+expected.equals(atual));
        
        assertEquals("INSERÇÃO.",expected, atual);
        
        System.out.println("------------------------------------------------");
        
        System.out.println("Alterando...");
        
        loc.setDescricao("agora ta mais ou menos");
        loc.setIdImovel(3L);
        
        System.out.println("Salvando alteração no BD...");
        lDAO.atualizarLocacao(loc);
        
        Thread.sleep(3000);
        System.out.println("Feito.");
        
        System.out.println("Mostrando os dados do banco...");
        
        expected = loc;       
        atual = lDAO.buscarLocacao(ID_TESTE);
        
        
        System.out.println("EXPECTED: "+expected);
        System.out.println("ATUAL: "+atual);
        
        System.out.println("RESULTADO: "+expected.equals(atual));
        
        assertEquals("ALTERACAO.",expected, atual);
        
        System.out.println("------------------------------------------------");
        
        System.out.println("Excluindo....");
        
        lDAO.excluirLocacao(ID_TESTE);
        
        Thread.sleep(3000);
        System.out.println("Feito.");
        
        System.out.println("Mostrando os dados do banco...");
        
        LocacaoDTO unexpected = loc;       
        atual = lDAO.buscarLocacao(ID_TESTE);
        
        System.out.println("UNEXPECTED: "+unexpected);
        System.out.println("ATUAL: "+atual);
        
        System.out.println("RESULTADO: "+!unexpected.equals(atual));
        
        assertNotEquals("EXCLUSAO.",unexpected, atual);
    }
}
