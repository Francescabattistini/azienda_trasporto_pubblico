package francescaBattistini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "statoveicolo")
public class StatoVeicolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name="inizio",nullable = false)
    private LocalDate inizio;
    @Column(name="fine",nullable = false)
    private LocalDate fine;
    //@Enumerated(EnumType.STRING)
    //private StatoType statotype;
    // ENUM DA AGGIUNGERE AL COSTRUTTO E SET

    public StatoVeicolo() {

    }

    public StatoVeicolo(UUID id, LocalDate inizio, LocalDate fine) {
        this.id = id;
        this.inizio = inizio;
        this.fine = fine;
    }

    public UUID getId() {
        return id;
    }


    public LocalDate getInizio() {
        return inizio;
    }

    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }

    public LocalDate getFine() {
        return fine;
    }

    public void setFine(LocalDate fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "StatoVeicolo{" +
                "id=" + id +
                ", inizio=" + inizio +
                ", fine=" + fine +
                '}';
    }
}
