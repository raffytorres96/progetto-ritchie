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
        Utils utils = new Utils();
        String input;
        do {
            do {
                GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "inserisci un comando: ");
                input = Comandi.input();

            if (input.equals("/help")) {
                Comandi.help();

            } else if (input.equals("/gioca") && !utils.isInGame()) {
                GestoreStampa.clearTerminale();
                Comandi.gioca();
            } else if (input.equals("/vuoto") && !utils.isInGame()) {
                GestoreStampa.stampareTavoliereVuoto();
            } else if (input.equals("/tavoliere") && !utils.isInGame()) {
                Tavoliere tavoliere = new Tavoliere();
                Comandi.comandoTavoliere(tavoliere);
            } else if (input.equals("/qualimosse") && !utils.isInGame()) {
                GestoreStampa.stampareMessaggio("Questo comando può essere utilizzato solo in partita\n\n");
            }  else if (input.equals("/abbandona") && !utils.isInGame()) {
                GestoreStampa.stampareMessaggio("Questo comando può essere utilizzato solo in partita\n\n");
            } else if (input.equals("/esci") && !utils.isInGame()) {
                Comandi.esci();
            } else {
                GestoreStampa.stampareMessaggio("Il comando inserito non è corretto\n\n");
            }

        } while (!utils.analizzatoreInput(input));

        } while (true);




        }
    }

