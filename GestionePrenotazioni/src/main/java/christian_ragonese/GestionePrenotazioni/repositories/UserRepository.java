package christian_ragonese.GestionePrenotazioni.repositories;

import christian_ragonese.GestionePrenotazioni.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
