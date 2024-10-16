package francescaBattistini;

import francescaBattistini.Enum.TipoUtente;
import francescaBattistini.dao.BaseDAO;
import francescaBattistini.entities.Utente;
import francescaBattistini.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendaTrasportoPubblico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        BaseDAO bd = new BaseDAO(em);

        Utente utente = new Utente("Francesca", "Bauhaus", LocalDate.of(1992, 11, 13 ), TipoUtente.ABUSIVO);

        bd.save(utente);

        System.out.println("FINE! :(");

        System.out.println("benvenuto");
        boolean risposta =  Utils.readYN("sei già registrato?", scanner);

        if (risposta){
            System.out.println("login");
            while (true) {
                
            }
            System.out.println("1. login tramite ID");
            System.out.println("2. mostrami lista utenti");
            System.out.println("0. esci");

            int command = Utils.readNumber("seleziona comando", scanner, 0,2);
            switch (command) {
                case 1:
                    Utils.readString("inserisci l'ID", scanner);
                    break;
                case 2:
                    List<Utente> utenti =  bd.getTakeAllObj(Utente.class);
                    for(Utente u:utenti) {
                        System.out.println(u);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("comando non valido");


            }
        }
        else{
            System.out.println("devi fare la registrazione");
        }

        



    }
}
