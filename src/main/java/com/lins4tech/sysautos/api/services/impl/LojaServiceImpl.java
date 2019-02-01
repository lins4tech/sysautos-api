package com.lins4tech.sysautos.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lins4tech.sysautos.api.entities.Loja;
import com.lins4tech.sysautos.api.repositories.LojaRepository;
import com.lins4tech.sysautos.api.services.LojaService;

@Service
public class LojaServiceImpl implements LojaService {
private static final Logger log = LoggerFactory.getLogger(LojaServiceImpl.class);
	
	@Autowired
	private LojaRepository lojaRepository;

	@Override
	public Loja findByCnpj(String cnpj) {
		log.info("Consultando uma Loja por CNPJ: {}", cnpj);
		return lojaRepository.findByCnpj(cnpj).orElse(null);
	}

	@Override
	public Loja findById(Long id) {
		log.info("Consultando uma Loja por ID: {}", id);
		return lojaRepository.findById(id).orElse(null);
	}
	
	
}
