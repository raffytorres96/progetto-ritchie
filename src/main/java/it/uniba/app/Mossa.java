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
     * Attributo statico che rappresenta la cella
     * su cui è possibile fare una mossa di tipo
     * generativa.
     */
    public static final int GIALLO = 3;

    /**
     * Attributo statico che rappresenta la cella
     * su cui è possibile fare una mossa di tipo
     * spostamento.
     */
    public static final int ARANCIONE = 4;


    /**
     * Costruttore che inizializza la mossa.
     *
     * @param tavoliereCorrente
     * @param newGiocatoreCorrente
     */
    Mossa(final Tavoliere tavoliereCorrente, final int newGiocatoreCorrente) {

        this.tavoliere = tavoliereCorrente;
        this.giocatoreCorrente = newGiocatoreCorrente;
        }
        /**
         * Metodo che restituisce le mosse possibili sulla cella scelta.
         * @param newgiocatoreCorrente
         * @param rigaSelezionata
         * @param colonnaSelezionata
         */
        public void qualiMosse(final int newgiocatoreCorrente, final int rigaSelezionata,
         final int colonnaSelezionata) {

          if (newgiocatoreCorrente == 1) {
            puliziaTavoliere();
            if (Cella.getStato(tavoliere.getCella(rigaSelezionata, colonnaSelezionata)) == 1) {
                        visualizzaMossePossibili(rigaSelezionata, colonnaSelezionata, tavoliere, newgiocatoreCorrente);
                    }
                }


          if (newgiocatoreCorrente == 2) {
              puliziaTavoliere();
              if (Cella.getStato(tavoliere.getCella(rigaSelezionata, colonnaSelezionata)) == 2) {
                        visualizzaMossePossibili(rigaSelezionata, colonnaSelezionata, tavoliere, newgiocatoreCorrente);
              }
          }
         GestoreStampa.stampareTavoliere(this.tavoliere);

        }


            /**
             * Metodo privato che effettua un controllo se la riga e la colanna selazionata
             * non siano cordinate che non rientrano nelle dimandione del tavoliere
             * e se il contorllo passa setta su quali celle è possibile effettuare
             * una mossa generativa o di spostamento sulla base della cella scelta.
             * @param rigaSelezionata
             * @param colonnaSelezionata
             * @param tavoliereCorrente
             * @param newgiocatoreCorrente
             */
            private void visualizzaMossePossibili(final int rigaSelezionata, final int colonnaSelezionata,
             final Tavoliere tavoliereCorrente, final int newgiocatoreCorrente) {

                if (rigaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata  + 1 < Tavoliere.N_RIGHE_COLONNE && rigaSelezionata + 1 > 0
                 && colonnaSelezionata + 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata + 1,
                    Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata  - 1 < Tavoliere.N_RIGHE_COLONNE && rigaSelezionata - 1 > 0
                 && colonnaSelezionata - 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata - 1,
                    Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata < Tavoliere.N_RIGHE_COLONNE && rigaSelezionata - 1 > 0
                 && colonnaSelezionata > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata,
                     Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && rigaSelezionata > 0
                 && colonnaSelezionata - 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata - 1,
                     Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata < Tavoliere.N_RIGHE_COLONNE && rigaSelezionata + 1 > 0
                 && colonnaSelezionata > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata,
                     Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && rigaSelezionata > 0
                 && colonnaSelezionata + 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata + 1,
                     Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && rigaSelezionata + 1 > 0
                 && colonnaSelezionata - 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata - 1,
                     Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && rigaSelezionata - 1 > 0
                 && colonnaSelezionata + 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 1,
                     colonnaSelezionata + 1,  Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata + 2 > 0 && colonnaSelezionata + 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata + 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata - 2 > 0 && colonnaSelezionata - 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata - 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata - 2 > 0 && colonnaSelezionata > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata > 0 && colonnaSelezionata - 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata - 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata + 2 > 0 && colonnaSelezionata > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata > 0 && colonnaSelezionata + 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata + 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata + 2 > 0 && colonnaSelezionata - 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata - 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata - 2 > 0 && colonnaSelezionata + 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata + 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata + 2 > 0 && colonnaSelezionata + 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata + 1,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata + 2 > 0 && colonnaSelezionata - 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata - 1,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata - 2 > 0 && colonnaSelezionata + 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata + 1,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata - 2 > 0 && colonnaSelezionata - 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata - 1,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata + 1 > 0 && colonnaSelezionata + 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata + 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata + 1 > 0 && colonnaSelezionata - 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata - 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata - 1 > 0 && colonnaSelezionata + 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata + 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE
                 && rigaSelezionata - 1 > 0 && colonnaSelezionata - 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata - 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }
            }
            /**
             * Metodo privato che pulisce il tavoliere
             * dalle mosse possibili.
             */
            private void puliziaTavoliere() {
                for (int i = 0; i < Tavoliere.N_RIGHE_COLONNE; i++) {
                    for (int j = 0; j < Tavoliere.N_RIGHE_COLONNE; j++) {
                        if (Cella.getStato(tavoliere.getCella(i, j)) == Cella.STATO_CELLA_GIALLA
                        || Cella.getStato(tavoliere.getCella(i, j)) == Cella.STATO_CELLA_ARANCIONE) {

                            tavoliere.setTavoliere(i, j, Cella.STATO_CELLA_VUOTA);
                        }
                    }
                }
            }
/**
    * Metodo che restituisce la riga.
    *
    * @return riga
    */
    public int getRiga() {
      return riga;

   }

/**
    * Metodo che restituisce la colonna.
    *
    * @return colonna
    */
    public int getColonna() {
      return colonna;
   }

    /**
    * Metodo che restituisce il tavoliere.
    *
    * @return tavoliere
    */
    public Tavoliere getTavoliere() {
      return tavoliere;
   }

   /**
    * Metodo che restituisce al stato del giocatore corrente.
    *
    * @return giocatoreCorrente
    */
    public int getGiocatoreCorrente() {
      return giocatoreCorrente;
   }
 /**
    * Metodo che setta l'attributo riga.
    *
    * @param newRiga
    */
   public void setRiga(final int newRiga) {
      this.riga = newRiga;
   }
 /**
    * Metodo che setta l'attributo colonne.
    *
    * @param newColonna
    */
   public void setColonna(final int newColonna) {
      this.colonna = newColonna;
   }
 /**
    * Metodo che setta il tavoliere passato a mossa.
    *
    * @param newTavoliere
    */
   public void setTavoliere(final Tavoliere newTavoliere) {
      this.tavoliere = newTavoliere;
   }
 /**
    * Metodo che setta lo stato del giocatore corrente.
    *
    * @param newGiocatoreCorrente
    */
   public void setGiocatoreCorrente(final int newGiocatoreCorrente) {
      this.giocatoreCorrente = newGiocatoreCorrente;


 }
}










