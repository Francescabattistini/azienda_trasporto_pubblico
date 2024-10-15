package francescaBattistini.Exceptions;

public class NotValidableException extends RuntimeException {
    public NotValidableException(String message) {
        super("il biglietto non è valido" + message);
    }
}
