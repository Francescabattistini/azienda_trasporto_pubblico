package francescaBattistini.entities;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name="parcomezzo")
public class ParcoMezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name="località",nullable = false)
    private String località;
    @Column(name="capienzaVeicolo",nullable = false)
    private int capienzaVeicoli;

    public ParcoMezzo(){}

    public ParcoMezzo(UUID id, String località, int capienza) {
        this.id = id;
        this.località = località;
        this.capienzaVeicoli = capienzaVeicoli;
    }

    public UUID getId() {
        return id;
    }



    public String getLocalità() {
        return località;
    }

    public void setLocalità(String località) {
        this.località = località;
    }

    public int getCapienzaVeicoli() {
        return capienzaVeicoli;
    }

    public void setCapienzaVeicoli(int capienza) {
        this.capienzaVeicoli = capienza;
    }

    @Override
    public String toString() {
        return "ParcoMezzo{" +
                "id=" + id +
                ", località='" + località + '\'' +
                ", capienza=" + capienzaVeicoli +
                '}';
    }
}
