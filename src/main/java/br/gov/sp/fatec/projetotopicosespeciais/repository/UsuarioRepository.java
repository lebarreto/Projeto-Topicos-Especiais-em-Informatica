package br.gov.sp.fatec.projetotopicosespeciais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.projetotopicosespeciais.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT u FROM Usuario u WHERE u.nome like %?1%")
	public List<Usuario> findByNameContainsIgnoreCase (@Param("name") String name);
	
	@Query("SELECT u FROM Usuario u WHERE u.nome = :name")
	public Usuario findByName (@Param("name") String name);
	
	@Query("SELECT u FROM Usuario u WHERE u.nome = :name AND u.senha = :pass")
	public Usuario findByNameAndPass (@Param("name") String name, @Param("pass") String pass);
	
	@Query("SELECT u FROM Usuario u JOIN Autorizacao a ON u.id = a.id WHERE a.nome = :auth ")
	public List<Usuario> findByAuthorization (@Param("auth") String auth);
}
