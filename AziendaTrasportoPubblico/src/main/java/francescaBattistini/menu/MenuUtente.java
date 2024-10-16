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
                    "0. Esci dal software"
            );

            int command = Utils.readNumber("seleziona comando", s, 0,1);

            switch(command){
                case 0:
                    break menuPrincipaleMainLoop;
                default:
                    System.out.println("Comando non valido");
            }
        }


    }


}
