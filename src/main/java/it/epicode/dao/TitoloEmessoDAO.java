package it.epicode.dao;

import it.epicode.entities.classes.Manutenzione;
import it.epicode.entities.classes.superclasses.TitoloEmesso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
/* WORKS */
public class TitoloEmessoDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public TitoloEmessoDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(TitoloEmesso titoloEmesso) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(titoloEmesso);
        et.commit();
    }

    public TitoloEmesso getById(int id) {
        return em.find(TitoloEmesso.class, id);
    }

    public void delete(int id) {
        EntityTransaction   et              = em.getTransaction();
        TitoloEmesso        titoloEmesso    = getById(id);

        et.begin();
        em.remove(titoloEmesso);
        et.commit();
    }

    public void update(TitoloEmesso titoloEmesso) {
        EntityTransaction   et       = em.getTransaction();

        et.begin();
        em.persist(titoloEmesso);
        et.commit();

    }

    //TODO query per controllare tutti i biglietti emessi in un periodo di tempo *
    //TODO query per controllare tutti i biglietti emessi dato un punto di emissione *
    //TODO query per controllare tutti i biglietti emessi dato un punto di emissione ed un periodo di tempo *
}
