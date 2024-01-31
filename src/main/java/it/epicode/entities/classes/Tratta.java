package it.epicode.entities.classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tratta")
public class Tratta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;
    @Column(name = "zona_di_partenza", nullable = false)
    private String  zonaDiPartenza;
    @Column(nullable = false)
    private String  capolinea;
    @Column(name = "tempo_medio_percorrenza")
    private int     tempoMedioPercorrenza;
    @OneToMany(mappedBy = "tratta")
    private List<Mezzo> mezzi;
    @OneToMany(mappedBy = "tratta")
    private List<TratteEffettuate> tratteEffettuate;

    public Tratta() {
    }

    public Tratta(String zonaDiPartenza, String capolinea) {
        this.zonaDiPartenza = zonaDiPartenza;
        this.capolinea = capolinea;
    }

    public Tratta(String zonaDiPartenza, String capolinea, int tempoMedioPercorrenza) {
        this.zonaDiPartenza = zonaDiPartenza;
        this.capolinea = capolinea;
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
    }

    public int getId() {
        return id;
    }

    public String getZonaDiPartenza() {
        return zonaDiPartenza;
    }

    public void setZonaDiPartenza(String zonaDiPartenza) {
        this.zonaDiPartenza = zonaDiPartenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public int getTempoMedioPercorrenza() {
        return tempoMedioPercorrenza;
    }

    public void setTempoMedioPercorrenza(int tempoMedioPercorrenza) {
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
    }
}
