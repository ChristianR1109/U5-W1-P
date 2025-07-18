package christian_ragonese.GestionePrenotazioni.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("L'utente con username " + username + " non è stata trovato");
    }
}
