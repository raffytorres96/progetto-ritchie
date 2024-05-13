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
    static final String ICONA_CELLA_VUOTA = Character.toString(0x25A1);
     /**
   * Attributo statico che contiene l'icona delle pedine del
   * giocatore 1.
   */
    static final String ICONA_GIOCATORE1 = Character.toString(0x26C0);
     /**
   * Attributo statico che contiene l'icona delle pedine del
   * giocatore 2.
   */
    static final String ICONA_GIOCATORE2 = Character.toString(0x26C2);
     /**
   * Attributo statico che contiene l'icona delle celle nelle
   * quali è possibile effettuare una mossa che generi una
   * pedina
   */
    static final String ICONA_CELLA_GIALLA=Character.toString(0x1F7E8);
     /**
   * Attributo statico che contiene l'icona delle celle nelle
   * quali è possibile spostare una pedina
   */
    static final String ICONA_CELLA_ARANCIONE=Character.toString(0x1F7E7);
     /**
   * Attributo statico che contiene l'icona delle celle nelle
   * quali è possibile spostare una pedina o generarne una
   */
    static final String ICONA_CELLA_ROSA=Character.toString(0x1F7EA);
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
