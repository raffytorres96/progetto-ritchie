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

    /**
	* Costruttore della classe Regola 
	  che inizializza il tipo di regola selezionata.
	
	* @param tipoRegola String, il tipo di regola selezionata
	*/
	public Regola(String tipoRegola) {
		
		if (tipoRegola.equals(CLASSICA)) {
			regolaEsatta=true;
		}
			
		
		if (tipoRegola.equals(THOMAS)) {
			regolaEsatta=true;
		}
				
		
		if (tipoRegola.equals(ASSIMILATION)) {
			regolaEsatta=true;
		}
				
		
		if (tipoRegola.equals(VARIANTE_PERDERE)) {
			regolaEsatta=true;
		}
		
		if (regolaEsatta) {
			this.tipoRegola = tipoRegola;
		}else {
			this.tipoRegola = CLASSICA;
		}
		
			
	}
   
	/**
    * Metodo d'istanza get dell'attributo tipo tipo regola.
    *
    * @return tipoRegola String, 
    */
    public String getTipoRegola() {
		return tipoRegola;
	}

	/**
	* Metodo d'istanza set dell'attributo tipo tipo regola.
	*
	* @param tipoRegola String, 
	*/
	public void setTipoRegola(String tipoRegola) {
		this.tipoRegola = tipoRegola;
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
	 * @param regolaEsatta
	 */
	public void setRegolaEsatta(boolean regolaEsatta) {
		this.regolaEsatta = regolaEsatta;
	}
    
}
