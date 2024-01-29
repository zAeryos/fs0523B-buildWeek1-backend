package it.epicode.dao;

import it.epicode.entities.classes.Abbonamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AbbonamentoDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public AbbonamentoDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(Abbonamento abbonamento) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(abbonamento);
        et.commit();

    }

    public Abbonamento getById(int id) {
        return em.find(Abbonamento.class, id);
    }

    public void delete(int id) {
        EntityTransaction   et              = em.getTransaction();
        Abbonamento         abbonamento     = getById(id);

        et.begin();
        em.remove(abbonamento);
        et.commit();

    }
}
