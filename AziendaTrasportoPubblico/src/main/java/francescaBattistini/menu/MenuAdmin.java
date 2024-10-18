package francescaBattistini.menu;

import francescaBattistini.entities.Utente;
import francescaBattistini.utils.Utils;

import java.util.Scanner;

public class MenuAdmin {

    public static void menuPrincipale(Utente u, Scanner s) {
        System.out.println("Benvenuto" + (u.getName() != null ? " " + u.getName() : "") + "! Sei un utente " + u.getTipologiaUtente());

        menuPrincipaleMainLoop:
        while (true) {

            System.out.println(
                    "0. Torna al menu principale: " + System.lineSeparator() +
                            "1. Accedi al parco mezzi: " + System.lineSeparator() +
                            "2. Statistiche tratte: "
            );

            int command = Utils.readNumber("seleziona comando", s, 0, 2);

            switch (command) {
                case 0:
                    break menuPrincipaleMainLoop;
                case 1:
                    SottoMenuAdmin.MenuPrincipale(s);
                    break;
                case 2:
                    SottoMenuStatistiche.MenuPrincipale(s);
                    break;
                default:
                    System.out.println("Comando non valido");
            }
        }
    }
}
