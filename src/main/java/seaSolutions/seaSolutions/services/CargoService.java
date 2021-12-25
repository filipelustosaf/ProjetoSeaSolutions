package seaSolutions.seaSolutions.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seaSolutions.seaSolutions.model.enums.setorNomeEnum;
import seaSolutions.seaSolutions.models.Cargo;
import seaSolutions.seaSolutions.models.Trabalhador;
import seaSolutions.seaSolutions.repositories.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public Cargo findById(Long id) throws Exception {	
		return cargoRepository.findById(id)
				.orElseThrow(() -> new Exception("Cargo não encontrado."));
	}
	
	public List<Cargo> findAll() {
		return cargoRepository.findAll();
	}	
	
	public Cargo create(Cargo cargo) {
		return cargoRepository.save(cargo);
	}
	
	public Cargo update(Long id, Cargo newCargo) throws Exception {
		Cargo cargo = findById(id);		
		cargo.setNome(newCargo.getNome() != null ? newCargo.getNome() : cargo.getNome());
		cargo.setNivel(newCargo.getNivel() != null ? newCargo.getNivel() : cargo.getNivel());
		cargo.setSalario(newCargo.getSalario() != 0 ? newCargo.getSalario() : cargo.getSalario());
		cargo.setSetor(newCargo.getSetor() != null ? newCargo.getSetor() : cargo.getSetor());
		return cargoRepository.save(cargo);
	}
	
	public void delete(Long id) throws Exception {
		Cargo cargo = findById(id);
		cargoRepository.delete(cargo);
	}
	
	public List<Cargo> findAllCargosPorSetor(setorNomeEnum setor) {
		List<Cargo> cargos = cargoRepository.findAll();
		List<Cargo> cargosNoSetor = null;
		for (Cargo cargo : cargos) {
			if (cargo.getSetor().getNome().equals(setor)) {
				cargosNoSetor.add(cargo);
			}
		}
		return cargosNoSetor;
	}
	
}
