package br.gov.sp.fatec.projetotopicosespeciais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.projetotopicosespeciais.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
