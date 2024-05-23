package lucafavaretto.GestionePrenotazioni.exeption;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String username) {
        super("L'email già esistente " + username);
    }
}
