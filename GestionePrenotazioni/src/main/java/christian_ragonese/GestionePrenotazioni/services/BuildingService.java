package christian_ragonese.GestionePrenotazioni.services;


import christian_ragonese.GestionePrenotazioni.entities.Building;
import christian_ragonese.GestionePrenotazioni.repositories.BuildingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;


    public void saveNewBuilding(Building building) {
        Optional<Building> exBuilding = buildingRepository.findByName(building.getName());
        if (exBuilding.isPresent()) {
            System.out.println("L'edificio " + building.getName() + " esiste già");
        } else {
            buildingRepository.save(building);
            System.out.println("L'edificio " + building.getName() + " è stato salvato correttamente");
        }

    }
}
