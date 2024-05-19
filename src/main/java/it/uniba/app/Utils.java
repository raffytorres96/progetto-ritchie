
package it.uniba.app;
/**
 * <<Control>>
 * Responsabilità: Contiene metodi per l'analisi dell'input.
 */
public class Utils {

/** attributo utilizzato in App per verifiacare che alcuni comandi siano dati
      * prima di iniziare una partita. */
      private boolean inGame = false;

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
