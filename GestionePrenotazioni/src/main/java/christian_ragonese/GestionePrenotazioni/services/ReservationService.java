package christian_ragonese.GestionePrenotazioni.services;

import christian_ragonese.GestionePrenotazioni.entities.Reservation;
import christian_ragonese.GestionePrenotazioni.repositories.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReservationService {
    @Autowired
    public ReservationRepository reservationRepository;

    public void saveNewReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
