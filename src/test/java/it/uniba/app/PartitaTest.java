package it.uniba.app;

//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
import java.io.PrintStream;
//import java.io.UnsupportedEncodingException;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
//mport static org.junit.jupiter.api.Assertions.assertTrue;
class PartitaTest {

private String regola = "classica";
private Tavoliere tavoliere = new Tavoliere();
private Tavoliere tavoliereExpected = new Tavoliere();
private String nomeGiocatore1 = "Andre";
private String nomeGiocatore2 = "Riccardo";

    @Test
    void testControlloPartita() {
        // Prepara l'input simulato
        String input = "/qualimosse\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

tavoliere.inizializzaTavolierePartita(tavoliere);
tavoliereExpected.inizializzaTavolierePartita(tavoliereExpected);
        // Prepara l'output simulato
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Prepara l'oggetto da testare
Partita partita = new Partita(regola, tavoliere, nomeGiocatore1, nomeGiocatore2);
Partita partitaExpected = new Partita(regola, tavoliereExpected, nomeGiocatore1, nomeGiocatore2);
Mossa mossa = new Mossa(tavoliere, partita.getGiocatoreCorrente());
Mossa mossaExpected = new Mossa(tavoliereExpected, partitaExpected.getGiocatoreCorrente());
mossaExpected.qualiMosse(partitaExpected.getGiocatoreCorrente());

        // Esegui il metodo da testare
        partita.controlloPartita(mossa);

        Cella[][] actualTavoliere = tavoliere.getTavoliere();
        Cella[][] expectedTavoliere = tavoliereExpected.getTavoliere();
        for (int i = 0; i < expectedTavoliere.length; i++) {
            for (int j = 0; j < expectedTavoliere[i].length; j++) {
                assertEquals(expectedTavoliere[i][j], actualTavoliere[i][j]);
            }
        }

    }
}
