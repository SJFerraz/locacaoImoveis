
package br.com.DAO;

import br.com.DTO.LocacaoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Ferraz
 */
public class LocacaoDAO {
    
    private ResultSet rs;
    private List<LocacaoDTO> listaLocacoes;
    
    public void inserirLocacao(LocacaoDTO locacao) throws ClassNotFoundException{
        String sql = "insert into locacao (descricao, valor, inicio_locacao, fim_locacao, id_cliente, id_imovel"+
                     (locacao.getId()!=null?" ,id":"")+") values (?,?,?,?,?,?"+
                     (locacao.getId()!=null?",?":"")+")";
        
        try(Connection conexao = new ConexaoDAO().conectarDB();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            
            ps.setString(1, locacao.getDescricao());
            ps.setBigDecimal(2, locacao.getValor());
            ps.setDate(3, locacao.getInicioLocacao());
            ps.setDate(4, locacao.getFimLocacao());
            ps.setLong(5, locacao.getIdCliente());
            ps.setLong(6, locacao.getIdImovel());
            if(locacao.getId()!=null){
                ps.setLong(7, locacao.getId());
            }
            ps.execute();
            
        }catch(SQLException se){
            se.printStackTrace();           
            JOptionPane.showMessageDialog(null, "Erro de Banco: "+se);
        }
    }
    
    private List<LocacaoDTO> listarLocacoes (Long id) throws ClassNotFoundException{
       String sql = "select * from locacao";
       
       // Pega a clausula where caso tenha um parametro ID incluso.
       if(id != null){
           sql += " where id = ?";
       }
       
       listaLocacoes = new ArrayList<>();
       
       try(Connection conexao = new ConexaoDAO().conectarDB();
           PreparedStatement ps = conexao.prepareStatement(sql)){
           
           if(id != null){
               ps.setLong(1,id);
           }
           rs = ps.executeQuery();
           
           while(rs.next()){
               LocacaoDTO locacaoDTO = new LocacaoDTO(rs.getLong("id"),
                                                   rs.getBigDecimal("valor"),
                                                   rs.getString("descricao"),
                                                   rs.getDate("inicio_locacao"),
                                                   rs.getDate("fim_locacao"),
                                                   rs.getLong("id_cliente"),              
                                                   rs.getLong("id_imovel"),
                                                  (new ClienteDAO()).buscarCliente(rs.getLong("id_cliente")),              
                                                  (new ImovelDAO()).buscarImovel(rs.getLong("id_imovel")));
               
               listaLocacoes.add(locacaoDTO);  
           }
           
       }catch(SQLException ex){
           ex.printStackTrace();           
           JOptionPane.showMessageDialog(null, "Erro de Banco: "+ex);
       }
       
       return listaLocacoes;
    }
    
    public List<LocacaoDTO> listarLocacoes() throws ClassNotFoundException{
        return listarLocacoes(null);
    }
    
    public LocacaoDTO buscarLocacao(Long id) throws ClassNotFoundException{
        LocacaoDTO locacao = new LocacaoDTO();
        List<LocacaoDTO> locacoes = listarLocacoes(id);
        if(locacoes.size() == 1){
            locacao = locacoes.get(0);
        }
        return locacao;
    }
    
    public void atualizarLocacao(LocacaoDTO locacao) throws ClassNotFoundException{
        String sql = "update locacao set descricao = ?, valor = ?, inicio_locacao = ?, fim_locacao = ?, id_cliente = ?, id_imovel = ? where id = ?";
        
        try(Connection conexao = new ConexaoDAO().conectarDB();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            
            ps.setString(1, locacao.getDescricao());
            ps.setBigDecimal(2, locacao.getValor());
            ps.setDate(3, locacao.getInicioLocacao());
            ps.setDate(4, locacao.getFimLocacao());
            ps.setLong(5, locacao.getIdCliente());
            ps.setLong(6, locacao.getIdImovel());
            ps.setLong(7, locacao.getId());
            
            ps.execute();
            
        }catch(SQLException se){
            se.printStackTrace();           
            JOptionPane.showMessageDialog(null, "Erro de Banco: "+se);
        }
    }
    
    public void excluirLocacao(Long id) throws ClassNotFoundException{
        String sql = "delete from locacao where id = ?";
        
        try(Connection conexao = new ConexaoDAO().conectarDB();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            
            ps.setLong(1, id);
            
            ps.execute();
            
        }catch(SQLException se){
            se.printStackTrace();           
            JOptionPane.showMessageDialog(null, "Erro de Banco: "+se);
        }
    }
}
