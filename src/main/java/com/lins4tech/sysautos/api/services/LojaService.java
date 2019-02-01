package com.lins4tech.sysautos.api.services;

import com.lins4tech.sysautos.api.entities.Loja;

public interface LojaService {
	
	Loja findByCnpj(String cnpj);
	
	Loja findById(Long id);

}
