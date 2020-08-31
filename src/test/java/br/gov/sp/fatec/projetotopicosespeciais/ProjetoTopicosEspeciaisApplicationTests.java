package br.gov.sp.fatec.projetotopicosespeciais;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.sp.fatec.projetotopicosespeciais.entity.Autorizacao;
import br.gov.sp.fatec.projetotopicosespeciais.entity.Usuario;
import br.gov.sp.fatec.projetotopicosespeciais.repository.AutorizacaoRepository;
import br.gov.sp.fatec.projetotopicosespeciais.repository.UsuarioRepository;

@SpringBootTest
@Transactional
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
	void testAuthorization() {
		Usuario usuario = usuarioRepository.findById(1L).get();
		
		assertEquals("ADMIN", usuario.getAutorizacao().iterator().next().getNome());
	}
	
	@Test
	void testUsers() {
		Autorizacao aut = autorizacaoRepository.findById(1L).get();
		
		assertEquals("Letícia Barreto", aut.getUsuario().iterator().next().getNome());
	}

}
