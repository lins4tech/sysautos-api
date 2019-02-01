package com.lins4tech.sysautos.api.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.lins4tech.sysautos.api.entities.Cliente;
import com.lins4tech.sysautos.api.entities.Loja;
import com.lins4tech.sysautos.api.enums.TipoClienteEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteRepositoryTest {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private static final String CNPJ = "15009078000188";
	private static final String CLIENTE_1_NOME = "Cliente1";
	private static final String CLIENTE_1_CPF = "05259988450";
	private static final String CLIENTE_2_NOME = "Cliente2";
	private static final String CLIENTE_2_CPF = "05259988451";
	
	
	
	@Before
	public void setUp() throws Exception {
		Loja loja = new Loja();
		loja.setRazaoSocial("Construtora Exemplo");
		loja.setCnpj(CNPJ);
		loja.setCidade("João Pessoa");
		loja.setEndereco("Av Jurandir Perez");
		loja.setEstado("PB");
		loja.setContato("Leurimar Lins");
		this.lojaRepository.save(loja);
		this.clienteRepository.save(generateCliente(loja, CLIENTE_1_NOME, CLIENTE_1_CPF, TipoClienteEnum.PF));
		this.clienteRepository.save(generateCliente(loja, CLIENTE_2_NOME, CLIENTE_2_CPF, TipoClienteEnum.PF));
	}
	
	@After
	public final void tearDown() throws Exception {
		this.clienteRepository.deleteAll();
		this.lojaRepository.deleteAll();
	}
	
	private Cliente generateCliente(Loja loja, String nome, String cpf, TipoClienteEnum tipo) {
		Cliente c = new Cliente();
		c.setLoja(loja);
		c.setNomeCompleto(nome);
		c.setCpfCnpj(cpf);
		c.setTipoClienteEnum(tipo);
		c.setEmail(nome + "@gmail.com");
		c.setCidade("João Pessoa");
		c.setEstado("PB");
		c.setEndereco("Avenida Coelho Lisboa");
		c.setCelular("(83)998827-2291");
		c.setDataNascimento(new Date());
		return c;
	}
	
	@Test
	public void testFindClienteByLojaId() {
		Loja loja = lojaRepository.findByCnpj(CNPJ).orElse(null);
		PageRequest pageable = PageRequest.of(0, 10);
		Page<Cliente> list = clienteRepository.findByLojaId(loja.getId(), pageable);
		assertTrue(list.getNumberOfElements() == 2);
	}
	
	@Test
	public void testFindClientePF() {
		Loja loja = lojaRepository.findByCnpj(CNPJ).orElse(null);
		String nome = "Cliente";
		String email = "@gmail.com";
		String cpf = "05259988450";
		TipoClienteEnum tipo = TipoClienteEnum.PF;
		PageRequest pageable = PageRequest.of(0, 10);
		List<Cliente> list = clienteRepository.findCliente(loja.getId(), nome, email, cpf, tipo, pageable);
		assertTrue(list.size() == 1);
	}
	
	@Test
	public void testFindClientePJ() {
		Loja loja = lojaRepository.findByCnpj(CNPJ).orElse(null);
		TipoClienteEnum tipo = TipoClienteEnum.PJ;
		PageRequest pageable = PageRequest.of(0, 10);
		List<Cliente> list = clienteRepository.findCliente(loja.getId(), null, null, null, tipo, pageable);
		assertTrue(list.size() == 0);
	}

}
