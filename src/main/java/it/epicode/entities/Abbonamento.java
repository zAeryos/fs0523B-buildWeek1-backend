package it.epicode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "abbonamento")
public class Abbonamento extends TitoloEmesso{
    private Periodicita periodicita;

    public Abbonamento(PuntoDiEmissione puntoDiEmissione, LocalDate dataEmissione, Periodicita periodicita) {
        super(puntoDiEmissione, dataEmissione);
        this.periodicita = periodicita;
    }

    public Abbonamento() {
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
