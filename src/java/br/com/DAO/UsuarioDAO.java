/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import br.com.util.StringUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author sferr
 */
public class UsuarioDAO {
    private ResultSet rs;
    private List<UsuarioDTO> listaUsuarios;
    
    private List<UsuarioDTO> listarUsuarios (Long id, String loginUsuario) throws ClassNotFoundException{
       String sql = "select * from usuario";
       
       String where= null;
       // Pega a clausula where caso tenha um parametro ID ou LOGIN_USUARIO incluso.
       if(id != null){
           where = "id = ?";
       }
       if(loginUsuario != null){
           if(where != null){
               where += "and ";
           }
           where = StringUtils.nvlStr(where)+"login_usuario = ?";
       }
       
       if(where != null){
           sql += " where "+where;
       }
       
       listaUsuarios = new ArrayList<>();
       
       
       try(Connection conexao = new ConexaoDAO().conectarDB();
           PreparedStatement ps = conexao.prepareStatement(sql)){
           
           if(id != null){
               ps.setLong(1,id);
           }
           
           if(loginUsuario != null){
               int indiceLU = 1;
               if(id != null){
                   indiceLU = 2;
               }
               ps.setString(indiceLU, loginUsuario);               
           }
           rs = ps.executeQuery();
           
           while(rs.next()){              
               
               UsuarioDTO usuarioDTO = new UsuarioDTO(rs.getLong("id"),
                                                      rs.getString("nome"),
                                                      rs.getString("login_usuario"),
                                                            rs.getString("senha"));
               
               listaUsuarios.add(usuarioDTO);  
           }
           
       }catch(SQLException ex){           
           
           ex.printStackTrace();           
           JOptionPane.showMessageDialog(null, "Erro de Banco: "+ex);
       }
       
       return listaUsuarios;
    }
    
    public List<UsuarioDTO> listarUsuarios() throws ClassNotFoundException{
        return listarUsuarios(null,null);
    }
    
    public UsuarioDTO buscarUsuario(Long id) throws ClassNotFoundException{
        UsuarioDTO usuario = new UsuarioDTO();
        List<UsuarioDTO> usuarios = listarUsuarios(id,null);
        if(usuarios.size() == 1){
            usuario = usuarios.get(0);
        }
        return usuario;
    }
    
    public UsuarioDTO buscarUsuario(String loginUsuario) throws ClassNotFoundException{
        UsuarioDTO usuario = new UsuarioDTO();
        List<UsuarioDTO> usuarios = listarUsuarios(null,loginUsuario);
        if(usuarios.size() == 1){
            usuario = usuarios.get(0);
        }
        return usuario;
    }
}
