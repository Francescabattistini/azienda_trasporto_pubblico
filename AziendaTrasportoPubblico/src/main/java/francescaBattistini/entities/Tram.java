package francescaBattistini.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "tram")
public class Tram  extends Veicolo{
    @Column(name="codice",nullable = false)
    private String codice ;


    public  Tram (){}

    public Tram(UUID id, int capienza, String modello, String codice) {
        super(id, capienza, modello);
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
        return "Tram{" +
                "codice='" + codice + '\'' +
                '}';
    }
}
