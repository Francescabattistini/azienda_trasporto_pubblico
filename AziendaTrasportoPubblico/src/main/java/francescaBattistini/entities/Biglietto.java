package francescaBattistini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "biglietto")
public class Biglietto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="dataemissione",nullable = false)
    private LocalDate dataEmissione;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente idUtente;

    @ManyToOne
    @JoinColumn(name = "id_rivenditore")
    private Rivenditore idRivenditore;

    @OneToOne(mappedBy = "biglietto")
    private Validazione idValidazione;

    public Biglietto() {}

    public Biglietto(LocalDate dataEmissione, Utente idUtente) {
        this.dataEmissione = dataEmissione;
        this.idUtente = idUtente;
    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public Utente getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Utente idUtente) {
        this.idUtente = idUtente;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", idUtente=" + idUtente +
                '}';
    }
}
