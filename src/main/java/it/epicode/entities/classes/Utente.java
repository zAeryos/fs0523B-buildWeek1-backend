package it.epicode.entities.classes;

import it.epicode.dao.UtenteDAO;
import it.epicode.entities.enums.Sesso;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int         id;
    @Column(nullable = false, length = 30)
    private String      nome;
    @Column(nullable = false, length = 30)
    private String      cognome;
    @Column(name = "data_di_nascita", nullable = false)
    private LocalDate   dataDiNascita;
    @Enumerated(EnumType.STRING)
    private Sesso       sesso;
    private String      indirizzo;
    @Column(name = "numero_telefono")
    private int         numeroTelefono;
    @Column(nullable = false)
    private String      email;
    @OneToOne(mappedBy = "utente")
    private Tessera     tessera;

    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita, String email) {
        this.nome           = nome;
        this.cognome        = cognome;
        this.dataDiNascita  = dataDiNascita;
        this.email          = email;

        UtenteDAO dao       = new UtenteDAO();
        dao.create(this);
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    @Override
    public String toString() {
        return "Utente{"            +
                "id="               + id +
                ", nome='"          + nome + '\'' +
                ", cognome='"       + cognome + '\'' +
                ", dataDiNascita="  + dataDiNascita +
                ", sesso="          + sesso +
                ", indirizzo='"     + indirizzo + '\'' +
                ", numeroTelefono=" + numeroTelefono +
                ", email='"         + email + '\'' +
//                ", tessera=" + tessera +
                '}';
    }
}
