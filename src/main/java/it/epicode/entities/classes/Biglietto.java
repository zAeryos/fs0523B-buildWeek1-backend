package it.epicode.entities.classes;

import it.epicode.dao.TitoloEmessoDAO;
import it.epicode.entities.classes.superclasses.PuntoDiEmissione;
import it.epicode.entities.classes.superclasses.TitoloEmesso;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "biglietto")
public class Biglietto extends TitoloEmesso {

    private boolean valido;

    public Biglietto(PuntoDiEmissione puntoDiEmissione, LocalDateTime dataEmissione) {
        super(puntoDiEmissione, dataEmissione);
        this.valido = true;
        TitoloEmessoDAO dao = new TitoloEmessoDAO();
        dao.create(this);
    }

    public Biglietto() {
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public void cambiaValidita() {
        if (valido) {
            valido = false;
        } else {
            System.out.println("Il biglietto è già stato utilizzato.");
        }
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "valido=" + valido +
                '}';
    }
}
