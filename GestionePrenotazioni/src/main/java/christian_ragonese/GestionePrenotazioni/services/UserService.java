package christian_ragonese.GestionePrenotazioni.services;

import christian_ragonese.GestionePrenotazioni.entities.User;
import christian_ragonese.GestionePrenotazioni.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public void saveNewUser(User user) {
        userRepository.save(user);
    }
}

