package seaSolutions.seaSolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import seaSolutions.seaSolutions.models.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long>{

}
