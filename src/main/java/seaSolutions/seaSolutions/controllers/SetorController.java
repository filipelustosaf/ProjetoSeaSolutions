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
import seaSolutions.seaSolutions.models.Setor;
import seaSolutions.seaSolutions.services.SetorService;

@RestController
@RequestMapping(path = "/setores")
public class SetorController {
	
	@Autowired
	private SetorService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Setor> findById(@PathVariable Long id) throws Exception {
		Setor setor = service.findById(id);
		return ResponseEntity.ok().body(setor);
	};

	@GetMapping
	public ResponseEntity<List<Setor>> findAll() {
		List<Setor> setores = service.findAll();
		return ResponseEntity.ok().body(setores);
	}
	
	@PostMapping
	public ResponseEntity<Setor> create(@RequestBody Setor setor) {
		Setor newSetor = service.create(setor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newSetor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Setor> update(@PathVariable Long id,
		@RequestBody Setor setor) throws Exception {
		service.update(id, setor);
		return ResponseEntity.ok().body(setor);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
