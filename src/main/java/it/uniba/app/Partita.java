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

/** Variabile statica per ritardare l'uscita dalla partita.  */
public static final int TIME = 2000;


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
public void controlloPartita(final Mossa mossa) {

    boolean continua = true;
    GestoreStampa.stampareMessaggio("\n\nAl momento è possibile utilizzare come comando in partita"
        + " solo /qualiMosse.\n\n");
    GestoreStampa.stampareMessaggio("Oppure puoi usare"
        + GestoreStampa.ANSI_BLUE + " '/Abbandona' " + GestoreStampa.ANSI_RESET + "per abbandonare la partita\n");
    GestoreStampa.stampareMessaggio("Oppure puoi usare"
        + GestoreStampa.ANSI_RED + " '/Esci' " + GestoreStampa.ANSI_RESET + "per uscire dal gioco\n\n");
    GestoreStampa.stampareMessaggio("Inserisci un comando: ");
    do {
        String input = Comandi.input();
        if (input.equals("/qualimosse")) {
            mossa.qualiMosse(getGiocatoreCorrente());
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "\nInserisci un comando: ");
        } else if (input.equals("/abbandona")) {
            continua = !Comandi.abbandona(this);
            if (!continua) {
                try {
                    Thread.sleep(TIME); // Ritarda l'esecuzione per 2 secondi
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "\nInserisci un comando: ");
            }

        } else if (input.equals("/esci")) {
            Comandi.esci();
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "\nInserisci un comando: ");
        } else if (input.equals("/help") || input.equals("-h") || input.equals("--help")) {
            Comandi.help();
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "\nInserisci un comando: ");


        } else if (input.equals("/tavoliere")) {
            GestoreStampa.clearTerminale();
            GestoreStampa.stampareTitoloGioco();
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET
            + " Questo è il tavoliere della partita, fai la tua mossa !\n\n");
            Comandi.comandoTavoliere(this.getTavoliere());
            do {
                GestoreStampa.stampareMessaggio("\nSe hai visualizzato il tavoliere digita 'ok'"
                + " per continuare. \n\n");
                GestoreStampa.stampareMessaggio("Inserisci un comando: ");
                input = Comandi.input();
                if (!input.equals("ok")) {
                   GestoreStampa.stampareMessaggio("Comando non valido\n\n");
                }
                } while (!input.equals("ok"));
                GestoreStampa.clearTerminale();
                GestoreStampa.stampareTitoloGioco();
                GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE + "\nBenvenuti in ATAXX: "
                + GestoreStampa.ANSI_RESET + " Hai iniziato una nuova partita, DIVERTITI !\n\n");
                Comandi.comandoTavoliere(this.getTavoliere());
                GestoreStampa.stampareMessaggio("\n\nAl momento è possibile utilizzare come comando in partita"
                      + " solo /qualiMosse e /tavoliere.\n\n");
                GestoreStampa.stampareMessaggio("Oppure puoi usare" + GestoreStampa.ANSI_BLUE + " '/Abbandona' "
                      + GestoreStampa.ANSI_RESET + "per abbandonare la partita\n");
                GestoreStampa.stampareMessaggio("Oppure puoi usare" + GestoreStampa.ANSI_RED + " '/Esci' "
                      + GestoreStampa.ANSI_RESET + "per uscire dal gioco\n\n");
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "\nInserisci un comando: ");

        } else {
            GestoreStampa.stampareMessaggio("Comando non utilizzabile in partita\n\n");
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "Inserisci un comando: ");
        }

    } while (continua);

}
    /**
    * Metodo che restituisce il giocatore1.
    */
    public String getGiocatore1() {
        return giocatore1.getNome();
    }
    /**
    * Metodo che restituisce il giocatore2.
    */
    public String getGiocatore2() {
        return giocatore2.getNome();
    }
   /**
    * Metodo che restituisce il tavoliere.
    */
    public Tavoliere getTavoliere() {
        return tavoliere;
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
    public String getRegola() {
        return regola.getTipoRegola();
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


