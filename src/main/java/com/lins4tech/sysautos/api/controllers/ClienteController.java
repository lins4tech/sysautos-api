package com.lins4tech.sysautos.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lins4tech.sysautos.api.dtos.ClienteDto;
import com.lins4tech.sysautos.api.entities.Cliente;
import com.lins4tech.sysautos.api.entities.Loja;
import com.lins4tech.sysautos.api.enums.TipoClienteEnum;
import com.lins4tech.sysautos.api.services.ClienteService;
import com.lins4tech.sysautos.api.services.LojaService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private LojaService lojaService;
	
	@RequestMapping(value = "/findCliente", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDto>> findCliente(
			@RequestParam(value = "lojaId") Long lojaId,
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "cpfCnpj", required = false) String cpfCnpj,
			@RequestParam(value = "tipo", required = false) String tipo,
			@RequestParam(value = "pag", defaultValue = "0") Integer pag,
			@RequestParam(value = "ord", defaultValue = "nomeCompleto") String ord,
			@RequestParam(value = "dir", defaultValue = "DESC") String dir,
			@RequestParam(value = "size", defaultValue = "30") Integer size) {
		
		PageRequest pageRequest = PageRequest.of(pag, size, Direction.valueOf(dir), ord);
		log.info("Chama ao ClienteController.findCliente - LojaId = {}", lojaId);
		TipoClienteEnum tipoCliente = null;
		if(tipo != null) {
			tipoCliente = TipoClienteEnum.valueOf(tipo);
		}
		List<Cliente> listClientes = clienteService.findCliente(lojaId, nome, email, cpfCnpj, tipoCliente, pageRequest);
		
		return new ResponseEntity<>(parseListClienteToListClienteDto(listClientes), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ClienteDto> saveCliente(@RequestBody ClienteDto clienteDto) {
		Cliente c = new Cliente();
		if(clienteDto.getId() != null && clienteDto.getId() > 0) {
			c = clienteService.findById(clienteDto.getId());
		}
		c = parseClienteDtoToCliente(c, clienteDto);
		return new ResponseEntity<>(new ClienteDto(clienteService.save(c)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable("id") Long clienteId) {
		Cliente c = clienteService.findById(clienteId);
		if(c != null) {
			clienteService.deleteById(c.getId());
			return true;
		}
		return false;
	}
	
	private List<ClienteDto> parseListClienteToListClienteDto(List<Cliente> list) {
		List<ClienteDto> listClienteDto = new ArrayList<>();
		for (Cliente c : list) {
			listClienteDto.add(new ClienteDto(c));
		}
		return listClienteDto;
	}
	
	private Cliente parseClienteDtoToCliente(Cliente cliente, ClienteDto dto) {
		cliente.setCelular(dto.getCelular());
		cliente.setCep(dto.getCep());
		cliente.setCidade(dto.getCidade());
		cliente.setContato(dto.getContato());
		cliente.setCpfCnpj(dto.getCpfCnpj());
		cliente.setEmail(dto.getEmail());
		cliente.setEndereco(dto.getEndereco());
		cliente.setEstado(dto.getEstado());
		cliente.setNomeCompleto(dto.getNomeCompleto());
		cliente.setRg(dto.getRg());
		cliente.setTelefone(dto.getTelefone());
		cliente.setTipoClienteEnum(TipoClienteEnum.valueOf(dto.getTipoCliente()));
		if(cliente.getLoja() == null) {
			Loja loja = lojaService.findById(dto.getLojaId());
			cliente.setLoja(loja);
		}
		return cliente;
	}

}
