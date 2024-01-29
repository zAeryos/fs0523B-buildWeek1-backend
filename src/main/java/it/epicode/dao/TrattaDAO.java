package it.epicode.dao;

import it.epicode.entities.classes.Tratta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TrattaDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public TrattaDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(Tratta tratta) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(tratta);
        et.commit();

    }

    public Tratta getById(int id) {
        return em.find(Tratta.class, id);
    }

    public void delete(int id) {
        EntityTransaction   et      = em.getTransaction();
        Tratta              tratta  = getById(id);

        et.begin();
        em.remove(tratta);
        et.commit();

    }
}
