package Entities;

import java.util.UUID;

public class Autobus {
    private String targa;

    public Autobus(){}


    public Autobus(String targa) {
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "targa='" + targa + '\'' +
                '}';
    }
}
