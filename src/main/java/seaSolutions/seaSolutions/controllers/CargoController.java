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
import seaSolutions.seaSolutions.models.Cargo;
import seaSolutions.seaSolutions.responses.MessageResponse;
import seaSolutions.seaSolutions.responses.MessageResponseImpl;
import seaSolutions.seaSolutions.services.CargoService;

@RestController
@RequestMapping(path = "/cargos")
public class CargoController implements MessageResponse {
	
	@Autowired
	private CargoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cargo> findById(@PathVariable Long id) throws Exception {
		Cargo cargo = service.findById(id);
		return ResponseEntity.ok().body(cargo);
	};

	@GetMapping
	public ResponseEntity<List<Cargo>> findAll() {
		List<Cargo> cargos = service.findAll();
		return ResponseEntity.ok().body(cargos);
	}
	
	@PostMapping
	public ResponseEntity<MessageResponseImpl> create(@RequestBody Cargo cargo) {
		Cargo newCargo = service.create(cargo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCargo.getId()).toUri();
		return ResponseEntity.created(uri).body(createMessageResponse("Cargo criado com sucesso!"));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<MessageResponseImpl> update(@PathVariable Long id,
		@RequestBody Cargo cargo) throws Exception {
		service.update(id, cargo);
		return ResponseEntity.ok().body(createMessageResponse("Cargo atualizado com sucesso!"));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
