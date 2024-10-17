package francescaBattistini.utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public static int readNumber(String question, Scanner s){

        int res = 0;
        while (true) {
            System.out.println(question);

            try{
                res = Integer.parseInt(s.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("valore non valido");
            }
        }

        return res;
    }

    public static int readNumber(String question, Scanner s, int source, int limit){

        int res = 0;
        while (true) {
            System.out.println(question);

            try{
                res = Integer.parseInt(s.nextLine());
                if (res < source || res > limit) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("valore non valido");
            }
        }

        return res;
    }

    public static double readDouble(String question, Scanner s){

        double res = 0;
        while (true) {
            System.out.println(question);

            try{
                res = Double.parseDouble(s.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("valore non valido");
            }
        }

        return res;
    }

    public static String readString(String question, Scanner s){
        System.out.println(question);
        return s.nextLine();
    }

    public static boolean readYN(String question, Scanner s){

        String res = "";
        while (true) {
            System.out.println(question + " (y/n)");

            try{
                res = s.nextLine();
                if (!res.equals("y") && !res.equals("n"))
                    throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("valore non valido");
            }
        }

        return res.equals("y");
    }

    public static LocalDate readDate (String question, Scanner s){

        System.out.println(question);
        int y = readNumber("Anno:",s, 1990,2024);
        int m = readNumber("Mese:",s, 1, 12);

        int dayLimit = switch (m) {
            case 2 -> 28; // Febbraio
            // Aprile - Giugno - Settembre - Novembre
            case 4, 6, 9, 11 -> 30;
            // Gennaio, Marzo, Maggio, Luglio, Agosto, Ottobre, Dicembre
            default -> 31;
        };

        int d = readNumber("Giorno:",s, 1, dayLimit);

        return LocalDate.of(y,m,d);

    }

    public static <T> T readEnum(String question, T[] myEnum, Scanner s){
        System.out.println(question);
        for (int i = 0; i < myEnum.length; i++) {
            System.out.println( i + ". " + myEnum[i]);
        }

        return myEnum[
                readNumber(
                        "Seleziona un valore:",
                        s,
                        0,
                        myEnum.length-1
                )
        ];

    }

}
