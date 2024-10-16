package francescaBattistini.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tram")
public class Tram {
    @Column(name="codice",nullable = false)
    private String codice ;


    public  Tram (){}
    public Tram(String codice) {
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
