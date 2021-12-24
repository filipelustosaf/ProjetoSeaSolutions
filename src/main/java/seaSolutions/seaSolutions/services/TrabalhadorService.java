package seaSolutions.seaSolutions.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		trabalhador.setDataNascimento(newTrabalhador.getDataNascimento() != null ? newTrabalhador.getDataNascimento() : trabalhador.getDataNascimento());
		trabalhador.setEmail(newTrabalhador.getEmail() != null ? newTrabalhador.getEmail() : trabalhador.getEmail());
		trabalhador.setTelefone(newTrabalhador.getTelefone() != null ? newTrabalhador.getTelefone() : trabalhador.getTelefone());
		trabalhador.setEndereco(newTrabalhador.getEndereco() != null ? newTrabalhador.getEndereco() : trabalhador.getEndereco());
		trabalhador.setCargo(newTrabalhador.getCargo() != null ? newTrabalhador.getCargo() : trabalhador.getCargo());
		return trabalhadorRepository.save(trabalhador);
	}
	
	public void delete(Long id) throws Exception {
		Trabalhador trabalhador = findById(id);
		trabalhadorRepository.delete(trabalhador);
	}
}
