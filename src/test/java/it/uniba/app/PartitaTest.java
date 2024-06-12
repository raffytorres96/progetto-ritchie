package it.uniba.app;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PartitaTest {

private String regola = "classica";
private Tavoliere tavoliere = new Tavoliere();
private Tavoliere tavoliereExpected = new Tavoliere();
private String nomeGiocatore1 = "Andre";
private String nomeGiocatore2 = "Riccardo";

    @Test
    void testComandoQualiMosse() throws UnsupportedEncodingException {
        // Prepara l'input simulato
        String input = "/qualimosse\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8"))));

tavoliere.inizializzaTavolierePartita(tavoliere);
tavoliereExpected.inizializzaTavolierePartita(tavoliereExpected);
        // Prepara l'output simulato
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        // Prepara l'oggetto da testare
Partita partita = new Partita(regola, tavoliere, nomeGiocatore1, nomeGiocatore2);
Partita partitaExpected = new Partita(regola, tavoliereExpected, nomeGiocatore1, nomeGiocatore2);
Mossa mossa = new Mossa(tavoliere, partita.getGiocatoreCorrente());
Mossa mossaExpected = new Mossa(tavoliereExpected, partitaExpected.getGiocatoreCorrente());
mossaExpected.qualiMosse(partitaExpected.getGiocatoreCorrente());

        // Esegui il metodo da testare
        partita.setTest(true);
        partita.controlloPartita(mossa);

        Cella[][] actualTavoliere = tavoliere.getTavoliere();
        Cella[][] expectedTavoliere = tavoliereExpected.getTavoliere();
        for (int i = 0; i < expectedTavoliere.length; i++) {
            for (int j = 0; j < expectedTavoliere[i].length; j++) {
                assertEquals(Cella.getStato(expectedTavoliere[i][j]), Cella.getStato(actualTavoliere[i][j]),
                "il comando /qualimosse è stato eseguito correttamente");
            }
        }

    }
    @Test
    void testControlloPartitaGenera() throws UnsupportedEncodingException {
        // Prepara l'input simulato
        String input = "a1-b1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8"))));

tavoliere.inizializzaTavolierePartita(tavoliere);
tavoliereExpected.inizializzaTavolierePartita(tavoliereExpected);
tavoliereExpected.setTavoliere(0, 1, 1);
        // Prepara l'output simulato
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        // Prepara l'oggetto da testare
Partita partita = new Partita(regola, tavoliere, nomeGiocatore1, nomeGiocatore2);
Mossa mossa = new Mossa(tavoliere, partita.getGiocatoreCorrente());



        // Esegui il metodo da testare
        partita.setTest(true);
        partita.controlloPartita(mossa);

        Cella[][] actualTavoliere = tavoliere.getTavoliere();
        Cella[][] expectedTavoliere = tavoliereExpected.getTavoliere();
        for (int i = 0; i < expectedTavoliere.length; i++) {
            for (int j = 0; j < expectedTavoliere[i].length; j++) {
                assertEquals(Cella.getStato(expectedTavoliere[i][j]), Cella.getStato(actualTavoliere[i][j]),
                " la pedina è stata generata correttamente");
            }
        }

    }

    @Test
    void testControlloPartitaSpostamento() throws UnsupportedEncodingException {
        // Prepara l'input simulato
        String input = "a1-c1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8"))));

tavoliere.inizializzaTavolierePartita(tavoliere);
tavoliereExpected.inizializzaTavolierePartita(tavoliereExpected);
tavoliereExpected.setTavoliere(0, 2, 1);
tavoliereExpected.setTavoliere(0, 0, 0);

        // Prepara l'output simulato
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        // Prepara l'oggetto da testare
Partita partita = new Partita(regola, tavoliere, nomeGiocatore1, nomeGiocatore2);
Mossa mossa = new Mossa(tavoliere, partita.getGiocatoreCorrente());



        // Esegui il metodo da testare
        partita.setTest(true);
        partita.controlloPartita(mossa);

        Cella[][] actualTavoliere = tavoliere.getTavoliere();
        Cella[][] expectedTavoliere = tavoliereExpected.getTavoliere();
        for (int i = 0; i < expectedTavoliere.length; i++) {
            for (int j = 0; j < expectedTavoliere[i].length; j++) {
                assertEquals(Cella.getStato(expectedTavoliere[i][j]), Cella.getStato(actualTavoliere[i][j]),
                " la pedina si è spostata correttamente");
            }
        }

    }

    @Test
    void testCoordinateInesatte()throws UnsupportedEncodingException {
        // Prepara l'input simulato
        String input = "z1-w1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8"))));

