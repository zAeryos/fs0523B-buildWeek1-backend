package it.epicode.entities.classes.superclasses;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "punto_di_emissione")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PuntoDiEmissione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int         id;

    @OneToMany(mappedBy = "puntoDiEmissione")
    @Column(name = "titoli_emessi")
    private List<TitoloEmesso> titoliEmessi;

    public PuntoDiEmissione() {
        this.titoliEmessi = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<TitoloEmesso> getTitoliEmessi() {
        return titoliEmessi;
    }

    public void setTitoliEmessi(TitoloEmesso titoloEmesso) {
        this.titoliEmessi.add(titoloEmesso);
    }
}
