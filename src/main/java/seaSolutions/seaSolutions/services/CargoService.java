package seaSolutions.seaSolutions.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seaSolutions.seaSolutions.exceptions.ResourceNotFoundException;
import seaSolutions.seaSolutions.models.Cargo;
import seaSolutions.seaSolutions.repositories.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public Cargo findById(Long id) {	
		return cargoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cargo não encontrado!"));
	}
	
	public List<Cargo> findAll() {
		return cargoRepository.findAll();
	}	
	
	public Cargo create(Cargo cargo) {
		cargoRepository.save(cargo);
		return cargo;
	}
	
	public Cargo update(Long id, Cargo newCargo) {
		Cargo cargo = findById(id);		
		cargo.setNome(newCargo.getNome() != null ? newCargo.getNome() : cargo.getNome()) ;
		cargo.setNivel(newCargo.getNivel() != null ? newCargo.getNivel() : cargo.getNivel());
		cargo.setSalario(newCargo.getSalario() != 0 ? newCargo.getSalario() : cargo.getSalario());
		cargo.setSetor(newCargo.getSetor() != null ? newCargo.getSetor() : cargo.getSetor());
		return cargoRepository.save(cargo);
	}
	
	public void delete(Long id) {
		Cargo cargo = findById(id);
		cargoRepository.delete(cargo);
	}
	
	public List<Cargo> findAllCargosBySetor(String setor) {
		List<Cargo> cargos = cargoRepository.findAll()
			.stream()
			.filter(c -> c.getSetor().getNome().equals(setor))
			.collect(Collectors.toList());
		return cargos;
	}
	
}
