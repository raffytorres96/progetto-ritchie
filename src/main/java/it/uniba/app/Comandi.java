/**
 *
 * <<Control>>
 * Responsabilità: gestisce il comportamento
 * dell'applicazione in gioco
 */

package it.uniba.app;

import java.util.Scanner;

/**
 * Classe che si occupa di descrivere i comandi del gioco.
 */

public final class Comandi {

    private Comandi() {
    }
   /**
    * Metodo statico che stampa le regole e i comandi del gioco.
    */
public static void help() {
        GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE + "\nBENVENUTI IN ATAXX\n\n"
            // INTRODUZIONE E DESCIZIONE DEI GIOCO
            + GestoreStampa.ANSI_RESET + "Ataxx è un gioco di strategia in cui due giocatori"
            + "si sfidano su una griglia di 7x7 caselle.\n"
            + "L\'obiettivo è che un giocatore abbia la maggioranza delle pedine sulla scacchiera"
            + "alla fine della partita\n"
            + "convertendo il maggior numero possibile di pedine dell\'avversario.\n\n"
            + GestoreStampa.ANSI_BLUE + "REGOLE DEL GIOCO\n\n"
            + GestoreStampa.ANSI_GREEN + "1 PEDINE E INIZIO\n\n"
            + GestoreStampa.ANSI_RESET
            + "- Ogni giocatore, inizialmente, ha due pedine in due angoli opposti della scacchiera.\n\n"
            + GestoreStampa.ANSI_RESET
            + "- Le quattro pedine iniziali sono posizionate agli angoli della scacchiera\n"
            + GestoreStampa.ANSI_RESET + "  con il rosso nell\'angolo in alto a sinistra e in basso a destra\n"
            + GestoreStampa.ANSI_RESET + "  e il blu negli altri due angoli.\n\n"
            + GestoreStampa.ANSI_GREEN + "2 TURNI E MOSSE\n\n"
                + GestoreStampa.ANSI_RESET + "- Il rosso muove per primo.\n\n"
                + GestoreStampa.ANSI_RESET
                + "- Durante il primo turno i giocatori possono spostare in una o due caselle\n"
                + GestoreStampa.ANSI_RESET + "  in qualsiasi direzione.\n\n"
                + GestoreStampa.ANSI_RESET + "- Le distanze diagonali sono sono equivalenti a quelle ortogonali.\n"
                + GestoreStampa.ANSI_RESET
                + "  Quindi è possibile spostarsi su una casella che si trova a due caselle di distanza\n"
                + GestoreStampa.ANSI_RESET + "  sia verticalmente sia orizzontalmente e in obliquo.\n\n"
                + GestoreStampa.ANSI_RESET + "- Se la destinazione è adiacente alla casella di partenza\n"
                + GestoreStampa.ANSI_RESET + "  viene creat una nuova pedina di quel colore.\n\n"
                + GestoreStampa.ANSI_GREEN + "3 CONVERSIONE DELLE PEDI\n\n"
                + GestoreStampa.ANSI_RESET
                + "- Dopo ogni mossa, tutte le pedine dell\'avversario adiacenti alla casella di\n"
                + GestoreStampa.ANSI_RESET
                + "  destinazione vengono convertite nel colore del giocatore che ha mosso.\n\n"
                + GestoreStampa.ANSI_RESET
                + "- I giocatori devono muovere a meno che non ci siano mosse legali possibili\n"
                + GestoreStampa.ANSI_RESET + "  in tal caso devono passare.\n\n"
                + GestoreStampa.ANSI_GREEN + "4 FINE GIOCO\n\n"
                + GestoreStampa.ANSI_RESET
                + "- La partita termina quando tutte le caselle sono state riempite o quando uno dei\n"
                + GestoreStampa.ANSI_RESET + "  giocatori non ha più pedine.\n\n"
                + GestoreStampa.ANSI_RESET + "- Il giocatore con il maggior numero di pedine vince.\n\n"
                + GestoreStampa.ANSI_RESET
                + "- In caso di parità, quando il numero di caselle è pari, si verifica un pareggio.\n\n\n"

                // STAMPA DEI COMANDI DI GIOCO
                + GestoreStampa.ANSI_RESET + "Di seguito vengono riportati i comandi del gioco:\n\n"

                + GestoreStampa.ANSI_RESET + "Per visualizzare i comandi disponibili" + GestoreStampa.ANSI_RED
                + " (QUALUNQUE)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_RED + "/help:"
                + GestoreStampa.ANSI_RESET + " Mostra i comandi disponibili.\n\n"

                + GestoreStampa.ANSI_RESET + "Per iniziare una nuova partita" + GestoreStampa.ANSI_GREEN
                + " (SCHERMATA PRINCIPALE)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_GREEN + "/gioca:"
                + GestoreStampa.ANSI_RESET
                + " Mostra il tavolgliere con le pedine in posizione iniziale e attende la prima mossa"
                + GestoreStampa.ANSI_RESET + " del giocatore rosso o altri comandi.\n\n"

                + GestoreStampa.ANSI_RESET + "Per mostrare il tavoliere vuoto" + GestoreStampa.ANSI_GREEN
                + " (SCHERMATA PRINCIPALE)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_GREEN + "/vuoto:"
                + GestoreStampa.ANSI_RESET + " Mostra il tavoliere vuoto.\n\n"

                + GestoreStampa.ANSI_RESET + "Per mostrare il tavoliere durante la partita" + GestoreStampa.ANSI_BLUE
                + " (SCHERMATA DI GIOCO)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_BLUE + "/tavoliere:"
                + GestoreStampa.ANSI_RESET
                + " Mostra il tavoliere con le pedine in posizione attuale e attende la mossa del giocatore.\n\n"

                + GestoreStampa.ANSI_RESET + "Per mostrare le mosse possibili in game" + GestoreStampa.ANSI_BLUE
                + " (SCHERMATA DI GIOCO)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_BLUE + "/qualimosse:"
                + GestoreStampa.ANSI_RESET
                + "Mostra quali mosse sono disponibili per il giocatore di turno evidenziato.\n\n"
                + GestoreStampa.ANSI_RESET + "a)"
                + GestoreStampa.ANSI_RESET + " In"
                + GestoreStampa.ANSI_YELLOW + " Giallo"
                + GestoreStampa.ANSI_RESET + " le caselle raggiungibili con mosse"
                + GestoreStampa.ANSI_RESET + " che generano una nuova pedina.\n"

                + GestoreStampa.ANSI_RESET + "b)"
                + GestoreStampa.ANSI_RESET + " In"
                + GestoreStampa.ANSI_ORANGE + " Arancione"
                + GestoreStampa.ANSI_RESET + " le caselle raggiungibili con mosse"
                + GestoreStampa.ANSI_RESET + " che cosentono il salto.\n"

                + GestoreStampa.ANSI_RESET + "c)"
                + GestoreStampa.ANSI_RESET + " In"
                + GestoreStampa.ANSI_PINK + " Rosa"
                + GestoreStampa.ANSI_RESET + " le caselle raggiungibili con mosse di tipo a) o b).\n\n"

                + GestoreStampa.ANSI_RESET + "Per abbandonare la partita" + GestoreStampa.ANSI_BLUE
                + " (SCHERMATA DI GIOCO)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_BLUE + "/abbandona:"
                + GestoreStampa.ANSI_RESET + " Abbandona la partita in corso e torna alla schermata principale.\n\n"

                + GestoreStampa.ANSI_RESET + "Per uscire dall'applicazione" + GestoreStampa.ANSI_RED + " (QUALUNQUE)\n"
                + GestoreStampa.ANSI_RESET + "- " + GestoreStampa.ANSI_RED + "/esci:"
                + GestoreStampa.ANSI_RESET + " Chiude l'applicazione.\n\n");

    }

