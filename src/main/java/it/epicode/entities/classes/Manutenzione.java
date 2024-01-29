package it.epicode.entities.classes;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "manutenzione")
public class Manutenzione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int         id;
    @Column(name = "data_inizio")
    private LocalDate   dataInizio;
    @Column(name = "data_fine")
    private LocalDate   dataFine;

    public Manutenzione(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Manutenzione() {
    }

    public int getId() {
        return id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }
}
