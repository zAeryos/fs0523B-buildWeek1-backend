package it.epicode.dao;

import it.epicode.entities.classes.Manutenzione;
import it.epicode.entities.classes.Mezzo;
import it.epicode.entities.enums.StatoServizio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

/* WORKS */

public class ManutenzioneDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public ManutenzioneDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(Manutenzione manutenzione) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(manutenzione);
        et.commit();
    }

    public Manutenzione getById(int id) {
        return em.find(Manutenzione.class, id);
    }

    public void update(Manutenzione manutenzione) {
        EntityTransaction   et       = em.getTransaction();

        et.begin();
        MezzoDAO mezzoDAO = new MezzoDAO();
        mezzoDAO.update(manutenzione.getMezzo());  //TODO verificare l'update (lo stato di servizio non viene aggiornato)

        et.commit();
    }

    public void delete(int id) {
        EntityTransaction   et              = em.getTransaction();
        Manutenzione        manutenzione    = getById(id);

        et.begin();
        em.remove(manutenzione);
        et.commit();

    }


    public List<Manutenzione> periodoManutenzioni(Mezzo mezzo){

        return em.createQuery("select m from Manutenzione m where m.mezzo = :mezzo", Manutenzione.class)
                .setParameter("mezzo", mezzo)
                .getResultList();

    }

}
