package br.gov.sp.fatec.projetotopicosespeciais;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.sp.fatec.projetotopicosespeciais.entity.Usuario;
import br.gov.sp.fatec.projetotopicosespeciais.repository.UsuarioRepository;

@SpringBootTest
class ProjetoTopicosEspeciaisApplicationTests {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void insertUser() {
		Usuario usuario = new Usuario();
		
		usuario.setNome("Letícia Barreto");
		usuario.setSenha("123123");
		
		usuarioRepository.save(usuario);
		
		assertNotNull(usuario.getId());
	}

}
