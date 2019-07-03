package com.lins4tech.sysautos.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "veiculo_api_agregado_procob")
public class VeiculoApiProcob {

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

    private Date dataUltimaAtualizacao;

    private Date dataUltimaConsulta;

    @Id
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

    @Column(name = "ano_fabricacao")
    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    @Column(name = "ano_modelo")
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

    @Column(name = "uf_placa")
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

    @Column(name = "numero_motor")
    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    @Column(name = "capacidade_passgeiro")
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

    @Column(name = "situacao_chassi")
    public String getSituacaoChassi() {
        return situacaoChassi;
    }

    public void setSituacaoChassi(String situacaoChassi) {
        this.situacaoChassi = situacaoChassi;
    }

    @Column(name = "situacao_veiculo")
    public String getSituacaoVeiculo() {
        return situacaoVeiculo;
    }

    public void setSituacaoVeiculo(String situacaoVeiculo) {
        this.situacaoVeiculo = situacaoVeiculo;
    }

    @Column(name = "tipo_veiculo")
    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    @Column(name = "data_ultima_atualizacao")
    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    @Column(name = "data_ultima_consulta")
    public Date getDataUltimaConsulta() {
        return dataUltimaConsulta;
    }

    public void setDataUltimaConsulta(Date dataUltimaConsulta) {
        this.dataUltimaConsulta = dataUltimaConsulta;
    }
}
