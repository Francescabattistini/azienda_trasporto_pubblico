package francescaBattistini.Exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super("l'elemento non è stato trovato" + message);
    }
}
