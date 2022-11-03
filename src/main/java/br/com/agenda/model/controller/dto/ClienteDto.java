package br.com.agenda.model.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.agenda.model.Cliente;


public class ClienteDto {
	
	private Long id;
	private String nomeCliente;
	private String email;
	private String endereco;
	private String bairro;
	private String complemento;
	private String cidade;
	
	public ClienteDto(Cliente cliente){
		this.id = cliente.getId();
		this.nomeCliente = cliente.getNomeCliente();
		this.email = cliente.getEmail();
		this.endereco = cliente.getEndereco();
		this.bairro = cliente.getBairro();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


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
	
	
		public static List<ClienteDto> converter(List<Cliente> clientes) {
		
			return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
		}
	
}
