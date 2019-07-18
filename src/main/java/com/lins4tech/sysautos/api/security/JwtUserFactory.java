package com.lins4tech.sysautos.api.security;

import java.util.ArrayList;
import java.util.List;

import com.lins4tech.sysautos.api.entities.Usuario;
import com.lins4tech.sysautos.api.enums.TipoUsuarioEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

//import com.kazale.pontointeligente.api.entities.Funcionario;
//import com.kazale.pontointeligente.api.enums.PerfilEnum;

public class JwtUserFactory {

    private JwtUserFactory() {
    }

    /**
     * Converte e gera um JwtUser com base nos dados de um funcionário.
     *
     * @param usuario
     * @return JwtUser
     */
    public static JwtUser create(Usuario usuario) {
        return new JwtUser(usuario.getId(), usuario.getEmail(), usuario.getPassword(),
                mapToGrantedAuthorities(usuario.getTipoUsuarioEnum()));
    }

    /**
     * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
     *
     * @param tipoUsuarioEnum
     * @return List<GrantedAuthority>
     */
    private static List<GrantedAuthority> mapToGrantedAuthorities(TipoUsuarioEnum tipoUsuarioEnum) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(tipoUsuarioEnum.toString()));
        return authorities;
    }

}