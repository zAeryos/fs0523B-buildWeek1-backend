package it.epicode.dao;

import it.epicode.entities.classes.TratteEffettuate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
/* WORKS */
public class TratteEffettuateDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public TratteEffettuateDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(TratteEffettuate tratteEffettuate) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(tratteEffettuate);
        et.commit();

    }

    public TratteEffettuate getById(int id) {
        return em.find(TratteEffettuate.class, id);
    }

    public void delete(int id) {
        EntityTransaction   et            = em.getTransaction();
        TratteEffettuate tratteEffettuate = getById(id);

        et.begin();
        em.remove(tratteEffettuate);
        et.commit();

    }

    //TODO metodo per tenere traccia del tempo effettivo di percorrenza di ogni tratta effettuata


}
