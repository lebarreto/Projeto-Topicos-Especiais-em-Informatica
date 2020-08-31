package br.gov.sp.fatec.projetotopicosespeciais.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aut_autorizacao")
public class Autorizacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "aut_id")
	private Long id;
	
	@Column(name = "aut_nome", nullable = false)
	private String nome;
	
	@ManyToMany (fetch = FetchType.LAZY, mappedBy = "autorizacao")
	private Set<Usuario> usuario;
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	public Set<Usuario> getUsuario() {
		return usuario;
	}

}
