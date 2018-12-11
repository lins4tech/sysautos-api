package com.lins4tech.sysautos.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.lins4tech.sysautos.api.enums.TipoUsuarioEnum;


@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 7129459210440467737L;
	
	private Long id;
	private String nomeCompleto;
	private String email;
	private String password;
	private Loja loja;
	private TipoUsuarioEnum tipoUsuarioEnum;
	private Date dataCadastro;
	private Date dataAtualizacao;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "nome_completo", nullable = false)
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToOne
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_usuario", nullable = false)
	public TipoUsuarioEnum getTipoUsuarioEnum() {
		return tipoUsuarioEnum;
	}
	public void setTipoUsuarioEnum(TipoUsuarioEnum tipoUsuarioEnum) {
		this.tipoUsuarioEnum = tipoUsuarioEnum;
	}
	
	@Column(name = "data_cadastro", nullable = false)
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Column(name = "data_atualizacao")
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date actualDate = new Date();
		dataCadastro = actualDate;
		dataAtualizacao = actualDate;
	}
	
	

}
