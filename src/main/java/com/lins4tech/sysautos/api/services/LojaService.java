package com.lins4tech.sysautos.api.services;

import java.util.Optional;

import com.lins4tech.sysautos.api.entities.Loja;

public interface LojaService {
	
	Optional<Loja> findByCnpj(String cnpj);

}
