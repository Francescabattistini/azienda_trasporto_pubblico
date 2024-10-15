package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "abbonamento")
public class Abbonamenti {
    @Id
    @GeneratedValue
    private UUID id;
   // @Enumerated(EnumType.STRING)
    //enumType settimanale/mensile
    @Column(name="dataEmissione",nullable = false)
    private LocalDate dataEmissione;

    public Abbonamenti() {
    }

    public Abbonamenti(UUID id, LocalDate dataEmissione) {
        this.id = id;
        this.dataEmissione = dataEmissione;
    }

    public UUID getId() {
        return id;
    }


    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    @Override
    public String toString() {
        return "Abbonamenti{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                '}';
    }
}
