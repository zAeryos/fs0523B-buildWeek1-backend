package it.epicode.dao;

import it.epicode.entities.classes.Mezzo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/* WORKS */
public class MezzoDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public MezzoDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(Mezzo mezzo) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(mezzo);
        et.commit();

    }

    public Mezzo getById(int id) {
        return em.find(Mezzo.class, id);
    }

    public void delete(int id) {
        EntityTransaction  et    = em.getTransaction();
        Mezzo              mezzo = getById(id);

        et.begin();
        em.remove(mezzo);
        et.commit();

    }
}
