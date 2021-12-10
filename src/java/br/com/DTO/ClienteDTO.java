
package br.com.DTO;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Samuel Ferraz
 */
public class ClienteDTO {
    
    private Long id;
    private String nome;
    private String cpf;
    private Date dtNascimento;
    private String endereco;
    private String numeroEndereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    
    public ClienteDTO(){}

    public ClienteDTO(Long id, String nome, String cpf, Date dtNascimento, String endereco, String numeroEndereco, String bairro, String cidade, String uf, String cep) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dtNascimento=" + dtNascimento + ", endereco=" + endereco + ", numeroEndereco=" + numeroEndereco + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.cpf);
        hash = 59 * hash + Objects.hashCode(this.dtNascimento);
        hash = 59 * hash + Objects.hashCode(this.endereco);
        hash = 59 * hash + Objects.hashCode(this.numeroEndereco);
        hash = 59 * hash + Objects.hashCode(this.bairro);
        hash = 59 * hash + Objects.hashCode(this.cidade);
        hash = 59 * hash + Objects.hashCode(this.uf);
        hash = 59 * hash + Objects.hashCode(this.cep);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteDTO other = (ClienteDTO) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.numeroEndereco, other.numeroEndereco)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.dtNascimento, other.dtNascimento);
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
}
