package francescaBattistini.entities;

import francescaBattistini.Enum.StatoDistributore;
import jakarta.persistence.*;

@Entity
@Table(name = "distributori_automatici")
public class DistributoreAutomatico extends Rivenditore{

    @Enumerated(EnumType.STRING)
    private StatoDistributore stato;
    @Column(name = "is_touchscreen")
    private boolean isTouchScreen;
    @Column(name = "cards_accepted")
    private boolean cardsAccepted;

    public DistributoreAutomatico() {}

    public DistributoreAutomatico(long id, String localita, StatoDistributore stato, boolean isTouchScreen, boolean cardsAccepted) {
        super(id, localita);
        this.stato = stato;
        this.isTouchScreen = isTouchScreen;
        this.cardsAccepted = cardsAccepted;
    }

    public StatoDistributore getStato() {
        return stato;
    }

    public void setStato(StatoDistributore stato) {
        this.stato = stato;
    }

    public boolean isTouchScreen() {
        return isTouchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        isTouchScreen = touchScreen;
    }

    public boolean isCardsAccepted() {
        return cardsAccepted;
    }

    public void setCardsAccepted(boolean cardsAccepted) {
        this.cardsAccepted = cardsAccepted;
    }

    @Override
    public String toString() {
        return super.toString() + "DistributoreAutomatico{" +
                "stato=" + stato +
                ", isTouchScreen=" + isTouchScreen +
                ", cardsAccepted=" + cardsAccepted +
                '}';
    }
}
