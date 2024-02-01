package it.epicode.entities.classes;

import it.epicode.dao.MezzoDAO;
import it.epicode.dao.TitoloEmessoDAO;
import it.epicode.entities.enums.StatoServizio;
import it.epicode.entities.enums.TipoMezzo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @OneToMany(mappedBy = "mezzo")
    @Column(name = "tratte_effettuate")
    private List<TratteEffettuate>  tratteEffettuate;

    public Mezzo() {
    }

    public Mezzo(int capienza, StatoServizio statoServizio, TipoMezzo tipoMezzo, Tratta tratta, MezzoDAO dao) {
        this.capienza       = capienza;
        this.statoServizio  = statoServizio;
        this.tipoMezzo      = tipoMezzo;
        this.tratta         = tratta;

        dao.create(this);
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

    public TratteEffettuate effettuaTratta(Tratta tratta, int tempoEffettivoTratta){
        if (this.statoServizio == StatoServizio.IN_SERVIZIO) {
            TratteEffettuate trattaEffettuata = new TratteEffettuate(this, tratta, LocalDateTime.now(), tempoEffettivoTratta);
            System.out.println(trattaEffettuata);
            return  trattaEffettuata;
        } else {
            System.out.println("Il Mezzo non può effettuare la tratta perchè è in manutenzione");
            return null;
        }
    }
    public void vidimaBiglietto(Biglietto biglietto, TitoloEmessoDAO titoloEmessoDAO){
        biglietto.cambiaValidita();
        titoloEmessoDAO.update(biglietto);
    }

    //TODO metodo per vidimare il biglietto


    @Override
    public String toString() {
        return "Mezzo{" +
                "codiceVeicolo=" + codiceVeicolo +
                ", capienza=" + capienza +
                ", statoServizio=" + statoServizio +
                ", tipoMezzo=" + tipoMezzo +
                ", tratteEffettuate=" + tratteEffettuate +
                '}';
    }
}