package it.epicode.entities.classes;

import it.epicode.entities.enums.StatoServizio;
import it.epicode.entities.enums.TipoMezzo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mezzo")
public class Mezzo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codice_veicolo")
    private int                     codiceVeicolo;
    private int                     capienza;
    @Enumerated(EnumType.STRING)
    @Column(name = "stato_servizio")
    private StatoServizio           statoServizio;
    @OneToMany(mappedBy = "mezzo")
    private List<Manutenzione>      manutenzioni;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_mezzo")
    private TipoMezzo               tipoMezzo;
//    @OneToMany(mappedBy = "mezzo")
//    private List<Tratta>            tratte;
    @OneToMany(mappedBy = "mezzo")
    @Column(name = "tratte_effettuate")
    private List<TrattaEffettuata> trattaEffettuata;

    public Mezzo() {
    }

    public Mezzo(int capienza, StatoServizio statoServizio, TipoMezzo tipoMezzo) {
        this.capienza = capienza;
        this.statoServizio = statoServizio;
        this.manutenzioni = new ArrayList<>();
        this.tipoMezzo = tipoMezzo;
//        this.tratte = new ArrayList<>();
        this.trattaEffettuata = new ArrayList<>();
    }

    public int getCodiceVeicolo() {
        return codiceVeicolo;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public StatoServizio getStatoServizio() {
        return statoServizio;
    }

    public void setStatoServizio(StatoServizio statoServizio) {
        this.statoServizio = statoServizio;
    }

    public List<Manutenzione> getManutenzioni() {
        return manutenzioni;
    }

    public void setManutenzioni(Manutenzione manutenzione) {
        this.manutenzioni.add(manutenzione);
    }

    public TipoMezzo getTipoMezzo() {
        return tipoMezzo;
    }

    public void setTipoMezzo(TipoMezzo tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }

//    public List<Tratta> getTratte() {
//        return tratte;
//    }
//
//    public void setTratte(Tratta tratta) {
//        this.tratte.add(tratta);
//    }

    public List<TrattaEffettuata> getTratteEffettuate() {
        return trattaEffettuata;
    }

    public void setTratteEffettuate(TrattaEffettuata trattaEffettuata) {
        this.trattaEffettuata.add(trattaEffettuata);
    }

//    public TrattaEffettuata eseguiTratta(Tratta tratta){
//        TrattaEffettuata trattaEffettuata = new TrattaEffettuata(tratta,this,LocalDate.now(),6000);
//        return trattaEffettuata;
//    }
}