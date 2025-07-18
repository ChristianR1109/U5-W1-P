package christian_ragonese.GestionePrenotazioni.services;

import christian_ragonese.GestionePrenotazioni.entities.User;
import christian_ragonese.GestionePrenotazioni.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public void saveNewUser(User user) {
        Optional<User> exUser = userRepository.findByUsername(user.getUsername()); // optional perchè potremmo ricevere null

        if (exUser.isPresent()) {
            User foundUser = exUser.get();
            System.out.println("L'username " + user.getUsername() + " esiste già");
        } else {
            userRepository.save(user);
            System.out.println("Utente " + user.getUsername() + " salvato correttamente");
        }

    }
}

