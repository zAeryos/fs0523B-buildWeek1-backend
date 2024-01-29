package it.epicode.dao;

import it.epicode.entities.classes.RivenditoreAutorizzato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RivenditoreAutorizzatoDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public RivenditoreAutorizzatoDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(RivenditoreAutorizzato rivenditoreAutorizzato) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(rivenditoreAutorizzato);
        et.commit();

    }

    public RivenditoreAutorizzato getById(int id) {
        return em.find(RivenditoreAutorizzato.class, id);
    }

    public void delete(int id) {
        EntityTransaction           et                      = em.getTransaction();
        RivenditoreAutorizzato      rivenditoreAutorizzato  = getById(id);

        et.begin();
        em.remove(rivenditoreAutorizzato);
        et.commit();

    }
}
