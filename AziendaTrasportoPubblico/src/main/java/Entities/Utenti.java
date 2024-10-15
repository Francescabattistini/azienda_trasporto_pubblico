package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utenti {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="surname",nullable = false)
    private String surname;
    @Column(name="datebirth",nullable = false)
    private LocalDate dateBirth;

    public Utenti() {

    }

    public Utenti(UUID id, String name, String surname, LocalDate dateBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
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

    @Override
    public String toString() {
        return "Utenti{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateBirth=" + dateBirth +
                '}';
    }
}
