package entities;

import enums.DurataAbbonamento;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Abbonamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DurataAbbonamento durataAbbonamento;
    private LocalDateTime dataEmissione;

    public Abbonamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DurataAbbonamento getDurataAbbonamento() {
        return durataAbbonamento;
    }

    public void setDurataAbbonamento(DurataAbbonamento durataAbbonamento) {
        this.durataAbbonamento = durataAbbonamento;
    }

    public LocalDateTime getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDateTime dataEmissione) {
        this.dataEmissione = dataEmissione;
    }
}
