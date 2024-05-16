
package main.java.it.uniba.app;
/**
 * <<Control>> 
 * Responsabilità: Contiene metodi per l'analisi dell'input.
 */
public class Utils {
    /**
     * Metodo che analizza l'input dell'utente.
     * @param input stringa inserita dall'utente
     * @return boolean true se l'input è valido, false altrimenti
     */
    public boolean analizzatoreInput(String input){
        switch (input){
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
            case "Classica":
                return true;
            case "Thomas":
                return true;
            case "Assimilation":
                return true;
            case "Variante a Perdere":
                return true;
        }
        return false;
    }
}
