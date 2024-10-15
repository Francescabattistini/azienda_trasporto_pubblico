package francescaBattistini.entities;

import francescaBattistini.Enum.StatoBiglietto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "validazioni")
public class Validazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "data_validazione", nullable = false)
    private LocalDate dataValidazione;
    @Column(name = "tipo_validazione", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatoBiglietto tipoValidazione;


    public Validazione() {}

    public Validazione(long id, LocalDate dataValidazione, StatoBiglietto tipoValidazione) {
        this.id = id;
        this.dataValidazione = dataValidazione;
        this.tipoValidazione = tipoValidazione;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataValidazione() {
        return dataValidazione;
    }

    public void setDataValidazione(LocalDate dataValidazione) {
        this.dataValidazione = dataValidazione;
    }

    public StatoBiglietto getTipoValidazione() {
        return tipoValidazione;
    }

    public void setTipoValidazione(StatoBiglietto tipoValidazione) {
        this.tipoValidazione = tipoValidazione;
    }

    @Override
    public String toString() {
        return "Validazione{" +
                "id=" + id +
                ", dataValidazione=" + dataValidazione +
                ", tipoValidazione=" + tipoValidazione +
                '}';
    }
}
