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
    
    /** Attributo di classe per identificare le regole classiche del gioco  */
	private final static String CLASSICA="Classica";
	
	/** Attributo di classe per identificare le regole del gioco secodo la vesione Thomas  */
	private final static String THOMAS="Thomas";
	
	/** Attributo di classe per identificare le regole del gioco secodo la vesione Assimilation  */
	private final static String ASSIMILATION="Assimilation";
	
	/** Attributo di classe per identificare le regole del gioco secodo la vesione Variante a perdere  */
	private final static String VARIANTE_PERDERE="Variante a Perdere";
	
	/** Attributo d'istanza che contine il tipo di regola selezionata  */
	private String tipoRegola;
	
	/** Attributo d'istanza di controllo per verificare che la regola selezionata è corretta  */
	private boolean regolaEsatta=false;
    
}
