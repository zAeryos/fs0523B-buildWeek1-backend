package it.epicode.dao;

import it.epicode.entities.classes.Biglietto;
import it.epicode.entities.classes.Manutenzione;
import it.epicode.entities.classes.Mezzo;
import it.epicode.entities.classes.superclasses.PuntoDiEmissione;
import it.epicode.entities.classes.superclasses.TitoloEmesso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;

/* WORKS */
public class TitoloEmessoDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public TitoloEmessoDAO(){
        emf = Persistence.createEntityManagerFactory("dbtrasportopubblico");
        em  = emf.createEntityManager();
    }
    public void create(TitoloEmesso titoloEmesso) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(titoloEmesso);
        et.commit();
    }

    public TitoloEmesso getById(int id) {
        return em.find(TitoloEmesso.class, id);
    }

    public void delete(int id) {
        EntityTransaction   et              = em.getTransaction();
        TitoloEmesso        titoloEmesso    = getById(id);

        et.begin();
        em.remove(titoloEmesso);
        et.commit();
    }

    public void update(TitoloEmesso titoloEmesso) {
        EntityTransaction   et       = em.getTransaction();

        et.begin();
        em.persist(titoloEmesso);
        et.commit();

    }

    public List<TitoloEmesso> getPeriodoBiglietti(LocalDateTime dataInizio, LocalDateTime dataFine) {

        return em.createQuery("select t from TitoloEmesso t where t.dataEmissione between :dataInizio and :dataFine", TitoloEmesso.class)
                .setParameter("dataInizio", dataInizio)
                .setParameter("dataFine", dataFine)
                .getResultList();
    }

    public List<TitoloEmesso> getBigliettiPuntoEmissione(PuntoDiEmissione puntoDiEmissione) {

        return em.createQuery("select t from TitoloEmesso t where t.puntoDiEmissione = :puntoDiEmissione", TitoloEmesso.class)
                .setParameter("puntoDiEmissione", puntoDiEmissione)
                .getResultList();
    }

    public List<TitoloEmesso> getBigliettiLuogoEmissione(PuntoDiEmissione puntoDiEmissione, LocalDateTime dataInizio, LocalDateTime dataFine) {

        return em.createQuery("select t from TitoloEmesso t where t.puntoDiEmissione = :puntoDiEmissione and t.dataEmissione between :dataInizio and :dataFine", TitoloEmesso.class)
                .setParameter("puntoDiEmissione", puntoDiEmissione)
                .setParameter("dataInizio", dataInizio)
                .setParameter("dataFine", dataFine)
                .getResultList();
    }

    public List<Biglietto> bigliettiVidimatiPerMezzo(Mezzo mezzo){

        return em.createQuery("select b from Biglietto b where b.mezzo = :mezzo", Biglietto.class)
                .setParameter("mezzo", mezzo)
                .getResultList();

    }

    public List<Biglietto> bigliettiVidimatiPerTempo(LocalDateTime periodoIniziale, LocalDateTime periodoFinale){

        return em.createQuery("select b from Biglietto b where b.dataVidimazione between :periodoIniziale and :periodoFinale", Biglietto.class)
                .setParameter("periodoIniziale", periodoIniziale)
                .setParameter("periodoFinale", periodoFinale)
                .getResultList();

    }


}

