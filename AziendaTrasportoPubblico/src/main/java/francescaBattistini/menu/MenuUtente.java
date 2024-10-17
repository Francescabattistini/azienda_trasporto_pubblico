package francescaBattistini.menu;

import francescaBattistini.Exceptions.NotFoundException;
import francescaBattistini.dao.BaseDAO;
import francescaBattistini.entities.Tessera;
import francescaBattistini.entities.Utente;
import francescaBattistini.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class MenuUtente {

    public static void menuPrincipale(Utente u, Scanner s,  EntityManagerFactory emf){
        System.out.println("Benvenuto" + (u.getName() != null ? " " + u.getName() : "") + "! Sei un utente " + u.getTipologiaUtente());

        EntityManager em = emf.createEntityManager();
        BaseDAO baseDAO = new BaseDAO(em);

        menuPrincipaleMainLoop:
        while(true){
            if(areThereAnyTessera(baseDAO)) {
                if(Utils.readYN("Hai la tessera?\n", s)) {
                    handleHasTessera(s, baseDAO);
                }
                else {
                    // ...
                }
            }
            else {
                if(Utils.readYN("Vuoi fare la tessera?\n", s)) {
                    createTessera(baseDAO, u);
                }
                else {
                    System.out.println("Non puoi procedere senza avere una tessera!\nInterrompo il processo!!");
                    break;
                }
            }


            int command = Utils.readNumber("seleziona comando", s, 0,1);

            switch(command){
                case 0:
                    break menuPrincipaleMainLoop;
                default:
                    System.out.println("Comando non valido");
            }
        }

    }

    private static void handleHasTessera(Scanner s, BaseDAO baseDAO) {
        String numberOfTessera = Utils.readString("Dammi il numero della tua tessera:\n", s);

        // ok confrontiamo il numero di tessera con quelli presenti nella tabella tessera del db
        try {
            baseDAO.getObjectById(Tessera.class, (UUID.fromString(numberOfTessera)).toString());
        }
        catch (NotFoundException exception) {
            System.out.println("Tessera con id " + numberOfTessera + " non trovata!");
        }
    }

    private static boolean areThereAnyTessera(BaseDAO baseDAO) {
        return !baseDAO.getTakeAllObj(Tessera.class).isEmpty();
    }

    private static void createTessera(BaseDAO baseDAO, Utente utente) {
        Tessera newTessera = new Tessera(LocalDate.of(LocalDate.now().plusYears(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()),
                                        LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()), utente);

        baseDAO.save(newTessera);
    }


    //1. Hai la tessera?

    //2.SI/NO

    //1.0 se SI dammi il numero della tessera.

    //0.0 controllo tessera se è scaduta o se la vuole ****

    //1.1  che cosa vuoi comprare(biglietto/abbonamento);
    //1.2  Dove lo vuoi compare (distribbutore automatico[attivo,non attivo]/rivenditore );
    //1.3  nel caso distribbutore automatico è ok va avanti(e ci ricaviamo il numero di biglietti/abbonamenti
    // presenti nel count  nella tabella del distribbutore automatico);
    //1.4 nel caso distribbutore automatico non è attivo ,"devi comprarlo dal riovenditore !");
    //1.5 Nel caso nel rivenditore lo compri ( e ci ricaviamo il numero di biglietti/abbonamenti presenti
    // e il punto di emissione dove è stato comprato);
    //1.6 vuoi salire su TRAM o AUTOBUS?;
    //1.7 Se l'Autobus o il Tram è in servizio e ha capienza entri;
    //1.8 se l'Autobus o Tram non è in servizio Esce;
    //1.9 e se l'autobus o il Tram è in servizio ma  non hanno capienza Esce;
    //1.10 Il biglietto viene poi associato a quel determinato mezzo.;
    //1.11 Entri nell'Autobus o Tram il biglietto cambia stato(biglietto Validato,Non validato);

    //****  Se i biglietti ce li ha ma sono tutti annullati torna  punto 1.1
    //abonamento se è scaduto (rinnovalo)torna a punto 1.1

    //2.0 se la tessera è scaduta o se è da fare?
    //la vuoi rinnovare?(y,n)-se fosse no esce-
    // se fosse Y
    // 2.1
    //se la vuole fare
    // 2.1 prendiamo i dati dell'utente  e gli permettiamo di avere un codice tessera che avrò validità di un anno
    // se no ESCE.

}
