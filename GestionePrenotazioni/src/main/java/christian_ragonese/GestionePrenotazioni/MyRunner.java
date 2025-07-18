package christian_ragonese.GestionePrenotazioni;

import christian_ragonese.GestionePrenotazioni.entities.*;
import christian_ragonese.GestionePrenotazioni.exceptions.UserNotFoundException;
import christian_ragonese.GestionePrenotazioni.exceptions.WorkstationNotFoundException;
import christian_ragonese.GestionePrenotazioni.services.BuildingService;
import christian_ragonese.GestionePrenotazioni.services.ReservationService;
import christian_ragonese.GestionePrenotazioni.services.UserService;
import christian_ragonese.GestionePrenotazioni.services.WorkstationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class MyRunner implements CommandLineRunner {
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserService userService;
    @Autowired
    private WorkstationService workstationService;

    @Override
    public void run(String... args) throws Exception {
        List<Reservation> reservationList1 = new ArrayList<>();
        List<Reservation> reservationList2 = new ArrayList<>();
        List<Workstation> workstationBuilding1 = new ArrayList<>();
        List<Workstation> workstationBuilding2 = new ArrayList<>();
        List<Reservation> pinosReservation = new ArrayList<>();
        List<Reservation> francosReservation = new ArrayList<>();


        //BUILDINGS
        Building building1 = new Building("Building1", "Street 23", "Rome", workstationBuilding1);
        Building building2 = new Building("Building2", "Street 24", "Rome", workstationBuilding2);
        buildingService.saveNewBuilding(building1);
        buildingService.saveNewBuilding(building2);
        //WORKSTATION
        Workstation workstation1 = new Workstation("postazionenumero1", WorkstationType.MEETINGROOM, 30, building1, reservationList1);
        Workstation workstation2 = new Workstation("postazionenumero2", WorkstationType.OPENSPACE, 25, building2, reservationList2);
        Workstation workstation3 = new Workstation("postazionenumero3", WorkstationType.PRIVATE, 20, building1, reservationList1);
        Workstation workstation4 = new Workstation("postazionenumero4", WorkstationType.MEETINGROOM, 40, building2, reservationList2);
        Workstation workstation5 = new Workstation("postazionenumero5", WorkstationType.OPENSPACE, 15, building1, reservationList1);
        Workstation workstation6 = new Workstation("postazionenumero6", WorkstationType.PRIVATE, 10, building2, reservationList1);
        workstationService.saveNewWorkstation(workstation1);
        workstationService.saveNewWorkstation(workstation2);
        workstationService.saveNewWorkstation(workstation3);
        workstationService.saveNewWorkstation(workstation4);
        workstationService.saveNewWorkstation(workstation5);
        workstationService.saveNewWorkstation(workstation6);

        workstationBuilding1.add(workstation1);
        workstationBuilding1.add(workstation3);
        workstationBuilding1.add(workstation5);

        workstationBuilding2.add(workstation2);
        workstationBuilding2.add(workstation4);
        workstationBuilding2.add(workstation6);
        // utilizzo lambda perchè orElseThrow vuole un Supplier

        Workstation workstationDb1 = workstationService.findByDescription("postazionenumero1").orElseThrow(() -> new WorkstationNotFoundException(workstation1.getDescription()));
        Workstation workstationDb2 = workstationService.findByDescription("postazionenumero2").orElseThrow(() -> new WorkstationNotFoundException(workstation2.getDescription()));
        Workstation workstationDb3 = workstationService.findByDescription("postazionenumero3").orElseThrow(() -> new WorkstationNotFoundException(workstation3.getDescription()));
        //USER
        User user1 = new User("pino.pinetto", "pino", "pinetto", "pino.pinetto@pino.com", pinosReservation);
        userService.saveNewUser(user1);
        User userDb1 = userService.findByUsername("pino.pinetto").orElseThrow(() -> new UserNotFoundException(user1.getUsername()));

        User user2 = new User("franco.conetto", "franco", "conetto", "franco.conetto@franco.com", francosReservation);
        userService.saveNewUser(user2);
        User userDb2 = userService.findByUsername("franco.conetto").orElseThrow(() -> new UserNotFoundException(user2.getUsername()));

        //RESERVATION
        Reservation reservation1 = new Reservation(workstationDb1, userDb1, LocalDate.now());
        reservationService.saveNewReservation(reservation1);

        Reservation reservation2 = new Reservation(workstationDb2, userDb2, LocalDate.now());
        reservationService.saveNewReservation(reservation2);

        Reservation reservation3 = new Reservation(workstationDb3, userDb2, LocalDate.of(2025, 7, 19));
        reservationService.saveNewReservation(reservation3);
        pinosReservation.add(reservation1);
        francosReservation.add(reservation2);
        francosReservation.add(reservation3);
        //METHODS
        System.out.println("");
        System.out.println("RICERCA POSTAZIONE PER TIPOLOGIA E CITTA'");
        System.out.println("");
        List<Workstation> found = workstationService.findByTypeAndCity(WorkstationType.MEETINGROOM, "Romee");
        found.forEach(o -> System.out.println("Postazione trovata con descrizione :  " + o.getDescription()));

    }
}
