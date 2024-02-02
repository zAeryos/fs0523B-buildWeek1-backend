package it.epicode.dao;

import it.epicode.entities.classes.*;
import it.epicode.entities.classes.superclasses.TitoloEmesso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

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
        em.persist(mezzo);
        et.commit();
    }


    public int contatoreTratteEffettuate(Mezzo mezzo){

        return em.createQuery("select count (t) from TratteEffettuate t where mezzo = :mezzo", Long.class)
                .setParameter("mezzo", mezzo)
                .getSingleResult()
                .intValue();

    }

    //TODO metodo per stampare il periodo di attività  !optional!

}
