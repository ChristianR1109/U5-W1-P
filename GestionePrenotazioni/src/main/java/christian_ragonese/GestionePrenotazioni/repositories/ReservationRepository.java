package christian_ragonese.GestionePrenotazioni.repositories;

import christian_ragonese.GestionePrenotazioni.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
