package francescaBattistini.entities;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "percorrenza")
public class Percorrenza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private UUID id;
    @Column(name="tempoeffettivo",nullable = false)
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
