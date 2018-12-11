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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lins4tech.sysautos.api.dtos.ClienteDto;
import com.lins4tech.sysautos.api.entities.Cliente;
import com.lins4tech.sysautos.api.enums.TipoClienteEnum;
import com.lins4tech.sysautos.api.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
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
		

		return new ResponseEntity<>(parseToListClienteDto(listClientes), HttpStatus.OK);
	}
	
	private List<ClienteDto> parseToListClienteDto(List<Cliente> list) {
		List<ClienteDto> listClienteDto = new ArrayList<>();
		for (Cliente c : list) {
			listClienteDto.add(new ClienteDto(c));
		}
		return listClienteDto;
	}

}
