package Entities;

import java.util.UUID;

public class Percorrenza {
private UUID id;
private Double tempoEffettivo;

    public Percorrenza() {
    }

    public Percorrenza(UUID id, Double tempoEffettivo) {
        this.id = id;
        this.tempoEffettivo = tempoEffettivo;
    }

    public UUID getId() {
        return id;
    }


    public Double getTempoEffettivo() {
        return tempoEffettivo;
    }

    public void setTempoEffettivo(Double tempoEffettivo) {
        this.tempoEffettivo = tempoEffettivo;
    }

    @Override
    public String toString() {
        return "Percorrenza{" +
                "id=" + id +
                ", tempoEffettivo=" + tempoEffettivo +
                '}';
    }
}
