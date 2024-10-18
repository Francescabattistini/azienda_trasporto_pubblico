package francescaBattistini.dao;

import francescaBattistini.Exceptions.NotFoundException;
import francescaBattistini.entities.Percorrenza;
import francescaBattistini.entities.StatoVeicolo;
import francescaBattistini.entities.Tratta;
import francescaBattistini.entities.Veicolo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AdminDAO extends BaseDAO {
    public AdminDAO(EntityManager em) {
        super(em);
    }

    public StatoVeicolo getFirstState(Veicolo V) throws NotFoundException {
        TypedQuery<StatoVeicolo> query = entityManager.createQuery("select SV from StatoVeicolo SV where SV.id_veicolo = :id", StatoVeicolo.class).setMaxResults(1);
        query.setParameter("id", V);
        return this.executeTypedQuery(StatoVeicolo.class, query).getFirst();
    }

    public List<Veicolo> VeicoloPerTratta(Tratta tr) throws NotFoundException {
        TypedQuery<Veicolo> query = entityManager.createNamedQuery("VeicoliPerTratta", Veicolo.class);
        query.setParameter("trattaSelezionata", tr);
        return this.executeTypedQuery(Veicolo.class, query);
    }


    public List<Percorrenza> percorrenzeDiVeicoloPerTratta(Tratta tr, Veicolo ve) throws NotFoundException {
        TypedQuery<Percorrenza> query = entityManager.createNamedQuery("percorrenzeDiVeicoloPerTratta", Percorrenza.class);
        query.setParameter("trattaSelezionata", tr);
        query.setParameter("veicoloSelezionato", ve);
        return this.executeTypedQuery(Percorrenza.class, query);
    }


}
