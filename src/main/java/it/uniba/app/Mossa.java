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
     * @param rigaSelezionata
     * @param colonnaSelezionata
     * @param tavoliereCorrente
     * @param newGiocatoreCorrente
     */
    Mossa(final int rigaSelezionata, final int colonnaSelezionata,
          final Tavoliere tavoliereCorrente, final int newGiocatoreCorrente) {

        this.riga = rigaSelezionata;
        this.colonna = colonnaSelezionata;
        this.tavoliere = tavoliereCorrente;
        this.giocatoreCorrente = newGiocatoreCorrente;
        }
        /**
         * Metodo che restituisce le mosse possibili.
         * @param newgiocatoreCorrente
         */
        public void qualiMosse(final int newgiocatoreCorrente) {

                if (newgiocatoreCorrente == 1) {
                    puliziaTavoliere();
                    for (int i = 0; i < SIZE; i++) {
                        for (int j = 0; j < SIZE; j++) {
                            if (Cella.getStato(tavoliere.getCella(i, j)) == 1) {
                                visualizzaMossePossibili(i, j, tavoliere, newgiocatoreCorrente);
                            }
                        }
                    }
                }
                if (newgiocatoreCorrente == 2) {
                    puliziaTavoliere();
                    for (int i = 0; i < SIZE; i++) {
                        for (int j = 0; j < SIZE; j++) {
                            if (Cella.getStato(tavoliere.getCella(i, j)) == 1) {
                                visualizzaMossePossibili(i, j, tavoliere, newgiocatoreCorrente);
                            }
                        }
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

                if (rigaSelezionata + 1 < SIZE && colonnaSelezionata  + 1 < SIZE && rigaSelezionata + 1 > 0
                 && colonnaSelezionata + 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata + 1,
                    Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata - 1 < SIZE && colonnaSelezionata  - 1 < SIZE && rigaSelezionata - 1 > 0
                 && colonnaSelezionata - 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata - 1,
                    Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata - 1 < SIZE && colonnaSelezionata < SIZE && rigaSelezionata - 1 > 0
                 && colonnaSelezionata > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata,
                     Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata < SIZE && colonnaSelezionata - 1 < SIZE && rigaSelezionata > 0
                 && colonnaSelezionata - 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata - 1,
                     Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata + 1 < SIZE && colonnaSelezionata < SIZE && rigaSelezionata + 1 > 0
                 && colonnaSelezionata > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata,
                     Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata < SIZE && colonnaSelezionata + 1 < SIZE && rigaSelezionata > 0
                 && colonnaSelezionata + 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata + 1,
                     Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata + 1 < SIZE && colonnaSelezionata - 1 < SIZE && rigaSelezionata + 1 > 0
                 && colonnaSelezionata - 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata - 1,
                     Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata - 1 < SIZE && colonnaSelezionata + 1 < SIZE && rigaSelezionata - 1 > 0
                 && colonnaSelezionata + 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 1,
                     colonnaSelezionata + 1,  Cella.STATO_CELLA_GIALLA);
                }

                if (rigaSelezionata + 2 < SIZE && colonnaSelezionata + 2 < SIZE
                 && rigaSelezionata + 2 > 0 && colonnaSelezionata + 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata + 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 2 < SIZE && colonnaSelezionata - 2 < SIZE
                 && rigaSelezionata - 2 > 0 && colonnaSelezionata - 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata - 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 2 < SIZE && colonnaSelezionata < SIZE
                 && rigaSelezionata - 2 > 0 && colonnaSelezionata > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata < SIZE && colonnaSelezionata - 2 < SIZE
                 && rigaSelezionata > 0 && colonnaSelezionata - 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata - 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 2 < SIZE && colonnaSelezionata < SIZE
                 && rigaSelezionata + 2 > 0 && colonnaSelezionata > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata < SIZE && colonnaSelezionata + 2 < SIZE
                 && rigaSelezionata > 0 && colonnaSelezionata + 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata + 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 2 < SIZE && colonnaSelezionata - 2 < SIZE
                 && rigaSelezionata + 2 > 0 && colonnaSelezionata - 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata - 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 2 < SIZE && colonnaSelezionata + 2 < SIZE
                 && rigaSelezionata - 2 > 0 && colonnaSelezionata + 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata + 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 2 < SIZE && colonnaSelezionata + 1 < SIZE
                 && rigaSelezionata + 2 > 0 && colonnaSelezionata + 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata + 1,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 2 < SIZE && colonnaSelezionata - 1 < SIZE
                 && rigaSelezionata + 2 > 0 && colonnaSelezionata - 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata - 1,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 2 < SIZE && colonnaSelezionata + 1 < SIZE
                 && rigaSelezionata - 2 > 0 && colonnaSelezionata + 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata + 1,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 2 < SIZE && colonnaSelezionata - 1 < SIZE
                 && rigaSelezionata - 2 > 0 && colonnaSelezionata - 1 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata - 1,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 1 < SIZE && colonnaSelezionata + 2 < SIZE
                 && rigaSelezionata + 1 > 0 && colonnaSelezionata + 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata + 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata + 1 < SIZE && colonnaSelezionata - 2 < SIZE
                 && rigaSelezionata + 1 > 0 && colonnaSelezionata - 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata - 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 1 < SIZE && colonnaSelezionata + 2 < SIZE
                 && rigaSelezionata - 1 > 0 && colonnaSelezionata + 2 > 0) {
                    tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata + 2,
                      Cella.STATO_CELLA_ARANCIONE);
                }

                if (rigaSelezionata - 1 < SIZE && colonnaSelezionata - 2 < SIZE
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
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (Cella.getStato(tavoliere.getCella(i, j)) == Cella.STATO_CELLA_GIALLA
                        || Cella.getStato(tavoliere.getCella(i, j)) == Cella.STATO_CELLA_ARANCIONE) {

                            tavoliere.setTavoliere(i, j, Cella.STATO_CELLA_VUOTA);
                        }
                    }
                }

    }
}