/**
* Metodo statico che legge l'input inserito dall'utente.
*
* @return String, stringa contentente l'input dell'utente
*/

public static String input() {
    Scanner keyboard = new Scanner(System.in, "UTF_8");
    String userInput = keyboard.nextLine();
    return userInput.toLowerCase();
}

/**
     * Metodo statico che si occupa di uscire dal gioco.
     */
    public static void esci() {
        String conferma;

        GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE
                + "Benvenuti in ATAXX" + GestoreStampa.ANSI_RESET
                + ": Sei sicuro di uscire dal gioco? [" + GestoreStampa.ANSI_GREEN
                + "si" + GestoreStampa.ANSI_RESET + "/" + GestoreStampa.ANSI_RED
                + "no" + GestoreStampa.ANSI_RESET + "] \n\n");
        GestoreStampa.stampareMessaggio("Conferma: ");

        conferma = input();

        while (!(conferma.equals("si") || conferma.equals("no"))) {
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE + "Benvenuti in ATAXX"
                    + GestoreStampa.ANSI_RESET + ": Non hai inserito una risposta valida\n"
                    + "Sei sicuro di uscire dal gioco? [" + GestoreStampa.ANSI_GREEN + "si"
                    + GestoreStampa.ANSI_RESET + "/" + GestoreStampa.ANSI_RED
                    + "no" + GestoreStampa.ANSI_RESET + "] \n\n");
            GestoreStampa.stampareMessaggio("Conferma: ");
            conferma = input();

        }

        if (conferma.equals("si")) {
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE
                    + "Benvenuti in ATAXX" + GestoreStampa.ANSI_RESET
                    + ": L'applicazione si chiuderà ... \n");
            System.exit(0);
        } else {
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE
                    + "Benvenuti in ATAXX" + GestoreStampa.ANSI_RESET
                    + ": OK \n\n");
        }
    }

