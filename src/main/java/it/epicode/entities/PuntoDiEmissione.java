package it.epicode.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "punto_di_emissione")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PuntoDiEmissione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "data_emissione")
    private LocalDate dataEmissione;


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