tavoliere.inizializzaTavolierePartita(tavoliere);
tavoliereExpected.inizializzaTavolierePartita(tavoliereExpected);


        // Prepara l'output simulato
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        // Prepara l'oggetto da testare
Partita partita = new Partita(regola, tavoliere, nomeGiocatore1, nomeGiocatore2);
Mossa mossa = new Mossa(tavoliere, partita.getGiocatoreCorrente());



        // Esegui il metodo da testare
        partita.setTest(true);
        partita.controlloPartita(mossa);

        Cella[][] actualTavoliere = tavoliere.getTavoliere();
        Cella[][] expectedTavoliere = tavoliereExpected.getTavoliere();
        for (int i = 0; i < expectedTavoliere.length; i++) {
            for (int j = 0; j < expectedTavoliere[i].length; j++) {
                assertEquals(Cella.getStato(expectedTavoliere[i][j]), Cella.getStato(actualTavoliere[i][j]),
                "Errore: le coordinate inserite sono inesatte");
            }
        }

    }

    @Test
    void testPedinaInizialeErrata()throws UnsupportedEncodingException {
        // Prepara l'input simulato
        String input = "g1-f1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8"))));

tavoliere.inizializzaTavolierePartita(tavoliere);
tavoliereExpected.inizializzaTavolierePartita(tavoliereExpected);


        // Prepara l'output simulato
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        // Prepara l'oggetto da testare
Partita partita = new Partita(regola, tavoliere, nomeGiocatore1, nomeGiocatore2);
Mossa mossa = new Mossa(tavoliere, partita.getGiocatoreCorrente());



        // Esegui il metodo da testare
        partita.setTest(true);
        partita.controlloPartita(mossa);

        Cella[][] actualTavoliere = tavoliere.getTavoliere();
        Cella[][] expectedTavoliere = tavoliereExpected.getTavoliere();
        for (int i = 0; i < expectedTavoliere.length; i++) {
            for (int j = 0; j < expectedTavoliere[i].length; j++) {
                assertEquals(Cella.getStato(expectedTavoliere[i][j]), Cella.getStato(actualTavoliere[i][j]),
                "Errore: la pedina iniziale è errata");
            }
        }

    }

    @Test
    void testDistanzaEccessiva() throws UnsupportedEncodingException {
        // Prepara l'input simulato
        String input = "a1-d1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8"))));

tavoliere.inizializzaTavolierePartita(tavoliere);
tavoliereExpected.inizializzaTavolierePartita(tavoliereExpected);


        // Prepara l'output simulato
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        // Prepara l'oggetto da testare
Partita partita = new Partita(regola, tavoliere, nomeGiocatore1, nomeGiocatore2);
Mossa mossa = new Mossa(tavoliere, partita.getGiocatoreCorrente());



        // Esegui il metodo da testare
        partita.setTest(true);
        partita.controlloPartita(mossa);

        Cella[][] actualTavoliere = tavoliere.getTavoliere();
        Cella[][] expectedTavoliere = tavoliereExpected.getTavoliere();
        for (int i = 0; i < expectedTavoliere.length; i++) {
            for (int j = 0; j < expectedTavoliere[i].length; j++) {
                assertEquals(Cella.getStato(expectedTavoliere[i][j]), Cella.getStato(actualTavoliere[i][j]),
                "Errore: la distanza tra le celle è eccessiva");
            }
        }
    }

    @Test
    void testSelezionaCellaVuota()throws UnsupportedEncodingException {
        // Prepara l'input simulato
        String input = "a2-b1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8"))));

tavoliere.inizializzaTavolierePartita(tavoliere);
tavoliereExpected.inizializzaTavolierePartita(tavoliereExpected);


        // Prepara l'output simulato
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        // Prepara l'oggetto da testare
Partita partita = new Partita(regola, tavoliere, nomeGiocatore1, nomeGiocatore2);
Mossa mossa = new Mossa(tavoliere, partita.getGiocatoreCorrente());



        // Esegui il metodo da testare
        partita.setTest(true);
        partita.controlloPartita(mossa);

        Cella[][] actualTavoliere = tavoliere.getTavoliere();
        Cella[][] expectedTavoliere = tavoliereExpected.getTavoliere();
        for (int i = 0; i < expectedTavoliere.length; i++) {
            for (int j = 0; j < expectedTavoliere[i].length; j++) {
                assertEquals(Cella.getStato(expectedTavoliere[i][j]), Cella.getStato(actualTavoliere[i][j]),
                "Errore: la cella selezionata è vuota");
            }
        }
    }




    @Test
    void testComandoNonUsabileInPartita() throws UnsupportedEncodingException {
        // Prepara l'input simulato
        String input = "/\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8"))));

