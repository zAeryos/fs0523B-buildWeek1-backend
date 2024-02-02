package it.epicode.entities.classes.superclasses;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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
    private LocalDateTime       dataEmissione;

    public TitoloEmesso() {
    }

    public TitoloEmesso(PuntoDiEmissione puntoDiEmissione) {
        this.puntoDiEmissione = puntoDiEmissione;
        this.dataEmissione = LocalDateTime.now();
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

    public LocalDateTime getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDateTime dataEmissione) {
        this.dataEmissione = dataEmissione;
    }


    @Override
    public String toString() {
        return "TitoloEmesso{"          +
                "id="                   + id                +
                ", puntoDiEmissione="   + puntoDiEmissione  +
                ", dataEmissione="      + dataEmissione     +
                '}';
    }
}
