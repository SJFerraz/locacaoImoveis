
package br.com.DTO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Samuel Ferraz
 */
public class ImovelDTO {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private String endereco;
    private String numeroEndereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private Long idCategoria;
    private CategoriaDTO categoria = new CategoriaDTO();

    public ImovelDTO() {}

    public ImovelDTO(Long id, String descricao, BigDecimal valor, String endereco, String numeroEndereco, String bairro, String cidade, String uf, String cep, Long idCategoria, CategoriaDTO categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.idCategoria = idCategoria;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ImovelDTO{" + "id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", endereco=" + endereco + ", numeroEndereco=" + numeroEndereco + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", idCategoria=" + idCategoria + ", categoria=" + categoria + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.descricao);
        hash = 53 * hash + Objects.hashCode(this.valor);
        hash = 53 * hash + Objects.hashCode(this.endereco);
        hash = 53 * hash + Objects.hashCode(this.numeroEndereco);
        hash = 53 * hash + Objects.hashCode(this.bairro);
        hash = 53 * hash + Objects.hashCode(this.cidade);
        hash = 53 * hash + Objects.hashCode(this.uf);
        hash = 53 * hash + Objects.hashCode(this.cep);
        hash = 53 * hash + Objects.hashCode(this.idCategoria);
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
        final ImovelDTO other = (ImovelDTO) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
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
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return Objects.equals(this.idCategoria, other.idCategoria);
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

//    public void setCategoria(CategoriaDTO categoria) {
//        this.categoria = categoria;
//    }
    
    
    
   
}
