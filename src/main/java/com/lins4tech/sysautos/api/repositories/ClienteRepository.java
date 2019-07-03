package com.lins4tech.sysautos.api.repositories;


import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lins4tech.sysautos.api.entities.Cliente;

@NamedQueries({
	@NamedQuery(
			name = "ClienteRepository.findByLojaId",
			query = "SELECT c FROM Cliente c WHERE c.loja.id = :lojaId"),
	@NamedQuery(
			name = "ClienteRepository.findByLojaIdAndNomeLike",
			query = "SELECT c FROM Cliente c WHERE c.nomeCompleto LIKE '%' || :nomeCompleto || '%' AND c.loja.id = :lojaId"
			),
	@NamedQuery(
			name = "ClienteRepository.findByLojaIdAndCpfCnpj",
			query = "SELECT c FROM Cliente c WHERE c.loja.id = :lojaId AND c.cpfCnpj = :cpfCnpj"
			)
})
public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryCustom{
	
	@Transactional(readOnly = true)
	Page<Cliente> findByLojaId(Long lojaId, Pageable pageable);
	
	@Transactional(readOnly = true)
	Page<Cliente> findByLojaIdAndNomeCompletoLike(Long lojaId, String nomeCompleto, Pageable pageable);
	
	@Transactional(readOnly = true)
	Cliente findByLojaIdAndCpfCnpj(Long lojaId, String cpfCnpj);

	@Transactional(readOnly = true)
	Cliente findByLojaIdAndEmail(Long lojaId, String email);
}
