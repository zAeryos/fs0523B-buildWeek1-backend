package it.epicode;

import it.epicode.dao.UtenteDAO;
import it.epicode.entities.classes.Utente;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        UtenteDAO utenteDAO = new UtenteDAO();

        Utente utente1 = new Utente("Giorgio", "Topa", LocalDate.of(1992,8,7), "giorgiotopa7@gmail.com");
        Utente utente2 = new Utente("Davide", "Jackowski", LocalDate.of(1998, 8,13), "davidejackowski@gmail.com");

        utenteDAO.create(utente2);
        utenteDAO.create(utente1, utente2);

    }
}