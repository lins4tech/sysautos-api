package com.lins4tech.sysautos.api.services.impl;

import com.lins4tech.sysautos.api.entities.Usuario;
import com.lins4tech.sysautos.api.repositories.UsuarioRepository;
import com.lins4tech.sysautos.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }
}
