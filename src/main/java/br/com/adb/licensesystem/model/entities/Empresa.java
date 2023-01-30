package br.com.adb.licensesystem.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor

@Entity(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeFantasia;

    private String razaoSocial;

    private String cnpj;

    private String incricaoEstadual;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    @OneToMany
    private List<Modulo> modulos;

    private Date ultimaRenovacao;

    private Date vencimento;

    private boolean ativo;

    public Empresa(int id, String nomeFantasia, String razaoSocial, String cnpj, String incricaoEstadual, Endereco endereco, Contato contato, Date ultimaRenovacao, Date vencimento, boolean ativo) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.incricaoEstadual = incricaoEstadual;
        this.endereco = endereco;
        this.contato = contato;
        this.ultimaRenovacao = ultimaRenovacao;
        this.vencimento = vencimento;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
