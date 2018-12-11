package com.lins4tech.sysautos.api.services.impl;

import java.util.List;
import java.util.Optional;

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

	public Optional<Cliente> findByLojaIdAndCpfCnpj(Long lojaId, String cpfCnpj) {
		log.info("Consultar Cliente por LojaId:{} e CpfCnpj: {}", lojaId, cpfCnpj);
		return Optional.ofNullable(clienteRepository.findByLojaIdAndCpfCnpj(lojaId, cpfCnpj));
	}
	
	public Cliente save(Cliente c) {
		log.info("Salvando um Cliente: {}", c);
		return clienteRepository.save(c);
	}
	
	public void remove(Long clienteId) {
		log.info("Excluindo o Cliente: {}", clienteId);
		clienteRepository.deleteById(clienteId);
	}

}
