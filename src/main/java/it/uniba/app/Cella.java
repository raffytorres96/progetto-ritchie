package it.uniba.app;
/**
 * <<Entity>>
 * Responsabilità: Rappresenta la cella della griglia di gioco.
 *
 * Classe che si occupa di descrivere la singola cella della
 * griglia di gioco.
 *
 * @author GruppoRitchie
 */

 public class Cella {
     /**
   * Attributo statico che contiene l'icona della cella vuota.
   */
    static final char ICONA_CELLA_VUOTA = '\u25A1';
     /**
   * Attributo statico che contiene l'icona delle pedine del
   * giocatore 1.
   */
    static final char ICONA_GIOCATORE1 = '\u26C0';
     /**
   * Attributo statico che contiene l'icona delle pedine del
   * giocatore 2.
   */
    static final char ICONA_GIOCATORE2 = '\u26C2';
     /**
   * Attributo che contiene lo stato della cella: 0 se vuota,
   * 1 se occupata da una pedina del giocatore 1, 2 se
   * occupata da una pedina del giocatore 2.
   */
    private int stato;
     /**
   * Metodo che inizializza lo stato della cella a 0 (cella
   * vuota).
   */
    public Cella() {
        stato = 0;
    }
     /**
   * Metodo d'accesso che restituisce lo stato della cella in input.
   * @param cel
   * @return stato
   */
    public static int getStato(final Cella cel) {
        return cel.stato;
    }
     /**
   * Metodo d'accesso che restituisce l'icona della cella
   * in base al suo stato.
   */
    public char getIcona() {
        if (getStato(this) == 1) {
            return ICONA_GIOCATORE1;
        } else if (getStato(this) == 2) {
            return ICONA_GIOCATORE2;
        } else {
            return ICONA_CELLA_VUOTA;
        }
    }
     /**
   * Metodo d'accesso che modifica lo stato della cella
   * in base al parametro passato.
   * @param s
   */
    public void setStato(final int s) {
        this.stato = s;
    }
}
