package francescaBattistini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tessera")
public class Tessera {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="scadenza",nullable = false)
    private LocalDate scadenza;
    @Column(name="emissione",nullable = false)
    private LocalDate emissione;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente idUtente;

    @OneToMany(mappedBy = "idTessera")
    private List<Abbonamento> abbonamenti;

    public Tessera() {}

    public Tessera(LocalDate scadenza, LocalDate emissione, Utente utentes) {
        this.scadenza = scadenza;
        this.emissione = emissione;
        this.idUtente = utentes;
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
