package com.lins4tech.sysautos.api.procob.veiculo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class VeiculoApiProcobJson implements Serializable {

    private String code;
    private String message;
    private String date;
    private String hour;
    private String revision;
    private String server;
    @JsonProperty("content")
    private VeiculoContentApiProcobJson veiculoContentApiProcobJson;


    public VeiculoApiProcobJson() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public VeiculoContentApiProcobJson getVeiculoContentApiProcobJson() {
        return veiculoContentApiProcobJson;
    }

    public void setVeiculoContentApiProcobJson(VeiculoContentApiProcobJson veiculoContentApiProcobJson) {
        this.veiculoContentApiProcobJson = veiculoContentApiProcobJson;
    }

}
