package com.lins4tech.sysautos.api.security.dto;

public class TokenDto {

    private String token;

    private Integer lojaId;

    private Integer email;

    private String nomeLoja;

    public TokenDto() {
    }

    public TokenDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
