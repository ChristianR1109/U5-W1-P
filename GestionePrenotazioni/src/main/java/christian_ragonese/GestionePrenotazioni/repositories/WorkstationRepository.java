package christian_ragonese.GestionePrenotazioni.repositories;

import christian_ragonese.GestionePrenotazioni.entities.Workstation;
import christian_ragonese.GestionePrenotazioni.entities.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Long> {

    List<Workstation> findByTypeAndBuilding_City(WorkstationType type, String city);

    Optional<Workstation> findByDescription(String description);
}
