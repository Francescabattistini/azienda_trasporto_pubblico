package entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtente;
    private String name;
    private String surname;
    private LocalDateTime birthDate;

    public Utente() {
    }

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
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

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}
