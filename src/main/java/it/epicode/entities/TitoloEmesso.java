package it.epicode.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "titolo_emesso")
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TitoloEmesso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "punto_di_emissione")
    private PuntoDiEmissione puntoDiEmissione;
    @Column(name = "data_emissione")
    private LocalDate dataEmissione;
    private LocalDate scadenza;

    public TitoloEmesso() {
    }

    public TitoloEmesso(PuntoDiEmissione puntoDiEmissione, LocalDate dataEmissione) {
        this.puntoDiEmissione = puntoDiEmissione;
        this.dataEmissione = dataEmissione;
    }

    public int getId() {
        return id;
    }

    public PuntoDiEmissione getPuntoDiEmissione() {
        return puntoDiEmissione;
    }

    public void setPuntoDiEmissione(PuntoDiEmissione puntoDiEmissione) {
        this.puntoDiEmissione = puntoDiEmissione;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }
}
