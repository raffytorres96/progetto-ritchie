package it.uniba.app;
/**
 * <<Control>>
 * Responsabilità: Contiene metodi per l'analisi dell'input.
 */
public class Utils {
    /** attributo utilizzato in App per verifiacare che alcuni comandi siano dati
      * prima di iniziare una partita. */
      private boolean inGame = false;

    /** Analizzatore utilizzato per separare la stringa delle coordinate date in input
     *  per passare ai meotodi di mapping righe e colonne.
     * @param inputCoordinate
     * */
    public static boolean analizzatoreInputCoordinate(final String inputCoordinate) {
        boolean errore = false;
        if (inputCoordinate.length() == 2 && Character.isLetter(inputCoordinate.charAt(0))
        && Character.isDigit(inputCoordinate.charAt(1))) {
            char coordinataColonnaCodificata = inputCoordinate.charAt(0);
            char coordinataRigaCodificata = inputCoordinate.charAt(1);
            int coordinataColonna = 0;
            int coordinataRiga = 0;
            if (coordinataColonnaCodificata >= 'a' && coordinataColonnaCodificata <= 'g'
                && coordinataRigaCodificata >= '1' && coordinataRigaCodificata <= '7') {
                coordinataRiga = mappingRighe(Character.toString(coordinataRigaCodificata));
                coordinataColonna = mappingColonne(Character.toString(coordinataColonnaCodificata));
                //passare coordinataRiga e coordinataColonna al metodo di Mossa che controlla se è valida
                return true;
            } else {
                errore = true;
            }
        } else {
            errore = true;
        }
        if (errore) {
            GestoreStampa.stampareMessaggio("Errore, coordinate non inserite correttamente.\nIl formato è ->  XY "
            + " <-con X=lettera della colonna e Y=numero della riga.\n");
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
