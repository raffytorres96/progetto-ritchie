package it.uniba.app;
/**
 * <<Boundary>>
 * Responsabilità: Gestisce la stampa a video di messaggi.
 */


/**
 * Classe che si occupa gestire la stampa a video dei messaggi
 * del gioco. Per migliorare l'interfaccia e la UX dell'utente
 * sono stati inseriti i colori e una particolare formattazione
 * dei messaggi.
 *
 * @author GrruppoRitchie
 */

public class GestoreStampa {

     /**
   * Attributo statico che contiene il colore di default.
   */
  public static final String ANSI_RESET = "\u001B[0m";

  /**
   * Attributo statico che contiene il colore rosso.
   */
  public static final String ANSI_RED = "\u001B[31m";

  /**
   * Attributo statico che contiene il colore verde.
   */
  public static final String ANSI_GREEN = "\u001B[32m";

  /**
   * Attributo statico che contiene il colore di giallo.
   */
  public static final String ANSI_YELLOW = "\u001B[33m";

  /**
   * Attributo statico che contiene il colore di blu.
   */
  public static final String ANSI_BLUE = "\u001B[34m";

  /**
   * Attributo statico che contiene il colore di blu.
   */
  public static final String ANSI_ORANGE = "\u001B[38;2;255;165;0m";

  /**
   * Attributo statico che contiene il colore di blu.
   */
  public static final String ANSI_PINK = "\u001B[38;2;255;105;180m";

    
}
