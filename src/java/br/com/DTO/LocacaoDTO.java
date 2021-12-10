
package br.com.DTO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Samuel Ferraz
 */
public class LocacaoDTO {
    private Long id;
    private BigDecimal valor;
    private String descricao;
    private Date inicioLocacao;
    private Date fimLocacao;
    private Long idCliente;
    private Long idImovel;
    private ClienteDTO cliente = new ClienteDTO();
    private ImovelDTO imovel = new ImovelDTO();

    public LocacaoDTO() {
    }

    public LocacaoDTO(Long id, BigDecimal valor, String descricao, Date inicioLocacao, Date fimLocacao, Long idCliente, Long idImovel, ClienteDTO cliente, ImovelDTO imovel) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.idCliente = idCliente;
        this.idImovel = idImovel;
        this.cliente = cliente;
        this.imovel = imovel;
    }

    @Override
    public String toString() {
        return "LocacaoDTO{" + "id=" + id + ", valor=" + valor + ", descricao=" + descricao + ", inicioLocacao=" + inicioLocacao + ", fimLocacao=" + fimLocacao + ", idCliente=" + idCliente + ", idImovel=" + idImovel + ", cliente=" + cliente + ", imovel=" + imovel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.valor);
        hash = 71 * hash + Objects.hashCode(this.descricao);
        hash = 71 * hash + Objects.hashCode(this.inicioLocacao);
        hash = 71 * hash + Objects.hashCode(this.fimLocacao);
        hash = 71 * hash + Objects.hashCode(this.idCliente);
        hash = 71 * hash + Objects.hashCode(this.idImovel);
        hash = 71 * hash + Objects.hashCode(this.cliente);
        hash = 71 * hash + Objects.hashCode(this.imovel);
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
        final LocacaoDTO other = (LocacaoDTO) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.inicioLocacao, other.inicioLocacao)) {
            return false;
        }
        if (!Objects.equals(this.fimLocacao, other.fimLocacao)) {
            return false;
        }
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        return Objects.equals(this.idImovel, other.idImovel);
    }
    
    
        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getInicioLocacao() {
        return inicioLocacao;
    }

    public void setInicioLocacao(Date inicioLocacao) {
        this.inicioLocacao = inicioLocacao;
    }

    public Date getFimLocacao() {
        return fimLocacao;
    }

    public void setFimLocacao(Date fimLocacao) {
        this.fimLocacao = fimLocacao;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Long idImovel) {
        this.idImovel = idImovel;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

//    public void setCliente(ClienteDTO cliente) {
//        this.cliente = cliente;
//    }

    public ImovelDTO getImovel() {
        return imovel;
    }

//    public void setImovel(ImovelDTO imovel) {
//        this.imovel = imovel;
//    }
    
    
}
