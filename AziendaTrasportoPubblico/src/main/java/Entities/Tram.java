package Entities;

import java.util.UUID;

public class Tram {
    private String codice ;


    public  Tram (){}
    public Tram(String codice) {
        this.codice = codice;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    @Override
    public String toString() {
        return "Tram{" +
                "codice='" + codice + '\'' +
                '}';
    }
}
