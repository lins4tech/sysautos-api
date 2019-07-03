package com.lins4tech.sysautos.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VeiculoApiProcobDto {

    private String placa;

    private String chassi;

    private String marca;

    private String modelo;

    private Integer anoFabricacao;

    private Integer anoModelo;

    private String combustivel;

    private String renavam;

    private String municipio;

    private String ufPlaca;

    private String procedencia;

    private Integer cilindradas;

    private String numeroMotor;

    private Integer capacidadePassgeiro;

    private Integer potencia;

    private String situacaoChassi;

    private String situacaoVeiculo;

    private String tipoVeiculo;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date dataUltimaAtualizacao;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date dataUltimaConsulta;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUfPlaca() {
        return ufPlaca;
    }

    public void setUfPlaca(String ufPlaca) {
        this.ufPlaca = ufPlaca;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public Integer getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(Integer cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public Integer getCapacidadePassgeiro() {
        return capacidadePassgeiro;
    }

    public void setCapacidadePassgeiro(Integer capacidadePassgeiro) {
        this.capacidadePassgeiro = capacidadePassgeiro;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public String getSituacaoChassi() {
        return situacaoChassi;
    }

    public void setSituacaoChassi(String situacaoChassi) {
        this.situacaoChassi = situacaoChassi;
    }

    public String getSituacaoVeiculo() {
        return situacaoVeiculo;
    }

    public void setSituacaoVeiculo(String situacaoVeiculo) {
        this.situacaoVeiculo = situacaoVeiculo;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Date getDataUltimaConsulta() {
        return dataUltimaConsulta;
    }

    public void setDataUltimaConsulta(Date dataUltimaConsulta) {
        this.dataUltimaConsulta = dataUltimaConsulta;
    }
}
