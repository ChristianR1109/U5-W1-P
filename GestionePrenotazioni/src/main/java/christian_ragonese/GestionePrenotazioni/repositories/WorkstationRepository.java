package christian_ragonese.GestionePrenotazioni.repositories;

import christian_ragonese.GestionePrenotazioni.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Long> {
}
