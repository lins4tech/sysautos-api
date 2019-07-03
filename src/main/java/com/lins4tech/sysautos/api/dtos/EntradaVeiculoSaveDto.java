package com.lins4tech.sysautos.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class EntradaVeiculoSaveDto {

    private Long entradaVeiculoId;

    private Long lojaId;

    private Long clienteId;

    // Caracteristicas do Veículo

    private Long veiculoId;

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

    // Caracteristicas da Entrada de Veículo

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date dataEntrada;

    private String ferramentas;

    private String opcionais;

    private Double valorCompra;

    private String observacao;

    private String dutEmNome;

    private Integer kilometragem;

    private Double valorVenda;

    private String observacaoVeiculo;

    private String observacaoEntrada;

    public Long getEntradaVeiculoId() {
        return entradaVeiculoId;
    }

    public void setEntradaVeiculoId(Long entradaVeiculoId) {
        this.entradaVeiculoId = entradaVeiculoId;
    }

    @NotNull(message = "Loja não informada.")
    public Long getLojaId() {
        return lojaId;
    }

    public void setLojaId(Long lojaId) {
        this.lojaId = lojaId;
    }

    @NotNull(message = "Cliente não informado")
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    @NotEmpty(message = "A Marca do veículo deve ser informada.")
    @Length(min = 2, max = 200, message = "Marca deve conter entre 2 e 200 caracteres.")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @NotEmpty(message = "O Modelo do veículo deve ser informado.")
    @Length(min = 2, max = 200, message = "Modelo deve conter entre 2 e 200 caracteres.")
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @NotNull(message = "O Ano de Fabricação deve ser informado.")
    @Min(1900)
    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    @NotNull(message = "O Ano de Modelo deve ser informado.")
    @Min(1900)
    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    @NotEmpty(message = "A Placa do veículo deve ser informada.")
    @Length(min = 7, max = 8, message = "Placa deve conter entre 7 e 8 caracteres.")
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @NotEmpty(message = "O chassis do veículo deve ser informado.")
//    @Length(min = 17, max = 20, message = "Chassis deve conter entre 17 e 20 caracteres.")
    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    @NotEmpty(message = "O renavam do veículo deve ser informado.")
//    @Length(min = 13, max = 15, message = "O renavam deve conter entre 13 e 15 caracteres.")
    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDutEmNome() {
        return dutEmNome;
    }

    public void setDutEmNome(String dutEmNome) {
        this.dutEmNome = dutEmNome;
    }

    public Integer getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(Integer kilometragem) {
        this.kilometragem = kilometragem;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getObservacaoVeiculo() {
        return observacaoVeiculo;
    }

    public void setObservacaoVeiculo(String observacaoVeiculo) {
        this.observacaoVeiculo = observacaoVeiculo;
    }

    public String getObservacaoEntrada() {
        return observacaoEntrada;
    }

    public void setObservacaoEntrada(String observacaoEntrada) {
        this.observacaoEntrada = observacaoEntrada;
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


