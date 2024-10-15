package Entities;

import java.util.UUID;

public class Veicolo {
    private UUID id;
    private int capienza;
    public Veicolo(){}

    public Veicolo(UUID id, int capienza) {
        this.id = id;
        this.capienza = capienza;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "id=" + id +
                ", capienza=" + capienza +
                '}';
    }
}
