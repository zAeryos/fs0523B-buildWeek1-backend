package it.epicode.entities.classes;

import it.epicode.entities.classes.superclasses.PuntoDiEmissione;
import it.epicode.entities.classes.superclasses.TitoloEmesso;
import it.epicode.entities.enums.Periodicita;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "abbonamento")
public class Abbonamento extends TitoloEmesso {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;
    @OneToOne(mappedBy = "abbonamento")
    private Tessera     tessera;

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
