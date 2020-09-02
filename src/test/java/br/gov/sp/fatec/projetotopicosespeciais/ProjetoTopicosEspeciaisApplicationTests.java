package br.gov.sp.fatec.projetotopicosespeciais;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.gov.sp.fatec.projetotopicosespeciais.entity.Autorizacao;
import br.gov.sp.fatec.projetotopicosespeciais.entity.Usuario;
import br.gov.sp.fatec.projetotopicosespeciais.repository.AutorizacaoRepository;
import br.gov.sp.fatec.projetotopicosespeciais.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
class ProjetoTopicosEspeciaisApplicationTests {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AutorizacaoRepository autorizacaoRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void insertUser() {
		Usuario usuario = new Usuario();
		
		usuario.setNome("Usuário");
		usuario.setSenha("123123");
		usuario.setAutorizacao(new HashSet<Autorizacao>());
		
		Autorizacao aut = new Autorizacao();
		aut.setNome("USER");
		
		autorizacaoRepository.save(aut);
		
		usuario.getAutorizacao().add(aut);
		
		usuarioRepository.save(usuario);
		
		assertNotNull(usuario.getAutorizacao().iterator().next().getId());
	}
	
	@Test
	void insertAuthorization() {
		Usuario usuario = new Usuario();
		
		usuario.setNome("Usuário2");
		usuario.setSenha("123123");
		usuario.setAutorizacao(new HashSet<Autorizacao>());
		
		usuarioRepository.save(usuario);

		Autorizacao aut = new Autorizacao();
		aut.setNome("USER2");
		aut.setUsuario(new HashSet<Usuario>());
		aut.getUsuario().add(usuario);
		
		autorizacaoRepository.save(aut);
		
		usuario.getAutorizacao().add(aut);
		
		assertNotNull(aut.getUsuario().iterator().next().getId());
	}

	
	@Test
	void testAuthorization() {
		Usuario usuario = usuarioRepository.findById(1L).get();
		
		assertEquals("ADMIN", usuario.getAutorizacao().iterator().next().getNome());
	}
	
	@Test
	void testUsers() {
		Autorizacao aut = autorizacaoRepository.findById(1L).get();
		
		assertEquals("Letícia Barreto", aut.getUsuario().iterator().next().getNome());
	}
	
	@Test
	void findUserByNameContains() {
		List<Usuario> user = usuarioRepository.findByNameContainsIgnoreCase("L");
		
		assertFalse(user.isEmpty());
	}
	
	@Test
	void findUserByName() {
		Usuario user = usuarioRepository.findByName("Letícia Barreto");
		
		assertNotNull(user);
	}
	
	@Test
	void findUserByNameAndPass() {
		Usuario user = usuarioRepository.findByNameAndPass("Letícia Barreto", "123123");
		
		assertNotNull(user);
	}
	
	@Test
	void findUserByAuthorization() {
		List<Usuario> user = usuarioRepository.findByAuthorization("ADMIN");
				
		assertFalse(user.isEmpty());
	}
}
