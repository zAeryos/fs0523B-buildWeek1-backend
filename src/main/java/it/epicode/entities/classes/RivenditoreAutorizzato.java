package it.epicode.entities.classes;

import it.epicode.dao.PuntoDiEmissioneDAO;
import it.epicode.entities.classes.superclasses.PuntoDiEmissione;
import it.epicode.entities.enums.StatoAttivita;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rivenditore_autorizzato")
public class RivenditoreAutorizzato extends PuntoDiEmissione {

    @Column(name = "nome_rivenditore")
    private String nomeRivenditore;
    @Column(name = "luogo_rivenditore")
    private String luogoRivenditore;
    @Column(name = "indirizzo_rivenditore")
    private String indirizzoRivenditore;

    public RivenditoreAutorizzato() {
    }

    public RivenditoreAutorizzato(StatoAttivita statoAttivita, String nomeRivenditore, String luogoRivenditore, PuntoDiEmissioneDAO dao) {
        super(statoAttivita);
        this.nomeRivenditore        = nomeRivenditore;
        this.luogoRivenditore       = luogoRivenditore;

        dao.create((PuntoDiEmissione)this);
    }

    public RivenditoreAutorizzato(StatoAttivita statoAttivita, String nomeRivenditore, String luogoRivenditore, String indirizzoRivenditore, PuntoDiEmissioneDAO dao) {
        super(statoAttivita);
        this.nomeRivenditore        = nomeRivenditore;
        this.luogoRivenditore       = luogoRivenditore;
        this.indirizzoRivenditore   = indirizzoRivenditore;
        dao.create((PuntoDiEmissione)this);
    }

    public String getNomeRivenditore() {
        return nomeRivenditore;
    }

    public void setNomeRivenditore(String nomeRivenditore) {
        this.nomeRivenditore = nomeRivenditore;
    }

    public String getLuogoRivenditore() {
        return luogoRivenditore;
    }

    public void setLuogoRivenditore(String luogoRivenditore) {
        this.luogoRivenditore = luogoRivenditore;
    }

    public String getIndirizzoRivenditore() {
        return indirizzoRivenditore;
    }

    public void setIndirizzoRivenditore(String indirizzoRivenditore) {
        this.indirizzoRivenditore = indirizzoRivenditore;
    }

    @Override
    public String toString() {
        return "RivenditoreAutorizzato{" +
                "nomeRivenditore='" + nomeRivenditore + '\'' +
                ", luogoRivenditore='" + luogoRivenditore + '\'' +
                ", indirizzoRivenditore='" + indirizzoRivenditore + '\'' +
                '}';
    }
}
