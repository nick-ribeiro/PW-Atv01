package br.edu.ifsul.modelo;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ordemServico")
public class OrdemServico implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_ordemServico", sequenceName = "seq_ordemServico_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_ordemServico", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "A descrição deve ser informado")
    @Length(max = 30, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 30, nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informado")
    @Column(name = "data", nullable = false)
    private Calendar data;

    @Min(value = 0, message = "O valor total nao pode ser negativo")
    @Column(name = "valor_total", nullable = false)
    @NotNull(message = "O valor total deve ser informado")
    private Double valorTotal;

    @NotNull(message = "O funcionario deve ser informada")
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id", nullable = false)
    private Funcionario funcionario;

    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;

    @NotNull(message = "O pet deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pet", referencedColumnName = "id", nullable = false)
    private Pet pet;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    List<ItemServico> itens = new ArrayList<>();

    public OrdemServico() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<ItemServico> getItens() {
        return itens;
    }

    public void setItens(List<ItemServico> itens) {
        this.itens = itens;
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
        final OrdemServico other = (OrdemServico) obj;
        return Objects.equals(this.id, other.id);
    }
}