/**
     * Metodo d'istanza che si occupa di abbandonare una partita.
     *
     * @param partita Istanza della classe partita
     * @return boolean, true se la conferma è andata a buon fine, false altrimenti
     */
    public boolean abbandona(final Partita partita) {

        String conferma;
        GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE
                + "Benvenuti in ATAXX" + GestoreStampa.ANSI_RESET
                + ": Sei sicuro di abbandonare la partita? [" + GestoreStampa.ANSI_GREEN
                + "si" + GestoreStampa.ANSI_RESET + "/" + GestoreStampa.ANSI_RED
                + "no" + GestoreStampa.ANSI_RESET + "] \n\n");
        GestoreStampa.stampareMessaggio("Conferma: ");
        conferma = input();

        while (!(conferma.equals("si") || conferma.equals("no"))) {
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE + "Benvenuti in ATAXX"
                    + GestoreStampa.ANSI_RESET + ": Non hai inserito una risposta valida\n"
                    + "Sei sicuro di voler abbandonare la partita? [" + GestoreStampa.ANSI_GREEN + "si"
                    + GestoreStampa.ANSI_RESET + "/" + GestoreStampa.ANSI_RED
                    + "no" + GestoreStampa.ANSI_RESET + "] \n\n");
            GestoreStampa.stampareMessaggio("Conferma: ");
            conferma = input();
        }

        if (conferma.equals("si") && partita.getGiocatore1().getStatoGiocatore() == 1) {
          GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE
                    + "Benvenuti in ATAXX" + GestoreStampa.ANSI_RESET
                    + ":" + partita.getGiocatore2().getNome() + " Vince per abbandono per 2 a 0 \n");

            return true;
        }

        if (conferma.equals("si") && partita.getGiocatore1().getStatoGiocatore() == 2) {
                GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE
                + "Bnevenuti in ATAXX" + GestoreStampa.ANSI_RESET
                + ":" + partita.getGiocatore2().getNome() + "Vince per abbandono per 2 a 0 \n");

            return true;
        }

        return false;
    }

}
