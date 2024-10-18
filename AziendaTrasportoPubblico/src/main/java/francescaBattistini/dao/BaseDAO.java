package francescaBattistini.dao;

import francescaBattistini.Exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class BaseDAO {

    protected final EntityManager entityManager;

    public BaseDAO(EntityManager em) {
        this.entityManager = em;
    }

    protected <T> List<T> executeTypedQuery(Class<T> entityType, TypedQuery<T> tq) throws NotFoundException {

        List<T> res = tq.getResultList();
        if (res.isEmpty()) throw new NotFoundException(entityType.getSimpleName() + " non trovato :(");

        return res;
    }

    public <T> void save(T obj) {
        EntityTransaction t = entityManager.getTransaction();

        t.begin();

        entityManager.persist(obj);

        t.commit();

        System.out.println(obj + " Saved!");
    }


    public <T> T getObjectById(Class<T> entityClass, String id) throws NotFoundException {

        T found = entityManager.find(entityClass, UUID.fromString(id));
        if (found == null) throw new NotFoundException(entityClass.getSimpleName() + " non trovato");

        return found;
    }

    public <T> T getObjectById(Class<T> entityClass, long id) throws NotFoundException {

        T found = entityManager.find(entityClass, id);
        if (found == null) throw new NotFoundException(entityClass.getSimpleName() + " non trovato");

        return found;
    }


    public <T> void delete(Class<T> entityClass, String id) throws NotFoundException {
        T obj = this.getObjectById(entityClass, id);

        EntityTransaction t = entityManager.getTransaction();

        t.begin();

        entityManager.remove(obj);

        t.commit();

        System.out.println(obj + " Deleted!");

    }

    public <T> List<T> getTakeAllObj(Class<T> entityClass) throws NotFoundException {
        TypedQuery<T> query = entityManager.createQuery("select T from " + entityClass.getSimpleName() + " T", entityClass);//selezionami gli elementi da 'T'che sarebbe l'alias di 'type'; cioè il nome della classe che gli assegniamo.
        return this.executeTypedQuery(entityClass, query);
    }


    public <T> void update(T obj) {
        EntityTransaction t = entityManager.getTransaction();
        try {
            t.begin();
            if (!entityManager.contains(obj)) {
                entityManager.merge(obj);
            }
            entityManager.flush();
            t.commit();
            System.out.println(obj + " updated!");
        } catch (Exception e) {
            if (t.isActive()) {
                t.rollback();
            }
            System.out.println("Errore durante l'aggiornamento: " + e.getMessage());
        }
    }

}