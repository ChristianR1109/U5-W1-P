package christian_ragonese.GestionePrenotazioni.repositories;

import christian_ragonese.GestionePrenotazioni.entities.Reservation;
import christian_ragonese.GestionePrenotazioni.entities.User;
import christian_ragonese.GestionePrenotazioni.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByUserAndDate(User user, LocalDate date);

    Optional<Reservation> findByWorkstationAndDate(Workstation workstation, LocalDate date);

    List<Reservation> findByUser(User user);
}
