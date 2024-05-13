package it.uniba.app;
import java.util.Scanner;

/**
 * Main class of the application.
 */
public final class App {

    /**
     * Get a greeting sentence.
     *
     * @return the "Hello World!" string.
     */
    public String getGreeting() {
        return "Hello World!!!";
    }

    /**
     * Entrypoint of the application.
     *
     * @param args command line arguments
     */

public static final int GIOCATORE1 = 1;
public static final int GIOCATORE2 = 2;
/**
 * Main della classe app.
 * @param args
 */
     public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la riga: ");
        int riga = scanner.nextInt();
        System.out.println(new App().getGreeting());
        Tavoliere t = new Tavoliere();
        //int riga = 0;
        int colonna = 0;
        t.setTavoliere(riga, colonna, GIOCATORE2);
        int riga1 = 1;
        int colonna1 = 0; //da pari qui
        t.setTavoliere(riga1, colonna1, GIOCATORE1);
        GestoreStampa.stampareTavoliereVuoto();
        GestoreStampa.stampareTavoliere(t);
    }
}
