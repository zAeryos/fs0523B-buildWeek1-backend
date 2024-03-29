package it.epicode.dao;

import it.epicode.entities.classes.Tessera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
/* WORKS */
public class TesseraDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public TesseraDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(Tessera tessera) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(tessera);
        et.commit();

    }

    public Tessera getById(int id) {
        return em.find(Tessera.class, id);
    }

    public void delete(int id) {
        EntityTransaction   et       = em.getTransaction();
        Tessera             tessera  = getById(id);

        et.begin();
        em.remove(tessera);
        et.commit();
    }

    public void update(int id) {
        EntityTransaction   et       = em.getTransaction();
        Tessera             tessera  = getById(id);

        et.begin();
        et.commit();
    }

    //TODO Modificare create e update
    //TODO Bisogna controllare se l'abbonamento collegato a questa tessera è valido
}
