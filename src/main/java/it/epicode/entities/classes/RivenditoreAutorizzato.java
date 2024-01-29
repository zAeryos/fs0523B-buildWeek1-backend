package it.epicode.entities.classes;

import it.epicode.entities.classes.superclasses.PuntoDiEmissione;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "rivenditore_autorizzato")
public class RivenditoreAutorizzato extends PuntoDiEmissione {

    public RivenditoreAutorizzato() {
    }
}
