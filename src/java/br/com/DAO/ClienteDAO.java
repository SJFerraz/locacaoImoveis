
package br.com.DAO;

import br.com.DTO.ClienteDTO;
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
public class ClienteDAO {
    
    private ResultSet rs;
    private List<ClienteDTO> listaClientes;
    
    public void inserirCliente(ClienteDTO cliente) throws ClassNotFoundException{
        String sql = "insert into cliente (nome, cpf, dt_nascimento, endereco, nr_endereco, bairro, cidade, uf, cep"+
                     (cliente.getId()!=null?" ,id":"")+") values (?,?,?,?,?,?,?,?,?"+
                     (cliente.getId()!=null?",?":"")+")";
        System.out.println(sql);
        try(Connection conexao = new ConexaoDAO().conectarDB();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            
            //ps = conexao.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setDate(3, cliente.getDtNascimento());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getNumeroEndereco());
            ps.setString(6, cliente.getBairro());
            ps.setString(7, cliente.getCidade());
            ps.setString(8, cliente.getUf());
            ps.setString(9, cliente.getCep());
            if(cliente.getId()!=null){
                ps.setLong(10, cliente.getId());
            }
            
            ps.execute();
            
        }catch(SQLException se){
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro de Banco: "+se);
        }
        
    }
    
    
    private List<ClienteDTO> listarClientes (Long id) throws ClassNotFoundException{
       String sql = "select * from cliente";
       if(id != null){
           sql += " where id = ?";
       }
       
       listaClientes = new ArrayList<>();
       
       try(Connection conexao = new ConexaoDAO().conectarDB();
           PreparedStatement ps = conexao.prepareStatement(sql)){
           
           // Pega a clausula where caso tenha um parametro ID incluso.
           if(id != null){
               ps.setLong(1,id);
           }
           rs = ps.executeQuery();
           while(rs.next()){
               ClienteDTO clienteDTO = new ClienteDTO(rs.getLong("id"),
                                                      rs.getString("nome"),
                                                      rs.getString("cpf"),
                                                      rs.getDate("dt_nascimento"),
                                                      rs.getString("endereco"),
                                                      rs.getString("nr_endereco"),
                                                      rs.getString("bairro"),
                                                      rs.getString("cidade"),
                                                      rs.getString("uf"),
                                                      rs.getString("cep"));
               listaClientes.add(clienteDTO);
           }
           
       }catch(SQLException ex){
           ex.printStackTrace();           
           JOptionPane.showMessageDialog(null, "Erro de Banco: "+ex);
       }
       return listaClientes;
    }
    
    public List<ClienteDTO> listarClientes() throws ClassNotFoundException{
        return listarClientes(null);
    }
    
    public ClienteDTO buscarCliente(Long id) throws ClassNotFoundException{
        ClienteDTO cliente = new ClienteDTO();
        List<ClienteDTO> clientes = listarClientes(id);
        if(clientes.size() == 1){
            cliente = clientes.get(0);
        }
        return cliente;
    }
    
    
    public void atualizarCliente(ClienteDTO cliente) throws ClassNotFoundException{
        String sql = "update cliente set nome  = ?, cpf  = ?, dt_nascimento = ?, endereco = ?, nr_endereco = ?, bairro = ?, cidade = ?, uf = ?, cep = ? where id = ?";
        
        try(Connection conexao = new ConexaoDAO().conectarDB();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setDate(3, cliente.getDtNascimento());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getNumeroEndereco());
            ps.setString(6, cliente.getBairro());
            ps.setString(7, cliente.getCidade());
            ps.setString(8, cliente.getUf());
            ps.setString(9, cliente.getCep());
            ps.setLong(10, cliente.getId());
            
            ps.execute();
            
        }catch(SQLException se){
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro de Banco: "+se);
        }
    }
    
    public void excluirCliente(Long id) throws ClassNotFoundException{
        String sql = "delete from cliente where id = ?";
        
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
