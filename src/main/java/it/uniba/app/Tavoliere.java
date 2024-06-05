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
    /** attributo statico usato per mappare la prima colonna. */
    public static final int COLONNA0 = 0;

    /** attributo statico usato per mappare la seconda colonna . */
    public static final int COLONNA1 = 1;

    /** attributo statico usato per mappare la terza colonna. */
    public static final int COLONNA2 = 2;

    /** attributo statico usato per mappare la quarta colonna. */
    public static final int COLONNA3 = 3;

    /** attributo statico usato per mappare la quinta colonna. */
    public static final int COLONNA4 = 4;

    /** attributo statico usato per mappare la sesta colonna. */
    public static final int COLONNA5 = 5;

    /** attributo statico usato per mappare la settima colonna. */
    public static final int COLONNA6 = 6;

    /** attributo statico usato per mappare la prima riga. */
    public static final int RIGA0 = 0;

    /** attributo statico usato per mappare la seconda riga . */
    public static final int RIGA1 = 1;

    /** attributo statico usato per mappare la terza riga. */
    public static final int RIGA2 = 2;

    /** attributo statico usato per mappare la quarta riga. */
    public static final int RIGA3 = 3;

    /** attributo statico usato per mappare la quinta riga. */
    public static final int RIGA4 = 4;

    /** attributo statico usato per mappare la sesta riga. */
    public static final int RIGA5 = 5;

    /** attributo statico usato per mappare la settima riga. */
    public static final int RIGA6 = 6;
   /**
   * Attributo statico che contiene il numero di righe e colonne.
   */
    public static final short N_RIGHE_COLONNE = 7;
    /**
   * Attributo statico che contiene il numero massimo di celle bloccate.
   */
    public static final short MAX_CELLE_BLOCCATE = 9;
    /**
   * Attributo che conta le celle bloccate.
   */
    private int celleBloccate = 0;
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
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("EI")
    public Cella[][] getTavoliere() {
        Cella[][] tav = tavoliere;
        return tav;
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
 * Metodo restituisce il numero di celle bloccate nel tavoliere.
 * @return numero di celle bloccate
 */
    public int getCelleBloccate() {
        return this.celleBloccate;
    }

/**
 * Metodo incrementa di 1 il contatore delle celle bloccate nel tavoliere.
 */
public void addCelleBloccate() {
    this.celleBloccate += 1;
}

/**
 * Metodo che conta le pedine del giocatore corrente nel Tavoliere.
 * @param t tavoliere da inizializzare per l'inizio di una nuova partita
 * @return t tavoliere inizializzato
 */
    public Tavoliere inizializzaTavolierePartita(final Tavoliere t) {
        t.setTavoliere(RIGA0, COLONNA0, Giocatore.GIOCATORE1);
        t.setTavoliere(RIGA6, COLONNA6, Giocatore.GIOCATORE1);
        t.setTavoliere(RIGA0, COLONNA6, Giocatore.GIOCATORE2);
        t.setTavoliere(RIGA6, COLONNA0, Giocatore.GIOCATORE2);
        return t;
    }
    /**
 * Metodo che verifica la fattibilità dell'inserimento di un blocco nel
 * quadrante nord ovest (righe 1 e 2, colonne A e B) attorno all'angolo.
 * @param t tavoliere di gioco
 * @return boolean, vero se è fattibile
 */
public boolean checkBloccoNWvicino(final Tavoliere t) {
    final int maxBLOCCATE = 2;
    int contaBloccate = 0;
    if (Cella.getStato(t.getCella(RIGA0, COLONNA1)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA1, COLONNA0)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA1, COLONNA1)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (contaBloccate < maxBLOCCATE) {
        return true;
    }
    return false;
}
    /**
 * Metodo che verifica la fattibilità dell'inserimento di un blocco nel
 * quadrante nord est (righe 1 e 2, colonne F e G) attorno all'angolo.
 * @param t tavoliere di gioco
 * @return boolean, vero se è fattibile
 */
public boolean checkBloccoNEvicino(final Tavoliere t) {
    final int maxBLOCCATE = 2;
    int contaBloccate = 0;
    if (Cella.getStato(t.getCella(RIGA0, COLONNA5)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA1, COLONNA5)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA1, COLONNA6)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (contaBloccate < maxBLOCCATE) {
        return true;
    }
    return false;
}
    /**
 * Metodo che verifica la fattibilità dell'inserimento di un blocco nel
 * quadrante sud ovest (righe 5 e 6, colonne A e B) attorno all'angolo.
 * @param t tavoliere di gioco
 * @return boolean, vero se è fattibile
 */
public boolean checkBloccoSWvicino(final Tavoliere t) {
    final int maxBLOCCATE = 2;
    int contaBloccate = 0;
    if (Cella.getStato(t.getCella(RIGA5, COLONNA0)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA5, COLONNA1)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA6, COLONNA1)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (contaBloccate < maxBLOCCATE) {
        return true;
    }
    return false;
}
    /**
 * Metodo che verifica la fattibilità dell'inserimento di un blocco nel
 * quadrante sud est (righe 5 e 6, colonne F e G) attorno all'angolo.
 * @param t tavoliere di gioco
 * @return boolean, vero se è fattibile
 */
public boolean checkBloccoSEvicino(final Tavoliere t) {
    final int maxBLOCCATE = 2;
    int contaBloccate = 0;
    if (Cella.getStato(t.getCella(RIGA5, COLONNA5)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA5, COLONNA6)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA6, COLONNA5)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (contaBloccate < maxBLOCCATE) {
        return true;
    }
    return false;
}
/**
 * Metodo che verifica la fattibilità dell'inserimento di un blocco nel
 * quadrante nord ovest (righe 1, 2 e 3, colonne A, B e C) lontano una casella
 * dall'angolo del tavoliere.
 * @param t tavoliere di gioco
 * @return boolean, vero se è fattibile
 */
public boolean checkBloccoNWlontano(final Tavoliere t) {
    final int maxBLOCCATE = 4;
    int contaBloccate = 0;
    if (Cella.getStato(t.getCella(RIGA0, COLONNA2)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA1, COLONNA2)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA2, COLONNA2)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA2, COLONNA1)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA2, COLONNA0)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (contaBloccate < maxBLOCCATE) {
        return true;
    }
    return false;
}
/**
 * Metodo che verifica la fattibilità dell'inserimento di un blocco nel
 * quadrante nord est (righe 1, 2 e 3, colonne E, F e G) lontano una casella
 * dall'angolo del tavoliere.
 * @param t tavoliere di gioco
 * @return boolean, vero se è fattibile
 */
