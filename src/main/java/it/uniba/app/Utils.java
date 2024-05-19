
package it.uniba.app;
/**
 * <<Control>>
 * Responsabilità: Contiene metodi per l'analisi dell'input.
 */
public class Utils {

    /** attributo statico usato per mappare la prima colonna. */
    public static final int COLONNA0 = 0;

    /** attributo statico usato per mappare la seconda colonna . */
    public static final int COLONNA1 = 1;

    /** attributo statico usato per mappare la terza colonna. */
    public static final int COLONNA2 = 2;

    /** attributo statico usato per mappare la quarta colonna. */
    public static final int COLONNA3 = 3;

    /** attributo statico usato per mappare la quinta colonna. */
    public static final int COLONNA4 = 4;

    /** attributo statico usato per mappare la sesta colonna. */
    public static final int COLONNA5 = 5;

    /** attributo statico usato per mappare la settima colonna. */
    public static final int COLONNA6 = 6;



    /** attributo utilizzato in App per verifiacare che alcuni comandi siano dati
      * prima di iniziare una partita. */
      private boolean inGame = false;

    /**
    *  Metodo che mappa le coordinate delle righe inserite da tastiera.
    * @param riga
    * @return
    */
    public int mappingRighe(final String riga) {

        return Integer.valueOf(riga) - 1;

    }

    /**
     * Metodo che mappa le coordinate delle colonne inserite da tastiera.
     * @param colonna
     */
    public int mappingColonne(final String colonna) {
        int colonnaInt = -1;
        switch (colonna) {
            case "a":
                colonnaInt = COLONNA0;
                break;
            case "b":
                colonnaInt = COLONNA1;
                break;
            case "c":
                colonnaInt = COLONNA2;
                break;
            case "d":
                colonnaInt = COLONNA3;
                break;
            case "e":
                colonnaInt = COLONNA4;
                break;
            case "f":
                colonnaInt = COLONNA5;
                break;
            case "g":
                colonnaInt = COLONNA6;
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
    public boolean analizzatoreInput(final String input) {
        switch (input) {
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
    public boolean isInGame() {
        return inGame;
    }
    /**Metodo che setta il valore dell'attributo inGame. */
    public void setInGame(final boolean setInGame) {
        this.inGame = setInGame;
    }

}
