package it.epicode.entities.classes;

import it.epicode.dao.TrattaDAO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tratte_effettuate")
public class TrattaEffettuata{

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
//    @ManyToOne
//    @JoinColumn(name = "tratta_fk")
//    private  Tratta tratta;

    public TrattaEffettuata() {
    }

    public TrattaEffettuata(Mezzo mezzo, LocalDate dataTratta, int tempoEffettivoTratta) {
//        this.tratta = tratta;
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

//    public int randomTempoEffettivo (){
//        int tempoMedio = ;
//        int tempoEffettivo = (int)Math.floor(Math.random()*(tempoMedio + 10)+(tempoMedio - 10));
//        return tempoEffettivo;
    }

