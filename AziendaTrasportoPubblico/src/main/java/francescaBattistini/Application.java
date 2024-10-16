package francescaBattistini;

import francescaBattistini.Enum.TipoUtente;
import francescaBattistini.dao.BaseDAO;
import francescaBattistini.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendaTrasportoPubblico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        BaseDAO bd = new BaseDAO(em);

        Utente utente = new Utente("Paolo", "Rossi", LocalDate.of(1997, 3, 25), TipoUtente.ANONIMO);

        bd.save(utente);

        System.out.println("FINE! :(");
    }
}
