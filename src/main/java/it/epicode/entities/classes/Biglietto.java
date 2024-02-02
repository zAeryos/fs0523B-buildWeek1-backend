package it.epicode.entities.classes;

import it.epicode.dao.TitoloEmessoDAO;
import it.epicode.entities.classes.superclasses.PuntoDiEmissione;
import it.epicode.entities.classes.superclasses.TitoloEmesso;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "biglietto")
public class Biglietto extends TitoloEmesso {

    private boolean valido;

    @ManyToOne
    @JoinColumn(name = "mezzo_fk")
    private Mezzo mezzo;

    @Column(name = "data_vidimazione")
    private LocalDateTime dataVidimazione;

    public Biglietto(PuntoDiEmissione puntoDiEmissione, TitoloEmessoDAO dao) {
        super(puntoDiEmissione);
        this.valido = true;
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

    public Biglietto cambiaValidita() {
        if (valido) {
           this.valido = false;
        } else {
            System.out.println("Il biglietto è già stato utilizzato.");
        }
        return this;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public LocalDateTime getDataVidimazione() {
        return dataVidimazione;
    }

    public void setDataVidimazione(LocalDateTime dataVidimazione) {
        this.dataVidimazione = dataVidimazione;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "valido=" + valido +
                '}';
    }
}
