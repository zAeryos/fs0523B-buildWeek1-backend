package it.epicode.entities.classes;

import it.epicode.entities.classes.superclasses.PuntoDiEmissione;
import it.epicode.entities.classes.superclasses.TitoloEmesso;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "biglietto")
public class Biglietto extends TitoloEmesso {

    private boolean valido;

    public Biglietto(PuntoDiEmissione puntoDiEmissione, LocalDate dataEmissione, boolean valido) {
        super(puntoDiEmissione, dataEmissione);
        this.valido = valido;
    }

    public Biglietto() {
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
}
