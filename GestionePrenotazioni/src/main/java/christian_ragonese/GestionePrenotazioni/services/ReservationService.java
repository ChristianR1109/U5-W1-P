package christian_ragonese.GestionePrenotazioni.services;

import christian_ragonese.GestionePrenotazioni.entities.Reservation;
import christian_ragonese.GestionePrenotazioni.entities.User;
import christian_ragonese.GestionePrenotazioni.entities.Workstation;
import christian_ragonese.GestionePrenotazioni.repositories.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class ReservationService {
    @Autowired
    public ReservationRepository reservationRepository;

    public void saveNewReservation(Reservation reservation) {
        User user = reservation.getUser();
        Workstation workstation = reservation.getWorkstation();
        LocalDate date = reservation.getDate();


//controllo per data di prenotazione
        Optional<Reservation> userRes = reservationRepository.findByUserAndDate(user, date);

        if (userRes.isPresent()) {
            System.out.println("Prenotazione fallita, l'utente " + user.getUsername() + " ha già una prenotazione per la data " + date);
            return;
        }

        //controllo per postazione prenotata

        Optional<Reservation> workstationRes = reservationRepository.findByWorkstationAndDate(workstation, date);
        if (workstationRes.isPresent()) {
            System.out.println("Prenotazione fallita, la postazione " + workstationRes + " è già prenotata in data " + date);
            return;
        }
        reservationRepository.save(reservation);
        System.out.println("Prenotazione salvata per l'utente " + user.getUsername() + " in data: " + date);
    }
}
