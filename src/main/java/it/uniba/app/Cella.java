package it.uniba.app;

/**
 * << Entity >>
 * Responsabilità: Rappresenta la cella della griglia di gioco.
 * Classe che si occupa di descrivere la singola cella della
 * griglia di gioco.
 *
 * @author GruppoRitchie
 */

public class Cella {
  /**
* Attributo statico che contiene lo stato relativo alla cella vuota.
*/
static final int STATO_CELLA_VUOTA = 0;
/**
* Attributo statico che contiene lo stato relativo alla cella occupata
* da una pedina del giocatore 1.
*/
static final int STATO_GIOCATORE1 = 1;
/**
* Attributo statico che contiene lo stato relativo alla cella occupata
* da una pedina del giocatore 2.
*/
static final int STATO_GIOCATORE2 = 2;
/**
* Attributo statico che contiene lo stato relativo ad una cella in cui
* è possibile generare una pedina.
*/
static final int STATO_CELLA_GIALLA = 3;
/**
* Attributo statico che contiene lo stato relativo ad una cella in cui
* è possibile spostare una pedina.
*/
static final int STATO_CELLA_ARANCIONE = 4;
/**
* Attributo statico che contiene lo stato relativo ad una cella in cui
* è possibile sia spostare una pedina che generarla.
*/
static final int STATO_CELLA_ROSA = 5;
  /**
* Attributo statico che contiene l'icona della cella vuota.
*/
  static final String ICONA_CELLA_VUOTA = Character.toString(0X1F7EB);
/**
* Attributo statico che contiene l'icona delle pedine del
* giocatore 1.
*/
  static final String ICONA_GIOCATORE1 = Character.toString(0x26AA);
  /**
 * Attributo statico che contiene l'icona delle pedine del
 * giocatore 2.
 */
  static final String ICONA_GIOCATORE2 = Character.toString(0x26AB);
  /**
 * Attributo statico che contiene l'icona delle celle nelle
 * quali è possibile effettuare una mossa che generi una
 * pedina.
 */
  static final String ICONA_CELLA_GIALLA = Character.toString(0x1F7E8);
  /**
 * Attributo statico che contiene l'icona delle celle nelle
 * quali è possibile spostare una pedina.
 */
  static final String ICONA_CELLA_ARANCIONE = Character.toString(0x1F7E7);
  /**
 * Attributo statico che contiene l'icona delle celle nelle
 * quali è possibile spostare una pedina o generarne una.
 */
  static final String ICONA_CELLA_ROSA = Character.toString(0x1F7EA);
  /**
 * Attributo che contiene lo stato della cella: 0 se vuota,
 * 1 se occupata da una pedina del giocatore 1, 2 se
 * occupata da una pedina del giocatore 2, 3 se vuota ma
 * eleggibile alla generazione di una nuova pedina, 4 se
 * vuota ma eleggibile come destinazione dello spostamento
 * di una pedina esistente, 5 se eleggibile alle azioni
 * di entrambi gli stati 3 e 4.
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
 *
 * @param cel cella di cui ricavare lo stato.
 * @return stato
 */

  public static int getStato(final Cella cel) {
    return cel.stato;
  }
    /**
 * Metodo d'accesso che restituisce l'icona della cella
 * in base al suo stato.
 * @return costante dell'icona relativa allo stato o null nel
 * caso lo stato sia invalid.
 */
  public String getIcona() {
      if (getStato(this) == STATO_CELLA_VUOTA) {
          return ICONA_CELLA_VUOTA;
      } else if (getStato(this) == STATO_GIOCATORE1) {
          return ICONA_GIOCATORE1;
      } else if (getStato(this) == STATO_GIOCATORE2) {
        return ICONA_GIOCATORE2;
      } else if (getStato(this) == STATO_CELLA_GIALLA) {
        return ICONA_CELLA_GIALLA;
      } else if (getStato(this) == STATO_CELLA_ARANCIONE) {
        return ICONA_CELLA_ARANCIONE;
      } else if (getStato(this) == STATO_CELLA_ROSA) {
        return ICONA_CELLA_ROSA;
      }
      return null;
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
