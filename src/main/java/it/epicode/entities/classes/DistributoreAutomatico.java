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

    public DistributoreAutomatico(StatoAttivita statoAttivita, PuntoDiEmissioneDAO dao) {
        super(statoAttivita);

        dao.create((PuntoDiEmissione)this);
    }

    public DistributoreAutomatico(){}

    public void stampaBiglietto() {
        Scanner scanner = new Scanner(System.in);
    }
}
