
package br.com.DAO;

import br.com.DTO.ImovelDTO;
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
public class ImovelDAO {
    
    private PreparedStatement ps;
    private ResultSet rs;
    private List<ImovelDTO> listaImoveis;
    
    public void inserirImovel(ImovelDTO imovel) throws ClassNotFoundException{
        String sql = "insert into imovel (descricao, valor, id_categoria, endereco, nr_endereco, bairro, cidade, uf, cep"+
                     (imovel.getId()!=null?" ,id":"")+") values (?,?,?,?,?,?,?,?,?"+
                     (imovel.getId()!=null?",?":"")+")";
 
        try(Connection conexao = new ConexaoDAO().conectarDB();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            
            ps.setString(1, imovel.getDescricao());
            ps.setBigDecimal(2, imovel.getValor());
            ps.setLong(3, imovel.getIdCategoria());
            ps.setString(4, imovel.getEndereco());
            ps.setString(5, imovel.getNumeroEndereco());
            ps.setString(6, imovel.getBairro());
            ps.setString(7, imovel.getCidade());
            ps.setString(8, imovel.getUf());
            ps.setString(9, imovel.getCep());
            if(imovel.getId()!=null){
                ps.setLong(10, imovel.getId());
            }
            
            ps.execute();
            ps.close();
            
        }catch(SQLException se){
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro de Banco: "+se);
        }
    }
    
    private List<ImovelDTO> listarImoveis (Long id) throws ClassNotFoundException{
       String sql = "select * from imovel";
       
       // Pega a clausula where caso tenha um parametro ID incluso.
       if(id != null){
           sql += " where id = ?";
       }
       
       listaImoveis = new ArrayList<>();
       
       try(Connection conexao = new ConexaoDAO().conectarDB();
           PreparedStatement ps = conexao.prepareStatement(sql)){
           
           if(id != null){
               ps.setLong(1,id);
           }
           rs = ps.executeQuery();
           
           while(rs.next()){              
               
               ImovelDTO imovelDTO = new ImovelDTO(rs.getLong("id"),
                                                   rs.getString("descricao"),
                                                   rs.getBigDecimal("valor"),
                                                   rs.getString("endereco"),
                                                   rs.getString("nr_endereco"),
                                                   rs.getString("bairro"),
                                                   rs.getString("cidade"),
                                                   rs.getString("uf"),
                                                   rs.getString("cep"),               
                                                   rs.getLong("id_categoria"),
                                                   (new CategoriaDAO()).buscarCategoria(rs.getLong("id_categoria")));
               
               listaImoveis.add(imovelDTO);  
           }
           
       }catch(SQLException ex){
           ex.printStackTrace();           
           JOptionPane.showMessageDialog(null, "Erro de Banco: "+ex);
       }
       
       return listaImoveis;
    }
    
    public List<ImovelDTO> listarImoveis() throws ClassNotFoundException{
        return listarImoveis(null);
    }
    
    public ImovelDTO buscarImovel(Long id) throws ClassNotFoundException{
        ImovelDTO imovel = new ImovelDTO();
        List<ImovelDTO> imoveis = listarImoveis(id);
        if(imoveis.size() == 1){
            imovel = imoveis.get(0);
        }
        return imovel;
    }
    
    
    public void atualizarImovel(ImovelDTO imovel) throws ClassNotFoundException{
        String sql = "update imovel set descricao = ?, valor = ?, id_categoria = ?, endereco = ?, nr_endereco = ?, bairro = ?, cidade = ?, uf = ?, cep = ? where id = ?";
 
        try(Connection conexao = new ConexaoDAO().conectarDB();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            
            ps.setString(1, imovel.getDescricao());
            ps.setBigDecimal(2, imovel.getValor());
            ps.setLong(3, imovel.getIdCategoria());
            ps.setString(4, imovel.getEndereco());
            ps.setString(5, imovel.getNumeroEndereco());
            ps.setString(6, imovel.getBairro());
            ps.setString(7, imovel.getCidade());
            ps.setString(8, imovel.getUf());
            ps.setString(9, imovel.getCep());
            ps.setLong(10, imovel.getId());
            
            ps.execute();
            ps.close();
            
        }catch(SQLException se){
            se.printStackTrace();           
           JOptionPane.showMessageDialog(null, "Erro de Banco: "+se);
        }
    }
    
    
    public void excluirImovel(Long id) throws ClassNotFoundException{
        String sql = "delete from imovel where id = ?";
        
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
