package it.epicode.entities.classes;

import it.epicode.dao.PuntoDiEmissioneDAO;
import it.epicode.entities.classes.superclasses.PuntoDiEmissione;
import it.epicode.entities.enums.StatoAttivita;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Scanner;

@Entity
@Table(name = "distributore_automatico")
public class DistributoreAutomatico extends PuntoDiEmissione {
    @Column(name = "stato_attivita", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatoAttivita statoAttivita;

    public DistributoreAutomatico(StatoAttivita statoAttivita) {
        this.statoAttivita = statoAttivita;

        PuntoDiEmissioneDAO dao = new PuntoDiEmissioneDAO();
        dao.create((PuntoDiEmissione)this);
    }

    public DistributoreAutomatico() {
    }

    public StatoAttivita getStatoAttivita() {
        return statoAttivita;
    }

    public void setStatoAttivita(StatoAttivita statoAttivita) {
        this.statoAttivita = statoAttivita;
    }

    public void stampaBiglietto() {
        Scanner scanner = new Scanner(System.in);
    }
}
