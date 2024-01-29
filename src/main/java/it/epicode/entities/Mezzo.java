package it.epicode.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mezzo")
public class Mezzo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codiceVeicolo;
    private int capienza;
    @Enumerated(EnumType.STRING)
    private StatoServizio statoServizio;
    private List<Manutenzione> manutenzioni;
    @Enumerated(EnumType.STRING)
    private TipoMezzo tipoMezzo;
    private Tratta tratta;
    @Column(name = "tratte_effettuate")
    private List<TratteEffettuate> tratteEffettuate;

}
