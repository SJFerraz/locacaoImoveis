/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.CRUD;

import br.com.DAO.ImovelDAO;
import br.com.DTO.CategoriaDTO;
import br.com.DTO.ImovelDTO;
import br.com.util.DateUtils;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sferr
 */
public class ImovelCRUDTest {
    
    private static final Long ID_TESTE = 1L;
    
    @Test
    public void testeCRUDImovel() throws ClassNotFoundException, InterruptedException{
        ImovelDAO  iDao = new ImovelDAO();
        System.out.println("-- TESTE DE CRUD PARA O MÓDULO IMOVEL --");
        System.out.println("Inserindo...");
        System.out.println("Criando a estrutura para a inserção no bd...");
        ImovelDTO imo = new ImovelDTO(ID_TESTE,
                                       "Casas Melobacana",
                                       new BigDecimal("1200.00"),
                                       "R. do Kiko",
                                       "21",
                                       "Brasilio",
                                       "Sao Paulo",
                                       "SP",
                                       "11003211",
                                       2L,
                                       new CategoriaDTO());
        System.out.println("Salvando no bd...");
        iDao.inserirImovel(imo);
        
        Thread.sleep(3000);
        System.out.println("Feito.");
        
        System.out.println("Mostrando os dados do banco...");
        
        ImovelDTO expected = imo;       
        ImovelDTO atual = iDao.buscarImovel(ID_TESTE);
        
        System.out.println("EXPECTED: "+expected);
        System.out.println("ATUAL: "+atual);
        
        System.out.println("RESULTADO: "+expected.equals(atual));
        
        assertEquals("INSERÇÃO.",expected, atual);
        
        System.out.println("------------------------------------------------");
        
        System.out.println("Alterando...");
        
        imo.setDescricao("Romario Eletro");
        imo.setEndereco("Rua Ronaldinho");
        imo.setNumeroEndereco("6000");
        
        System.out.println("Salvando alteração no BD...");
        iDao.atualizarImovel(imo);
        
        Thread.sleep(3000);
        System.out.println("Feito.");
        
        System.out.println("Mostrando os dados do banco...");
        
        expected = imo;       
        atual = iDao.buscarImovel(ID_TESTE);
        
        
        System.out.println("EXPECTED: "+expected);
        System.out.println("ATUAL: "+atual);
        
        System.out.println("RESULTADO: "+expected.equals(atual));
        
        assertEquals("ALTERACAO.",expected, atual);
        
        System.out.println("------------------------------------------------");
        
        System.out.println("Excluindo....");
        
        iDao.excluirImovel(ID_TESTE);
        
        Thread.sleep(3000);
        System.out.println("Feito.");
        
        System.out.println("Mostrando os dados do banco...");
        
        ImovelDTO unexpected = imo;       
        atual = iDao.buscarImovel(ID_TESTE);
        
        System.out.println("UNEXPECTED: "+unexpected);
        System.out.println("ATUAL: "+atual);
        
        System.out.println("RESULTADO: "+!unexpected.equals(atual));
        
        assertNotEquals("EXCLUSAO.",unexpected, atual);
    }
}
