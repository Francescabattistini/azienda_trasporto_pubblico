package francescaBattistini.menu;

import francescaBattistini.Application;
import francescaBattistini.Exceptions.NotFoundException;
import francescaBattistini.dao.AdminDAO;
import francescaBattistini.entities.*;
import francescaBattistini.utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SottoMenuAdmin {


    public static void MenuPrincipale(Scanner scanner) {

        AdminDAO bs = new AdminDAO(Application.em);


        SottoMenu:
        while (true) {
            System.out.println(
                    "0. Ritorna al Menu precedente" + System.lineSeparator() +
                    "1. Elenco mezzi: " + System.lineSeparator() +
                    "2. Traccia il tempo medio effettivo del percorso dei veicoli" + System.lineSeparator() +
                    "3. Aggiungi stato veicolo: " + System.lineSeparator() +
                    "4. Aggiungi veicolo al parco mezzi: : " + System.lineSeparator() +
                    "5. Rimuovi veicolo al parco mezzi: " + System.lineSeparator() +
                    "6. Elenco parco mezzi: " + System.lineSeparator() +
                    "7. Aggiungi veicolo"
            );
            int command = Utils.readNumber("seleziona comando", scanner, 0, 6);

            switch (command) {
                case 0:
                    break SottoMenu; //spacca tuttoooo!!!
                case 1:
                    List<Veicolo> listaVeicoli = new ArrayList<>();
                    try {
                        listaVeicoli = bs.getTakeAllObj(Veicolo.class);
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    for (Veicolo v : listaVeicoli) {
                        System.out.println(v);

                        try {
                            StatoVeicolo primoStato = bs.getFirstState(v);
                            System.out.println(primoStato);
                        } catch (NotFoundException e) {
                            System.out.println(e.getMessage());
                            if(Utils.readYN("Vuoi aggiungere uno stato a questo mezzo", scanner))
                                aggiungiStato(v, scanner, bs);
                        }
                    }

                    break;
                case 2:
                    break;
                case 3:
                    String idVeicolo = Utils.readString("inserisci l'ID del veicolo ", scanner);
                    try {
                        Veicolo v = bs.getObjectById(Veicolo.class, idVeicolo);

                        aggiungiStato(v, scanner, bs);

                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    String entityVeicolo = Utils.readString("inserisci l'ID del veicolo ", scanner);
                    try {
                        Veicolo v = bs.getObjectById(Veicolo.class, entityVeicolo);

                        String idParcoMezzo = Utils.readString("Inserisci ID parco mezzo: ", scanner);
                        ParcoMezzo pm = bs.getObjectById(ParcoMezzo.class, idParcoMezzo);
                        v.setId_parcoMezzo(pm);

                        bs.update(v);

                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    String v1 = Utils.readString("inserisci l'ID del veicolo ", scanner);
                    try {
                        Veicolo v = bs.getObjectById(Veicolo.class, v1);
                        v.setId_parcoMezzo(null);
                        bs.update(v);
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        List<ParcoMezzo> parcoMezzo = bs.getTakeAllObj(ParcoMezzo.class);
                        for (ParcoMezzo pm : parcoMezzo) {
                            System.out.println(pm);
                        }
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    int tipoVeicolo = Utils.readNumber(
                "Seleziona il veicolo da inserire: " + System.lineSeparator() +
                            "1. Autobus " + System.lineSeparator() +
                            "2. Tram"
                        , scanner, 1,2
                    );

                    int capienza = Utils.readNumber("Inserisci la capienza:",scanner);
                    String modello = Utils.readString("Inserisci il modello:", scanner);
                    switch (tipoVeicolo){
                        case 1:
                            String targa = Utils.readString("Inserisci la targa", scanner);
                            Autobus nuovoBus = new Autobus(capienza, modello, targa);
                            bs.save(nuovoBus);
                            break;
                        case 2:
                            String codice = Utils.readString("Inserisci il codice del tram:", scanner);
                            Tram nuovoTram = new Tram(capienza, modello, codice);
                            bs.save(nuovoTram);
                            break;
                        default:
                            System.out.println("Comando non valido!");
                    }
                default:
                    System.out.println("Comando non valido");
            }
        }


    }

    private static void aggiungiStato(Veicolo v, Scanner scanner, AdminDAO bs){
        LocalDate inizio = Utils.readDate("inizio periodo", scanner);
        LocalDate fine = Utils.readDate("fine periodo", scanner);
        francescaBattistini.Enum.StatoVeicolo stato = Utils.readEnum(
                "Seleziona stato veicolo",
                francescaBattistini.Enum.StatoVeicolo.values(),
                scanner
        );
        StatoVeicolo nuovoStato = new StatoVeicolo(inizio, fine, stato, v);


        bs.save(nuovoStato);
    }


}
