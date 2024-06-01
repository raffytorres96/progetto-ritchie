package it.uniba.app;

/**
 * Main class of the application.
 */
public final class App {

    /**
     * Costruttore.
     */
    private App() { }
/**
 * Main della classe app.
 * @param args
 */
     public static void main(final String[] args) {
        GestoreStampa.stampareTitoloGioco();
        GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE + "Benvenuti in ATAXX\n\n ");
        GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "Scrivi /help oppure -h o --help"
        + " per saperne di più !\n\n ");

        String input;
        do {
            do {
                GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "\ninserisci un comando: ");
                input = Comandi.input();

            if (input.equals("/help") || input.equals("-h") || input.equals("--help")) {
                Comandi.help();

            } else if (input.equals("/gioca") && !Utils.isInGame()) {
                GestoreStampa.clearTerminale();
                Comandi.gioca();
                GestoreStampa.clearTerminale();
                GestoreStampa.stampareTitoloGioco();
                GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE + "Benvenuti in ATAXX\n\n ");
            } else if (input.equals("/vuoto") && !Utils.isInGame()) {
                GestoreStampa.clearTerminale();
                GestoreStampa.stampareTitoloGioco();
                GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE + "Benvenuti in ATAXX\n\n "
                + GestoreStampa.ANSI_RESET);
                GestoreStampa.stampareTavoliereVuoto();
            } else if (input.equals("/tavoliere") && !Utils.isInGame()) {
                GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET
                + "\nComando utilizzabile solo in partita\n\n");
                GestoreStampa.stampareMessaggio("Perché non provi a giocare usando il comando"
                + GestoreStampa.ANSI_BLUE + " /Gioca\n\n" + GestoreStampa.ANSI_RESET);
            } else if (input.equals("/qualimosse") && !Utils.isInGame()) {
                GestoreStampa.stampareMessaggio("Questo comando può essere utilizzato solo in partita\n\n");
            }  else if (input.equals("/abbandona") && !Utils.isInGame()) {
                GestoreStampa.stampareMessaggio("Questo comando può essere utilizzato solo in partita\n\n");
            } else if (input.equals("/esci") && !Utils.isInGame()) {
                Comandi.esci();
            } else {
                GestoreStampa.stampareMessaggio("Il comando inserito non è corretto\n\n");
            }

        } while (!Utils.analizzatoreInput(input));

        } while (true);




        }
    }

