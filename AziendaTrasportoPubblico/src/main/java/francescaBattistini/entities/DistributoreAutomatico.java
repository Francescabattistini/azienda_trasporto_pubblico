package francescaBattistini.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "distributori_automatici")
public class DistributoreAutomatico extends Rivenditore{

//    private Enum stato;
    @Column(name = "is_touchscreen")
    private boolean isTouchScreen;
    @Column(name = "cards_accepted")
    private boolean cardsAccepted;

    public DistributoreAutomatico() {}

    public DistributoreAutomatico(long id, String localita, boolean isTouchScreen, boolean cardsAccepted) {
        super(id, localita);
        this.isTouchScreen = isTouchScreen;
        this.cardsAccepted = cardsAccepted;
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
                "isTouchScreen=" + isTouchScreen +
                ", cardsAccepted=" + cardsAccepted +
                '}';
    }
}
