/**
 *  <<Entity>>
 *  Responsabilità: Modella l'entità Giocatore
 *  del gioco.
 */
package it.uniba.app;
/**
 *  <<Entity>>
 *  Responsabilità: Modella l'entità Giocatore
 *  del gioco.
 */
public class Giocatore {
 /** Attributo d'istanza contenente il nome del Giocatore.  */
private String nome;
 /** Attributo d'istanza contenente il nome del Giocatore.  */
private int statoGiocatore;

/**
* Costruttore di Giocatore.
*/
Giocatore(final String nomeInit, final int statoGiocatoreInit) {
    nome = nomeInit;
    statoGiocatore = statoGiocatoreInit;
 }
/**
* Metodo get per lo stato del giocatore.

* @return Variabile contenente lo stato del giocatore.
*/
public int getStatoGiocatore() {
    return statoGiocatore;
 }
/**
    * Metodo get per lo stato del giocatore.

    * @param statoGiocatoreInit variabile contenente lo stato del giocatore.
    */
    public void setStatoGiocatore(final int statoGiocatoreInit) {
        statoGiocatore = statoGiocatoreInit;
    }
/**
    * Metodo get per il nome dell' giocatore.

    * @return Variabile contenente il nome del giocatore.
    */
    public String getNome() {
        return nome;
    }
/**
    * Metodo set per il nome del giocatore.

    *@param nomeInit variabile contenente il nome del giocatore.
    */
    public void setNome(final String nomeInit) {
        nome = nomeInit;
    }

}
