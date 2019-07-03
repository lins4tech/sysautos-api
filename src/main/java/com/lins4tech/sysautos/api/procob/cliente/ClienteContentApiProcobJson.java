package com.lins4tech.sysautos.api.procob.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ClienteContentApiProcobJson implements Serializable {

    @JsonProperty("nome")
    private ClienteContentDadosGeraisApiProcobJson clienteContentDadosGerais;

    @JsonProperty("pesquisa_enderecos")
    private ClienteContentEnderecosApiProcobJson enderecos;

    @JsonProperty("emails")
    private ClienteContentEmailsApiProcobJson emails;


    public ClienteContentDadosGeraisApiProcobJson getClienteContentDadosGerais() {
        return clienteContentDadosGerais;
    }

    public void setClienteContentDadosGerais(ClienteContentDadosGeraisApiProcobJson clienteContentDadosGerais) {
        this.clienteContentDadosGerais = clienteContentDadosGerais;
    }


    public ClienteContentEnderecosApiProcobJson getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ClienteContentEnderecosApiProcobJson enderecos) {
        this.enderecos = enderecos;
    }

    public ClienteContentEmailsApiProcobJson getEmails() {
        return emails;
    }

    public void setEmails(ClienteContentEmailsApiProcobJson emails) {
        this.emails = emails;
    }
}
