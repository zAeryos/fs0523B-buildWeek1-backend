package it.epicode.entities.classes;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "tessera")
public class Tessera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int             id;
    @OneToOne(mappedBy = "tessera")
    private Utente          utente;
    @Column(name = "data_emissione", nullable = false)
    private LocalDate       dataEmissione;
    @Column(nullable = false)
    private LocalDate       scadenza;
    @OneToOne
    @JoinColumn(name = "abbonamento_fk")
    private Abbonamento     abbonamento;

    public Tessera() {
    }

    public Tessera(Utente utente) {
        this.utente = utente;
        this.dataEmissione = LocalDate.now();
        this.scadenza = this.dataEmissione.plusDays(365);
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

    public void rinnovaTessera() {
        LocalDate nuovaDataScadenza = LocalDate.now();
        this.scadenza = this.scadenza.plusDays(365);
    }
}
