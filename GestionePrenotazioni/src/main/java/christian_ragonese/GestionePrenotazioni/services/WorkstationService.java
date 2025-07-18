package christian_ragonese.GestionePrenotazioni.services;

import christian_ragonese.GestionePrenotazioni.entities.Workstation;
import christian_ragonese.GestionePrenotazioni.entities.WorkstationType;
import christian_ragonese.GestionePrenotazioni.repositories.WorkstationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class WorkstationService {
    @Autowired
    WorkstationRepository workstationRepository;

    public void saveNewWorkstation(Workstation workstation) {
        Optional<Workstation> exWorkstation = workstationRepository.findByDescription(workstation.getDescription());
        if (exWorkstation.isPresent()) {
            System.out.println("La postazione " + workstation.getDescription() + " esiste già ");

        } else {
            workstationRepository.save(workstation);
            System.out.println("Postazione " + workstation.getDescription() + " salvata correttamente");
        }
    }

    public List<Workstation> findByTypeAndCity(WorkstationType type, String city) {
        return workstationRepository.findByTypeAndBuilding_City(type, city);
    }
}
