package it.epicode.entities.classes;

import it.epicode.dao.TesseraDAO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tessera")
public class Tessera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int             id;
    @OneToOne
    @JoinColumn(name = "utente_fk")
    private Utente          utente;
    @Column(name = "data_emissione", nullable = false)
    private LocalDateTime   dataEmissione;
    @Column(nullable = false)
    private LocalDateTime   scadenza;
    @OneToOne(mappedBy = "tessera")
    private Abbonamento     abbonamento;

    public Tessera() {
    }

    public Tessera(Utente utente, TesseraDAO dao) {
        this.utente         = utente;
        this.dataEmissione  = LocalDateTime.now();
        this.scadenza       = this.dataEmissione.plusDays(365);

        dao.create(this);
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

    public LocalDateTime getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDateTime dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public LocalDateTime getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDateTime scadenza) {
        this.scadenza = scadenza;
    }

    public Abbonamento getAbbonamento() {
        return abbonamento;
    }

    public void setAbbonamento(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    public void rinnovaTessera() {
        this.scadenza = LocalDateTime.now();
        this.scadenza = this.scadenza.plusDays(365);

    }


    @Override
    public String toString() {
        return "Tessera{"           +
                "dataEmissione="    + dataEmissione +
                ", scadenza="       + scadenza      +
                ", abbonamento="    + abbonamento   +
                '}';
    }
}
