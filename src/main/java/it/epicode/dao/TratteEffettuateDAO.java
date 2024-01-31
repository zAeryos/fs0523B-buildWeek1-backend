package it.epicode.dao;

import it.epicode.entities.classes.TrattaEffettuata;
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
    public void create(TrattaEffettuata trattaEffettuata) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(trattaEffettuata);
        et.commit();

    }

    public TrattaEffettuata getById(int id) {
        return em.find(TrattaEffettuata.class, id);
    }

    public void delete(int id) {
        EntityTransaction   et                = em.getTransaction();
        TrattaEffettuata trattaEffettuata = getById(id);

        et.begin();
        em.remove(trattaEffettuata);
        et.commit();

    }

    //TODO metodo per tenere traccia del tempo effettivo di percorrenza di ogni tratta effettuata

}
