package francescaBattistini.menu;

import francescaBattistini.Application;
import francescaBattistini.dao.BaseDAO;
import francescaBattistini.entities.Utente;
import francescaBattistini.entities.Veicolo;
import francescaBattistini.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class SottoMenuAdmin {



    public static void MenuPrincipale (Scanner scanner) {

            BaseDAO bs =  new BaseDAO(Application.em);


        SottoMenu:
        while (true) {
            System.out.println(
                    "0. Ritorna al Menu precedente" + System.lineSeparator() +
                    "1. Verifica lo stato dei veicoli" + System.lineSeparator() +
                    "2. Traccia il tempo medio effettivo del percorso dei veicoli"
            );
            int command = Utils.readNumber("seleziona comando", scanner, 0, 2);

            switch (command) {
                case 0:
                    break SottoMenu; //spacca tuttoooo!!!
                case 1:
                    List<Veicolo> listaVeicoli = bs.getTakeAllObj(Veicolo.class);
                    for(Veicolo v:listaVeicoli) {
                        System.out.println(v);
                    }

                    break ;
                case 2:
                    break ;
                default:
                    System.out.println("Comando non valido");
            }
        }



    }


}
