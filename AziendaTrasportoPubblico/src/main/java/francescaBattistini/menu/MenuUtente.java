package francescaBattistini.menu;


import francescaBattistini.Enum.PeriodoAbbonamento;
import francescaBattistini.Enum.StatoBiglietto;
import francescaBattistini.Exceptions.NotFoundException;
import francescaBattistini.dao.BaseDAO;
import francescaBattistini.entities.*;
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
                    if(!hasBigliettoValid(baseDAO, u, em)) {
                        // gestire qui l'attività del comprare biglietto o abbonamento
                        if (Utils.readString("Vuoi fare il biglietto o l'abbonamento?", s).equals("biglietto")) {
                            handleBuyBiglietto(u);
                        } else {
                            handleBuyAbbonamento(u, s);
                        }
                    }
                    handleSalitaMezzo(u, baseDAO, s);
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
    private static void handleSalitaMezzo(Utente utente, BaseDAO baseDAO, Scanner s) {
        // ricavare su che mezzo sei salito
        // convalidare il biglietto
        if(Utils.readString("Vuoi salire in un bus o in un tram?", s).equals("bus")) {
            handleSalitaBus(baseDAO, s, utente);
        }
    }

    private static void handleSalitaBus(BaseDAO baseDAO, Scanner s, Utente utente) {
        List<Autobus> autobuses = baseDAO.getTakeAllObj(Autobus.class);
        if(autobuses.isEmpty()) {
            System.out.println("Non ci sono bus disponibili!");
        }
        else {
            System.out.println("I bus disponibili sono:\n");
            autobuses.stream().forEach(autobus -> System.out.println("E' presente il bus con id: " + autobus.getId()));
            String choosenBusId = Utils.readString("Inserisci l'id del bus che desideri: ", s);

            try {
                Autobus currentBus = baseDAO.getObjectById(Autobus.class, choosenBusId);
                if(currentBus.getCapienza() > 0) {
                    List<Biglietto> bigliettos = utente.getBigliettos();
                    if(bigliettos.size() > 0) {
                        Validazione validazione = new Validazione();
                        validazione.setDataValidazione(LocalDate.now());
                        validazione.setTipoValidazione(StatoBiglietto.CONVALIDATO);

                        bigliettos.get(0).setIdValidazione(validazione);
                    }
                    else {
                        List<Abbonamento> abbonamentos = utente.getTesseras().get(0).getAbbonamenti();
                        if(abbonamentos.isEmpty()) {
                            System.out.println("Non hai ne biglietti e ne abbonamenti!!\nNon è possibile proseguire!!");
                        }

                    }
                }
            }
            catch(NotFoundException exception) {
                System.out.println("Il bus con id: " + choosenBusId + " non esiste nel db!!");
            }
        }
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

    private static boolean hasBigliettoValid(BaseDAO baseDAO, Utente utente, EntityManager em) {
        List<Biglietto> results = em.createQuery("SELECT b FROM Biglietto b WHERE b.idUtente:idUtente")
                        .setParameter("idUtente", utente)
                .getResultList();

        return results.size() > 0;
    }

    private static boolean hasAbbonamentoValid(BaseDAO baseDAO, Utente utente, EntityManager em) {
        List<Tessera> tesseras = utente.getTesseras();

        List<Abbonamento> results = em.createQuery("SELECT a FROM Abbonamento a JOIN a.idTessera t JOIN t.idUtente u WHERE a.dataScadenza > GETDATE() AND u = :utente")
                .setParameter("utente", utente)
                .getResultList();

        return results.size() > 0;
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




