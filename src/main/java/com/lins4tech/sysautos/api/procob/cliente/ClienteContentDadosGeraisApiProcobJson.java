package com.lins4tech.sysautos.api.procob.cliente;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class ClienteContentDadosGeraisApiProcobJson implements Serializable {
    @JsonProperty("conteudo")
    private DadosGeraisConteudo conteudo;


    public DadosGeraisConteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(DadosGeraisConteudo conteudo) {
        this.conteudo = conteudo;
    }

    public class DadosGeraisConteudo {

        private String documento;
        @JsonProperty("tipo_documento")
        private String tipoDocumento;
        private String nome;
        @JsonProperty("data_nascimento")
        @JsonFormat(pattern="dd/MM/yyyy")
        private Date dataNascimento;
        private String idade;
        private String signo;
        private String obito;
        private String sexo;
        private String uf;
        @JsonProperty("situacao_receita")
        private String situacaoReceita;
        @JsonProperty("situacao_receita_data")
        @JsonFormat(pattern="yyyy-MM-dd")
        private Date situacaoReceitaData;


        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public String getTipoDocumento() {
            return tipoDocumento;
        }

        public void setTipoDocumento(String tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
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

        public String getIdade() {
            return idade;
        }

        public void setIdade(String idade) {
            this.idade = idade;
        }

        public String getSigno() {
            return signo;
        }

        public void setSigno(String signo) {
            this.signo = signo;
        }

        public String getObito() {
            return obito;
        }

        public void setObito(String obito) {
            this.obito = obito;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
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
    }
}



