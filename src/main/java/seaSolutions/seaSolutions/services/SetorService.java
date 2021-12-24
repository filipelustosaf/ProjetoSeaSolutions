package seaSolutions.seaSolutions.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seaSolutions.seaSolutions.models.Setor;
import seaSolutions.seaSolutions.repositories.SetorRepository;

@Service
public class SetorService {
	
	@Autowired
	private SetorRepository setorRepository;
	
	public Setor findById(Long id) throws Exception {	
		return setorRepository.findById(id)
				.orElseThrow(() -> new Exception("Setor não encontrado."));
	}
	
	public List<Setor> findAll() {
		return setorRepository.findAll();
	}	
	
	public Setor create(Setor setor) {
		return setorRepository.save(setor);
	}
	
	public Setor update(Long id, Setor newSetor) throws Exception {
		Setor setor = findById(id);		
		setor.setNome(newSetor.getNome() != null ? newSetor.getNome() : setor.getNome());
		return setorRepository.save(setor);
	}
	
	public void delete(Long id) throws Exception {
		Setor setor = findById(id);
		setorRepository.delete(setor);
	}
}
