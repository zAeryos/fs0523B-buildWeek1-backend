package it.epicode.entities.classes;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tratte_effettuate")
public class TratteEffettuate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int         id;
    @ManyToOne()
    @JoinColumn(name = "mezzo_fk", nullable = false)
    private Mezzo       mezzo;
    @Column(name = "data_tratta", nullable = false)
    private LocalDate   dataTratta;
    @Column(name = "tempo_effettivo_tratta", nullable = false)
    private int         tempoEffettivoTratta;

    public TratteEffettuate() {
    }

    public TratteEffettuate(Mezzo mezzo, LocalDate dataTratta, int tempoEffettivoTratta) {
        this.mezzo = mezzo;
        this.dataTratta = dataTratta;
        this.tempoEffettivoTratta = tempoEffettivoTratta;
    }

    public int getId() {
        return id;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public LocalDate getDataTratta() {
        return dataTratta;
    }

    public void setDataTratta(LocalDate dataTratta) {
        this.dataTratta = dataTratta;
    }

    public int getTempoEffettivoTratta() {
        return tempoEffettivoTratta;
    }

    public void setTempoEffettivoTratta(int tempoEffettivoTratta) {
        this.tempoEffettivoTratta = tempoEffettivoTratta;
    }
}
