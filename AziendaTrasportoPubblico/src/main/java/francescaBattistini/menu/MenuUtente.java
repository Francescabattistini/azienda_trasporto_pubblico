package francescaBattistini.menu;


import francescaBattistini.Enum.PeriodoAbbonamento;
import francescaBattistini.Exceptions.NotFoundException;
import francescaBattistini.dao.BaseDAO;
import francescaBattistini.entities.Abbonamento;
import francescaBattistini.entities.Biglietto;
import francescaBattistini.entities.Tessera;
import francescaBattistini.entities.Utente;
import francescaBattistini.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MenuUtente {

    public static void menuPrincipale(Utente u, Scanner s, EntityManagerFactory emf) {
        System.out.println("Benvenuto" + (u.getName() != null ? " " + u.getName() : "") + "! Sei un utente " + u.getTipologiaUtente());

        EntityManager em = emf.createEntityManager();
        BaseDAO baseDAO = new BaseDAO(em);

        while (true) {
            if(Utils.readYN("Hai la tessera?\n", s)) {
                if(isTesseraScaduta(handleHasTessera(s, baseDAO))) {
                    if(Utils.readYN("La tua tessera risulta scaduta!!\nVuoi fare un'altra tessera?\n", s)) {
                        createTessera(baseDAO, u);
                    }
                    else {
                        System.out.println("Ok allora non puoi continuare senza tessera, interrompo il processo!!");
                        break;
                    }
                }
                else {
                    // TODO: gestire se l'utenti ha già biglietti o abbonamenti associati
                    if(hasTicketValid(baseDAO, u, em)) {
                        handleSalitaMezzo(u, baseDAO);
                    }
                    // gestire qui l'attività del prendere il mezzo
                    if(Utils.readString("Vuoi fare il biglietto o l'abbonamento?", s).equals("biglietto")) {
                        handleBuyBiglietto(u);
                    }
                    else if(Utils.readString("Vuoi fare il biglietto o l'abbonamento?", s).equals("abbonamento")) {
                        handleBuyAbbonamento(u, s);
                    }
                }
            }
            else {
                if (Utils.readYN("Vuoi fare la tessera?\n", s)) {
                    createTessera(baseDAO, u);
                    break;
                }
                else {
                    System.out.println("Non puoi procedere senza avere una tessera!\nInterrompo il processo!!");
                    break;
                }
            }
        }
    }


    //METODI
    private static void handleSalitaMezzo(Utente utente, BaseDAO baseDAO) {
        // ricavare su che mezzo sei salito
        // convalidare il biglietto
    }

    private static boolean isTesseraScaduta(Tessera tessera) {
        return tessera.getScadenza().isBefore(LocalDate.now());
    }

    private static void handleBuyBiglietto(Utente utente) {
        Biglietto biglietto = new Biglietto();
        biglietto.setIdUtente(utente);
        biglietto.setDataEmissione(LocalDate.now());
    }

    private static void handleBuyAbbonamento(Utente utente, Scanner s) {
        Abbonamento abbonamento = new Abbonamento();

        if(Utils.readYN("Vuoi l'abbonamento mensile?", s)) {
            abbonamento.setTipoAbbonamento(PeriodoAbbonamento.MENSILE);
            abbonamento.setDataScadenza(LocalDate.now().plusMonths(1));
        } else {
            abbonamento.setTipoAbbonamento(PeriodoAbbonamento.SETTIMANLE);
            abbonamento.setDataScadenza(LocalDate.now().plusWeeks(1));
        }
        abbonamento.setDataEmissione(LocalDate.now());
    }


    private static Tessera handleHasTessera(Scanner s, BaseDAO baseDAO) {
        String numberOfTessera = Utils.readString("Dammi il numero della tessera:\n", s);

        // ok confrontiamo il numero di tessera con quelli presenti nella tabella tessera del db
        try {
            Tessera tessera = baseDAO.getObjectById(Tessera.class,(UUID.fromString(numberOfTessera)).toString());
            System.out.println("Tessera con id " + numberOfTessera + " trovata! :)");
            return tessera;
        } catch (NotFoundException exception) {
            System.out.println("Tessera con id " + numberOfTessera + " non trovata!");
            // se non la trova o si richiede il codice o si stoppa
            return null;
        }
    }

    private static boolean tesseraEsistente(BaseDAO baseDAO) {
        return !baseDAO.getTakeAllObj(Tessera.class).isEmpty();
    }

    private static void createTessera(BaseDAO baseDAO, Utente utente) {
        Tessera newTessera = new Tessera(LocalDate.now().plusYears(1), LocalDate.now(), utente);

        baseDAO.save(newTessera);
        System.out.println("Tessera creata con successo per l'utente: " + utente.getName() + " !");
    }

    private static boolean hasTicketValid(BaseDAO baseDAO, Utente utente, EntityManager em) {
        List<Tessera> results = em.createQuery("SELECT t FROM Tessera t WHERE t.idUtente = :idUtente")
                        .setParameter("idUtente", utente)
                .getResultList();

        return results.stream().filter(ticket -> ticket.getScadenza().isAfter(LocalDate.now())).toList().size() > 0;
    }
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

    //2.0 se la tessera è scaduta ?
    //la vuoi rinnovare?(y,n)-se fosse no esce-
    // se fosse Y
    // 2.1
    //se la vuole fare
    // 2.1 prendiamo i dati dell'utente  e gli permettiamo di avere un codice tessera che avrò validità di un anno
    // se no ESCE.




