package seaSolutions.seaSolutions.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seaSolutions.seaSolutions.exceptions.AttributesErrorException;
import seaSolutions.seaSolutions.exceptions.ResourceNotFoundException;
import seaSolutions.seaSolutions.model.enums.sexoEnum;
import seaSolutions.seaSolutions.models.Trabalhador;
import seaSolutions.seaSolutions.repositories.TrabalhadorRepository;

@Service
public class TrabalhadorService {
	
	@Autowired
	private TrabalhadorRepository trabalhadorRepository;
	
	public Trabalhador findById(Long id) {	
		return trabalhadorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Trabalhador não encontrado!"));
	}
	
	public List<Trabalhador> findAll() {
		return trabalhadorRepository.findAll();
	}	
	
	public Trabalhador create(Trabalhador trabalhador) throws Exception {
		try {
			trabalhadorRepository.save(trabalhador);
		} catch (Exception e) {
			throw new AttributesErrorException("Erro nos atributos passados!");
		} 		
		return trabalhador;
	}
	
	public Trabalhador update(Long id, Trabalhador newTrabalhador) {
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
	
	public void delete(Long id) {
		Trabalhador trabalhador = findById(id);
		trabalhadorRepository.delete(trabalhador);
	}
	
	public List<Trabalhador> findAllTrabalhadoresBySexo(sexoEnum sexo) {
		List<Trabalhador> trabalhadores = trabalhadorRepository.findAll()
			.stream()
			.filter(t -> t.getSexo().equals(sexo))
			.collect(Collectors.toList());
		return trabalhadores;
	}
	
	public List<Trabalhador> findAllTrabalhadoresByCargo(String cargo) {
		List<Trabalhador> trabalhadores = trabalhadorRepository.findAll()
			.stream()
			.filter(t -> t.getCargo().getNome().equals(cargo))
			.collect(Collectors.toList());
		return trabalhadores;
	}
	
	public List<Trabalhador> findAllTrabalhadoresBySetor(String setor) {
		List<Trabalhador> trabalhadores = trabalhadorRepository.findAll()
			.stream()
			.filter(t -> t.getCargo().getSetor().getNome().equals(setor))
			.collect(Collectors.toList());;
		return trabalhadores;
	}
	
}
