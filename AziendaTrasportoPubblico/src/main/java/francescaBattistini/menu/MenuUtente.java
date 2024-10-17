package francescaBattistini.menu;

import francescaBattistini.entities.Utente;
import francescaBattistini.utils.Utils;

import java.util.Scanner;

public class MenuUtente {

    public static void menuPrincipale(Utente u, Scanner s){
        System.out.println("Benvenuto" + (u.getName() != null ? " " + u.getName() : "") + "! Sei un utente " + u.getTipologiaUtente());

        menuPrincipaleMainLoop:
        while(true){

            System.out.println(
                    "1. hai la tessera? \n"
                    
            );

            int command = Utils.readNumber("seleziona comando", s, 0,1);

            switch(command){
                case 0:
                    break menuPrincipaleMainLoop;
                default:
                    System.out.println("Comando non valido");
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

    }


}
