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

   */
  public void qualiMosse(final int newgiocatoreCorrente) {
         GestoreStampa.clearTerminale();
         GestoreStampa.stampareTitoloGioco();
         GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE + "\nBenvenuti in ATAXX: "
         + GestoreStampa.ANSI_RESET + " Hai iniziato una nuova partita, DIVERTITI ! \n\n");
          GestoreStampa.stampareMessaggio("\nCon le pedine nere puoi fare le seguenti mosse:\n\n");
         // BLOCCO NUOVO PER ESAMINARE TUTTE LE PEDINE DEL GIOCATORE 1 SOTTO

         for (int i = 0; i < Tavoliere.N_RIGHE_COLONNE; i++) {
            for (int j = 0; j < Tavoliere.N_RIGHE_COLONNE; j++) {
                  visualizzaMossePossibili(i, j, tavoliere, newgiocatoreCorrente);
            }
         }
         // BLOCCO NUOVO PER ESAMINARE TUTTE LE PEDINE DEL GIOCATORE 1 SOPRA ^
           GestoreStampa.stampareTavoliere(this.tavoliere);
           String input;
           do {
              GestoreStampa.stampareMessaggio("\nSe hai visualizzato le mosse possibili digita 'ok'"
              + " per continuare: \n\n");
              GestoreStampa.stampareMessaggio("Inserisci un comando: ");
              input = Comandi.input();
              if (!input.equals("ok")) {
                 GestoreStampa.stampareMessaggio("Non hai inserito correttamente 'ok'.\n\n");
              }
              } while (!input.equals("ok"));
              puliziaTavoliere();
              GestoreStampa.clearTerminale();
              GestoreStampa.stampareTitoloGioco();
              GestoreStampa.stampareMessaggio(GestoreStampa.ANSI_BLUE + "\nBenvenuti in ATAXX: "
              + GestoreStampa.ANSI_RESET + " Hai iniziato una nuova partita, DIVERTITI !\n\n");
              GestoreStampa.stampareGiocatoreCorrente(this.giocatoreCorrente);
              GestoreStampa.stampareTavoliere(this.tavoliere);
              GestoreStampa.stampareMessaggio("Puoi usare" + GestoreStampa.ANSI_BLUE + " '/Abbandona' "
                    + GestoreStampa.ANSI_RESET + "per abbandonare la partita\n");
              GestoreStampa.stampareMessaggio("Oppure puoi usare" + GestoreStampa.ANSI_RED + " '/Esci' "
                    + GestoreStampa.ANSI_RESET + "per uscire dal gioco\n\n");
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
      if (rigaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata + 1 >= 0 && colonnaSelezionata + 1 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata + 1))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata + 1))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata + 1))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata + 1))
         != Cella.STATO_CELLA_ARANCIONE
         && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata + 1))
         != Cella.STATO_CELLA_ROSA) {
            tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata + 1,
            Cella.STATO_CELLA_GIALLA);
         } else {
            tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata + 1,
            Cella.STATO_CELLA_ROSA);
         }

      }
      if (rigaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata  - 1 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata - 1 >= 0 && colonnaSelezionata - 1 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata - 1))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata - 1))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata - 1))
         != Cella.STATO_CELLA_BLOCCATA) {
            if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata - 1))
            != Cella.STATO_CELLA_ARANCIONE
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata - 1))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata - 1,
               Cella.STATO_CELLA_GIALLA);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata - 1,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata - 1 >= 0 && colonnaSelezionata >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata))
         != Cella.STATO_CELLA_BLOCCATA) {
            if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata))
            != Cella.STATO_CELLA_ARANCIONE
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata,
               Cella.STATO_CELLA_GIALLA);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata >= 0 && colonnaSelezionata - 1 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata - 1))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata - 1))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata - 1))
         != Cella.STATO_CELLA_BLOCCATA) {
            if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata - 1))
            != Cella.STATO_CELLA_ARANCIONE
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata - 1))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata - 1,
               Cella.STATO_CELLA_GIALLA);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata - 1,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata + 1 >= 0 && colonnaSelezionata >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata))
         != Cella.STATO_CELLA_BLOCCATA) {
            if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata))
            != Cella.STATO_CELLA_ARANCIONE
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata,
               Cella.STATO_CELLA_GIALLA);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata >= 0 && colonnaSelezionata + 1 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata + 1))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata + 1))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata,  colonnaSelezionata + 1))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata + 1))
            != Cella.STATO_CELLA_ARANCIONE
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata + 1))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata + 1,
               Cella.STATO_CELLA_GIALLA);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata + 1,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata + 1 >= 0 && colonnaSelezionata - 1 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata - 1))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata - 1))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata - 1))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata - 1))
            != Cella.STATO_CELLA_ARANCIONE
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata - 1))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata - 1,
               Cella.STATO_CELLA_GIALLA);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata - 1,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata - 1 >= 0 && colonnaSelezionata + 1 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata + 1))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata + 1))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata + 1))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata + 1))
            != Cella.STATO_CELLA_ARANCIONE
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata + 1))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata + 1,
               Cella.STATO_CELLA_GIALLA);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata + 1,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata + 2 >= 0 && colonnaSelezionata + 2 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata + 2))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata + 2))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata + 2))
         != Cella.STATO_CELLA_BLOCCATA) {
            if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata + 2))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata + 2))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata + 2,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata + 2,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata - 2 >= 0 && colonnaSelezionata - 2 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata - 2))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata - 2))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata - 2))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata - 2))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata - 2))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata - 2,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata - 2,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata - 2 >= 0 && colonnaSelezionata >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata,
               Cella.STATO_CELLA_ROSA);
         }
      }
      if (rigaSelezionata < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata >= 0 && colonnaSelezionata - 2 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata - 2))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata - 2))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata - 2))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata - 2))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata - 2))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata - 2,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata - 2,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata + 2 >= 0 && colonnaSelezionata >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata >= 0 && colonnaSelezionata + 2 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata + 2))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata + 2))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata + 2))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata + 2))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata + 2))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata + 2,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata, colonnaSelezionata + 2,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata + 2 >= 0 && colonnaSelezionata - 2 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata - 2))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata - 2))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata - 2))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata - 2))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata - 2))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata - 2,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata - 2,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata - 2 >= 0 && colonnaSelezionata + 2 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata + 2))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata + 2))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata + 2))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata + 2))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata + 2))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata + 2,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata + 2,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata + 2 >= 0 && colonnaSelezionata + 1 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata + 1))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata + 1))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata + 1))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata + 1))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata + 1))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata + 1,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata + 1,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata + 2 >= 0 && colonnaSelezionata - 1 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata - 1))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata - 1))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata - 1))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata - 1))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 2, colonnaSelezionata - 1))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata - 1,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 2, colonnaSelezionata - 1,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata - 2 >= 0 && colonnaSelezionata + 1 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata + 1))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata + 1))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata + 1))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata + 1))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata + 1))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata + 1,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata + 1,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata - 2 >= 0 && colonnaSelezionata - 1 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata - 1))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata - 1))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata - 1))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata - 1))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 2, colonnaSelezionata - 1))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata - 1,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 2, colonnaSelezionata - 1,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata + 1 >= 0 && colonnaSelezionata + 2 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata + 2))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata + 2))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata + 2))
         != Cella.STATO_CELLA_BLOCCATA) {
            if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata + 2))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata + 2))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata + 2,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata + 2,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata + 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata + 1 >= 0 && colonnaSelezionata - 2 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata - 2))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata - 2))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata - 2))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata - 2))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata + 1, colonnaSelezionata - 2))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata - 2,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata + 1, colonnaSelezionata - 2,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata + 2 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata - 1 >= 0 && colonnaSelezionata + 2 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata + 2))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata + 2))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata + 2))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata + 2))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata + 2))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata + 2,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata + 2,
               Cella.STATO_CELLA_ROSA);
            }
      }
      if (rigaSelezionata - 1 < Tavoliere.N_RIGHE_COLONNE && colonnaSelezionata - 2 < Tavoliere.N_RIGHE_COLONNE
      && rigaSelezionata - 1 >= 0 && colonnaSelezionata - 2 >= 0
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata, colonnaSelezionata)) == newgiocatoreCorrente
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata - 2))
         != Cella.STATO_GIOCATORE2
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata - 2))
         != Cella.STATO_GIOCATORE1
      && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata - 2))
         != Cella.STATO_CELLA_BLOCCATA) {
         if (Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata - 2))
            != Cella.STATO_CELLA_GIALLA
            && Cella.getStato(tavoliereCorrente.getCella(rigaSelezionata - 1, colonnaSelezionata - 2))
            != Cella.STATO_CELLA_ROSA) {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata - 2,
               Cella.STATO_CELLA_ARANCIONE);
            } else {
               tavoliereCorrente.setTavoliere(rigaSelezionata - 1, colonnaSelezionata - 2,
               Cella.STATO_CELLA_ROSA);
            }
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
            || Cella.getStato(tavoliere.getCella(i, j)) == Cella.STATO_CELLA_ARANCIONE
            || Cella.getStato(tavoliere.getCella(i, j)) == Cella.STATO_CELLA_ROSA) {

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
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("EI")
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
   @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("EI2")
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










