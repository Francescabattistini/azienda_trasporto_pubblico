package francescaBattistini.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rivenditori")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Rivenditore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String localita;

    @OneToMany(mappedBy = "idRivenditore")
    private List<Biglietto> biglietti;

    @OneToMany(mappedBy = "idRivenditore")
    private List<Abbonamento> abbonamenti;

    public Rivenditore() {}

    public Rivenditore(long id, String localita) {
        this.id = id;
        this.localita = localita;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getLocalita() {
        return localita;
    }

    public void setLocalita(String localita) {
        this.localita = localita;
    }

    @Override
    public String toString() {
        return "Rivenditore{" +
                "id=" + id +
                ", localita='" + localita + '\'' +
                '}';
    }
}
