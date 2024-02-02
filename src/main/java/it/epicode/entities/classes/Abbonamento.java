package it.epicode.entities.classes;

import it.epicode.dao.PuntoDiEmissioneDAO;
import it.epicode.dao.TitoloEmessoDAO;
import it.epicode.entities.classes.superclasses.PuntoDiEmissione;
import it.epicode.entities.classes.superclasses.TitoloEmesso;
import it.epicode.entities.enums.Periodicita;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "abbonamento")
public class Abbonamento extends TitoloEmesso {
    @Enumerated(EnumType.STRING)
    private Periodicita     periodicita;
    @OneToOne
    @JoinColumn(name = "tessera_fk")
    private Tessera         tessera;
    private LocalDateTime   scadenza;

    public Abbonamento(PuntoDiEmissione puntoDiEmissione, Periodicita periodicita, Tessera tessera, TitoloEmessoDAO dao) {
        super(puntoDiEmissione);

        this.periodicita    = periodicita;
        this.scadenza       = LocalDateTime.now();
        this.scadenza       = calcolaScadenza();
        this.tessera        = tessera;
        this.tessera.setAbbonamento(this);

        dao.create(this);
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

    public LocalDateTime calcolaScadenza () {
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

    public LocalDateTime getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDateTime scadenza) {
        this.scadenza = scadenza;
    }
    public void rinnovaAbbonamento(Periodicita periodicita) {
            this.scadenza = LocalDateTime.now();
        if (periodicita == Periodicita.SETTIMANALE){
            this.scadenza = this.scadenza.plusDays(7);
            this.periodicita = Periodicita.SETTIMANALE;
        } else if (periodicita == Periodicita.MENSILE) {
            this.scadenza = this.scadenza.plusDays(30);
            this.periodicita = Periodicita.MENSILE;
        } else if(periodicita == Periodicita.ANNUALE){
            this.scadenza = this.scadenza.plusDays(365);
            this.periodicita = Periodicita.ANNUALE;
        }
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "periodicita=" + periodicita +
                ", scadenza=" + scadenza +
                '}';
    }
}
