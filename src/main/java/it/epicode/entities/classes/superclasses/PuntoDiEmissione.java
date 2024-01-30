package it.epicode.entities.classes.superclasses;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "punto_di_emissione")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PuntoDiEmissione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int         id;
    @Column(name = "data_emissione")
    private LocalDate   dataEmissione;

    @OneToMany(mappedBy = "puntoDiEmissione")
    private List<TitoloEmesso> titoliEmessi;


    public PuntoDiEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public PuntoDiEmissione() {
    }

    public int getId() {
        return id;
    }
    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }
}
