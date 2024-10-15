package francescaBattistini.entities;

import francescaBattistini.Enum.PeriodoAbbonamento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "abbonamento")
public class Abbonamenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "tipo_abbonamento", nullable = false)
    @Enumerated(EnumType.STRING)
    private PeriodoAbbonamento tipoAbbonamento;
    @Column(name="data_emissione",nullable = false)
    private LocalDate dataEmissione;

    public Abbonamenti() {
    }

    public Abbonamenti(UUID id, PeriodoAbbonamento tipoAbbonamento, LocalDate dataEmissione) {
        this.id = id;
        this.tipoAbbonamento = tipoAbbonamento;
        this.dataEmissione = dataEmissione;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public PeriodoAbbonamento getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(PeriodoAbbonamento tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    @Override
    public String toString() {
        return "Abbonamenti{" +
                "id=" + id +
                ", tipoAbbonamento=" + tipoAbbonamento +
                ", dataEmissione=" + dataEmissione +
                '}';
    }
}
