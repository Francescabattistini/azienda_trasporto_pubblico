package Entities;

import java.util.Date;
import java.util.UUID;

public class Tratta {
    private UUID id;
    private String zonaPartenza;
    private String capolinea;
    private Double tempoIpotetico;


    public Tratta() {
    }

    public Tratta(UUID id, String zonaPartenza, String capolinea, Double tempoIpotetico) {
        this.id = id;
        this.zonaPartenza = zonaPartenza;
        this.capolinea = capolinea;
        this.tempoIpotetico = tempoIpotetico;
    }

    public UUID getId() {
        return id;
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
                ", numeroVoltePerTratta=" +
                '}';
    }
}
