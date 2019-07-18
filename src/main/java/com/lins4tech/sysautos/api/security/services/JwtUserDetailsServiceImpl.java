package com.lins4tech.sysautos.api.security.services;

import java.util.Optional;

import com.lins4tech.sysautos.api.entities.Usuario;
import com.lins4tech.sysautos.api.repositories.UsuarioRepository;
import com.lins4tech.sysautos.api.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.kazale.pontointeligente.api.entities.Funcionario;
//import com.kazale.pontointeligente.api.security.JwtUserFactory;
//import com.kazale.pontointeligente.api.services.FuncionarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        if (usuario.isPresent()) {
            return JwtUserFactory.create(usuario.get());
        }

        throw new UsernameNotFoundException("Email não encontrado.");
    }

}