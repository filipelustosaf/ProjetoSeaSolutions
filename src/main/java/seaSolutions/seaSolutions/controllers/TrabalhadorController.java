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
import seaSolutions.seaSolutions.model.enums.SexoEnum;
import seaSolutions.seaSolutions.models.Trabalhador;
import seaSolutions.seaSolutions.responses.MessageResponse;
import seaSolutions.seaSolutions.services.TrabalhadorService;

@RestController
@RequestMapping(path = "/trabalhadores")
public class TrabalhadorController extends MessageResponseController {
	
	@Autowired
	private TrabalhadorService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trabalhador> findById(@PathVariable Long id) {
		Trabalhador trabalhador = service.findById(id);
		return ResponseEntity.ok().body(trabalhador);
	};

	@GetMapping
	public ResponseEntity<List<Trabalhador>> findAll() {
		List<Trabalhador> trabalhadores = service.findAll();
		return ResponseEntity.ok().body(trabalhadores);
	}
	
	@PostMapping
	public ResponseEntity<MessageResponse> create(@RequestBody Trabalhador trabalhador) throws Exception {
		Trabalhador newTrabalhador = service.create(trabalhador);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTrabalhador.getId()).toUri();
		return ResponseEntity.created(uri).body(createMessageResponse("Trabalhador cadastrado com sucesso!"));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<MessageResponse> update(@PathVariable Long id,
		@RequestBody Trabalhador trabalhador) {
		service.update(id, trabalhador);
		return ResponseEntity.ok().body(createMessageResponse("Trabalhador atualizado com sucesso!"));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

	@GetMapping(value = "/sexo/{sexo}")
	public ResponseEntity<List<Trabalhador>> findAllTrabalhadoresPorSexo(@PathVariable String sexo) throws Exception {
		SexoEnum sexoEnum = seaSolutions.seaSolutions.model.enums.SexoEnum.getSexoEnum(sexo);
		List<Trabalhador> trabalhadores = service.findAllTrabalhadoresBySexo(sexoEnum);
		return ResponseEntity.ok().body(trabalhadores);
	};
	
	@GetMapping(value = "/cargo/{cargo}")
	public ResponseEntity<List<Trabalhador>> findAllTrabalhadoresPorCargo(@PathVariable String cargo) throws Exception {
		List<Trabalhador> trabalhadores = service.findAllTrabalhadoresByCargo(cargo);
		return ResponseEntity.ok().body(trabalhadores);
	};
	
	@GetMapping(value = "/setor/{setor}")
	public ResponseEntity<List<Trabalhador>> findAllTrabalhadoresPorSetor(@PathVariable String setor) throws Exception {
		List<Trabalhador> trabalhadores = service.findAllTrabalhadoresBySetor(setor);
		return ResponseEntity.ok().body(trabalhadores);
	};

}
