package it.epicode.dao;

import it.epicode.entities.classes.Mezzo;
import it.epicode.entities.classes.Tessera;
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
    public Mezzo create(Mezzo mezzo) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(mezzo);
        et.commit();

        return mezzo;
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

    public void update(Mezzo mezzo) {
        EntityTransaction   et       = em.getTransaction();

        et.begin();
        et.commit();
    }

    //TODO metodo per stampare il periodo delle manutenzioni ed il periodo di attività
    //TODO metodo per controllare i biglietti vidimati in quel mezzo
    //TODO metodo per controllare i biglietti vidimati in un periodo di tempo
    //TODO metodo per tenere traccia di numero di volte che un mezzo percorre una tratta effettuata

}
