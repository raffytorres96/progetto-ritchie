/**
 *  <<Entity>>
 *  Responsabilità: Modella l'entità Partita
 *  del gioco.
 */
package it.uniba.app;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


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
private static Giocatore giocatore1;

/** attributo che rappresenta il giocatore2.  */
private static Giocatore giocatore2;

/** attributo che imposta la partita a false non chimato il cotruttore dipartita.  */
private boolean partitaIniziata = false;

/** attributo che rappresenta il giocatore corrente.  */
private int giocatoreCorrente;

/** attributo che memorizza lo storico delle mosse effettuate.  */
private static List<String> storicoMosse = new ArrayList<String>();

/** attributo contatore dei turni di gioco.  */
private int turno = 1;

/** Variabile statica per ritardare l'uscita dalla partita.  */
public static final int TIME = 2800;

/** Variabile statica per mantenerete per 3.2 secondi l'uscita dei messaggi
 * di erroe quando si cerca di fare una mossa non lecita.  */
public static final int TIME2 = 3200;

/**
Variabile statica per mantenerete per 3 secondi l'uscita dei messaggi
*di erroe LUNGHI quando si cerca di fare una mossa non lecita.  */
public static final int TIME3 = 3000;
/**
 * Variabile statica per mantenerete per 5 secondi l'uscita
 * del tavoliere con le mosse possibili.
 */
public static final int TIME4 = 5000;

// Variabile privata per memorizzare l'ora di inizio della partita
private static long oraInizio;
/**
 * Costruttore della classe Partita.
 * @param regolaGioco
 * @param nome1
 * @param nome2
 */
public Partita(final String regolaGioco, final Tavoliere t, final String nome1, final String nome2) {

this.partitaIniziata = true;
this.giocatoreCorrente = Giocatore.GIOCATORE1;
tavoliere = t;
this.regola = new Regola(regolaGioco);
Partita.giocatore1 = new Giocatore(nome1, Giocatore.GIOCATORE1);
Partita.giocatore2 = new Giocatore(nome2, Giocatore.GIOCATORE2);
oraInizio = System.currentTimeMillis();
}


/**
 * Metodo per il controllo dei comandi in partita. */
public void controlloPartita(final Mossa mossa) {
    boolean continua = true;
    do {
        String input = Comandi.input();
        if (input.equals("/qualimosse")) {
            mossa.qualiMosse(getGiocatoreCorrente());
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "\nInserisci un comando: ");
        } else if (input.equals("/abbandona")) {
            continua = !Comandi.abbandona(this);
            resetTavoliere(this.tavoliere);
            if (!continua) {
                try {
                    Thread.sleep(TIME2); // Ritarda l'esecuzione per 2 secondi
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "\nInserisci un comando: ");
            }

        } else if (input.equals("/esci")) {
            Comandi.esci();
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "\nInserisci un comando: ");
        } else if (input.equals("/help") || input.equals("-h") || input.equals("--help")) {
            GestoreStampa.clearTerminale();
            do {
                Comandi.help();
                GestoreStampa.stampareMessaggio("\n\nPremere comando 'ok', per ritornare in partita\n\n ");
                GestoreStampa.stampareMessaggio("Inserisci un comando: ");
                input = Comandi.input();
                if (!input.equals("ok")) {
                   GestoreStampa.stampareMessaggio("Non hai inserito correttamente 'ok'.\n\n");
                }
                } while (!input.equals("ok"));
                GestoreStampa.stampareMessaggioInGioco(this.giocatoreCorrente, this.tavoliere,
                 "Hai iniziato una nuova partita, DIVERTITI !", false, input);

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
            GestoreStampa.stampareMessaggioInGioco(this.giocatoreCorrente, this.tavoliere,
            "Hai iniziato una nuova partita, DIVERTITI !", false, input);
        } else if (input.equals("/gioca")) {
            GestoreStampa.stampareMessaggio("Hai già iniziato una partita.\n\n");
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "Inserisci un comando: ");
        } else if (input.equals("/tempo")) {
            GestoreStampa.stampareMessaggioInGioco(this.giocatoreCorrente, this.tavoliere,
            "Hai iniziato una nuova partita, DIVERTITI !", false, input);
        } else if (input.equals("/mosse")) {
            GestoreStampa.stampareMessaggioInGioco(this.giocatoreCorrente, this.tavoliere,
            "STORICO MOSSE", true, input);
            Comandi.mosse();
            do {
                GestoreStampa.stampareMessaggio("\nSe hai visualizzato lo storico mosse digita 'ok'"
                + " per continuare. \n\n");
                GestoreStampa.stampareMessaggio("Inserisci un comando: ");
                input = Comandi.input();
                if (!input.equals("ok")) {
                   GestoreStampa.stampareMessaggio("Comando non valido\n\n");
                }
                } while (!input.equals("ok"));
            GestoreStampa.stampareMessaggioInGioco(this.giocatoreCorrente, this.tavoliere,
            "Hai iniziato una nuova partita, DIVERTITI !", false, input);
        } else if (Utils.analizzatoreInputCoordinate(input)) {
            String[] result = input.split("-");
            if (controlloPedinaCorretta(result[0]) && controlloPedinaArrivoCorretta(result[1])) {
                controlloMossaDaEffettuaree(result[0], result[1]);
            }
            String m = "TURNO " + turno;
            GestoreStampa.stampareMessaggioInGioco(this.giocatoreCorrente, this.tavoliere, m, false, input);
            continua = controlloVincitore();
            resetTavoliere(this.tavoliere);
        } else if (input.startsWith("/") || input.startsWith("-") || input.startsWith("--")) {
            GestoreStampa.stampareMessaggio("Comando non utilizzabile in partita\n\n");
        } else {
            GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_RESET + "Inserisci un comando: ");
        }
    } while (continua);

}

