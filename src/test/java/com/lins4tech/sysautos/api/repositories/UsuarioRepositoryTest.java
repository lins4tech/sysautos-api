package com.lins4tech.sysautos.api.repositories;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.lins4tech.sysautos.api.entities.Loja;
import com.lins4tech.sysautos.api.entities.Usuario;
import com.lins4tech.sysautos.api.enums.TipoClienteEnum;
import com.lins4tech.sysautos.api.enums.TipoUsuarioEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	private static final String CNPJ = "15009078000188";

	private static final String USER_1_NOME = "Cliente1";
	private static final String USER_1_EMAIL = "cliente1@gmail.com";
	
	private static final String USER_2_NOME = "Cliente2";
	private static final String USER_2_EMAIL = "cliente2@gmail.com";
	
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
		this.usuarioRepository.save(generateUsuario(loja, USER_1_NOME, USER_1_EMAIL, TipoUsuarioEnum.ROLE_ADMIN));
		this.usuarioRepository.save(generateUsuario(loja, USER_2_NOME, USER_2_EMAIL, TipoUsuarioEnum.ROLE_USUARIO));
	}
	
	@After
	public final void tearDown() throws Exception {
		this.usuarioRepository.deleteAll();
		this.lojaRepository.deleteAll();
	}
	
	private Usuario generateUsuario(Loja loja, String nome, String email, TipoUsuarioEnum tipo) {
		Usuario user = new Usuario();
		user.setLoja(loja);
		user.setNomeCompleto(nome);
		user.setTipoUsuarioEnum(tipo);
		user.setEmail(email);
		user.setPassword("xxx");
		return user;
	}
	
	@Test
	public void testFindUsuarioByLojaId() {
		Loja loja = lojaRepository.findByCnpj(CNPJ);
		@SuppressWarnings("deprecation")
		PageRequest pageable = new PageRequest(0, 10);
		List<Usuario> list = usuarioRepository.findByLojaId(loja.getId(), pageable);
		assertTrue(list.size() == 2);
	}
}
