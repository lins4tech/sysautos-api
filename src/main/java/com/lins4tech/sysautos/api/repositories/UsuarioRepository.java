package com.lins4tech.sysautos.api.repositories;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.lins4tech.sysautos.api.entities.Usuario;
@NamedQueries({
	@NamedQuery(
			name = "UsuarioRepository.findByLojaId",
			query = "SELECT u FROM Usuario u WHERE u.loja.id = :lojaId")
})
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Transactional(readOnly = true)
	List<Usuario> findByLojaId(Long lojaId, Pageable pageable);

	Optional<Usuario> findByEmail(String email);
}
