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
    @OneToOne
    @JoinColumn(name = "tessera_fk")
    private Tessera     tessera;
    private LocalDate   scadenza;

    public Abbonamento(PuntoDiEmissione puntoDiEmissione, LocalDate dataEmissione, Periodicita periodicita, Tessera tessera) {
        super(puntoDiEmissione, dataEmissione);
        this.periodicita = periodicita;
        this.scadenza = LocalDate.now();
        this.scadenza = calcolaScadenza();
        this.tessera = tessera;
    }

    public Abbonamento() {
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
        calcolaScadenza();
    }

    public LocalDate calcolaScadenza () {
        if (periodicita == Periodicita.SETTIMANALE) {
            return this.scadenza = this.scadenza.plusDays(7);
        } else if (periodicita == Periodicita.MENSILE) {
            return this.scadenza = this.scadenza.plusDays(30);
        } else if (periodicita == Periodicita.ANNUALE) {
            return this.scadenza = this.scadenza.plusDays(365);
        }
        return this.scadenza;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "periodicita=" + periodicita +
                ", tessera=" + tessera +
                ", scadenza=" + scadenza +
                '}';
    }
}
