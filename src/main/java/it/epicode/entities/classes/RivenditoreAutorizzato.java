package it.epicode.entities.classes;

import it.epicode.entities.classes.superclasses.PuntoDiEmissione;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

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

    public RivenditoreAutorizzato(String nomeRivenditore, String luogoRivenditore) {
        this.nomeRivenditore = nomeRivenditore;
        this.luogoRivenditore = luogoRivenditore;
    }

    public RivenditoreAutorizzato(String nomeRivenditore, String luogoRivenditore, String indirizzoRivenditore) {
        this.nomeRivenditore = nomeRivenditore;
        this.luogoRivenditore = luogoRivenditore;
        this.indirizzoRivenditore = indirizzoRivenditore;
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
}
