package it.epicode;

import it.epicode.dao.*;
import it.epicode.entities.classes.*;
import it.epicode.entities.enums.Periodicita;
import it.epicode.entities.enums.StatoAttivita;
import it.epicode.entities.enums.StatoServizio;
import it.epicode.entities.enums.TipoMezzo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        PuntoDiEmissioneDAO  puntoDiEmissioneDAO   = new PuntoDiEmissioneDAO();
        TitoloEmessoDAO      titoloEmessoDAO       = new TitoloEmessoDAO();
        UtenteDAO            utenteDAO             = new UtenteDAO();
        MezzoDAO             mezzoDAO              = new MezzoDAO();
        TrattaDAO            trattaDAO             = new TrattaDAO();
        ManutenzioneDAO      manutenzioneDAO       = new ManutenzioneDAO();
        TesseraDAO           tesseraDAO            = new TesseraDAO();
        TratteEffettuateDAO  tratteEffettuateDAO   = new TratteEffettuateDAO();

        DistributoreAutomatico distributoreAutomatico = new DistributoreAutomatico(StatoAttivita.ATTIVO);

        Utente utente1 = new Utente("Giorgio", "Topa", LocalDate.of(1992,8,7), "giorgiotopa7@gmail.com");
        Utente utente2 = new Utente("Davide", "Jackowski", LocalDate.of(1998, 8,13), "davidejackowski@gmail.com");
        Utente utente3 = new Utente("Emanuele", "Barone", LocalDate.of(1996, 5, 22), "barone.emanuele8@gmail.com");

        Abbonamento abbonamento = new Abbonamento(distributoreAutomatico, LocalDate.now(), Periodicita.ANNUALE);


        Mezzo mezzo = new Mezzo(50, StatoServizio.IN_SERVIZIO, TipoMezzo.AUTOBUS);


        Tratta tratta = new Tratta("Parigi","Roma",5000);
        TrattaEffettuata trattaEffettuata = new TrattaEffettuata(mezzoDAO.getById(1),LocalDate.now(),6000);

//       TrattaEffettuata trattaEffettuata = mezzo.eseguiTratta(tratta);






        Manutenzione manutenzione = new Manutenzione(LocalDate.now(), mezzoDAO.getById(1));

        Tessera tessera = new Tessera(utenteDAO.getById(1));



//        tesseraDAO.create(tessera);
//        manutenzioneDAO.create(manutenzione);
//        mezzoDAO.create(mezzo);
        trattaDAO.create(tratta);
//        tratteEffettuateDAO.create(trattaEffettuata);




//        puntoDiEmissioneDAO.create(distributoreAutomatico);
//        titoloEmessoDAO.create(abbonamento);









//
//        Biglietto biglietto = new Biglietto(distributoreAutomatico, LocalDate.now());
//
//        distributoreAutomatico.setTitoliEmessi(biglietto);
//
//        puntoDiEmissioneDAO.create(distributoreAutomatico);
//        titoloEmessoDAO.create(biglietto);
//
//        System.out.println(distributoreAutomatico.getTitoliEmessi());

    }
}