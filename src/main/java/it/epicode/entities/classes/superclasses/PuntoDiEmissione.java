package it.epicode.entities.classes.superclasses;

import it.epicode.dao.PuntoDiEmissioneDAO;
import it.epicode.dao.TitoloEmessoDAO;
import it.epicode.entities.classes.Abbonamento;
import it.epicode.entities.classes.Biglietto;
import it.epicode.entities.classes.Tessera;
import it.epicode.entities.classes.Utente;
import it.epicode.entities.enums.Periodicita;
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

    public PuntoDiEmissione() {
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

    public Biglietto emettiBiglietto() {
        return new Biglietto(this, LocalDateTime.now());
    }

    public Abbonamento emettiAbbonamento(Periodicita periodicita, Tessera tessera) {
        return new Abbonamento(this, LocalDateTime.now(), periodicita, tessera);
    }

    public Tessera emettiTessera(Utente utente) {

        return new Tessera(utente);
    }



    //TODO metodi per emettere biglietti / abbonamenti | ?Tessera
    //TODO aggiungere ai metodi un controllo dello stato di servizio
}
