package it.epicode.entities.classes.superclasses;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "titolo_emesso")
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TitoloEmesso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int                 id;
    @ManyToOne
    @JoinColumn(name = "punto_di_emissione_fk")
    private PuntoDiEmissione    puntoDiEmissione;
    @Column(name = "data_emissione")
    private LocalDate           dataEmissione;

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

    public void setPuntoEmissione(PuntoDiEmissione puntoDiEmissione) {
        this.puntoDiEmissione = puntoDiEmissione;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

}
