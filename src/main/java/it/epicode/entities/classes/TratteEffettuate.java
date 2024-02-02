package it.epicode.entities.classes;

import it.epicode.dao.TratteEffettuateDAO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Entity
@Table(name = "tratte_effettuate")
public class TratteEffettuate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int         id;
    @ManyToOne()
    @JoinColumn(name = "mezzo_fk", nullable = false)
    private Mezzo       mezzo;
    @ManyToOne()
    @JoinColumn(name = "tratta_fk")
    private Tratta tratta;
    @Column(name = "data_tratta", nullable = false)
    private LocalDateTime dataTratta;
    @Column(name = "tempo_effettivo_tratta", nullable = false)
    private int         tempoEffettivoTratta;

    public TratteEffettuate() {
    }

    public TratteEffettuate(Mezzo mezzo, Tratta tratta, LocalDateTime dataTratta) {
        this.mezzo                  = mezzo;
        this.tratta                 = tratta;
        this.dataTratta             = dataTratta;
        this.tempoEffettivoTratta   = calcolaTempoEffettivoRandom();

        TratteEffettuateDAO dao     = new TratteEffettuateDAO();
        dao.create(this);
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

    public LocalDateTime getDataTratta() {
        return dataTratta;
    }

    public void setDataTratta(LocalDateTime dataTratta) {
        this.dataTratta = dataTratta;
    }

    public int getTempoEffettivoTratta() {
        return tempoEffettivoTratta;
    }

    public void setTempoEffettivoTratta(int tempoEffettivoTratta) {
        this.tempoEffettivoTratta = tempoEffettivoTratta;
    }

    public int calcolaTempoEffettivoRandom() {
        Random  random          = new Random();

        int     tempoMedio      = tratta.getTempoMedioPercorrenza();
        int     tempoMinimo     = tempoMedio - 10;
        int     tempoMassimo    = tempoMedio + 10;

        return random.nextInt(tempoMassimo - tempoMinimo + 1) + tempoMinimo;
    }

    @Override
    public String toString() {
        return "TratteEffettuate{"          +
                "id="                       + id +
                ", tratta="                 + tratta +
                ", dataTratta="             + dataTratta +
                ", tempoEffettivoTratta="   + tempoEffettivoTratta +
                '}';
    }
}
