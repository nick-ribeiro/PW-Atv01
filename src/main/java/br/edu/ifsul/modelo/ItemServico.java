package br.edu.ifsul.modelo;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "itemServico")
public class ItemServico implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_itemServico", sequenceName = "seq_itemServico_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_itemServico", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Min(value = 0, message = "A quantidade nao pode ser negativa")
    @Column(name = "quantidade", nullable = false)
    @NotNull(message = "A quantidade deve ser informada")
    private Double quantidade;

    @Min(value = 0, message = "O valor unitário nao pode ser negativo")
    @Column(name = "valor_unitario", nullable = false)
    @NotNull(message = "O valor unitário deve ser informado")
    private Double valorUnitario;

    @Min(value = 0, message = "O valor total nao pode ser negativo")
    @Column(name = "valor_total", nullable = false)
    @NotNull(message = "O valor total deve ser informado")
    private Double valorTotal;

    @NotNull(message = "A ordem do serviço deve ser informado")
    @ManyToOne
    @JoinColumn(name = "ordemServico", referencedColumnName = "id", nullable = false)
    private OrdemServico ordemServico;

    @NotNull(message = "O serviço deve ser informado")
    @ManyToOne
    @JoinColumn(name = "servico", referencedColumnName = "id", nullable = false)
    private Servico servico;

    public ItemServico() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final ItemServico other = (ItemServico) obj;
        return Objects.equals(this.id, other.id);
    }
}
