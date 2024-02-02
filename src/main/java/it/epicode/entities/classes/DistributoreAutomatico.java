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

    private LocalDate dataInstallazione;

    public DistributoreAutomatico(StatoAttivita statoAttivita, LocalDate dataInstallazione, PuntoDiEmissioneDAO dao) {
        super(statoAttivita);
        this.dataInstallazione = dataInstallazione;

        dao.create((PuntoDiEmissione)this);
    }

    public DistributoreAutomatico(StatoAttivita statoAttivita, PuntoDiEmissioneDAO dao) {
        super(statoAttivita);

        dao.create((PuntoDiEmissione)this);
    }
    public DistributoreAutomatico(){}

    public LocalDate getDataInstallazione() {
        return dataInstallazione;
    }

    public void setDataInstallazione(LocalDate dataInstallazione) {
        this.dataInstallazione = dataInstallazione;
    }

    public void stampaBiglietto() {
        Scanner scanner = new Scanner(System.in);
    }
}
