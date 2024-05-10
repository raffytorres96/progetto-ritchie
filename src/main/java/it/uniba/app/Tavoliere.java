package it.uniba.app;
/**
 * <<Entity>>
 * Responsabilità: Descrive la griglia di gioco.
 */

 /**
 * Classe che si occupa di descrivere la griglia di gioco come
 * matrice di 49 celle. Sono state inserite delle costanti che
 * descrivono il nome di righe e colonne, insieme al loro
 * numero.
 *
 * @author GruppoRitchie
 */
public class Tavoliere
{
	 /**
   * Attributo statico che contiene l'etichetta delle colonne 
   * della griglia di gioco.
   */
    private static final char [] ETICHETTA_COLONNE = {'1','2','3','4','5','6','7'};
	 /**
   * Attributo statico che contiene l'etichetta delle righe
   * della griglia di gioco.
   */
    private static final String ETICHETTA_RIGHE = "   A  B  C  D  E  F  G";
	 /**
   * Attributo statico che contiene il numero di righe e colonne.
   */
    private static final short N_RIGHE_COLONNE = 7;
	 /**
   * Attributo che descrive il tavoliere come una matrice 7x7
   * di istanze di Cella (variabili tipo Cella).
   */
    public Cella [][] tavoliere = new Cella [N_RIGHE_COLONNE][N_RIGHE_COLONNE];
	 /**
   * Costruttore che inizializza la matrice tavoliere.
   */
    public Tavoliere(){
        for(int i=0;i<7;i++){
	        for(int j=0;j<7;j++){
                tavoliere[i][j]=new Cella();
	        }
	    }
    }
}
