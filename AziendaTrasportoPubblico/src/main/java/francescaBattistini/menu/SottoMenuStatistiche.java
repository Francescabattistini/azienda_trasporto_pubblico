package francescaBattistini.menu;

import francescaBattistini.Application;
import francescaBattistini.Exceptions.NotFoundException;
import francescaBattistini.dao.AdminDAO;
import francescaBattistini.entities.Tratta;
import francescaBattistini.utils.Utils;

import java.util.List;
import java.util.Scanner;

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
                    break;
                case 1:
                    try {
                        List<Tratta> listaTratte = bt.getTakeAllObj(Tratta.class);
                        for (int i = 0; i < listaTratte.size(); i++) {
                            System.out.println((i + 1) + "." + listaTratte.get(i));
                        }
                        int scelta = Utils.readNumber("Scegli la tratta (Inserisci il numero: ", scanner, 0, listaTratte.size() - 1);
                        bt.VeicoloPerTratta(listaTratte.get(scelta));


                    } catch (NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }

    }
}
