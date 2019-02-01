package com.lins4tech.sysautos.api.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.lins4tech.sysautos.api.entities.Cliente;
import com.lins4tech.sysautos.api.enums.TipoClienteEnum;

public interface ClienteService {
	
	/**
	 * Consulta padrão da tela de Cliente.
	 * @param lojaId
	 * @param nome
	 * @param email
	 * @param cpfCnpj
	 * @param tipo
	 * @param pageable
	 * @return List<Cliente>
	 */
	List<Cliente> findCliente(Long lojaId, String nome, String email, String cpfCnpj, TipoClienteEnum tipo, PageRequest pageRequest);
	
	/**
	 * Consulta o cliente pelo cpf ou cnpj.
	 * @param lojaId
	 * @param cpfCnpj
	 * @return Cliente
	 */
	Cliente findByLojaIdAndCpfCnpj(Long lojaId, String cpfCnpj);
	
	/**
	 * Consulta o cliente pelo Id.
	 * @param id
	 * @return
	 */
	Cliente findById(Long id);
	
	
	Cliente save(Cliente c);
	
	void deleteById(Long id);

}
