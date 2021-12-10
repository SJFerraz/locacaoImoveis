
package br.com.DTO;

/**
 *
 * @author sferr
 */
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String loginUsuario;
    private String senha;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nome, String loginUsuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.loginUsuario = loginUsuario;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
