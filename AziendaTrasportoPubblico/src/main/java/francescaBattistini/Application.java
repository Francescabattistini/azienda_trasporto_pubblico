package francescaBattistini;

import francescaBattistini.Enum.TipoUtente;
import francescaBattistini.Exceptions.NotFoundException;
import francescaBattistini.dao.BaseDAO;
import francescaBattistini.entities.Tram;
import francescaBattistini.entities.Utente;
import francescaBattistini.menu.MenuAdmin;
import francescaBattistini.menu.MenuUtente;
import francescaBattistini.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AziendaTrasportoPubblico");
    private static final Scanner scanner = new Scanner(System.in);
    public static EntityManager em = emf.createEntityManager();

    public Application() {
    }

    public static void main(String[] args) {


        BaseDAO bd = new BaseDAO(em);

        System.out.println("BENVENUTO IN AUTOTRASPORTI BW6!");
        boolean eRegistrato =  Utils.readYN("Sei già registrato?", scanner);

        if (eRegistrato){
            logInLoop:
            while (true) {
                System.out.println(
                        "1. Login tramite ID" + System.lineSeparator() +
                        "2. Mostrami lista utenti" + System.lineSeparator() +
                        "0. Esci dal software"
                );

                int command = Utils.readNumber("seleziona comando", scanner, 0,2);
                switch (command) {
                    case 1:
                        String idUtente = Utils.readString("inserisci l'ID", scanner);
                        try{
                            Utente u = bd.getObjectById(Utente.class, idUtente);
                            menuManager(u);
                        } catch (NotFoundException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        List<Utente> utenti =  bd.getTakeAllObj(Utente.class);
                        for(Utente u:utenti) {
                            System.out.println(u);
                        }
                        break;
                    case 0:
                        break logInLoop;
                    default:
                        System.out.println("comando non valido");


                }
            }
        }
        else{
            System.out.println("SIGN IN: ");

            Utente nuovoUtente;
            if(Utils.readYN("Vuoi essere un utente anonimo?",scanner)) {
                nuovoUtente = new Utente(TipoUtente.ANONIMO);
            }
            else{
                String nome = Utils.readString("Inserisci il tuo nome:", scanner);
                String cognome = Utils.readString("Inserisci il tuo cognome:", scanner);
                LocalDate dataNascita = Utils.readDate("Inserisci la tua data di nascita: ", scanner);
                TipoUtente tipoUtente = Utils.readEnum("Scegli il tuo ruolo: ", TipoUtente.values(), scanner);
                nuovoUtente = new Utente(nome, cognome, dataNascita, tipoUtente);

            }
            bd.save(nuovoUtente);

            menuManager(nuovoUtente);
        }

        System.out.println("FINE! :(");
        scanner.close();
    }

    private static void menuManager(Utente u){
        switch (u.getTipologiaUtente()){
            case TipoUtente.VIAGGIATORE:
            case TipoUtente.ANONIMO:
                MenuUtente.menuPrincipale(u, scanner);
                break;
            case TipoUtente.AMMINISTRATORE:
                MenuAdmin.menuPrincipale(u, scanner);
                break;
            default:
                System.out.println("Utente non autorizzato! Pussa via (╬ಠ益ಠ)");
        }
    }

}
