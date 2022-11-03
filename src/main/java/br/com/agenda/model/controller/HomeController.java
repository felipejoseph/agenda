package br.com.agenda.model.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agenda.model.Cliente;
import br.com.agenda.model.controller.dto.ClienteDto;
import br.com.agenda.model.controller.form.AtualizacaoClienteForm;
import br.com.agenda.model.controller.form.ClienteForm;
import br.com.agenda.repository.AgendaRepository;




@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {
	
	@Autowired
	private AgendaRepository repository;
		
	@GetMapping
	
	public List<ClienteDto> listar(String nomeCliente){
		
		if(nomeCliente == null) {
			List<Cliente> pokemons = repository.findAll();
			return ClienteDto.converter(pokemons);
		}
		
		else {
			List<Cliente> clientes = repository.findBynomeCliente(nomeCliente);
			return ClienteDto.converter(clientes);
		}
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm clienteform, UriComponentsBuilder uriBuilder) {
		
		Cliente cliente = clienteform.converter();
		
			repository.save(cliente);
		
			URI uri = uriBuilder.path("/home/{id}").buildAndExpand(cliente.getId()).toUri();
			return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
	
	@GetMapping("/editar/{id}")
	public ClienteDto detalhar(@PathVariable Long id) {
		@SuppressWarnings("deprecation")
		Cliente cliente = repository.getById(id);
		return new ClienteDto(cliente);
		
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoClienteForm atualizacaoclienteform){
		Cliente cliente = atualizacaoclienteform.atualizacao(id, repository);
		
		return ResponseEntity.ok(new ClienteDto(cliente));  
				
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
