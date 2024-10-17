package francescaBattistini.dao;

import francescaBattistini.Exceptions.NotFoundException;
import francescaBattistini.entities.StatoVeicolo;
import francescaBattistini.entities.Veicolo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class AdminDAO extends BaseDAO {
    public AdminDAO(EntityManager em) {


        super(em);
    }

    public StatoVeicolo getFirstState(Veicolo V) throws NotFoundException {
        TypedQuery<StatoVeicolo> query = entityManager.createQuery("select SV from StatoVeicolo SV where SV.id_veicolo = :id", StatoVeicolo.class).setMaxResults(1);
        query.setParameter("id", V);
        return this.executeTypedQuery(StatoVeicolo.class, query).getFirst();
    }
}
