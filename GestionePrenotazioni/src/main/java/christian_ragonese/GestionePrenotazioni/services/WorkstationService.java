package christian_ragonese.GestionePrenotazioni.services;

import christian_ragonese.GestionePrenotazioni.entities.Workstation;
import christian_ragonese.GestionePrenotazioni.repositories.WorkstationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkstationService {
    @Autowired
    WorkstationRepository workstationRepository;

    public void saveNewWorkstation(Workstation workstation) {

        workstationRepository.save(workstation);
    }
}
