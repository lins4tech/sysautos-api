package com.lins4tech.sysautos.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lins4tech.sysautos.api.entities.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long>{
	
	Optional<Loja> findByCnpj(String cnpj);

}
