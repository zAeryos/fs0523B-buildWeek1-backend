package it.epicode.entities.classes;

import it.epicode.entities.enums.StatoServizio;
import it.epicode.entities.enums.TipoMezzo;
import jakarta.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "tratta_fk")
    private Tratta                  tratta;
    @ManyToMany(mappedBy = "mezzo")
    @Column(name = "tratte_effettuate")
    private List<TratteEffettuate>  tratteEffettuate;

    public Mezzo() {
    }

    public Mezzo(int capienza, StatoServizio statoServizio, TipoMezzo tipoMezzo, Tratta tratta) {
        this.capienza = capienza;
        this.statoServizio = statoServizio;
        this.tipoMezzo = tipoMezzo;
        this.tratta = tratta;
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

    public void setManutenzioni(List<Manutenzione> manutenzioni) {
        this.manutenzioni = manutenzioni;
    }

    public TipoMezzo getTipoMezzo() {
        return tipoMezzo;
    }

    public void setTipoMezzo(TipoMezzo tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public List<TratteEffettuate> getTratteEffettuate() {
        return tratteEffettuate;
    }

    public void setTratteEffettuate(List<TratteEffettuate> tratteEffettuate) {
        this.tratteEffettuate = tratteEffettuate;
    }
}