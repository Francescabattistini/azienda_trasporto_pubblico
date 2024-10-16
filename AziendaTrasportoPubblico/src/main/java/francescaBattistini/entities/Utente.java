package francescaBattistini.entities;

import francescaBattistini.Enum.TipoUtente;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="datebirth")
    private LocalDate dateBirth;
    @Column(name = "tipologia_utente", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoUtente tipologiaUtente;

    @OneToMany(mappedBy = "idUtente")
    private List<Biglietto> bigliettos;

    @OneToMany(mappedBy = "idUtente")
    private List<Tessera> tesseras;

    public Utente() {}

    public Utente(TipoUtente tipologiaUtente) {
        this.tipologiaUtente = tipologiaUtente;
    }

    public Utente(String name, String surname, LocalDate dateBirth, TipoUtente tipologiaUtente) {
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.tipologiaUtente = tipologiaUtente;
    }

    public Utente getUtenteAnonimo(){
        return new Utente(TipoUtente.ANONIMO);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public TipoUtente getTipologiaUtente() {
        return tipologiaUtente;
    }

    public void setTipologiaUtente(TipoUtente tipologiaUtente) {
        this.tipologiaUtente = tipologiaUtente;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateBirth=" + dateBirth +
                ", tipologiaUtente=" + tipologiaUtente +
                '}';
    }
}
