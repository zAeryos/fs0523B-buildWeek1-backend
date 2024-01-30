package it.epicode.dao;

import it.epicode.entities.classes.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UtenteDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public UtenteDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(Utente utente) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(utente);
        et.commit();

    }

    public Utente getById(int id) {
        return em.find(Utente.class, id);
    }

    public void delete(int id) {
        EntityTransaction   et      = em.getTransaction();
        Utente              utente  = getById(id);

        et.begin();
        em.remove(utente);
        et.commit();

    }
}
