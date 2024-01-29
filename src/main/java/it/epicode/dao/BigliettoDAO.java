package it.epicode.dao;

import it.epicode.entities.classes.Biglietto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BigliettoDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public BigliettoDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(Biglietto biglietto) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(biglietto);
        et.commit();

    }

    public Biglietto getById(int id) {
        return em.find(Biglietto.class, id);
    }

    public void delete(int id) {
        EntityTransaction   et          = em.getTransaction();
        Biglietto           biglietto   = getById(id);

        et.begin();
        em.remove(biglietto);
        et.commit();

    }
}
