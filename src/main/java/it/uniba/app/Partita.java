/**
 *  <<Entity>>
 *  Responsabilità: Modella l'entità Partita
 *  del gioco.
 */
package it.uniba.app;
/**
 * Classe che modella Partita.
 *
 * @author GruppoRitchie
 */
public class Partita {

    /** attributo statico per identificare lo stato della cella occupata
 * nel tavoliere dalla pedina che corrisponde al giocatore1.  */
private static final int GIOCATORE1 = 1;

/** attributo statico per identificare lo stato della cella occupata
 * nel tavoliere dalla pedina che corrisponde al giocatore2.  */
private static final int GIOCATORE2 = 2;

/** attributo statico per identificare la cordinata da dare a setTavoliere.  */
private static final int POSIZIONE0 = 0;

/** attributo statico per identificare la cordinata da dare a setTavoliere.  */
private static final int POSIZIONE7 = 7;

/** attributo che indica se il gioco è finito o meno.  */
private boolean giocoFinito = false;

/** attributo che rappresenta la regola del gioco.  */
private Regola regola;

/** attributo che rappresenta il tavoliere del gioco.  */
private Tavoliere tavoliere;

/** attributo che rappresenta il giocatore1.  */
private Giocatore giocatore1;

/** attributo che rappresenta il giocatore2.  */
private Giocatore giocatore2;

}
