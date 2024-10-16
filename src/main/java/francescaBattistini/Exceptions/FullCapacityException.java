package francescaBattistini.Exceptions;

public class FullCapacityException extends RuntimeException {
    public FullCapacityException(String message) {
        super("la capienza del veicolo è stata superata" + message);
    }
}
