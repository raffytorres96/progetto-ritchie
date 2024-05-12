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
     /**
   * Metodo che restituisce l'intera matrice tavoliere.
   * @return tavoliere
   */
    public Cella[][] getTavoliere(){
        return tavoliere;
    }
     /**
   * Metodo che scrive l'attributo stato della cella individuata dai parametri
   * riga e colonna nella matrice tavoliere
   * @param riga
   * @param colonna
   * @param stato
   * @return restituisce true se lo stato viene modificato correttamente.
   */
    public boolean setTavoliere(int riga, int colonna, int stato){
        tavoliere[riga][colonna].setStato(stato);
        return true;
    }
}
