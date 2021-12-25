package seaSolutions.seaSolutions.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seaSolutions.seaSolutions.model.enums.cargoNomeEnum;
import seaSolutions.seaSolutions.model.enums.setorNomeEnum;
import seaSolutions.seaSolutions.model.enums.sexoEnum;
import seaSolutions.seaSolutions.models.Trabalhador;
import seaSolutions.seaSolutions.repositories.TrabalhadorRepository;

@Service
public class TrabalhadorService {
	
	@Autowired
	private TrabalhadorRepository trabalhadorRepository;
	
	public Trabalhador findById(Long id) throws Exception {	
		return trabalhadorRepository.findById(id)
				.orElseThrow(() -> new Exception("Trabalhador não encontrado."));
	}
	
	public List<Trabalhador> findAll() {
		return trabalhadorRepository.findAll();
	}	
	
	public Trabalhador create(Trabalhador trabalhador) {
		return trabalhadorRepository.save(trabalhador);
	}
	
	public Trabalhador update(Long id, Trabalhador newTrabalhador) throws Exception {
		Trabalhador trabalhador = findById(id);		
		trabalhador.setNome(newTrabalhador.getNome() != null ? newTrabalhador.getNome() : trabalhador.getNome());
		trabalhador.setCpf(newTrabalhador.getCpf() != null ? newTrabalhador.getCpf() : trabalhador.getCpf());
		trabalhador.setSexo(newTrabalhador.getSexo() != null ? newTrabalhador.getSexo() : trabalhador.getSexo());
		trabalhador.setDataNascimento(newTrabalhador.getDataNascimento() != null ? newTrabalhador.getDataNascimento() : trabalhador.getDataNascimento());
		trabalhador.setEmail(newTrabalhador.getEmail() != null ? newTrabalhador.getEmail() : trabalhador.getEmail());
		trabalhador.setTelefone(newTrabalhador.getTelefone() != null ? newTrabalhador.getTelefone() : trabalhador.getTelefone());
		trabalhador.setEndereco(newTrabalhador.getEndereco() != null ? newTrabalhador.getEndereco() : trabalhador.getEndereco());
		trabalhador.setCargo(newTrabalhador.getCargo() != null ? newTrabalhador.getCargo() : trabalhador.getCargo());
		trabalhador.setStatus(newTrabalhador.getStatus() != null ? newTrabalhador.getStatus() : trabalhador.getStatus());
		return trabalhadorRepository.save(trabalhador);
	}
	
	public void delete(Long id) throws Exception {
		Trabalhador trabalhador = findById(id);
		trabalhadorRepository.delete(trabalhador);
	}
	
	public List<Trabalhador> findAllTrabalhadoresPorSexo(sexoEnum sexo) {
		List<Trabalhador> trabalhadores = trabalhadorRepository.findAll();
		List<Trabalhador> trabalhadoresPorSexo = null;
		for (Trabalhador trabalhador : trabalhadores) {
			if (trabalhador.getSexo().equals(sexo)) {
				trabalhadoresPorSexo.add(trabalhador);
			}
		}
		return trabalhadoresPorSexo;
	}
	
	public List<Trabalhador> findAllTrabalhadoresPorCargo(cargoNomeEnum cargo) {
		List<Trabalhador> trabalhadores = trabalhadorRepository.findAll();
		List<Trabalhador> trabalhadoresPorCargo = null;
		for (Trabalhador trabalhador : trabalhadores) {
			if (trabalhador.getCargo().getNome().equals(cargo)) {
				trabalhadoresPorCargo.add(trabalhador);
			}
		}
		return trabalhadoresPorCargo;
	}
	
	public List<Trabalhador> findAllTrabalhadoresPorSetor(setorNomeEnum setor) {
		List<Trabalhador> trabalhadores = trabalhadorRepository.findAll();
		List<Trabalhador> trabalhadoresNoSetor = null;
		for (Trabalhador trabalhador : trabalhadores) {
			if (trabalhador.getCargo().getSetor().getNome().equals(setor)) {
				trabalhadoresNoSetor.add(trabalhador);
			}
		}
		return trabalhadoresNoSetor;
	}
	
}
