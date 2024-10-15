package francescaBattistini;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendaTrasportoPubblico");

    public static void main(String[] args) {
        //EntityManager em = emf.createEntityManager();

    }
}
