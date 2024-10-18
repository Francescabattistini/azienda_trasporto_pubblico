package francescaBattistini.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tram")
public class Tram extends Veicolo {
    @Column(name = "codice", nullable = false)
    private String codice;


    public Tram() {
    }

    public Tram(int capienza, String modello, String codice) {
        super(capienza, modello);
        this.codice = codice;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Tram{" +
                "codice='" + codice + '\'' +
                '}';
    }
}
