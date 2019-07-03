package com.lins4tech.sysautos.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VendaVeiculoSaveDto {

    private Long clienteId;

    private Long entradaVeiculoId;

    private Double valorTotal;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Date dataVenda;

    private String observacao;


    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getEntradaVeiculoId() {
        return entradaVeiculoId;
    }

    public void setEntradaVeiculoId(Long entradaVeiculoId) {
        this.entradaVeiculoId = entradaVeiculoId;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
