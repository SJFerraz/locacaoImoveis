
package br.com.DAO;

import br.com.DTO.CategoriaDTO;
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
public class CategoriaDAO {
    
    private ResultSet rs;
    private List<CategoriaDTO> listaCategorias;
    
    private List<CategoriaDTO> listarCategorias (Long id) throws ClassNotFoundException{
       String sql = "select * from categoria";
       
       // Pega a clausula where caso tenha um parametro ID incluso.
       if(id != null){
           sql += " where id = ?";
       }
       
       listaCategorias = new ArrayList<>();
       
       try(Connection conexao = new ConexaoDAO().conectarDB();
           PreparedStatement ps = conexao.prepareStatement(sql)){
           
           if(id != null){
               ps.setLong(1,id);
           }
           rs = ps.executeQuery();
           
           while(rs.next()){              
               
               CategoriaDTO categoriaDTO = new CategoriaDTO(rs.getLong("id"),
                                                            rs.getString("descricao"));
               
               listaCategorias.add(categoriaDTO);  
           }
           
       }catch(SQLException ex){
           ex.printStackTrace();
           JOptionPane.showMessageDialog(null, "Erro de Banco: "+ex);
       }
       
       return listaCategorias;
    }
    
    public List<CategoriaDTO> listarCategorias() throws ClassNotFoundException{
        return listarCategorias(null);
    }
    
    public CategoriaDTO buscarCategoria(Long id) throws ClassNotFoundException{
        CategoriaDTO categoria = new CategoriaDTO();
        List<CategoriaDTO> categorias = listarCategorias(id);
        if(categorias.size() == 1){
            categoria = categorias.get(0);
        }
        return categoria;
    }
}
