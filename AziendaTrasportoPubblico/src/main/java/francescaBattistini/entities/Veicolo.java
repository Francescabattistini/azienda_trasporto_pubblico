package francescaBattistini.entities;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name= "Veicoli")
public abstract class  Veicolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name="capienza",nullable = false)
    private int capienza;
    @Column(name="modello",nullable = false)
    private String modello;

    public Veicolo(){}

    public Veicolo(UUID id, int capienza,String modello) {
        this.id = id;
        this.capienza = capienza;
        this.modello = modello;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "id=" + id +
                ", capienza=" + capienza +
                '}';
    }
}
