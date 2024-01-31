package it.epicode;

import it.epicode.dao.*;
import it.epicode.entities.classes.*;
import it.epicode.entities.enums.Periodicita;
import it.epicode.entities.enums.StatoAttivita;
import it.epicode.entities.enums.StatoServizio;
import it.epicode.entities.enums.TipoMezzo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        PuntoDiEmissioneDAO  puntoDiEmissioneDAO    = new PuntoDiEmissioneDAO();
        TitoloEmessoDAO      titoloEmessoDAO        = new TitoloEmessoDAO();
        UtenteDAO            utenteDAO              = new UtenteDAO();
        TesseraDAO           tesseraDAO             = new TesseraDAO();

        DistributoreAutomatico distributoreAutomatico = new DistributoreAutomatico(StatoAttivita.ATTIVO);
        RivenditoreAutorizzato rivenditoreAutorizzato = new RivenditoreAutorizzato("Rivenditore2000", "Napoli");

        Utente          utente1         = new Utente("Giorgio", "Topa", LocalDate.of(1992,8,7), "giorgiotopa7@gmail.com");
        Utente          utente2         = new Utente("Davide", "Jackowski", LocalDate.of(1998, 8,13), "davidejackowski@gmail.com");
        Utente          utente3         = new Utente("Emanuele", "Barone", LocalDate.of(1996, 5, 22), "barone.emanuele8@gmail.com");
        Biglietto       biglietto1      = new Biglietto(distributoreAutomatico, LocalDate.now());
        Biglietto       biglietto2      = new Biglietto(rivenditoreAutorizzato, LocalDate.now());
        Tessera         tessera         = new Tessera(utente1);
        Abbonamento     abbonamento     = new Abbonamento(distributoreAutomatico, LocalDate.now(), Periodicita.MENSILE, tessera);


//        utenteDAO.create(utente1);
//        tesseraDAO.create(tessera);
//
//        puntoDiEmissioneDAO.create(rivenditoreAutorizzato);
//        titoloEmessoDAO.create(biglietto2);
//        titoloEmessoDAO.create(abbonamento);




        /* MEZZI - TRATTE */

        MezzoDAO mezzoDAO = new MezzoDAO();
        TrattaDAO trattaDAO = new TrattaDAO();
        TratteEffettuateDAO tratteEffettuateDAO = new TratteEffettuateDAO();
        ManutenzioneDAO manutenzioneDAO = new ManutenzioneDAO();

        Tratta tratta = new Tratta("Roma", "Milano", 220);
        Mezzo mezzo = new Mezzo(40, StatoServizio.IN_SERVIZIO, TipoMezzo.AUTOBUS, tratta);
        TratteEffettuate tratteEffettuate = new TratteEffettuate(mezzo, tratta, LocalDateTime.now(), 235 );
        Manutenzione manutenzione = new Manutenzione(LocalDate.now(), mezzo);

        trattaDAO.create(tratta);
        Mezzo mezzoCreato = mezzoDAO.create(mezzo);

        System.out.println(mezzoCreato);

        mezzo.setCapienza(64);
        mezzo.setStatoServizio(StatoServizio.IN_MANUTENZIONE);

        System.out.println(mezzoCreato);

        mezzoDAO.update(mezzoCreato);

//        manutenzioneDAO.create(manutenzione);

//        tratteEffettuateDAO.create(tratteEffettuate);

    }
}