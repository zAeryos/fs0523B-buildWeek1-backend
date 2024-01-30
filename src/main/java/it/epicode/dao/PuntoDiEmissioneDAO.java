package it.epicode.dao;

import it.epicode.entities.classes.superclasses.PuntoDiEmissione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PuntoDiEmissioneDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public PuntoDiEmissioneDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(PuntoDiEmissione puntoDiEmissione) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(puntoDiEmissione);
        et.commit();

    }

    public PuntoDiEmissione getById(int id) {
        return em.find(PuntoDiEmissione.class, id);
    }

    public void delete(int id) {
        EntityTransaction   et                  = em.getTransaction();
        PuntoDiEmissione    puntoDiEmissione    = getById(id);

        et.begin();
        em.remove(puntoDiEmissione);
        et.commit();

    }
}
