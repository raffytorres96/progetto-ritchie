package it.uniba.app;



import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Main test class of the application.
 */
class AppTest {

    @Test
    @DisplayName("il test che segue vuole verificare la corretteza del comportamento"
            + "del metodo main all'atto dell'inserimento del comando /gioca")
void testInserimantoComandoGioca() throws IOException {

    InputStream originalIn = System.in;
    PrintStream originalOut = System.out;
    try {
          // Imposta l'input
        String input = "/gioca\n";
        System.setIn(new ByteArrayInputStream(input.getBytes("UTF-8")));

 // Imposta l'output
 ByteArrayOutputStream output = new ByteArrayOutputStream();
 System.setOut(new PrintStream(output));

 // Esegui il metodo main
 App.main(new String[]{});


        assertEquals(GestoreStampa.ANSI_BLUE + "Benvenuti in ATAXX: "
        + GestoreStampa.ANSI_RESET + " Inserisci i dati per iniziare la partita.\n\n"
        + GestoreStampa.ANSI_RESET
        + "Inserisci la regola di gioco (Classica, Thomas, Assimilation, Variante a Perdere): ",
        output.toString("UTF-8"));
    } finally {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}
    /*
     *
     * @throws UnsupportedEncodingException
    *
     *
     */
    @Disabled
    @Test
    @DisplayName("il test che segue vuole verificare la corretteza del comportamento"
    + "del metodo main all'atto dell'inserimento del comando /help")

    void testInserimantoComandoHelp() throws UnsupportedEncodingException {

        String input = "/help";
        //InputStream in = new ByteArrayInputStream(input.getBytes("UTF-8"));
        //System.setIn(in);
        // Reindirizza l'output della console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.main(new String[]{input});

        // Verifica che l'output contenga ciò che ti aspetti
        assertTrue(outContent.toString().contains(GestoreStampa.ANSI_BLUE + "\nBENVENUTI IN ATAXX\n\n"
                + GestoreStampa.ANSI_RESET + "Ataxx è un gioco di strategia in cui due giocatori"
                + "si sfidano su una griglia di 7x7 caselle.\n"
                + "L\'obiettivo è che un giocatore abbia la maggioranza delle pedine sulla scacchiera"
                + "alla fine della partita\n"
                + "convertendo il maggior numero possibile di pedine dell\'avversario.\n\n"
                + GestoreStampa.ANSI_BLUE + "REGOLE DEL GIOCO\n\n"
                + GestoreStampa.ANSI_GREEN + "1 PEDINE E INIZIO\n"
                + GestoreStampa.ANSI_RESET
                + "- Ogni giocatore, inizialmente, ha due pedine in due angoli opposti della scacchiera.\n"
                + GestoreStampa.ANSI_RESET
                + "- Le quattro pedine iniziali sono posizionate agli angoli della scacchiera\n"
                + GestoreStampa.ANSI_RESET + "  con il rosso nell\'angolo in alto a sinistra e in basso a destra\n"
                + GestoreStampa.ANSI_RESET + "  e il blu negli altri due angoli.\n\n"
                + GestoreStampa.ANSI_GREEN + "2 TURNI E MOSSE\n"
                + GestoreStampa.ANSI_RESET + "- Il rosso muove per primo.\n"
                + GestoreStampa.ANSI_RESET
                + "- Durante il primo turno i giocatori possono spostare in una o due caselle\n"
                + GestoreStampa.ANSI_RESET + "  in qualsiasi direzione.\n"
                + GestoreStampa.ANSI_RESET + "- Le distanze diagonali sono sono equivalenti a quelle ortogonali.\n"
                + GestoreStampa.ANSI_RESET
                + "  Quindi è possibile spostarsi su una casella che si trova a due caselle di distanza\n"
                + GestoreStampa.ANSI_RESET + "  sia verticalmente sia orizzontalmente e in obliquo.\n"
                + GestoreStampa.ANSI_RESET + "- Se la destinazione è adiacente alla casella di partenza\n"
                + GestoreStampa.ANSI_RESET + "  viene creat una nuova pedina di quel colore.\n\n"
                + GestoreStampa.ANSI_GREEN + "3 CONVERSIONE DELLE PEDINE\n"
                + GestoreStampa.ANSI_RESET
                + "- Dopo ogni mossa, tutte le pedine dell\'avversario adiacenti alla casella di\n"
                + GestoreStampa.ANSI_RESET
                + "  destinazione vengono convertite nel colore del giocatore che ha mosso.\n"
                + GestoreStampa.ANSI_RESET
                + "- I giocatori devono muovere a meno che non ci siano mosse legali possibili,\n"
                + GestoreStampa.ANSI_RESET + "  in tal caso devono passare.\n\n"
                + GestoreStampa.ANSI_GREEN + "4 FINE GIOCO\n"
                + GestoreStampa.ANSI_RESET
                + "- La partita termina quando tutte le caselle sono state riempite o quando uno dei\n"
                + GestoreStampa.ANSI_RESET + "  giocatori non ha più pedine.\n"
                + GestoreStampa.ANSI_RESET + "- Il giocatore con il maggior numero di pedine vince.\n"
                + GestoreStampa.ANSI_RESET
                + "- In caso di parità, quando il numero di caselle è pari, si verifica un pareggio.\n\n"
                + GestoreStampa.ANSI_YELLOW + "COME INSERIRE LE COORDINATE DELLE CELLE\n\n"
                + GestoreStampa.ANSI_RESET + "Le coordinate delle celle sono composte da una lettera e un numero,"
                + GestoreStampa.ANSI_RESET + " corrispettivamente le lettere rappresentano le colonne\n"
                + GestoreStampa.ANSI_RESET + "e i numeri le righe."
                + GestoreStampa.ANSI_RESET + " Le lettere delle colonne vanno dalla A alla G e i numeri delle righe"
                + GestoreStampa.ANSI_RESET + " vanno dal 1 al 7.\n\n"
                + GestoreStampa.ANSI_RESET + "Esempio: 'A1' rappresenta la cella"
                + GestoreStampa.ANSI_RESET + " in alto a sinistra della scacchiera.\n\n"
                + GestoreStampa.ANSI_RESET + "Durante la partita il giocatore può compiere per ogni sua pedina"
                + GestoreStampa.ANSI_RESET + " una mossa per volta e questa può essere di due tipi:\n\n"
                + GestoreStampa.ANSI_RESET + " 1) Generazione di una nuova pedina in una casella"
                + GestoreStampa.ANSI_RESET + " adiacente a quella selezionata\n"
                + GestoreStampa.ANSI_RESET + " 2) Salto su una casella a distanza due rispetto a quella selezionata\n\n"
                + GestoreStampa.ANSI_RESET + "Per compiere una delle due mosse il giocatore deve inserire le coordinate"
                + GestoreStampa.ANSI_RESET + " nel formato"
                + GestoreStampa.ANSI_GREEN + " 'cella di partenza'" + GestoreStampa.ANSI_RESET + "-"
                + GestoreStampa.ANSI_YELLOW + "'cella di arrivo'.\n\n"
                + GestoreStampa.ANSI_RESET + "Esempio: 'A1-B3'\n\n"
                + GestoreStampa.ANSI_RESET + "Rappresenta la mossa di una pedina dalla cella"
                + GestoreStampa.ANSI_RESET + " in alto a sinistra a quella in basso a destra"
                + GestoreStampa.ANSI_RESET + " e in questo caso"
                + GestoreStampa.ANSI_RESET + " essendo la cella B3 una\n"
                + GestoreStampa.ANSI_RESET + "cella a distanza 2 dalla cella A1"
                + GestoreStampa.ANSI_RESET + " la pedina nella cella A1 si sposterà nella cella B3.\n\n"
                + GestoreStampa.ANSI_BLUE + "COMANDI UTILIZZABILI\n\n"
                + GestoreStampa.ANSI_RESET + "Per visualizzare i comandi disponibili" + GestoreStampa.ANSI_RED
                + " (QUALUNQUE)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_RED + "/help:"
                + GestoreStampa.ANSI_RESET + " Mostra i comandi disponibili.\n\n"
                + GestoreStampa.ANSI_RESET + "Per iniziare una nuova partita" + GestoreStampa.ANSI_GREEN
                + " (SCHERMATA PRINCIPALE)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_GREEN + "/gioca:"
                + GestoreStampa.ANSI_RESET
                + " Mostra il tavoliere con le pedine in posizione iniziale e attende la prima\n"
                + GestoreStampa.ANSI_RESET + " mossa del giocatore rosso o altri comandi.\n\n"
                + GestoreStampa.ANSI_RESET + "Per mostrare il tavoliere vuoto" + GestoreStampa.ANSI_GREEN
                + " (SCHERMATA PRINCIPALE)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_GREEN + "/vuoto:"
                + GestoreStampa.ANSI_RESET + " Mostra il tavoliere vuoto.\n\n"
                + GestoreStampa.ANSI_RESET + "Per mostrare il tavoliere durante la partita" + GestoreStampa.ANSI_BLUE
                + " (SCHERMATA DI GIOCO)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_BLUE + "/tavoliere:"
                + GestoreStampa.ANSI_RESET
                + " Mostra il tavoliere con le pedine in posizione attuale e attende la mossa\n"
                + " del giocatore.\n\n"
                + GestoreStampa.ANSI_RESET + "Per mostrare le mosse possibili in game" + GestoreStampa.ANSI_BLUE
                + " (SCHERMATA DI GIOCO)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_BLUE + "/qualimosse:"
                + GestoreStampa.ANSI_RESET
                + " Mostra quali mosse sono disponibili per il giocatore di turno, evidenziando:\n"
                + GestoreStampa.ANSI_RESET + "   a)"
                + GestoreStampa.ANSI_RESET + " in"
                + GestoreStampa.ANSI_YELLOW + " Giallo"
                + GestoreStampa.ANSI_RESET + " le caselle raggiungibili con mosse"
                + GestoreStampa.ANSI_RESET + " che generano una nuova pedina.\n"

                + GestoreStampa.ANSI_RESET + "   b)"
                + GestoreStampa.ANSI_RESET + " in"
                + GestoreStampa.ANSI_ORANGE + " Arancione"
                + GestoreStampa.ANSI_RESET + " le caselle raggiungibili con mosse"
                + GestoreStampa.ANSI_RESET + " che cosentono il salto.\n"

                + GestoreStampa.ANSI_RESET + "   c)"
                + GestoreStampa.ANSI_RESET + " in"
                + GestoreStampa.ANSI_PINK + " Rosa"
                + GestoreStampa.ANSI_RESET + " le caselle raggiungibili con mosse di tipo a) o b).\n\n"

                + GestoreStampa.ANSI_RESET + "Per abbandonare la partita" + GestoreStampa.ANSI_BLUE
                + " (SCHERMATA DI GIOCO)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_BLUE + "/abbandona:"
                + GestoreStampa.ANSI_RESET + " Abbandona la partita in corso e torna alla schermata principale.\n\n"

                + GestoreStampa.ANSI_RESET + "Per uscire dall'applicazione" + GestoreStampa.ANSI_RED + " (QUALUNQUE)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_RED + "/esci:"
                + GestoreStampa.ANSI_RESET + " Chiude l'applicazione.\n\n"

                + GestoreStampa.ANSI_RESET + "Per bloccare una cella"
                + GestoreStampa.ANSI_GREEN + " (SCHERMATA DI PRINCIPALE)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_GREEN + "/blocca:"
                + GestoreStampa.ANSI_RESET
                + " Il comando da la possibilità al giocatore di inizialaizzare il tavoliere di gioco"
                + GestoreStampa.ANSI_RESET + "  bloccando una cella a sua scelta.\n"
                + GestoreStampa.ANSI_RESET + " La cella scelta va inserita nel formato 'Z0' dove:\n"
                + GestoreStampa.ANSI_RESET + " - Z è la lettera della colonna\n"
                + GestoreStampa.ANSI_RESET + " - 0 è il numero della riga\n\n"

                + GestoreStampa.ANSI_RESET + "Per visualizzare lo storico delle mosse effettuate"
                + GestoreStampa.ANSI_BLUE + " (SCHERMATA DI GIOCO)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_BLUE + "/mosse:"
                + GestoreStampa.ANSI_RESET + " Mostra lo storico delle mosse effettuate da entrambi i giocatori.\n\n"

                + GestoreStampa.ANSI_RESET + "Per visualizzare il tempo trascorso dall'inizio della partita"
                + GestoreStampa.ANSI_BLUE + " (SCHERMATA DI GIOCO)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_BLUE + "/tempo:"
                + GestoreStampa.ANSI_RESET + " Mostra il tempo trascorso dall'inizio della partita.\n\n"));


    }

}
