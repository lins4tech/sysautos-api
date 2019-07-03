package com.lins4tech.sysautos.api.services.impl;

import java.util.List;

import com.lins4tech.sysautos.api.entities.ClienteApiProcob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lins4tech.sysautos.api.entities.Cliente;
import com.lins4tech.sysautos.api.enums.TipoClienteEnum;
import com.lins4tech.sysautos.api.repositories.ClienteRepository;
import com.lins4tech.sysautos.api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findCliente(Long lojaId, String nome, String email, String cpfCnpj, TipoClienteEnum tipo,
			PageRequest pageRequest) {
		log.info("Consulta Padrão FindCliente -> LojaId = {}", lojaId);
		return clienteRepository.findCliente(lojaId, nome, email, cpfCnpj, tipo, pageRequest);
	}

	public Cliente findByLojaIdAndCpfCnpj(Long lojaId, String cpfCnpj) {
		log.info("Consultar Cliente por LojaId:{} e CpfCnpj: {}", lojaId, cpfCnpj);
		return clienteRepository.findByLojaIdAndCpfCnpj(lojaId, cpfCnpj);
	}

	public Cliente findByLojaIdAndEmail(Long lojaId, String email) {
		log.info("Consultar Cliente por LojaId:{} e Email: {}", lojaId, email);
		return clienteRepository.findByLojaIdAndEmail(lojaId, email);
	}

	public ClienteApiProcob findClienteApiProcobByCpfCnpj(String cpfCnpj) {
		log.info("Consultar ClienteApiProcob por CPF_CNPJ:{}", cpfCnpj);
		return clienteRepository.findClienteApiProcobByCpfCnpj(cpfCnpj);
	}
	
	public Cliente save(Cliente c) {
		log.info("Salvando um Cliente: {}", c);
		return clienteRepository.save(c);
	}

	public ClienteApiProcob saveClienteApiProcob(ClienteApiProcob c) {
		log.info("Salvando um ClienteApiProcob: {}", c);
		return clienteRepository.saveClienteApiProcob(c);
	}
	
	public void deleteById(Long id) {
		log.info("Excluindo um Cliente: {}", id);
		clienteRepository.deleteById(id);
	} 
	public Cliente findById(Long id) {
		log.info("FindById ClienteId: {}", id);
		return clienteRepository.findById(id).orElse(null);
	}

}
