package com.lins4tech.sysautos.api.dtos;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lins4tech.sysautos.api.entities.Cliente;


public class ClienteDto {
	
	private Long id;
	private Long lojaId;
	private String nomeCompleto;
	private String tipoCliente;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dataNascimento;
	private String email;
	private String rg;
	private String cpfCnpj;
	private String contato;
	private String telefone;
	private String celular;
	private String endereco;
	private String cidade;
	private String estado;
	private String cep;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dataCadastro;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dataAtualizacao;
	
	
	public ClienteDto() {
		super();
	}
	
	public ClienteDto(Cliente c) {
		this.id = c.getId();
		this.lojaId = c.getLoja().getId();
		this.nomeCompleto = c.getNomeCompleto();
		this.tipoCliente = c.getTipoClienteEnum().name();
		this.dataNascimento = c.getDataNascimento();
		this.email = c.getEmail();
		this.rg = c.getRg();
		this.cpfCnpj = c.getCpfCnpj();
		this.contato = c.getContato();
		this.telefone = c.getTelefone();
		this.celular = c.getCelular();
		this.endereco = c.getEndereco();
		this.cidade = c.getCidade();
		this.estado = c.getEstado();
		this.cep = c.getCep();
		this.dataCadastro = c.getDataCadastro();
		this.dataAtualizacao = c.getDataAtualizacao();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLojaId() {
		return lojaId;
	}
	public void setLojaId(Long lojaId) {
		this.lojaId = lojaId;
	}
	
	@NotEmpty(message="Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	@NotEmpty(message="Tipo do Cliente não pode ser vazio.")
	@Length(min = 2, max = 2, message = "Nome deve conter apenas 2 caracteres.")
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@NotEmpty(message = "Email não pode ser vazio.")
	@Length(min = 5, max = 200, message = "Email deve conter entre 5 e 200 caracteres.")
	@Email(message="Email inválido.")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	@NotEmpty(message = "CPF/CNPJ não pode ser vazio.")
	@Length(min = 11, max = 14, message = "CPF/CNPJ deve conter entre 11 e 14 caracteres.")
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	

}
