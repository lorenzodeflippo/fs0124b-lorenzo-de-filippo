package lucafavaretto.GestionePrenotazioni.exeption;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(long id) {
        super("Record with " + id + " don't found!");
    }

    public ItemNotFoundException() {
        super("Don't found ");
    }
}
