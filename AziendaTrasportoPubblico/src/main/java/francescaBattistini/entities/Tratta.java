package francescaBattistini.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "tratta")
public class Tratta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="zonaPartenza",nullable = false)
    private String zonaPartenza;
    @Column(name="capoilinea",nullable = false)
    private String capolinea;
    @Column(name="tempoipotetico",nullable = false)
    private Double tempoIpotetico;
    @Column(name="kmtratta",nullable = false)
    private int kmTratta;

    @OneToMany(mappedBy = "id_tratta")
    private List<Percorrenza> listaPercorrenzeTratta;

    public Tratta() {
    }

    public Tratta(UUID id, String zonaPartenza, String capolinea, Double tempoIpotetico,int kmTratta) {
        this.id = id;
        this.zonaPartenza = zonaPartenza;
        this.capolinea = capolinea;
        this.tempoIpotetico = tempoIpotetico;
        this.kmTratta=kmTratta;
    }

    public UUID getId() {
        return id;
    }

    public int getKmTratta() {
        return kmTratta;
    }

    public void setKmTratta(int kmTratta) {
        this.kmTratta = kmTratta;
    }

    public String getZonaPartenza() {
        return zonaPartenza;
    }

    public void setZonaPartenza(String zonaPartenza) {
        this.zonaPartenza = zonaPartenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public Double getTempoIpotetico() {
        return tempoIpotetico;
    }

    public void setTempoIpotetico(Double tempoIpotetico) {
        this.tempoIpotetico = tempoIpotetico;
    }




    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", zonaPartenza='" + zonaPartenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempoIpotetico=" + tempoIpotetico +
                ", numeroVoltePerTratta=" +kmTratta+
                '}';
    }
}
