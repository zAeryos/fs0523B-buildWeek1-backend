package it.epicode.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "distributore_automatico")
public class DistributoreAutomatico extends PuntoDiEmissione{
    @Column(name = "stato_attivita", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatoAttivita statoAttivita;

    public DistributoreAutomatico(LocalDate dataEmissione, StatoAttivita statoAttivita) {
        super(dataEmissione);
        this.statoAttivita = statoAttivita;
    }

    public DistributoreAutomatico() {
    }

    public StatoAttivita getStatoAttivita() {
        return statoAttivita;
    }

    public void setStatoAttivita(StatoAttivita statoAttivita) {
        this.statoAttivita = statoAttivita;
    }
}
