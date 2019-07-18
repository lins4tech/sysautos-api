package com.lins4tech.sysautos.api.dtos;

import com.lins4tech.sysautos.api.entities.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UsuarioCustomDto implements UserDetails {


    private String username;
    private String password;
    private Long lojaId;
    private String tipoUsuario;

    public UsuarioCustomDto(Usuario usuario) {
        this.username = usuario.getEmail();
        this.password = usuario.getPassword();
        this.lojaId = usuario.getLoja().getId();
        this.tipoUsuario = usuario.getTipoUsuarioEnum().name();
    }

    public Long getLojaId() {
        return lojaId;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
