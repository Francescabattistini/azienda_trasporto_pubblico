package Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;
@Entity
@Table(name="autobus")
public class Autobus {
    @Column(name="targa",nullable = false)
    private String targa;




    public Autobus(){}


    public Autobus(String targa) {
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "targa='" + targa + '\'' +
                '}';
    }
}
