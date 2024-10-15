package Entities;

import java.util.UUID;

public class ParcoMezzo {
    private UUID id;
    private String località;
    private int capienza;

    public ParcoMezzo(){}

    public ParcoMezzo(UUID id, String località, int capienza) {
        this.id = id;
        this.località = località;
        this.capienza = capienza;
    }

    public UUID getId() {
        return id;
    }



    public String getLocalità() {
        return località;
    }

    public void setLocalità(String località) {
        this.località = località;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    @Override
    public String toString() {
        return "ParcoMezzo{" +
                "id=" + id +
                ", località='" + località + '\'' +
                ", capienza=" + capienza +
                '}';
    }
}
