package it.uniba.app;
/**
 * <<Entity>>
 * Responsabilità: Descrive la griglia di gioco.
 *
 * Classe che si occupa di descrivere la griglia di gioco come
 * matrice di 49 celle. Sono state inserite delle costanti che
 * descrivono il nome di righe e colonne, insieme al loro
 * numero.
 *
 * @author GruppoRitchie
 */
public class Tavoliere {
   /**
   * Attributo statico che contiene il numero di righe e colonne.
   */
    private static final short N_RIGHE_COLONNE = 7;
   /**
   * Attributo che descrive il tavoliere come una matrice 7x7
   * di istanze di Cella (variabili tipo Cella).
   */
    private Cella[][] tavoliere = new Cella[N_RIGHE_COLONNE][N_RIGHE_COLONNE];
   /**
   * Costruttore che inizializza la matrice tavoliere.
   */
    public Tavoliere() {
        for (int i = 0; i < N_RIGHE_COLONNE; i++) {
            for (int j = 0; j < N_RIGHE_COLONNE; j++) {
                tavoliere[i][j] = new Cella();
            }
        }
    }
     /**
   * Metodo d'accesso al tavoliere, restituisce lintera griglia di gioco.
   * @return tavoliere intera matrice di celle
   */
    public Cella[][] getTavoliere() {
        return tavoliere;
    }
     /**
   * Metodo d'accesso al tavoliere, modifica un attributo di una specifica
   * cella.
   * @param riga indice della riga della matrice tavoliere
   * @param colonna indice della colonna della matrice tavoliere
   * @param stato stato da scrivere nella cella del tavoliere selezionata
   * @return boolean restituisce true se il metodo viene eseguito senza problemi
   */
    public boolean setTavoliere(final int riga, final int colonna, final int stato) {
        tavoliere[riga][colonna].setStato(stato);
        return true;
    }
    /**
   * Metodo d'accesso al tavoliere, restituisce una specifica cella.
   * @param riga
   * @param colonna
   * @return cella
   */
    public Cella getCella(final int riga, final int colonna) {
        Cella cella = tavoliere[riga][colonna];
        return cella;
    }

/**
 * Metodo che conta le pedine del giocatore corrente nel Tavoliere.
 * @param giocatoreCorrente
 * @return
 */
    public int getContaPedine(final int giocatoreCorrente) {
        int contaPedine = 0;
        for (int i = 0; i < N_RIGHE_COLONNE; i++) {
            for (int j = 0; j < N_RIGHE_COLONNE; j++) {
                if (Cella.getStato(getCella(i, j)) == giocatoreCorrente) {
                    contaPedine++;
                }
            }

        }
        return contaPedine;
    }

/**
 * Metodo che conta le pedine del giocatore corrente nel Tavoliere.
 * @param t tavoliere da inizializzare per l'inizio di una nuova partita
 * @return t tavoliere inizializzato
 */
    public Tavoliere inizializzaTavolierePartita (Tavoliere t){
        t.setTavoliere(POSIZIONE0, POSIZIONE0, GIOCATORE1);
        t.setTavoliere(POSIZIONE6, POSIZIONE6, GIOCATORE1);
        t.setTavoliere(POSIZIONE0, POSIZIONE6, GIOCATORE2);
        t.setTavoliere(POSIZIONE6, POSIZIONE0, GIOCATORE2);
        return t;
    }

}
