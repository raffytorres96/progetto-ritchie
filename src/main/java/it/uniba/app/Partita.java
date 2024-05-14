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

    /** attributo statico per identificare lo stato della cella occupata
 * nel tavoliere dalla pedina che corrisponde al giocatore1.  */
private static final int GIOCATORE1 = 1;

/** attributo statico per identificare lo stato della cella occupata
 * nel tavoliere dalla pedina che corrisponde al giocatore2.  */
private static final int GIOCATORE2 = 2;

/** attributo statico per identificare la cordinata da dare a setTavoliere.  */
private static final int POSIZIONE0 = 0;

/** attributo statico per identificare la cordinata da dare a setTavoliere.  */
private static final int POSIZIONE7 = 7;

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
/**
 * Costruttore della classe Partita.
 * @param regolaGioco
 * @param nome1
 * @param nome2
 */
public Partita(final String regolaGioco, final String nome1, final String nome2) {

this.tavoliere = new Tavoliere();
this.tavoliere.setTavoliere(POSIZIONE0, POSIZIONE0, GIOCATORE1);
this.tavoliere.setTavoliere(POSIZIONE7, POSIZIONE7, GIOCATORE1);
this.tavoliere.setTavoliere(POSIZIONE0, POSIZIONE7, GIOCATORE2);
this.tavoliere.setTavoliere(POSIZIONE7, POSIZIONE0, GIOCATORE2);
this.regola = new Regola(regolaGioco);
this.giocatore1 = new Giocatore(nome1, GIOCATORE1);
this.giocatore2 = new Giocatore(nome2, GIOCATORE2);
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
        this.giocoFinito = giocoFinito;
    }

}


