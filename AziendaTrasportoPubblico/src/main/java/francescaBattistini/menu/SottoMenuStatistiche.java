package francescaBattistini.menu;

import francescaBattistini.Application;
import francescaBattistini.Exceptions.NotFoundException;
import francescaBattistini.dao.AdminDAO;
import francescaBattistini.entities.Percorrenza;
import francescaBattistini.entities.Tratta;
import francescaBattistini.entities.Veicolo;
import francescaBattistini.utils.Utils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SottoMenuStatistiche {

    public static void MenuPrincipale(Scanner scanner) {

        AdminDAO bt = new AdminDAO(Application.em);


        SottMenu:
        while (true) {
            System.out.println(
                    "0. Esci dal sottomenu." + System.lineSeparator() +
                            "1. Tempo medio percorrenza tratta: "

            );

            int command = Utils.readNumber("seleziona comando", scanner, 0, 2);

            switch (command) {
                case 0:
                    break SottMenu;
                case 1:
                    try {
                        List<Tratta> listaTratte = bt.getTakeAllObj(Tratta.class);
                        for (int i = 0; i < listaTratte.size(); i++) {
                            System.out.println(i + ". " + listaTratte.get(i));
                        }
                        int sceltaTratta = Utils.readNumber("Scegli la tratta (Inserisci il numero: ", scanner, 0, listaTratte.size() - 1);
                        Tratta trattaScelta = listaTratte.get(sceltaTratta);
                        List<Veicolo> veicoliPerTratta = bt.VeicoloPerTratta(trattaScelta);

                        for(int i = 0; i < veicoliPerTratta.size(); i++){
                            System.out.println(i + ". " + veicoliPerTratta.get(i));
                        }
                        int sceltaVeicolo = Utils.readNumber("Scegli il veicolo (Inserisci il numero) ", scanner, 0, veicoliPerTratta.size() - 1);

                        Veicolo veicoloScelto = veicoliPerTratta.get(sceltaVeicolo);

                        List<Percorrenza> percorrenzaList = bt.percorrenzeDiVeicoloPerTratta(trattaScelta, veicoloScelto);

                        double avgPercorrenza = percorrenzaList.stream()
                                .mapToDouble(Percorrenza::getTempoEffettivo)
                                .average()
                                .orElse(0.0);

                        System.out.println("Tratta: " + trattaScelta);
                        System.out.println("Veicolo: " + veicoloScelto);
                        System.out.println("---------------------------");
                        System.out.println("Tempo di percorrenza ipotetico della tratta: " + trattaScelta.getTempoIpotetico());
                        System.out.println("Tempo medio di percorrenza effettiva: " + avgPercorrenza);

                    } catch (NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }

    }
}
