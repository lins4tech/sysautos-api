package com.lins4tech.sysautos.api.services;

import com.lins4tech.sysautos.api.entities.Usuario;

import java.util.Optional;

public interface UserService {
    Usuario findByEmail(String email);

}
