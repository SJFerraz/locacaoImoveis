
package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Ferraz
 */
public class ConexaoDAO {
    
    private String url;
    private Connection conexao = null;
    
    public Connection conectarDB() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.url = "jdbc:mysql://localhost:3306/locacao_imoveis?user=root&password=";
            this.conexao = DriverManager.getConnection(url);
        }catch(SQLException ex){
            ex.printStackTrace();            
            JOptionPane.showMessageDialog(null, "Erro de Banco: "+ex);
        }
        return this.conexao;
    }
}
