package br.gov.sp.fatec.projetotopicosespeciais.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usr_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usr_id")
	private Long id;
	
	@Column(name = "usr_nome", nullable = false)
	private String nome;
	
	@Column(name = "usr_senha", nullable = false)
	private String senha;
	
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable (name = "uau_usuario_autorizacao", 
		joinColumns = { @JoinColumn (name = "usr_id") },
		inverseJoinColumns = { @JoinColumn (name = "aut_id")}
	)
	private Set<Autorizacao> autorizacao;
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setAutorizacao(Set<Autorizacao> autorizacao) {
		this.autorizacao = autorizacao;
	}
	
	public Set<Autorizacao> getAutorizacao() {
		return autorizacao;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
}
