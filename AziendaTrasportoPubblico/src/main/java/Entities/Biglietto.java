package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "biglietto")
public class Biglietto {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name="dataemissione",nullable = false)
    private LocalDate dataEmissione;
}
