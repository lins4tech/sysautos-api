package com.lins4tech.sysautos.api.procob.veiculo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class VeiculoContentAgregadosApiProcobJson {

    @JsonProperty("existe_informacao")
    private String existeInformacao;

    @JsonProperty("ano_fabricacao")
    private String anoFabricacao;

    @JsonProperty("ano_modelo")
    private String anoModelo;

    @JsonProperty("capacidade_de_carga")
    private String capacidadeDeCarga;

    @JsonProperty("capacidade_maxtracao")
    private String capacidadeMaxtracao;

    @JsonProperty("capacidade_passgeiro")
    private String capacidadePassgeiro;
    private String chassi;
    private String cilindradas;
    private String combustivel;
    private String cor;

    @JsonProperty("data_limite_restricaotributaria")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataLimiteRestricaotributaria;

    @JsonProperty("data_registrodi")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataRegistrodi;

    @JsonProperty("data_ultima_atualizacao")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataUltimaAtualizacao;

    @JsonProperty("eixo_traseiro_diferencial")
    private String eixoTraseiroDiferencial;

    @JsonProperty("especie_veiculo")
    private String especieVeiculo;
    private String marca;
    private String modelo;
    private String municipio;

    @JsonProperty("numero_caixacambio")
    private String numeroCaixaCambio;

    @JsonProperty("numero_carroceria")
    private String numeroCarroceria;

    @JsonProperty("numero_di")
    private String numeroDi;

    @JsonProperty("numero_eixos")
    private String numeroEixos;

    @JsonProperty("numero_faturado")
    private String numeroFaturado;

    @JsonProperty("numero_importadora")
    private String numeroImportadora;

    @JsonProperty("numero_motor")
    private String numeroMotor;

    @JsonProperty("pesobruto_total")
    private String pesobrutoTotal;
    private String placa;
    private String potencia;
    private String procedencia;
    private String renavam;
    private String segmento;

    @JsonProperty("situacao_chassi")
    private String situacaoChassi;

    @JsonProperty("situacao_veiculo")
    private String situacaoVeiculo;
    private String subsegmento;

    @JsonProperty("terceiro_eixotipo_carroceria")
    private String terceiroEixotipoCarroceria;

    @JsonProperty("tipo_docfaturado")
    private String tipoDocFaturado;

    @JsonProperty("tipo_docimportadoratipo_montagem")
    private String tipoDocImportadoraTipoMontagem;

    @JsonProperty("tipo_veiculo")
    private String tipoVeiculo;
    private String uf;

    @JsonProperty("uf_faturado")
    private String ufFaturado;


    public String getExisteInformacao() {
        return existeInformacao;
    }

    public void setExisteInformacao(String existeInformacao) {
        this.existeInformacao = existeInformacao;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    public void setCapacidadeDeCarga(String capacidadeDeCarga) {
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public String getCapacidadeMaxtracao() {
        return capacidadeMaxtracao;
    }

    public void setCapacidadeMaxtracao(String capacidadeMaxtracao) {
        this.capacidadeMaxtracao = capacidadeMaxtracao;
    }

    public String getCapacidadePassgeiro() {
        return capacidadePassgeiro;
    }

    public void setCapacidadePassgeiro(String capacidadePassgeiro) {
        this.capacidadePassgeiro = capacidadePassgeiro;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(String cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getDataLimiteRestricaotributaria() {
        return dataLimiteRestricaotributaria;
    }

    public void setDataLimiteRestricaotributaria(Date dataLimiteRestricaotributaria) {
        this.dataLimiteRestricaotributaria = dataLimiteRestricaotributaria;
    }

    public Date getDataRegistrodi() {
        return dataRegistrodi;
    }

    public void setDataRegistrodi(Date dataRegistrodi) {
        this.dataRegistrodi = dataRegistrodi;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public String getEixoTraseiroDiferencial() {
        return eixoTraseiroDiferencial;
    }

    public void setEixoTraseiroDiferencial(String eixoTraseiroDiferencial) {
        this.eixoTraseiroDiferencial = eixoTraseiroDiferencial;
    }

    public String getEspecieVeiculo() {
        return especieVeiculo;
    }

    public void setEspecieVeiculo(String especieVeiculo) {
        this.especieVeiculo = especieVeiculo;
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

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNumeroCaixaCambio() {
        return numeroCaixaCambio;
    }

    public void setNumeroCaixaCambio(String numeroCaixaCambio) {
        this.numeroCaixaCambio = numeroCaixaCambio;
    }

    public String getNumeroCarroceria() {
        return numeroCarroceria;
    }

    public void setNumeroCarroceria(String numeroCarroceria) {
        this.numeroCarroceria = numeroCarroceria;
    }

    public String getNumeroDi() {
        return numeroDi;
    }

    public void setNumeroDi(String numeroDi) {
        this.numeroDi = numeroDi;
    }

    public String getNumeroEixos() {
        return numeroEixos;
    }

    public void setNumeroEixos(String numeroEixos) {
        this.numeroEixos = numeroEixos;
    }

    public String getNumeroFaturado() {
        return numeroFaturado;
    }

    public void setNumeroFaturado(String numeroFaturado) {
        this.numeroFaturado = numeroFaturado;
    }

    public String getNumeroImportadora() {
        return numeroImportadora;
    }

    public void setNumeroImportadora(String numeroImportadora) {
        this.numeroImportadora = numeroImportadora;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getPesobrutoTotal() {
        return pesobrutoTotal;
    }

    public void setPesobrutoTotal(String pesobrutoTotal) {
        this.pesobrutoTotal = pesobrutoTotal;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
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

    public String getSubsegmento() {
        return subsegmento;
    }

    public void setSubsegmento(String subsegmento) {
        this.subsegmento = subsegmento;
    }

    public String getTerceiroEixotipoCarroceria() {
        return terceiroEixotipoCarroceria;
    }

    public void setTerceiroEixotipoCarroceria(String terceiroEixotipoCarroceria) {
        this.terceiroEixotipoCarroceria = terceiroEixotipoCarroceria;
    }

    public String getTipoDocFaturado() {
        return tipoDocFaturado;
    }

    public void setTipoDocFaturado(String tipoDocFaturado) {
        this.tipoDocFaturado = tipoDocFaturado;
    }

    public String getTipoDocImportadoraTipoMontagem() {
        return tipoDocImportadoraTipoMontagem;
    }

    public void setTipoDocImportadoraTipoMontagem(String tipoDocImportadoraTipoMontagem) {
        this.tipoDocImportadoraTipoMontagem = tipoDocImportadoraTipoMontagem;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUfFaturado() {
        return ufFaturado;
    }

    public void setUfFaturado(String ufFaturado) {
        this.ufFaturado = ufFaturado;
    }
}
