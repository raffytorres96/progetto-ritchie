/**
 *  <<Entity>>
 *  Responsabilità: Modella l'entità regola
 *  che definisce da quali regole sarà governata la partità.
 */

package it.uniba.app;

/**
 * Classe che modella la regola.
 *
 * @author GruppoRitchie
 */
public class Regola {

/** Attributo di classe per identificare le regole classiche del gioco.  */
private static final String CLASSICA = "Classica";

/** Attributo di classe per identificare le regole del gioco secodo la vesione Thomas. */
private static final String THOMAS = "Thomas";

/** Attributo di classe per identificare le regole del gioco secodo la vesione Assimilation.  */
private static final String ASSIMILATION = "Assimilation";

/** Attributo di classe per identificare le regole del gioco secodo la vesione Variante a perdere.  */
private static final String VARIANTE_PERDERE = "Variante a Perdere";

/** Attributo d'istanza che contine il tipo di regola selezionata.  */
private String tipoRegola;

/** Attributo d'istanza di controllo per verificare che la regola selezionata è corretta.  */
private boolean regolaEsatta = false;

 /**
* Costruttore della classe Regola
che inizializza il tipo di regola selezionata.

* @param regolaScelta String, il tipo di regola selezionata
*/
public Regola(final String regolaScelta) {
    if (regolaScelta.equals(CLASSICA)) {
        regolaEsatta = true;
    }
    if (regolaScelta.equals(THOMAS)) {
        regolaEsatta = true;
    }
    if (regolaScelta.equals(ASSIMILATION)) {
        regolaEsatta = true;
    }
    if (regolaScelta.equals(VARIANTE_PERDERE)) {
        regolaEsatta = true;
    }
    if (regolaEsatta) {
        this.tipoRegola = regolaScelta;
    } else {
        this.tipoRegola = CLASSICA;
    }
}

/**
* Metodo d'istanza get dell'attributo tipo tipo regola.
*
* @return tipoRegola String.
*/
public String getTipoRegola() {
    return tipoRegola;
}

/**
* Metodo d'istanza set dell'attributo tipo tipo regola.
*
* @param regolaScelta String.
*/
public void setTipoRegola(final String regolaScelta) {
    this.tipoRegola = regolaScelta;
}

/**
* Metodo d'istanza get dell'attributo regolaEsatta.
*
* @return regolaEsatta boolean,
*/
public boolean getRegolaEsatta() {
    return regolaEsatta;
}

/**
* Metodo d'istanza set dell'attributo regolaEsatta.
* @param newRegolaEsatta
*/
public void setRegolaEsatta(final boolean newRegolaEsatta) {
    this.regolaEsatta = newRegolaEsatta;
}

}
