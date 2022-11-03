package br.com.agenda.model.controller.form;

import javax.validation.constraints.NotEmpty;

import br.com.agenda.model.Cliente;
import br.com.agenda.repository.AgendaRepository;

public class AtualizacaoClienteForm {
	
	@NotEmpty
	private String nomeCliente;
	@NotEmpty
	private String email;
	@NotEmpty
	private String endereco;
	@NotEmpty
	private String bairro;
	
	private String complemento;
	@NotEmpty
	private String cidade;
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
		public Cliente atualizacao(Long id, AgendaRepository repository) {
				
				Cliente cliente = repository.getById(id);
				
				cliente.setNomeCliente(this.nomeCliente);
				cliente.setEmail(this.email);
				cliente.setEndereco(this.endereco);
				cliente.setBairro(this.bairro);
				cliente.setComplemento(this.complemento);
				cliente.setCidade(this.cidade);
				
				return cliente;
			}
	
}
