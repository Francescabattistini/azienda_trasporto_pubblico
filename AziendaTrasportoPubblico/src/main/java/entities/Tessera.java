package entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tessere")
public class Tessera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTessera;
    private LocalDateTime scadenza;
    private LocalDateTime emissione;

    public Tessera() {
    }

    public Long getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(Long idTessera) {
        this.idTessera = idTessera;
    }

    public LocalDateTime getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDateTime scadenza) {
        this.scadenza = scadenza;
    }

    public LocalDateTime getEmissione() {
        return emissione;
    }

    public void setEmissione(LocalDateTime emissione) {
        this.emissione = emissione;
    }
}
