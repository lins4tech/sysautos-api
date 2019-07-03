package com.lins4tech.sysautos.api.vos;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class VeiculoInfoVO implements Serializable {

    @Id
    private Long idEntradaVeiculo;
    private Long idVeiculo;
    private Long idVendaVeiculo;
    private Long idLoja;
    private String placa;
    private String chassis;
    private String renavam;
    private String modelo;
    private String marca;
    private String combustivel;
    private String motor;
    private String cor;
    private Integer anoModelo;
    private Integer anoFabricacao;
    private Double valorCompra;
    private Double valorParaVenda;
    private Double valorTotalVenda;
    private String ferramentas;
    private String opcionais;
    private Date dataEntradaVeiculo;
    private Date dataVendaVeiculo;
    private String status;

    public VeiculoInfoVO() {
        super();
    }

    public Long getIdEntradaVeiculo() {
        return idEntradaVeiculo;
    }

    public void setIdEntradaVeiculo(Long idEntradaVeiculo) {
        this.idEntradaVeiculo = idEntradaVeiculo;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Long getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Long idLoja) {
        this.idLoja = idLoja;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorParaVenda() {
        return valorParaVenda;
    }

    public void setValorParaVenda(Double valorParaVenda) {
        this.valorParaVenda = valorParaVenda;
    }

    public Double getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(Double valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public Date getDataEntradaVeiculo() {
        return dataEntradaVeiculo;
    }

    public void setDataEntradaVeiculo(Date dataEntradaVeiculo) {
        this.dataEntradaVeiculo = dataEntradaVeiculo;
    }

    public Date getDataVendaVeiculo() {
        return dataVendaVeiculo;
    }

    public void setDataVendaVeiculo(Date dataVendaVeiculo) {
        this.dataVendaVeiculo = dataVendaVeiculo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdVendaVeiculo() {
        return idVendaVeiculo;
    }

    public void setIdVendaVeiculo(Long idVendaVeiculo) {
        this.idVendaVeiculo = idVendaVeiculo;
    }


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFerramentas() {
        return ferramentas;
    }

    public void setFerramentas(String ferramentas) {
        this.ferramentas = ferramentas;
    }

    public String getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(String opcionais) {
        this.opcionais = opcionais;
    }
}
