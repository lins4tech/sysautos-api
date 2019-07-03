package com.lins4tech.sysautos.api.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "venda_veiculo")
public class VendaVeiculo  implements Serializable {

    private Long id;

    private EntradaVeiculo entradaVeiculo;

    private Cliente cliente;

    private Double valorTotal;

    private Date dataVenda;

    private String observacao;

    private Date dataCadastro;

    private Date dataAtualizacao;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    public EntradaVeiculo getEntradaVeiculo() {
        return entradaVeiculo;
    }

    public void setEntradaVeiculo(EntradaVeiculo entradaVeiculo) {
        this.entradaVeiculo = entradaVeiculo;
    }

    @ManyToOne
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Column(name = "valor_total", nullable = false)
    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Column(name = "data_venda", nullable = false)
    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Column(name = "observacao")
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Column(name = "data_cadastro", nullable = false)
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Column(name = "data_atualizacao", nullable = false)
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date actualDate = new Date();
        dataCadastro = actualDate;
        dataAtualizacao = actualDate;
    }
}
