package it.epicode;

import it.epicode.dao.*;
import it.epicode.entities.classes.*;
import it.epicode.entities.classes.superclasses.TitoloEmesso;
import it.epicode.entities.enums.Periodicita;
import it.epicode.entities.enums.StatoAttivita;
import it.epicode.entities.enums.StatoServizio;
import it.epicode.entities.enums.TipoMezzo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

                                                    /* ------ DAO ------ */

        PuntoDiEmissioneDAO     puntoDiEmissioneDAO     = new PuntoDiEmissioneDAO();
        TitoloEmessoDAO         titoloEmessoDAO         = new TitoloEmessoDAO();
        UtenteDAO               utenteDAO               = new UtenteDAO();
        TesseraDAO              tesseraDAO              = new TesseraDAO();
        MezzoDAO                mezzoDAO                = new MezzoDAO();
        TrattaDAO               trattaDAO               = new TrattaDAO();
        TratteEffettuateDAO     tratteEffettuateDAO     = new TratteEffettuateDAO();
        ManutenzioneDAO         manutenzioneDAO         = new ManutenzioneDAO();


                                                    /* --- Rivenditori --- */

        DistributoreAutomatico  distributoreAutomatico  = new DistributoreAutomatico(StatoAttivita.ATTIVO, puntoDiEmissioneDAO);
        RivenditoreAutorizzato  rivenditoreAutorizzato  = new RivenditoreAutorizzato(StatoAttivita.APERTO,"Rivenditore2000", "Napoli", puntoDiEmissioneDAO);

                                                      /* --- Utenti --- */

        Utente                  utente1                 = new Utente("Giorgio", "Topa", LocalDate.of(1992,8,7), "giorgiotopa7@gmail.com");
        Utente                  utente2                 = new Utente("Davide", "Jackowski", LocalDate.of(1998, 8,13), "davidejackowski@gmail.com");
        Utente                  utente3                 = new Utente("Emanuele", "Barone", LocalDate.of(1996, 5, 22), "barone.emanuele8@gmail.com");
        Biglietto               biglietto1              = new Biglietto(distributoreAutomatico, titoloEmessoDAO);
        Biglietto               biglietto2              = new Biglietto(rivenditoreAutorizzato, titoloEmessoDAO);
        Biglietto               biglietto3              = new Biglietto(rivenditoreAutorizzato, titoloEmessoDAO);

        Tessera                 tessera                 = new Tessera(utente1, tesseraDAO);
        Tessera                 tessera2                = new Tessera(utente3, tesseraDAO);
        Abbonamento             abbonamento             = new Abbonamento(distributoreAutomatico, Periodicita.MENSILE, tessera, titoloEmessoDAO);
        Tratta                  tratta                  = new Tratta("Roma", "Milano", 220);
        Mezzo                   mezzo                   = new Mezzo(40, StatoServizio.IN_SERVIZIO, TipoMezzo.AUTOBUS, tratta, mezzoDAO);
        TratteEffettuate        tratteEffettuate        = new TratteEffettuate(mezzoDAO.getById(3902), tratta, LocalDateTime.now());
        Manutenzione            manutenzione            = new Manutenzione(LocalDate.now(), mezzo, manutenzioneDAO, mezzoDAO);

        Biglietto               bigliettoTest           = distributoreAutomatico.emettiBiglietto();
        Abbonamento             abbonamentoTest         = distributoreAutomatico.emettiAbbonamento(Periodicita.MENSILE, tessera2, titoloEmessoDAO);
        Tessera                 tesseraTest             = distributoreAutomatico.emettiTessera(utente2, tesseraDAO);

        manutenzione.setDataFine(manutenzioneDAO, mezzoDAO);
        mezzo.vidimaBiglietto(biglietto1, titoloEmessoDAO);
        mezzo.vidimaBiglietto(biglietto3, titoloEmessoDAO);
        titoloEmessoDAO.bigliettiVidimatiPerTempo(LocalDateTime.of(2024,01,01,0,0), LocalDateTime.of(2024, 02,02,0,0));
        System.out.println(titoloEmessoDAO.bigliettiVidimatiPerMezzo(mezzo));
        System.out.println(mezzoDAO.contatoreTratteEffettuate(mezzoDAO.getById(3902)));
        System.out.println(tratteEffettuateDAO.getTempoEffettivoTratta(4052));




    }
}