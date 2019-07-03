package com.lins4tech.sysautos.api.procob.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ClienteApiProcobJson implements Serializable {
    private String code;
    private String message;
    private String date;
    private String hour;
    @JsonProperty("content")
    private ClienteContentApiProcobJson content;


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

    public ClienteContentApiProcobJson getContent() {
        return content;
    }

    public void setContent(ClienteContentApiProcobJson content) {
        this.content = content;
    }
}
