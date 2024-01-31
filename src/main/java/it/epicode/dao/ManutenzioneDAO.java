package it.epicode.dao;

import it.epicode.entities.classes.Manutenzione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/* WORKS */

public class ManutenzioneDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public ManutenzioneDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(Manutenzione manutenzione) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(manutenzione);
        et.commit();

    }

    public Manutenzione getById(int id) {
        return em.find(Manutenzione.class, id);
    }

    public void delete(int id) {
        EntityTransaction   et              = em.getTransaction();
        Manutenzione        manutenzione    = getById(id);

        et.begin();
        em.remove(manutenzione);
        et.commit();

    }
}
