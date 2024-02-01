package it.epicode.entities.classes;

import it.epicode.dao.ManutenzioneDAO;
import it.epicode.dao.MezzoDAO;
import it.epicode.entities.enums.StatoServizio;
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
    @ManyToOne()
    @JoinColumn(name = "mezzo_fk")
    private Mezzo       mezzo;

    public Manutenzione() {
    }

    public Manutenzione(LocalDate dataInizio, Mezzo mezzo, ManutenzioneDAO manutenzioneDAO, MezzoDAO mezzoDAO) {
        this.dataInizio = dataInizio;
        this.mezzo      = mezzo;

        mezzo.setStatoServizio(StatoServizio.IN_MANUTENZIONE);

        mezzoDAO.update(mezzo);
        manutenzioneDAO.create(this);
    }

    public Manutenzione(LocalDate dataInizio, Mezzo mezzo) {
        this.dataInizio = dataInizio;
        this.mezzo      = mezzo;

        mezzo.setStatoServizio(StatoServizio.IN_MANUTENZIONE);
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
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
        this.mezzo.setStatoServizio(StatoServizio.IN_SERVIZIO);
    }

    @Override
    public String toString() {
        return "Manutenzione{" +
                "id=" + id +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }
}
