package seaSolutions.seaSolutions.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seaSolutions.seaSolutions.exceptions.ResourceNotFoundException;
import seaSolutions.seaSolutions.models.Setor;
import seaSolutions.seaSolutions.repositories.SetorRepository;

@Service
public class SetorService {
	
	@Autowired
	private SetorRepository setorRepository;
	
	public Setor findById(Long id) {	
		return setorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Setor não encontrado!"));
	}
	
	public List<Setor> findAll() {
		return setorRepository.findAll();
	}	
	
	public Setor create(Setor setor) throws Exception {
		setorRepository.save(setor);
		return setor;
	}
	
	public Setor update(Long id, Setor newSetor) {
		Setor setor = findById(id);		
		setor.setNome(newSetor.getNome() != null ? newSetor.getNome() : setor.getNome());
		return setorRepository.save(setor);
	}
	
	public void delete(Long id) {
		Setor setor = findById(id);
		setorRepository.delete(setor);
	}
	
}
