package francescaBattistini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tessera")
public class Tessera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name="scadenza",nullable = false)
    private LocalDate scadenza;
    @Column(name="emissione",nullable = false)
    private LocalDate emissione;

    public Tessera() {
    }

    public Tessera(UUID id, LocalDate scadenza, LocalDate emissione) {
        this.id = id;
        this.scadenza = scadenza;
        this.emissione = emissione;
    }

    public UUID getId() {
        return id;
    }


    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    public void setEmissione(LocalDate emissione) {
        this.emissione = emissione;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "id=" + id +
                ", scadenza=" + scadenza +
                ", emissione=" + emissione +
                '}';
    }
}
