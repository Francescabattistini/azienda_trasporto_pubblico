package francescaBattistini.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="autobus")
public class Autobus extends Veicolo{

    @Column(name="targa",nullable = false)
    private String targa;




    public Autobus(){}


    public Autobus(UUID id, int capienza, String modello, String targa) {
        super(id, capienza, modello);
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "targa='" + targa + '\'' +
                '}';
    }
}
