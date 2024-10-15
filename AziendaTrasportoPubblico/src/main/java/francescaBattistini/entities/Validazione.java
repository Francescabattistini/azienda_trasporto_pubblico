package francescaBattistini.entities;

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
//    @Column(name = "tipo_validazione", nullable = false)
//    @Enumerated(EnumType.STRING)
//    private Enum tipoValidazione;


    public Validazione() {}

    public Validazione(long id, LocalDate dataValidazione) {
        this.id = id;
        this.dataValidazione = dataValidazione;
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


    @Override
    public String toString() {
        return "Validazione{" +
                "id=" + id +
                ", dataValidazione=" + dataValidazione +
                '}';
    }
}
