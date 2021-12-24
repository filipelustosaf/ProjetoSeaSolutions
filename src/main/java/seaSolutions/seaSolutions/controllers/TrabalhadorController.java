package seaSolutions.seaSolutions.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import seaSolutions.seaSolutions.models.Trabalhador;
import seaSolutions.seaSolutions.responses.MessageResponse;
import seaSolutions.seaSolutions.responses.MessageResponseImpl;
import seaSolutions.seaSolutions.services.TrabalhadorService;

@RestController
@RequestMapping(path = "/trabalhadores")
public class TrabalhadorController implements MessageResponse {
	
	@Autowired
	private TrabalhadorService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trabalhador> findById(@PathVariable Long id) throws Exception {
		Trabalhador trabalhador = service.findById(id);
		return ResponseEntity.ok().body(trabalhador);
	};

	@GetMapping
	public ResponseEntity<List<Trabalhador>> findAll() {
		List<Trabalhador> trabalhadores = service.findAll();
		return ResponseEntity.ok().body(trabalhadores);
	}
	
	@PostMapping
	public ResponseEntity<MessageResponseImpl> create(@RequestBody Trabalhador trabalhador) {
		Trabalhador newTrabalhador = service.create(trabalhador);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTrabalhador.getId()).toUri();
		return ResponseEntity.created(uri).body(createMessageResponse("Trabalhador cadastrado com sucesso!"));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<MessageResponseImpl> update(@PathVariable Long id,
		@RequestBody Trabalhador trabalhador) throws Exception {
		service.update(id, trabalhador);
		return ResponseEntity.ok().body(createMessageResponse("Trabalhador atualizado com sucesso!"));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
