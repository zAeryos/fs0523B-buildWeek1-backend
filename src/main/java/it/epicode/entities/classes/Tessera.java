package it.epicode.entities.classes;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "tessera")
public class Tessera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int             id;
    @OneToOne
    @Column(nullable = false)
    private Utente          utente;
    @Column(name = "data_emissione", nullable = false)
    private LocalDate       dataEmissione;
    @Column(nullable = false)
    private LocalDate       scadenza;
    @OneToOne(mappedBy = "abbonamento_fk")
    private Abbonamento     abbonamento;

    public Tessera() {
    }

    public Tessera(Utente utente, LocalDate dataEmissione, LocalDate scadenza) {
        this.utente = utente;
        this.dataEmissione = dataEmissione;
        this.scadenza = scadenza;
    }

    public int getId() {
        return id;
    }
    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }
}
