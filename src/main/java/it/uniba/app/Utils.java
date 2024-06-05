package it.uniba.app;
/**
 * <<Control>>
 * Responsabilità: Contiene metodi per l'analisi dell'input.
 */
public final class Utils {
private Utils() { }
    /** attributo utilizzato in App per verifiacare che alcuni comandi siano dati
      * prima di iniziare una partita. */
      private static boolean inGame = false;

      /** attributo utilizzato come indice di posizione nel metodo anlaizzatoreInputCoordinate. */
      private static final int TRE = 3;

      /** attributo utilizzato come indice di posizione nel metodo anlaizzatoreInputCoordinate. */
      private static final int QUATTRO = 4;

      /** attributo utilizzato come indice di posizione nel metodo anlaizzatoreInputCoordinate. */
      private static final int CINQUE = 5;

      /** attributo utilizzato come indice di posizione nel metodo anlaizzatoreInputCoordinate. */
      private static final int SETTE = 7;


    /** Analizzatore utilizzato per verificare la correttezza delle oordinate inserite
     * ossia che sia date nel formato  xi-yj dove x e y sono lettere da a a g e i e j
     * numeri da 1 a 7  compreso il trattinoe separatore "-".
     * @param inputCoordinate
     * */
    public static boolean analizzatoreInputCoordinate(final String inputCoordinate) {
        boolean errore = false;
        if (inputCoordinate.length() == CINQUE && Character.isLetter(inputCoordinate.charAt(0))
        && Character.isDigit(inputCoordinate.charAt(1)) && inputCoordinate.charAt(2) == '-'
        && Character.isLetter(inputCoordinate.charAt(TRE))
        && Character.isDigit(inputCoordinate.charAt(QUATTRO))) {
            char coordinataColonnaPartenza = inputCoordinate.charAt(0);
            int coordinataRigaPartenza = Integer.parseInt(String.valueOf(inputCoordinate.charAt(1)));
            char coordinataColonnaArrivo = inputCoordinate.charAt(TRE);
            int coordinataRigaArrivo = Integer.parseInt(String.valueOf(inputCoordinate.charAt(QUATTRO)));
            if (mappingColonne(Character.toString(coordinataColonnaPartenza)) != -1
            && mappingColonne(Character.toString(coordinataColonnaArrivo)) != -1
                && coordinataRigaPartenza >= 1 && coordinataRigaPartenza <= SETTE
                && coordinataRigaArrivo >= 1 && coordinataRigaArrivo <= SETTE) {
                //passare coordinataRiga e coordinataColonna al metodo di Mossa che controlla se è valida
                return true;
            } else {
                errore = true;
            }
        } else {
            errore = true;
        }
        if (errore) {
            GestoreStampa.stampareMessaggio("Errore, coordinate non inserite correttamente.\nIl formato è ->  xi-yj\n"
            + "dove i e j sono numeri da 1 a 7 e x e y sono lettere da a a g.\n");

            return false;
        } else {
            return true;
        }
    }

    /**
    *  Metodo che mappa le coordinate delle righe inserite da tastiera.
    * @param riga
    * @return
    */
    public static int mappingRighe(final String riga) {
        if (Character.isDigit(riga.charAt(0))) {
            return Integer.parseInt(riga) - 1;
        } else {
            return -1;
        }
    }

    /**
     * Metodo che mappa le coordinate delle colonne inserite da tastiera.
     * @param colonna
     */
    public static int mappingColonne(final String colonna) {
        int colonnaInt = -1;
        switch (colonna) {
            case "a":
                colonnaInt = Tavoliere.COLONNA0;
                break;
            case "b":
                colonnaInt = Tavoliere.COLONNA1;
                break;
            case "c":
                colonnaInt = Tavoliere.COLONNA2;
                break;
            case "d":
                colonnaInt = Tavoliere.COLONNA3;
                break;
            case "e":
                colonnaInt = Tavoliere.COLONNA4;
                break;
            case "f":
                colonnaInt = Tavoliere.COLONNA5;
                break;
            case "g":
                colonnaInt = Tavoliere.COLONNA6;
                break;
            default:
                break;
        }
        return colonnaInt;
    }

    /**
    * Metodo che analizza l'input dell'utente
    * per conotrollare la correttezza dei comandi
    * inseriti.
    * @param input
    * @return
    */
    public static boolean analizzatoreInput(final String input) {
        switch (input) {
            case "--help":
                return true;
            case "-h":
                return true;
            case "/help":
                return true;
            case "/esci":
                return true;
            case "/gioca":
                return true;
            case "/qualiMosse":
                return true;
            case "/abbandona":
                return true;
            case "/vuoto":
                return true;
            case "/tavoliere":
                return true;
            case "/blocca":
                return true;
            case "classica":
                return true;
            case "thomas":
                return true;
            case "assimilation":
                return true;
            case "variante a perdere":
                return true;

                default:
                    break;
        }
        return false;
    }
    /** Metodo che restituisce il valore dell'attributo inGame. */
    public static boolean isInGame() {
        return inGame;
    }
    /**Metodo che setta il valore dell'attributo inGame. */
    public static void setInGame(final boolean setInGame) {
        inGame = setInGame;
    }

}
