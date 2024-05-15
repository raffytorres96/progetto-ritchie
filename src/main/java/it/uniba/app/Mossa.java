/**
 *
 * <<Control>>
 * Responsabilità: gestisce e modella
 * il le mosse lecite effettuata dal giocatore.
 */
package it.uniba.app;
/**
 * Classe che modella la mossa.
 */
public class Mossa {
    /**
     * Attributo di istanza che rappresenta la coordinata di riga
     * che identifica la cella su cui applicare
     * la mossa.
     */
    private int riga;

    /**
     * Attributo di istanza che rappresenta  la coordinata di colonna
     * che identifica la cella su cui applicare la mossa.
     *
     */
    private int colonna;

    /**
     * Attributo di istanza che rappresenta il tavoliere
     * su cui applicare la mossa.
     */
    private Tavoliere tavoliere;

    /**
     * Attributo di istanza che rappresenta il giocatore corrente.
     */
    private int giocatoreCorrente;

    /**
     * Attributo statico che rappresenta la dimensione del tavoliere.
     */
    public static final  int SIZE = 7;

}
