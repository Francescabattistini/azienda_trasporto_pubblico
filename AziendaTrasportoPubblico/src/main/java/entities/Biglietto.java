package entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Biglietto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBiglietto;
    private LocalDateTime dataEmissione;

    public Biglietto() {
    }

    public Long getIdBiglietto() {
        return idBiglietto;
    }

    public void setIdBiglietto(Long idBiglietto) {
        this.idBiglietto = idBiglietto;
    }

    public LocalDateTime getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDateTime dataEmissione) {
        this.dataEmissione = dataEmissione;
    }
}
