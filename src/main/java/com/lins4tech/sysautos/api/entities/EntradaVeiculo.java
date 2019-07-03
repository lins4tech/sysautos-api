package com.lins4tech.sysautos.api.entities;

import com.lins4tech.sysautos.api.enums.StatusVeiculoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "entrada_veiculo")
public class EntradaVeiculo implements Serializable {

    private Long id;

    private Loja loja;

    private Veiculo veiculo;

    private Cliente cliente;

    private Date dataEntrada;

    private Double valorCompra;

    private String observacao;

    private String dutEmNome;

    private Integer kilometragem;

    private Double valorVenda;

    private String observacaoVeiculo;

    private String observacaoEntrada;

    private String ferramentas;

    private String opcionais;

    private StatusVeiculoEnum status;

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

    @ManyToOne(fetch = FetchType.EAGER)
    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @ManyToOne
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Column(name = "data_entrada", nullable = false)
    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Column(name = "valor_compra", nullable = false)
    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Column(name = "observacao")
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Column(name = "dut_em_nome")
    public String getDutEmNome() {
        return dutEmNome;
    }

    public void setDutEmNome(String dutEmNome) {
        this.dutEmNome = dutEmNome;
    }

    @Column(name = "kilometragem")
    public Integer getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(Integer kilometragem) {
        this.kilometragem = kilometragem;
    }

    @Column(name = "valor_venda")
    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Column(name = "observacao_veiculo")
    public String getObservacaoVeiculo() {
        return observacaoVeiculo;
    }

    public void setObservacaoVeiculo(String observacaoVeiculo) {
        this.observacaoVeiculo = observacaoVeiculo;
    }

    @Column(name = "observacao_entrada")
    public String getObservacaoEntrada() {
        return observacaoEntrada;
    }

    public void setObservacaoEntrada(String observacaoEntrada) {
        this.observacaoEntrada = observacaoEntrada;
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

    @Column(name = "ferramentas")
    public String getFerramentas() {
        return ferramentas;
    }

    public void setFerramentas(String ferramentas) {
        this.ferramentas = ferramentas;
    }

    @Column(name = "opcionais")
    public String getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(String opcionais) {
        this.opcionais = opcionais;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    public StatusVeiculoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculoEnum status) {
        this.status = status;
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
