package francescaBattistini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "statoveicolo")
public class StatoVeicolo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "inizio", nullable = false)
    private LocalDate inizio;
    @Column(name = "fine", nullable = false)
    private LocalDate fine;
    @Enumerated(EnumType.STRING)
    private francescaBattistini.Enum.StatoVeicolo statotype;


    @ManyToOne
    @JoinColumn(name = "veicolo")
    private Veicolo id_veicolo;

    public StatoVeicolo() {

    }

    public StatoVeicolo(LocalDate inizio, LocalDate fine, francescaBattistini.Enum.StatoVeicolo statotype, Veicolo id_veicolo) {
        this.inizio = inizio;
        this.fine = fine;
        this.statotype = statotype;
        this.id_veicolo = id_veicolo;
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

    public francescaBattistini.Enum.StatoVeicolo getStatotype() {
        return statotype;
    }

    public void setStatotype(francescaBattistini.Enum.StatoVeicolo statotype) {
        this.statotype = statotype;
    }

    @Override
    public String toString() {
        return "StatoVeicolo{" +
                "id=" + id +
                ", inizio=" + inizio +
                ", fine=" + fine +
                ", statotype=" + statotype +
                '}';
    }
}
