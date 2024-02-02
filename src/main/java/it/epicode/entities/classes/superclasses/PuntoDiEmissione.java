package it.epicode.entities.classes.superclasses;

import it.epicode.dao.PuntoDiEmissioneDAO;
import it.epicode.dao.TitoloEmessoDAO;
import it.epicode.entities.classes.*;
import it.epicode.entities.enums.Periodicita;
import it.epicode.entities.enums.StatoAttivita;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "punto_di_emissione")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PuntoDiEmissione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int         id;

    @OneToMany(mappedBy = "puntoDiEmissione")
    @Column(name = "titoli_emessi")
    private List<TitoloEmesso> titoliEmessi;

    @Column(name = "stato_attivita")
    @Enumerated(EnumType.STRING)
    private StatoAttivita statoAttivita;

    public PuntoDiEmissione() {
        this.titoliEmessi = new ArrayList<>();
    }

    public PuntoDiEmissione(StatoAttivita statoAttivita) {
        this.statoAttivita = statoAttivita;
        this.titoliEmessi = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<TitoloEmesso> getTitoliEmessi() {
        return titoliEmessi;
    }

    public void setTitoliEmessi(TitoloEmesso titoloEmesso) {
        this.titoliEmessi.add(titoloEmesso);
    }

    public StatoAttivita getStatoAttivita() {
        return statoAttivita;
    }

    public void setStatoAttivita(StatoAttivita statoAttivita) {
        this.statoAttivita = statoAttivita;
    }

    public Biglietto emettiBiglietto() {
        if (this.statoAttivita == StatoAttivita.APERTO || this.statoAttivita == StatoAttivita.ATTIVO) {
            return new Biglietto(this, new TitoloEmessoDAO());
        } else if (this.statoAttivita == StatoAttivita.CHIUSO) {
            System.out.println("Il negozio è chiuso, torna quando siamo aperti.");
            return null;
        } else {
            System.out.println("Il distributore è fuori uso.");
            return null;
        }
    }

    public Abbonamento emettiAbbonamento(Periodicita periodicita, Tessera tessera) {
        if (this.statoAttivita == StatoAttivita.APERTO || this.statoAttivita == StatoAttivita.ATTIVO) {
            return new Abbonamento(this, periodicita, tessera);
        } else if (this.statoAttivita == StatoAttivita.CHIUSO) {
            System.out.println("Il negozio è chiuso, torna quando siamo aperti.");
            return null;
        } else {
            System.out.println("Il distributore è fuori uso.");
            return null;
        }
    }



    public Tessera emettiTessera(Utente utente) {
        if (this.statoAttivita == StatoAttivita.APERTO || this.statoAttivita == StatoAttivita.ATTIVO) {
            return new Tessera(utente);
        } else if (this.statoAttivita == StatoAttivita.CHIUSO) {
            System.out.println("Il negozio è chiuso, torna quando siamo aperti.");
            return null;
        } else {
            System.out.println("Il distributore è fuori uso.");
            return null;
        }
    }
}
