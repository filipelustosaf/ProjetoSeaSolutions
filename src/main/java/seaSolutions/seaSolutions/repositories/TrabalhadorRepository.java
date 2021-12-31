package seaSolutions.seaSolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import seaSolutions.seaSolutions.models.Trabalhador;

public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long>{
	
}
