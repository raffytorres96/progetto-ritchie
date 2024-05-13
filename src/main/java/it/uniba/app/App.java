package it.uniba.app;
import java.util.Scanner;

/**
 * Main class of the application.
 */
public final class App {
    /**
     * Creazione dello scanner per l'input, usabile
     * in tutti i metodi.
     */
    private static Scanner scanner = null;
    /**
     * Get a greeting sentence.
     *
     * @return the "Hello World!" string.
     */
    public String getGreeting() {
        return "Hello World!!!";
    }

/**
 * Main della classe app.
 * @param args
 */
     public static void main(final String[] args) {
        scanner = new Scanner(System.in);
        System.out.println(new App().getGreeting());
        Tavoliere t = new Tavoliere();
        System.out.println("PRIMA MOSSA - giocatore1");
        System.out.println("Inserisci la riga: ");
        int riga = scanner.nextInt();
        System.out.println("Inserisci la colonna: ");
        int colonna = scanner.nextInt();
        t.setTavoliere(riga, colonna, Cella.STATO_GIOCATORE2);
        System.out.println("SECONDA MOSSA - giocatore2");
        System.out.println("Inserisci la riga: ");
        riga = scanner.nextInt();
        System.out.println("Inserisci la colonna: ");
        colonna = scanner.nextInt();
        t.setTavoliere(riga, colonna, Cella.STATO_GIOCATORE1);
        GestoreStampa.stampareTavoliereVuoto();
        GestoreStampa.stampareTavoliere(t);
    }
}
