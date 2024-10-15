package francescaBattistini.Exceptions;

public class NotMoreValidException extends RuntimeException {
    public NotMoreValidException(String message) {
        super("l'abbonamento è scaduto" + message);
    }
}
