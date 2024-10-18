package francescaBattistini.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name="parcomezzo")
public class ParcoMezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="località",nullable = false)
    private String località;
    @Column(name="capienzaVeicolo",nullable = false)
    private int capienzaVeicoli;

    @OneToMany(mappedBy = "id_parcoMezzo")
    private List<Veicolo> listaVeicoli;

    public ParcoMezzo(){}

    public ParcoMezzo(String località, int capienza) {
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
