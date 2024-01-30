package it.epicode;

import it.epicode.dao.PuntoDiEmissioneDAO;
import it.epicode.dao.TitoloEmessoDAO;
import it.epicode.dao.UtenteDAO;
import it.epicode.entities.classes.Abbonamento;
import it.epicode.entities.classes.Biglietto;
import it.epicode.entities.classes.DistributoreAutomatico;
import it.epicode.entities.classes.Utente;
import it.epicode.entities.enums.Periodicita;
import it.epicode.entities.enums.StatoAttivita;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        PuntoDiEmissioneDAO  puntoDiEmissioneDAO   = new PuntoDiEmissioneDAO();
        TitoloEmessoDAO      titoloEmessoDAO       = new TitoloEmessoDAO();
        UtenteDAO            utenteDAO             = new UtenteDAO();

        DistributoreAutomatico distributoreAutomatico = new DistributoreAutomatico(StatoAttivita.ATTIVO);

        Utente utente1 = new Utente("Giorgio", "Topa", LocalDate.of(1992,8,7), "giorgiotopa7@gmail.com");
        Utente utente2 = new Utente("Davide", "Jackowski", LocalDate.of(1998, 8,13), "davidejackowski@gmail.com");
        Utente utente3 = new Utente("Emanuele", "Barone", LocalDate.of(1996, 5, 22), "barone.emanuele8@gmail.com");

        Abbonamento abbonamento = new Abbonamento(distributoreAutomatico, LocalDate.now(), Periodicita.MENSILE);

        System.out.println(abbonamento.toString());
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