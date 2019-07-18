package com.lins4tech.sysautos.api.services.impl;

import com.lins4tech.sysautos.api.dtos.UsuarioCustomDto;
import com.lins4tech.sysautos.api.entities.Usuario;
import com.lins4tech.sysautos.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Usuario> optionalUser = usuarioRepository.findByEmail(email);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Email not found"));

        UserDetails userDetails = new UsuarioCustomDto(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}