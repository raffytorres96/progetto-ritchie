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
        Tavoliere tavoliere = new Tavoliere();
        tavoliere.inizializzaTavolierePartita(tavoliere);
        GestoreStampa.stampareTitoloGioco();
        GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE + "Benvenuti in ATAXX\n\n");
        GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "Scrivi /help oppure -h o --help"
        + " per saperne di più !\n\n ");

        String input;
        char inputLettera;
        char inputNumero;
        boolean erroreInput;
        do {
            do {
                GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "\ninserisci un comando: ");
                input = Comandi.input();
                if (input.equals("/help") || input.equals("-h") || input.equals("--help")) {
                    Comandi.help();
                } else if (input.equals("/gioca") && !Utils.isInGame()) {
                    GestoreStampa.clearTerminale();
                    Comandi.gioca(tavoliere);
                    GestoreStampa.stampareMessaggioFuoriGioco();
                } else if (input.equals("/vuoto") && !Utils.isInGame()) {
                    GestoreStampa.stampareMessaggioFuoriGioco();
                    GestoreStampa.stampareTavoliereVuoto();
                } else if (input.equals("/blocca") && !Utils.isInGame()) {
                    GestoreStampa.stampareMessaggioFuoriGioco();
                    if (tavoliere.getCelleBloccate() >= Tavoliere.MAX_CELLE_BLOCCATE) {
                        GestoreStampa.stampareMessaggio("E' stato raggiunto il massimo numero di caselle bloccate.");
                    } else {
                        GestoreStampa.stampareTavoliere(tavoliere);
                        GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RED + "\nATTENZIONE:"
                        + GestoreStampa.ANSI_RESET + "Non è possibile bloccare tutte le caselle intorno ad una pedina"
                        + "\n\t   in modo da impedire qualsiasi possibilità di spostarsi o di\n\t   "
                        + "generarne un'altra accanto a sè.\n\n");
                        do {
                            erroreInput = false;
                            GestoreStampa.stampareMessaggio("Inserire coordinate cella da bloccare (formato Z0)->");
                            input = Comandi.input();
                            input = input.toLowerCase();
                            inputLettera = input.charAt(0);
                            inputNumero = input.charAt(1);
                            if (input.length() != 2 || !Character.isLetter(inputLettera)
                                || !Character.isDigit(inputNumero)) {
                                GestoreStampa.stampareMessaggio("Formato coordinate non corretto\n");
                                erroreInput = true;
                            }
                            else if (inputLettera < 'a' || inputLettera > 'g' || inputNumero - '0' <= Tavoliere.RIGA0
                                || inputNumero - '0' > Tavoliere.N_RIGHE_COLONNE) {
                                GestoreStampa.stampareMessaggio("Coordinate non valide\n");
                                erroreInput = true;
                            }
                        } while (erroreInput);
                        GestoreStampa.stampareMessaggio("Cella " + input.toUpperCase() + " bloccata!\n");
                        int colonnaDaBloccare = Utils.mappingColonne(input.substring(0, 1));
                        int rigaDaBloccare = Utils.mappingRighe(input.substring(1, 2));
                        Comandi.blocca(tavoliere, rigaDaBloccare, colonnaDaBloccare);
                    }
                } else if (input.equals("/tavoliere") && !Utils.isInGame()) {
                    GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET
                    + "\nComando utilizzabile solo in partita\n\n");
                    GestoreStampa.stampareMessaggio("Perché non provi a giocare usando il comando"
                    + GestoreStampa.ANSI_BLUE + " /Gioca\n\n" + GestoreStampa.ANSI_RESET);
                } else if ((input.equals("/qualimosse") || input.equals("/abbandona")) && !Utils.isInGame()) {
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

