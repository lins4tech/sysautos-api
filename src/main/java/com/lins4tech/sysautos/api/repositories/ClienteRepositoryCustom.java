package com.lins4tech.sysautos.api.repositories;

import java.util.List;

import com.lins4tech.sysautos.api.entities.ClienteApiProcob;
import org.springframework.data.domain.Pageable;

import com.lins4tech.sysautos.api.entities.Cliente;
import com.lins4tech.sysautos.api.enums.TipoClienteEnum;

public interface ClienteRepositoryCustom {
	
	List<Cliente> findCliente(Long lojaId, String nome, String email, String cpfCnpj, TipoClienteEnum tipo, Pageable pageable);

	ClienteApiProcob findClienteApiProcobByCpfCnpj(String cpfCnpj);

	ClienteApiProcob saveClienteApiProcob(ClienteApiProcob entity);
}
