package com.lins4tech.sysautos.api.procob.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ClienteContentEmailsApiProcobJson {

    @JsonProperty("conteudo")
    private ArrayList<ClienteContentEmailConteudoApiProcobJson> emails;


    public ArrayList<ClienteContentEmailConteudoApiProcobJson> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<ClienteContentEmailConteudoApiProcobJson> emails) {
        this.emails = emails;
    }

    public class EmailConteudo {
        private String email;


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
