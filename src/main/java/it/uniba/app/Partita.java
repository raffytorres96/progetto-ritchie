/**
 *  <<Entity>>
 *  Responsabilità: Modella l'entità Partita
 *  del gioco.
 */
package it.uniba.app;
/**
 * Classe che modella Partita.
 *
 * @author GruppoRitchie
 */
public class Partita {

/** attributo che indica se il gioco è finito o meno.  */
private boolean giocoFinito = false;

/** attributo che rappresenta la regola del gioco.  */
private Regola regola;

/** attributo che rappresenta il tavoliere del gioco.  */
private Tavoliere tavoliere;

/** attributo che rappresenta il giocatore1.  */
private Giocatore giocatore1;

/** attributo che rappresenta il giocatore2.  */
private Giocatore giocatore2;

/** attributo che imposta la partita a false non chimato il cotruttore dipartita.  */
private boolean partitaIniziata = false;

/** attributo che rappresenta il giocatore corrente.  */
private int giocatoreCorrente;


/**
 * Costruttore della classe Partita.
 * @param regolaGioco
 * @param nome1
 * @param nome2
 */
public Partita(final String regolaGioco, final String nome1, final String nome2) {

this.partitaIniziata = true;
this.giocatoreCorrente = Giocatore.GIOCATORE1;
this.tavoliere = new Tavoliere();
this.tavoliere = this.tavoliere.inizializzaTavolierePartita(this.tavoliere);
this.regola = new Regola(regolaGioco);
this.giocatore1 = new Giocatore(nome1, Giocatore.GIOCATORE1);
this.giocatore2 = new Giocatore(nome2, Giocatore.GIOCATORE2);
}


/**
 * Metodo per il controllo dei comandi in partita. */
public void controlloPartita() {
    Utils utils = new Utils();
    GestoreStampa.stampareMessaggio("Al momento è possibile utilizzare come comando in partita"
        + " solo /qualiMosse.\n\n");
    GestoreStampa.stampareMessaggio("Oppure puoi usare"
        + GestoreStampa.ANSI_BLUE + " '/Abbandona' " + GestoreStampa.ANSI_RESET + "per abbandonare la partita\n");
    GestoreStampa.stampareMessaggio("Oppure puoi usare"
        + GestoreStampa.ANSI_RED + " '/Esci' " + GestoreStampa.ANSI_RESET + "per uscire dal gioco\n\n");
    GestoreStampa.stampareMessaggio("Inserisci un comando: ");
    do {
        Mossa mossa = new Mossa(getTavoliere(), getGiocatoreCorrente());
        String input = Comandi.input();
        int colonna;
        int riga;
        if (input.equals("/qualimosse")) {
            do {
                GestoreStampa.stampareMessaggio("inserisci la colonna: ");
                 colonna = utils.mappingColonne(Comandi.input());
                 if (colonna == -1) {
                    GestoreStampa.stampareMessaggio("\nInserisci una lettera valida tra A e G\n");
                    GestoreStampa.stampareMessaggio("solo lettere sono accettate.\n\n ");
                }
            } while (colonna == -1);

            do {

            GestoreStampa.stampareMessaggio("inserisci la riga: ");
            riga = utils.mappingRighe(Comandi.input());
            GestoreStampa.stampareMessaggio("\nInserisci una cifra valida tra 1 e 7\n");
            GestoreStampa.stampareMessaggio("Solo le cifre sono accettate.\n\n ");

        } while (riga == -1);

            mossa.qualiMosse(getGiocatoreCorrente(), riga, colonna);
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "\nInserisci un comando: ");
        } else if (input.equals("/abbandona")) {
            Comandi.abbandona(this);
        } else if (input.equals("/esci")) {
            Comandi.esci();
        } else if (!input.startsWith("/")) {
            Utils.analizzatoreInputCoordinate(input);
        } else {
            GestoreStampa.stampareMessaggio("Comando non utilizzabile in partita\n\n");
        }




    } while (true);

}
    /**
    * Metodo che restituisce il giocatore1.
    */
    public Giocatore getGiocatore1() {
        return this.giocatore1;
    }
    /**
    * Metodo che restituisce il giocatore2.
    */
    public Giocatore getGiocatore2() {
        return this.giocatore2;
    }
   /**
    * Metodo che restituisce il tavoliere.
    */
    public Tavoliere getTavoliere() {
        return this.tavoliere;
    }
    /**
    * Metodo che setta il tavoliere.
    * @param riga
    * @param colonna
    * @param stato
    */
    public void setTavoliere(final int riga, final int colonna, final int stato) {
        this.tavoliere.setTavoliere(riga, colonna, stato);
    }
    /**
    * Metodo che restituisce la regola.
    * @return
    */
    public Regola getRegola() {
        return this.regola;
    }
    /**
    * Metodo che restituisce se il gioco è finito o meno.
    * @return
     */
    public boolean isGiocoFinito() {
        return this.giocoFinito;

    }
    /**
    * Metodo che setta se il gioco è finito o meno.
    * @param isGiocoFinito
    */
    public void setGiocoFinito(final boolean isGiocoFinito) {
        this.giocoFinito = isGiocoFinito;
    }
    /**
    * Metodo che restituisce se l apartita è iniziata oppure no.
    * @return
    */
    public boolean isPartitaIniziata() {
        return this.partitaIniziata;
    }

    /**
    * Metodo che setta l'attributo partita iniziata.
    * @param newpartitaIniziata
    */
    public void setPartitaIniziata(final boolean newpartitaIniziata) {
        this.partitaIniziata = newpartitaIniziata;
    }

    /**
    * Metodo che restituisce il giorcatore corente.
    * @return
    */
    public int getGiocatoreCorrente() {
        return this.giocatoreCorrente;
    }

    /**
    * Metodo che setta il giocatore corrente.
    * @param newgiocatoreCorrente
    */
    public void setGiocatoreCorrente(final int newgiocatoreCorrente) {
        this.giocatoreCorrente = newgiocatoreCorrente;
    }


}


