package francescaBattistini.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Veicoli")
@Inheritance(strategy = InheritanceType.JOINED)
//@NamedQuery(name = "VeicoliPerTratta", query = "SELECT v FROM Veicolo v JOIN Percorrenza p on v.listaPercorrenze = p.id_veicolo JOIN Tratta t on p.id_tratta = t.listaPercorrenzeTratta WHERE t=:trattaSelezionata")
@NamedQuery(name = "VeicoliPerTratta", query = "SELECT v FROM Veicolo v JOIN v.listaPercorrenze p JOIN p.id_tratta t WHERE t=:trattaSelezionata")
public abstract class Veicolo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "capienza", nullable = false)
    private int capienza;
    @Column(name = "modello", nullable = false)
    private String modello;

    @OneToMany(mappedBy = "veicoli")
    private List<Validazione> listaValidazioni;

    @ManyToOne
    @JoinColumn(name = "parco_mezzo")
    private ParcoMezzo id_parcoMezzo;

    @OneToMany(mappedBy = "id_veicolo")
    private List<Percorrenza> listaPercorrenze;

    @OneToMany(mappedBy = "id_veicolo")
    private List<StatoVeicolo> id_statoVeicolo;

    @OneToOne
    @JoinColumn(name = "id_tratta")
    private Tratta idTratta;

    public Veicolo() {
    }

    public Veicolo(int capienza, String modello) {
        this.capienza = capienza;
        this.modello = modello;
    }

    public ParcoMezzo getId_parcoMezzo() {
        return id_parcoMezzo;
    }

    public void setId_parcoMezzo(ParcoMezzo id_parcoMezzo) {
        this.id_parcoMezzo = id_parcoMezzo;
    }

    public List<StatoVeicolo> getId_statoVeicolo() {
        return id_statoVeicolo;
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
                ", modello='" + modello + '\'' +
                ", id_parcoMezzo=" + id_parcoMezzo +
                ", id_statoVeicolo=" + id_statoVeicolo +
                '}';
    }
}