public boolean checkBloccoNElontano(final Tavoliere t) {
    final int maxBLOCCATE = 4;
    int contaBloccate = 0;
    if (Cella.getStato(t.getCella(RIGA0, COLONNA4)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA1, COLONNA4)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA2, COLONNA4)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA2, COLONNA5)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA2, COLONNA6)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (contaBloccate < maxBLOCCATE) {
        return true;
    }
    return false;
}
/**
 * Metodo che verifica la fattibilità dell'inserimento di un blocco nel
 * quadrante sud ovest (righe 5, 6 e 7, colonne A, B e C) lontano una casella
 * dall'angolo del tavoliere.
 * @param t tavoliere di gioco
 * @return boolean, vero se è fattibile
 */
public boolean checkBloccoSWlontano(final Tavoliere t) {
    final int maxBLOCCATE = 4;
    int contaBloccate = 0;
    if (Cella.getStato(t.getCella(RIGA4, COLONNA0)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA4, COLONNA1)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA4, COLONNA2)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA5, COLONNA2)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA6, COLONNA2)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (contaBloccate < maxBLOCCATE) {
        return true;
    }
    return false;
}
/**
 * Metodo che verifica la fattibilità dell'inserimento di un blocco nel
 * quadrante sud est (righe 5, 6 e 7, colonne E, F e G) lontano una casella
 * dall'angolo del tavoliere.
 * @param t tavoliere di gioco
 * @return boolean, vero se è fattibile
 */
public boolean checkBloccoSElontano(final Tavoliere t) {
    final int maxBLOCCATE = 4;
    int contaBloccate = 0;
    if (Cella.getStato(t.getCella(RIGA4, COLONNA4)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA4, COLONNA5)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA4, COLONNA6)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA5, COLONNA4)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (Cella.getStato(t.getCella(RIGA6, COLONNA4)) == Cella.STATO_CELLA_BLOCCATA) {
        contaBloccate += 1;
    }
    if (contaBloccate < maxBLOCCATE) {
        return true;
    }
    return false;
}
}
