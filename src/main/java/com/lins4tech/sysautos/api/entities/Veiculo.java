package com.lins4tech.sysautos.api.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {

    private Long id;

    private Loja loja;

    private String marca;

    private String modelo;

    private Integer anoFabricacao;

    private Integer anoModelo;

    private String placa;

    private String chassis;

    private String renavam;

    private String combustivel;

    private String motor;

    private String cor;

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

    @Column(name = "marca", nullable = false)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Column(name = "modelo", nullable = false)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Column(name = "ano_fabricacao", nullable = false)
    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    @Column(name = "ano_modelo", nullable = false)
    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    @Column(name = "placa", nullable = false, unique = true)
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Column(name = "chassis", nullable = false, unique = true)
    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    @Column(name = "renavam", nullable = false)
    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    @Column(name = "combustivel")
    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    @Column(name = "motor")
    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
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

    @Column(name = "cor")
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
