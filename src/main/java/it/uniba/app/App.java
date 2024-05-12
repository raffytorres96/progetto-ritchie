package it.uniba.app;

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
    public static void main(final String[] args) {
        System.out.println(new App().getGreeting());
        Tavoliere t = new Tavoliere();
        t.setTavoliere(0,0,2);
        t.setTavoliere(1,5,1);
        GestoreStampa.stampareTavoliereVuoto();
        GestoreStampa.stampareTavoliere(t);
        Cella c = t.getCella(0,2);
        int sc = t.getStatoCella(c);
        System.out.println(c+" "+sc);
    }
}
