package com.lins4tech.sysautos.api.dtos;

import java.util.Date;

public class ClienteApiProcobDto {

    private String cpfCnpj;
    private String tipo;
    private String nome;
    private Date dataNascimento;
    private String sexo;
    private String obito;
    private String uf;
    private String situacaoReceita;
    private String endereco;
    private String bairro;
    private String cidade;
    private String cep;
    private String complemento;
    private String ufEndereco;
    private String email;

    private Date situacaoReceitaData;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObito() {
        return obito;
    }

    public void setObito(String obito) {
        this.obito = obito;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getSituacaoReceita() {
        return situacaoReceita;
    }

    public void setSituacaoReceita(String situacaoReceita) {
        this.situacaoReceita = situacaoReceita;
    }

    public Date getSituacaoReceitaData() {
        return situacaoReceitaData;
    }

    public void setSituacaoReceitaData(Date situacaoReceitaData) {
        this.situacaoReceitaData = situacaoReceitaData;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUfEndereco() {
        return ufEndereco;
    }

    public void setUfEndereco(String ufEndereco) {
        this.ufEndereco = ufEndereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