tavoliere.inizializzaTavolierePartita(tavoliere);
tavoliereExpected.inizializzaTavolierePartita(tavoliereExpected);


        // Prepara l'output simulato
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        // Prepara l'oggetto da testare
Partita partita = new Partita(regola, tavoliere, nomeGiocatore1, nomeGiocatore2);
Mossa mossa = new Mossa(tavoliere, partita.getGiocatoreCorrente());



        // Esegui il metodo da testare
        partita.setTest(true);
        partita.controlloPartita(mossa);

        assertEquals(GestoreStampa.ANSI_RED + "\nERRORE: " + GestoreStampa.ANSI_RESET
        + "coordinate non inserite correttamente.\n\tIl formato è -> " + GestoreStampa.ANSI_GREEN + "XI"
        + GestoreStampa.ANSI_RESET + "-" + GestoreStampa.ANSI_ORANGE + "YJ\n" + GestoreStampa.ANSI_RESET
        + "\tX,Y = lettere da A a G (colonne) | I,J = numeri da 1 a 7 (righe).\n\t"
        + GestoreStampa.ANSI_GREEN + "XI " + GestoreStampa.ANSI_RESET + "= cella di partenza; "
        + GestoreStampa.ANSI_ORANGE + "YJ " + GestoreStampa.ANSI_RESET + "= cella di arrivo.\n\n"
        + "Comando non utilizzabile in partita\n\n", outContent.toString("UTF-8"),
        "Comando non valido in partita\n\n");
            }

            @Test
            void testComandoVuotoInPartita() throws UnsupportedEncodingException {
                // Prepara l'input simulato
                String input = "/vuoto\n";
                System.setIn(new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8"))));

        tavoliere.inizializzaTavolierePartita(tavoliere);
        tavoliereExpected.inizializzaTavolierePartita(tavoliereExpected);


                // Prepara l'output simulato
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outContent, true, "UTF-8"));

                // Prepara l'oggetto da testare
        Partita partita = new Partita(regola, tavoliere, nomeGiocatore1, nomeGiocatore2);
        Mossa mossa = new Mossa(tavoliere, partita.getGiocatoreCorrente());

                // Esegui il metodo da testare
                partita.setTest(true);
                partita.controlloPartita(mossa);

                assertEquals(GestoreStampa.ANSI_RED + "\nERRORE: " + GestoreStampa.ANSI_RESET
                + "coordinate non inserite correttamente.\n\tIl formato è -> " + GestoreStampa.ANSI_GREEN + "XI"
                + GestoreStampa.ANSI_RESET + "-" + GestoreStampa.ANSI_ORANGE + "YJ\n" + GestoreStampa.ANSI_RESET
                + "\tX,Y = lettere da A a G (colonne) | I,J = numeri da 1 a 7 (righe).\n\t"
                + GestoreStampa.ANSI_GREEN + "XI " + GestoreStampa.ANSI_RESET + "= cella di partenza; "
                + GestoreStampa.ANSI_ORANGE + "YJ " + GestoreStampa.ANSI_RESET + "= cella di arrivo.\n\n"
                + "Comando non utilizzabile in partita\n\n", outContent.toString("UTF-8"),
                "Comando non valido in partita\n\n");
                    }



                    @Test
                    void testComandoBloccaInPartita() throws UnsupportedEncodingException {
                        // Prepara l'input simulato
                        String input = "/blocca\n";
                        System.setIn(new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8"))));
                tavoliere.inizializzaTavolierePartita(tavoliere);
                tavoliereExpected.inizializzaTavolierePartita(tavoliereExpected);


                        // Prepara l'output simulato
                        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                        System.setOut(new PrintStream(outContent, true, "UTF-8"));

                        // Prepara l'oggetto da testare
                Partita partita = new Partita(regola, tavoliere, nomeGiocatore1, nomeGiocatore2);
                Mossa mossa = new Mossa(tavoliere, partita.getGiocatoreCorrente());

                        // Esegui il metodo da testare
                        partita.setTest(true);
                        partita.controlloPartita(mossa);

                        assertEquals(GestoreStampa.ANSI_RED + "\nERRORE: " + GestoreStampa.ANSI_RESET
                        + "coordinate non inserite correttamente.\n\tIl formato è -> " + GestoreStampa.ANSI_GREEN + "XI"
                        + GestoreStampa.ANSI_RESET + "-" + GestoreStampa.ANSI_ORANGE + "YJ\n" + GestoreStampa.ANSI_RESET
                        + "\tX,Y = lettere da A a G (colonne) | I,J = numeri da 1 a 7 (righe).\n\t"
                        + GestoreStampa.ANSI_GREEN + "XI " + GestoreStampa.ANSI_RESET + "= cella di partenza; "
                        + GestoreStampa.ANSI_ORANGE + "YJ " + GestoreStampa.ANSI_RESET + "= cella di arrivo.\n\n"
                        + "Comando non utilizzabile in partita\n\n", outContent.toString("UTF-8"),
                        "Comando non valido in partita\n\n");
                            }







}
