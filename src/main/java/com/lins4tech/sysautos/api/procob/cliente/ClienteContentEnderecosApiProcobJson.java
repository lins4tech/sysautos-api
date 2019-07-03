package com.lins4tech.sysautos.api.procob.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ClienteContentEnderecosApiProcobJson {

    @JsonProperty("conteudo")
    private ArrayList<ClienteContentEnderecoConteudoApiProcobJson> enderecos;


    public ArrayList<ClienteContentEnderecoConteudoApiProcobJson> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<ClienteContentEnderecoConteudoApiProcobJson> enderecos) {
        this.enderecos = enderecos;
    }

    public ClienteContentEnderecosApiProcobJson() {
        super();
    }

    public class EnderecoConteudo {

        private String logradouro;

        private String endereco;

        private String bairro;

        private String cidade;

        private String numero;

        private String cep;

        private String complemento;

        private String uf;

        public String getLogradouro() {
            return logradouro;
        }

        public void setLogradouro(String logradouro) {
            this.logradouro = logradouro;
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

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
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

        public String getUf() {
            return uf;
        }

        public void setUf(String uf) {
            this.uf = uf;
        }
    }

}

