package Entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class StatoVeicolo {
    private UUID id;
    private LocalDate inizio;
    private LocalDate fine;
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
