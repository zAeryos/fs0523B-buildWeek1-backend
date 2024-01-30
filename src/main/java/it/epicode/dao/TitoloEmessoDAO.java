package it.epicode.dao;

import it.epicode.entities.classes.superclasses.TitoloEmesso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
}