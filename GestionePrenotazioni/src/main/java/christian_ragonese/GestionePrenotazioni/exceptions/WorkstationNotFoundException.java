package christian_ragonese.GestionePrenotazioni.exceptions;

public class WorkstationNotFoundException extends RuntimeException {
    public WorkstationNotFoundException(String description) {
        super("La postazione con descrizione " + description + " non è stata trovato");
    }
}