/**
 * Metodo che controlla se la prima coordinata è effettivamente un pedina del gocatore corrente.
 * @param input
 */
private boolean controlloPedinaCorretta(final String input) {
    if (input.length() != 2) {

        return false;
    }
    int colonna = Utils.mappingColonne(String.valueOf(input.charAt(0)));
    int riga = Utils.mappingRighe(String.valueOf(input.charAt(1)));
    if (Cella.getStato(this.tavoliere.getCella(riga, colonna)) != (this.giocatoreCorrente)) {
        GestoreStampa.stampareMessaggio("La pedina selezionata non è tua\n\n");
        try {
            Thread.sleep(TIME); // Ritarda l'esecuzione per 2 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    } else if (Cella.getStato(this.tavoliere.getCella(riga, colonna)) == 0) {
        GestoreStampa.stampareMessaggio("Hai selezionato una cella vuota\n\n");
        try {
            Thread.sleep(TIME); // Ritarda l'esecuzione per 2 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    } else if (Cella.getStato(this.tavoliere.getCella(riga, colonna)) == Cella.STATO_CELLA_BLOCCATA) {
        GestoreStampa.stampareMessaggio("Hai selezionato una cella di partenza bloccata,"
        + " seleziona una in cui ci sia una tua pedina.\n\n");
        try {
            Thread.sleep(TIME); // Ritarda l'esecuzione per 2 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }
    return true;

}


/**
 * Metodo di controllo sulla correttezza della seconda coordinata.
 * @param input
*/
private boolean controlloPedinaArrivoCorretta(final String input) {
    if (input.length() != 2) {
        return false;
    }
    int colonna = Utils.mappingColonne(String.valueOf(input.charAt(0)));
    int riga = Utils.mappingRighe(String.valueOf(input.charAt(1)));
    if (Cella.getStato(this.tavoliere.getCella(riga, colonna)) == (this.giocatoreCorrente)) {
        GestoreStampa.stampareMessaggio("La destinazione selezionata è già occupata da una tua pedina\n\n");
        try {
            Thread.sleep(TIME); // Ritarda l'esecuzione per 2 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }
    if (Cella.getStato(this.tavoliere.getCella(riga, colonna)) == 2) {
        GestoreStampa.stampareMessaggio("La destinazione selezionata è già occupata da una pedina avversaria\n\n");
        try {
            Thread.sleep(TIME); // Ritarda l'esecuzione per 2 secondi

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    } else if (Cella.getStato(this.tavoliere.getCella(riga, colonna)) == Cella.STATO_CELLA_BLOCCATA) {
        GestoreStampa.stampareMessaggio("La destinazione selezionata è bloccata, scegli una destinazione libera.\n\n");
        try {
            Thread.sleep(TIME); // Ritarda l'esecuzione per 2 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    return true;
}


/**
 * Meotodo che si occupa di controllare se la mossa che il giocatore corrente vuole
 * effettuare sia una lecita, quindi o generativa o spostamento.
 * @param input1
 * @param input2
 */
private void controlloMossaDaEffettuaree(final String input1, final String input2) {
    int rigaTemp = -1;
    int colonnaTemp = -1;
    int statoTemp = -1;
    int colonna1 = Utils.mappingColonne(String.valueOf(input1.charAt(0)));
    int riga1 = Utils.mappingRighe(String.valueOf(input1.charAt(1)));
    int colonna2 = Utils.mappingColonne(String.valueOf(input2.charAt(0)));
    int riga2 = Utils.mappingRighe(String.valueOf(input2.charAt(1)));
    if (Math.abs(colonna1 - colonna2) <= 1 && Math.abs(riga1 - riga2) <= 1) {
        this.tavoliere.setTavoliere(riga2, colonna2, this.giocatoreCorrente);
        // Controlla le celle adiacenti
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Evita di controllare la cella stessa
                if (i == 0 && j == 0) {
                    continue;
                }

                // Calcola le coordinate della cella adiacente
                int rigaAdiacente = riga2 + i;
                int colonnaAdiacente = colonna2 + j;

                // Verifica che le coordinate siano all'interno dei limiti del tavoliere
                if (rigaAdiacente >= 0 && rigaAdiacente < Tavoliere.N_RIGHE_COLONNE
                        && colonnaAdiacente >= 0 && colonnaAdiacente < Tavoliere.N_RIGHE_COLONNE) {
                    rigaTemp = rigaAdiacente;
                    colonnaTemp = colonnaAdiacente;
                    statoTemp = Cella.getStato(this.tavoliere.getCella(rigaTemp, colonnaTemp));


                    // Se lo stato della cella adiacente è 2, cambialo in 1
                    if (statoTemp != this.giocatoreCorrente
                    && statoTemp != 0
                    && statoTemp != Cella.STATO_CELLA_BLOCCATA) {
                        this.tavoliere.setTavoliere(rigaTemp, colonnaTemp, this.giocatoreCorrente);
                    }
                }
            }
        }
        setStoricoMosse(turno, input1, input2, giocatoreCorrente);
        passaTurno(this.giocatoreCorrente);

    } else if (Math.abs(colonna1 - colonna2) <= 2 && Math.abs(riga1 - riga2) <= 2) {
        this.tavoliere.setTavoliere(riga2, colonna2, this.giocatoreCorrente);
        this.tavoliere.setTavoliere(riga1, colonna1, 0);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Evita di controllare la cella stessa
                if (i == 0 && j == 0) {
                    continue;
                }

                // Calcola le coordinate della cella adiacente
                int rigaAdiacente = riga2 + i;
                int colonnaAdiacente = colonna2 + j;
                // Verifica che le coordinate siano all'interno dei limiti del tavoliere
                if (rigaAdiacente >= 0 && rigaAdiacente < Tavoliere.N_RIGHE_COLONNE
                        && colonnaAdiacente >= 0 && colonnaAdiacente < Tavoliere.N_RIGHE_COLONNE) {
                    rigaTemp = rigaAdiacente;
                    colonnaTemp = colonnaAdiacente;
                    statoTemp = Cella.getStato(this.tavoliere.getCella(rigaTemp, colonnaTemp));

                    // Se lo stato della cella adiacente è 2, cambialo in 1
                    if (statoTemp != this.giocatoreCorrente
                    && statoTemp != 0
                    && statoTemp != Cella.STATO_CELLA_BLOCCATA) {
                        this.tavoliere.setTavoliere(rigaTemp, colonnaTemp, this.giocatoreCorrente);

                    }
                }
            }
        }
        setStoricoMosse(turno, input1, input2, giocatoreCorrente);
        passaTurno(this.giocatoreCorrente);
    } else {
        GestoreStampa.stampareMessaggio("Mossa non valida\n");
        GestoreStampa.stampareMessaggio("\nLa mossa è valida solo se scegli una cordinata"
                + " di distanza 1 o 2 da quella di partenza");
        try {
            Thread.sleep(TIME3); // Ritarda l'esecuzione per 2 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}



/**
 * Metodo che permette ad ogni mossa effettuata
 * di cambiare cambaire il tunro del giocatore corrente.
 * @param isGiocatoreCorrente
 */
private void passaTurno(final int isGiocatoreCorrente) {
    turno += 1;
    if (isGiocatoreCorrente == 1) {
        this.giocatoreCorrente = Giocatore.GIOCATORE2;

    } else if (isGiocatoreCorrente == 2) {
        this.giocatoreCorrente = Giocatore.GIOCATORE1;
    }
}

/**
 * Metodo che controlla se il vincitore della partita.
 * Il metodo controlla se le pedine del giocatore corrente
 * sono esaurite il vincitore è l'avversario.
 * Altrimenti, se il tavoliere è pieno, controlla quale
 * giocatore ha il numero di pedine maggiore e restituisce
 * il medesimo come vincitore.
 */
private boolean controlloVincitore() {

    int puntiNero = tavoliere.getContaPedine(Giocatore.GIOCATORE1);
    int puntiBianco = tavoliere.getContaPedine(Giocatore.GIOCATORE2);
    if (puntiBianco == 0 || puntiNero == 0) {
        if (puntiBianco == 0) {
            GestoreStampa.stampareMessaggio("Vince: " + GestoreStampa.ANSI_GREEN + getGiocatore1() + " con "
            + GestoreStampa.ANSI_YELLOW + puntiNero
            + GestoreStampa.ANSI_RESET + " punti");
            this.partitaIniziata = false;
            this.giocoFinito = true;
            Utils.setInGame(false);
            try {
                Thread.sleep(TIME2); // Ritarda l'esecuzione per 2 secondi

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            GestoreStampa.stampareMessaggio("Vince: " + GestoreStampa.ANSI_GREEN + getGiocatore2() + " con "
            + GestoreStampa.ANSI_YELLOW + puntiBianco
            + GestoreStampa.ANSI_RESET + " punti");
            this.partitaIniziata = false;
            this.giocoFinito = true;
            Utils.setInGame(false);
            try {
                Thread.sleep(TIME2); // Ritarda l'esecuzione per 2 secondi

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this.partitaIniziata;
        }
    } else {
        boolean tutteCasellePiene = true;

        for (int i = 0; i < Tavoliere.N_RIGHE_COLONNE; i++) {
            for (int j = 0; j < Tavoliere.N_RIGHE_COLONNE; j++) {
                if (Cella.getStato(this.tavoliere.getCella(i, j)) == 0) {
                    tutteCasellePiene = false;
                    break;
                }
            }
            if (!tutteCasellePiene) {
                break;
            }
        }

        if (tutteCasellePiene) {
            if (puntiBianco > puntiNero) {
                GestoreStampa.stampareMessaggio("Vince: " + GestoreStampa.ANSI_GREEN + getGiocatore2() + " con "
                + GestoreStampa.ANSI_YELLOW + puntiBianco
                + GestoreStampa.ANSI_RESET + " punti");
                this.partitaIniziata = false;
                this.giocoFinito = true;
                Utils.setInGame(false);
                try {
                    Thread.sleep(TIME2); // Ritarda l'esecuzione per 2 secondi

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (puntiNero > puntiBianco) {
                GestoreStampa
                        .stampareMessaggio("Vince: " + GestoreStampa.ANSI_GREEN + getGiocatore1() + " con "
                        + GestoreStampa.ANSI_YELLOW + puntiNero
                        + GestoreStampa.ANSI_RESET + " punti");
                this.partitaIniziata = false;
                this.giocoFinito = true;
                Utils.setInGame(false);
                try {
                    Thread.sleep(TIME2); // Ritarda l'esecuzione per 2 secondi

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("La partita è finita in pareggio");
                this.partitaIniziata = false;
                this.giocoFinito = true;
                Utils.setInGame(false);
                try {
                    Thread.sleep(TIME2); // Ritarda l'esecuzione per 2 secondi

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.partitaIniziata;
        }
    }
    return this.partitaIniziata;
}

/**
 * Metodo che si occupa di resettare il tavoliere quando
 * si esce dalla partita.
 @param isTavoliere
 */

private void resetTavoliere(final Tavoliere isTavoliere) {

    // Se isGiocoFinito() restituisce true, il codice all'interno dell'if verrà eseguito
    if (isGiocoFinito()) {

        // Questi due cicli for attraversano tutte le righe e le colonne del tavoliere
   for (int i = 0; i < Tavoliere.N_RIGHE_COLONNE; i++) {
       for (int j = 0; j < Tavoliere.N_RIGHE_COLONNE; j++) {
           isTavoliere.setTavoliere(i, j, Cella.STATO_CELLA_VUOTA);
       }
   }
     // imposto le pedine di partenza alle loro posizioni iniziali
     isTavoliere.inizializzaTavolierePartita(isTavoliere);
}

}


/**
    * Metodo che restituisce il giocatore1.
    */
    public static String getGiocatore1() {
        return giocatore1.getNome();
    }
    /**
    * Metodo che restituisce il giocatore2.
    */
    public static String getGiocatore2() {
        return giocatore2.getNome();
    }
   /**
    * Metodo che restituisce il tavoliere.
    */
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("EI")
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

    /**
    * Metodo che aggiunge una nuova entry allo storico mosse.
    * @param t turno in cui si è svolta la mossa
    * @param cPartenza cella di partenza della mossa
    * @param cArrivo cella di arrivo della mossa
    * @param g giocatore che effettua la mossa
    */
    public static void setStoricoMosse(final int t, final String cPartenza, final String cArrivo, final int g) {
        String coloreG = "";
        if (g == 1) {
            coloreG = "Nero";
        } else if (g == 2) {
            coloreG = "Bianco";
        }
        storicoMosse.add(GestoreStampa.ANSI_BLUE + t + GestoreStampa.ANSI_RESET + "."
        + GestoreStampa.ANSI_GREEN + cPartenza + GestoreStampa.ANSI_RESET + "-"
        + GestoreStampa.ANSI_ORANGE + cArrivo + GestoreStampa.ANSI_PINK + "(" + coloreG + ")"
        + GestoreStampa.ANSI_RESET);
    }

    /**
    * Metodo che restituisce lo storico delle mosse effettuate.
    */
    public static List<String> getStoricoMosse() {
        return storicoMosse;
    }

    /**
     * Metodo che restituisce il tempo trascorso dalla partita.
     */
public static String getTempoTrascorso() {
    // Calcola il tempo trascorso in millisecondi
    long tempoTrascorsoMillis = System.currentTimeMillis() - oraInizio;
    // Converte il tempo trascorso in ore
    long ore = TimeUnit.MILLISECONDS.toHours(tempoTrascorsoMillis);
    // Sottrae le ore dal tempo trascorso
    tempoTrascorsoMillis -= TimeUnit.HOURS.toMillis(ore);
    // Converte il tempo rimanente in minuti
    long minuti = TimeUnit.MILLISECONDS.toMinutes(tempoTrascorsoMillis);
    // Sottrae i minuti dal tempo trascorso
    tempoTrascorsoMillis -= TimeUnit.MINUTES.toMillis(minuti);
    // Converte il tempo rimanente in secondi
    long secondi = TimeUnit.MILLISECONDS.toSeconds(tempoTrascorsoMillis);
    // Restituisce il tempo trascorso nel formato ore:minuti:secondi
    return String.format("%02d:%02d:%02d", ore, minuti, secondi);
}

/**
 * Metodo che azzera lo storico delle mosse.
 */
public void azzeraStoricoMosse() {
    storicoMosse.clear();
}

}


