package it.uniba.app;

/**
 * <<Boundary>>
 * Responsabilità: Gestisce la stampa a video di messaggi.
 *
 * Classe che si occupa gestire la stampa a video dei messaggi
 * del gioco. Per migliorare l'interfaccia e la UX dell'utente
 * sono stati inseriti i colori e una particolare formattazione
 * dei messaggi.
 *
 * @author GrruppoRitchie
 */

public final class GestoreStampa {

     /**
   * Attributo statico che contiene il colore di default.
   */
  public static final String ANSI_RESET = "\u001B[0m";

  /**
   * Attributo statico che contiene il colore rosso.
   */
  public static final String ANSI_RED = "\u001B[31m";

  /**
   * Attributo statico che contiene il colore verde.
   */
  public static final String ANSI_GREEN = "\u001B[32m";

  /**
   * Attributo statico che contiene il colore di giallo.
   */
  public static final String ANSI_YELLOW = "\u001B[33m";

  /**
   * Attributo statico che contiene il colore di blu.
   */
  public static final String ANSI_BLUE = "\u001B[34m";

  /**
   * Attributo statico che contiene il colore di blu.
   */
  public static final String ANSI_ORANGE = "\u001B[38;2;255;165;0m";

  /**
   * Attributo statico che contiene il colore di blu.
   */
  public static final String ANSI_PINK = "\u001B[38;2;255;105;180m";

/**
  * Attributo statico contiene le etichette delle colonne
  * della griglia di gioco.
 */

  private static final char[] ETICHETTA_COLONNE = {'1', '2', '3', '4', '5', '6', '7'};
  /**
  * Attributo statico che contiene l'etichetta delle righe
  * della griglia di gioco.
  */

   private static final String ETICHETTA_RIGHE = "    A   B   C   D   E   F   G";
  /**
   * Costruttore di GestioneStampa.
   */
  private GestoreStampa() {
}

/**
   * Metodo statico che stampa
   * il titolo del gioco.
   */
  public static void stampareTitoloGioco() {
    stampareScritteInAsciiArt("ATAXX ", ANSI_RED);

  }

  /**
   * Metodo statico che si occupa di stampare messaggi a video.
   *
   * @param messaggio
   */
  public static void stampareMessaggio(final String messaggio) {
    System.out.print(messaggio);
  }


  /**
   * Metodo statico che si occupa di stampare
   * in AsciiArt il titolo del gioco.
   *
   * @param input
   * @param color
   */
  public static void stampareScritteInAsciiArt(final String input,
                                               final String color) {

    System.out.println(color);

    stamparePrimaRiga(input);
    System.out.println();
    stampareSecondaRiga(input);
    System.out.println();
    stampareTerzaRiga(input);
    System.out.println();
    stampareQuartaRiga(input);
    System.out.println();
    stampareQuintaRiga(input);
    System.out.println();
    stampareSestaRiga(input);

    System.out.println(ANSI_RESET + "\n");
  }

  /**
   * Metodo statico che si occupa di convertire
   * la prima riga del titolo in AsciiArt.
   *
   * @param input
   */
  private static void stamparePrimaRiga(final String input) {
    int posizione;

    posizione = 0;
    while (posizione < input.length()) {
      if (input.charAt(posizione) == 'A'
              || input.charAt(posizione) == 'a') {
        System.out.printf("  ___   ");
      } else if (input.charAt(posizione) == 'B'
              || input.charAt(posizione) == 'b') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'C'
              || input.charAt(posizione) == 'c') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'D'
              || input.charAt(posizione) == 'd') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'E'
              || input.charAt(posizione) == 'e') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'F'
              || input.charAt(posizione) == 'f') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'G'
              || input.charAt(posizione) == 'g') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'H'
              || input.charAt(posizione) == 'h') {
        System.out.printf(" _   _  ");
      } else if (input.charAt(posizione) == 'I'
              || input.charAt(posizione) == 'i') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'J'
              || input.charAt(posizione) == 'j') {
        System.out.printf("   ___  ");
      } else if (input.charAt(posizione) == 'K'
              || input.charAt(posizione) == 'k') {
        System.out.printf(" _   __ ");
      } else if (input.charAt(posizione) == 'L'
              || input.charAt(posizione) == 'l') {
        System.out.printf(" _      ");
      } else if (input.charAt(posizione) == 'M'
              || input.charAt(posizione) == 'm') {
        System.out.printf(" __  __  ");
      } else if (input.charAt(posizione) == 'N'
              || input.charAt(posizione) == 'n') {
        System.out.printf(" _   _  ");
      } else if (input.charAt(posizione) == 'O'
              || input.charAt(posizione) == 'o') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'P'
              || input.charAt(posizione) == 'p') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'Q'
              || input.charAt(posizione) == 'q') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'R'
              || input.charAt(posizione) == 'r') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'S'
              || input.charAt(posizione) == 's') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'T'
              || input.charAt(posizione) == 't') {
        System.out.printf(" _____  ");
      } else if (input.charAt(posizione) == 'U'
              || input.charAt(posizione) == 'u') {
        System.out.printf(" _   _  ");
      } else if (input.charAt(posizione) == 'V'
              || input.charAt(posizione) == 'v') {
        System.out.printf(" _   _  ");
      } else if (input.charAt(posizione) == 'W'
              || input.charAt(posizione) == 'w') {
        System.out.printf(" _    _  ");
      } else if (input.charAt(posizione) == 'X'
              || input.charAt(posizione) == 'x') {
        System.out.printf("__   __ ");
      } else if (input.charAt(posizione) == 'Y'
              || input.charAt(posizione) == 'y') {
        System.out.printf("__   __ ");
      } else if (input.charAt(posizione) == 'Z'
              || input.charAt(posizione) == 'z') {
        System.out.printf(" ______ ");
      } else if (input.charAt(posizione) == '!') {
        System.out.printf(" _  ");
      } else if (input.charAt(posizione) == '\'') {
        System.out.printf(" _  ");
      }

      posizione++;
    }
  }

  /**
   * Metodo statico che si occupa di convertire
   * la seconda riga del titolo in AsciiArt.
   *
   * @param input
   */
  private static void stampareSecondaRiga(final String input) {
    int posizione;
    posizione = 0;
    while (posizione < input.length()) {
      if (input.charAt(posizione) == 'A'
              || input.charAt(posizione) == 'a') {
        System.out.printf(" / _ \\  ");
      } else if (input.charAt(posizione) == 'B'
              || input.charAt(posizione) == 'b') {
        System.out.printf("| ___ \\ ");
      } else if (input.charAt(posizione) == 'C'
              || input.charAt(posizione) == 'c') {
        System.out.printf("/  __ \\ ");
      } else if (input.charAt(posizione) == 'D'
              || input.charAt(posizione) == 'd') {
        System.out.printf("|  _  \\ ");
      } else if (input.charAt(posizione) == 'E'
              || input.charAt(posizione) == 'e') {
        System.out.printf("|  ___| ");
      } else if (input.charAt(posizione) == 'F'
              || input.charAt(posizione) == 'f') {
        System.out.printf("|  ___| ");
      } else if (input.charAt(posizione) == 'G'
              || input.charAt(posizione) == 'g') {
        System.out.printf("|  __ \\ ");
      } else if (input.charAt(posizione) == 'H'
              || input.charAt(posizione) == 'h') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'I'
              || input.charAt(posizione) == 'i') {
        System.out.printf("|_   _| ");
      } else if (input.charAt(posizione) == 'J'
              || input.charAt(posizione) == 'j') {
        System.out.printf("  |_  | ");
      } else if (input.charAt(posizione) == 'K'
              || input.charAt(posizione) == 'k') {
        System.out.printf("| | / / ");
      } else if (input.charAt(posizione) == 'L'
              || input.charAt(posizione) == 'l') {
        System.out.printf("| |     ");
      } else if (input.charAt(posizione) == 'M'
              || input.charAt(posizione) == 'm') {
        System.out.printf("|  \\/  | ");
      } else if (input.charAt(posizione) == 'N'
              || input.charAt(posizione) == 'n') {
        System.out.printf("| \\ | | ");
      } else if (input.charAt(posizione) == 'O'
              || input.charAt(posizione) == 'o') {
        System.out.printf("|  _  | ");
      } else if (input.charAt(posizione) == 'P'
              || input.charAt(posizione) == 'p') {
        System.out.printf("| ___ \\ ");
      } else if (input.charAt(posizione) == 'Q'
              || input.charAt(posizione) == 'q') {
        System.out.printf("|  _  | ");
      } else if (input.charAt(posizione) == 'R'
              || input.charAt(posizione) == 'r') {
        System.out.printf("| ___ \\ ");
      } else if (input.charAt(posizione) == 'S'
              || input.charAt(posizione) == 's') {
        System.out.printf("/  ___| ");
      } else if (input.charAt(posizione) == 'T'
              || input.charAt(posizione) == 't') {
        System.out.printf("|_   _| ");
      } else if (input.charAt(posizione) == 'U'
              || input.charAt(posizione) == 'u') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'V'
              || input.charAt(posizione) == 'v') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'W'
              || input.charAt(posizione) == 'w') {
        System.out.printf("| |  | | ");
      } else if (input.charAt(posizione) == 'X'
              || input.charAt(posizione) == 'x') {
        System.out.printf("\\ \\ / / ");
      } else if (input.charAt(posizione) == 'Y'
              || input.charAt(posizione) == 'y') {
        System.out.printf("\\ \\ / / ");
      } else if (input.charAt(posizione) == 'Z'
              || input.charAt(posizione) == 'z') {
        System.out.printf("|___  / ");
      } else if (input.charAt(posizione) == '!') {
        System.out.printf("| | ");
      } else if (input.charAt(posizione) == '\'') {
        System.out.printf("( ) ");
      }
      posizione++;
    }
  }

  /**
   * Metodo statico che si occupa di convertire
   * la terza riga del titolo in AsciiArt.
   *
   * @param input
   */
  private static void stampareTerzaRiga(final String input) {
    int posizione;

    posizione = 0;
    while (posizione < input.length()) {
      if (input.charAt(posizione) == 'A'
              || input.charAt(posizione) == 'a') {
        System.out.printf("/ /_\\ \\ ");
      } else if (input.charAt(posizione) == 'B'
              || input.charAt(posizione) == 'b') {
        System.out.printf("| |_/ / ");
      } else if (input.charAt(posizione) == 'C'
              || input.charAt(posizione) == 'c') {
        System.out.printf("| /  \\/ ");
      } else if (input.charAt(posizione) == 'D'
              || input.charAt(posizione) == 'd') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'E'
              || input.charAt(posizione) == 'e') {
        System.out.printf("| |__   ");
      } else if (input.charAt(posizione) == 'F'
              || input.charAt(posizione) == 'f') {
        System.out.printf("| |_    ");
      } else if (input.charAt(posizione) == 'G'
              || input.charAt(posizione) == 'g') {
        System.out.printf("| |  \\/ ");
      } else if (input.charAt(posizione) == 'H'
              || input.charAt(posizione) == 'h') {
        System.out.printf("| |_| | ");
      } else if (input.charAt(posizione) == 'I'
              || input.charAt(posizione) == 'i') {
        System.out.printf("  | |   ");
      } else if (input.charAt(posizione) == 'J'
              || input.charAt(posizione) == 'j') {
        System.out.printf("    | | ");
      } else if (input.charAt(posizione) == 'K'
              || input.charAt(posizione) == 'k') {
        System.out.printf("| |/ /  ");
      } else if (input.charAt(posizione) == 'L'
              || input.charAt(posizione) == 'l') {
        System.out.printf("| |     ");
      } else if (input.charAt(posizione) == 'M'
              || input.charAt(posizione) == 'm') {
        System.out.printf("| .  . | ");
      } else if (input.charAt(posizione) == 'N'
              || input.charAt(posizione) == 'n') {
        System.out.printf("|  \\| | ");
      } else if (input.charAt(posizione) == 'O'
              || input.charAt(posizione) == 'o') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'P'
              || input.charAt(posizione) == 'p') {
        System.out.printf("| |_/ / ");
      } else if (input.charAt(posizione) == 'Q'
              || input.charAt(posizione) == 'q') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'R'
              || input.charAt(posizione) == 'r') {
        System.out.printf("| |_/ / ");
      } else if (input.charAt(posizione) == 'S'
              || input.charAt(posizione) == 's') {
        System.out.printf("\\ `--.  ");
      } else if (input.charAt(posizione) == 'T'
              || input.charAt(posizione) == 't') {
        System.out.printf("  | |   ");
      } else if (input.charAt(posizione) == 'U'
              || input.charAt(posizione) == 'u') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'V'
              || input.charAt(posizione) == 'v') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'W'
              || input.charAt(posizione) == 'w') {
        System.out.printf("| |  | | ");
      } else if (input.charAt(posizione) == 'X'
              || input.charAt(posizione) == 'x') {
        System.out.printf(" \\ V /  ");
      } else if (input.charAt(posizione) == 'Y'
              || input.charAt(posizione) == 'y') {
        System.out.printf(" \\ V /  ");
      } else if (input.charAt(posizione) == 'Z'
              || input.charAt(posizione) == 'z') {
        System.out.printf("   / /  ");
      } else if (input.charAt(posizione) == '!') {
        System.out.printf("| | ");
      } else if (input.charAt(posizione) == '\'') {
        System.out.printf("|/  ");
      }
      posizione++;
    }
  }

  /**
   * Metodo statico che si occupa di convertire
   * la quarta riga del titolo in AsciiArt.
   *
   * @param input
   */
  private static void stampareQuartaRiga(final String input) {
    int posizione;

    posizione = 0;
    while (posizione < input.length()) {
      if (input.charAt(posizione) == 'A'
              || input.charAt(posizione) == 'a') {
        System.out.printf("|  _  | ");
      } else if (input.charAt(posizione) == 'B'
              || input.charAt(posizione) == 'b') {
        System.out.printf("| ___ \\ ");
      } else if (input.charAt(posizione) == 'C'
              || input.charAt(posizione) == 'c') {
        System.out.printf("| |     ");
      } else if (input.charAt(posizione) == 'D'
              || input.charAt(posizione) == 'd') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'E'
              || input.charAt(posizione) == 'e') {
        System.out.printf("|  __|  ");
      } else if (input.charAt(posizione) == 'F'
              || input.charAt(posizione) == 'f') {
        System.out.printf("|  _|   ");
      } else if (input.charAt(posizione) == 'G'
              || input.charAt(posizione) == 'g') {
        System.out.printf("| | __  ");
      } else if (input.charAt(posizione) == 'H'
              || input.charAt(posizione) == 'h') {
        System.out.printf("|  _  | ");
      } else if (input.charAt(posizione) == 'I'
              || input.charAt(posizione) == 'i') {
        System.out.printf("  | |   ");
      } else if (input.charAt(posizione) == 'J'
              || input.charAt(posizione) == 'j') {
        System.out.printf("    | | ");
      } else if (input.charAt(posizione) == 'K'
              || input.charAt(posizione) == 'k') {
        System.out.printf("|    \\  ");
      } else if (input.charAt(posizione) == 'L'
              || input.charAt(posizione) == 'l') {
        System.out.printf("| |     ");
      } else if (input.charAt(posizione) == 'M'
              || input.charAt(posizione) == 'm') {
        System.out.printf("| |\\/| | ");
      } else if (input.charAt(posizione) == 'N'
              || input.charAt(posizione) == 'n') {
        System.out.printf("| . ` | ");
      } else if (input.charAt(posizione) == 'O'
              || input.charAt(posizione) == 'o') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'P'
              || input.charAt(posizione) == 'p') {
        System.out.printf("|  __/  ");
      } else if (input.charAt(posizione) == 'Q'
              || input.charAt(posizione) == 'q') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'R'
              || input.charAt(posizione) == 'r') {
        System.out.printf("|    /  ");
      } else if (input.charAt(posizione) == 'S'
              || input.charAt(posizione) == 's') {
        System.out.printf(" `--. \\ ");
      } else if (input.charAt(posizione) == 'T'
              || input.charAt(posizione) == 't') {
        System.out.printf("  | |   ");
      } else if (input.charAt(posizione) == 'U'
              || input.charAt(posizione) == 'u') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'V'
              || input.charAt(posizione) == 'v') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'W'
              || input.charAt(posizione) == 'w') {
        System.out.printf("| |/\\| | ");
      } else if (input.charAt(posizione) == 'X'
              || input.charAt(posizione) == 'x') {
        System.out.printf(" / ^ \\  ");
      } else if (input.charAt(posizione) == 'Y'
              || input.charAt(posizione) == 'y') {
        System.out.printf("  \\ /   ");
      } else if (input.charAt(posizione) == 'Z'
              || input.charAt(posizione) == 'z') {
        System.out.printf("  / /   ");
      } else if (input.charAt(posizione) == '!') {
        System.out.printf("| | ");
      } else if (input.charAt(posizione) == '\'') {
        System.out.printf("    ");
      }

      posizione++;
    }
  }

  /**
   * Metodo statico che si occupa di convertire
   * la quarta riga del titolo in AsciiArt.
   *
   * @param input
   */
  private static void stampareQuintaRiga(final String input) {
    int posizione;
    posizione = 0;
    while (posizione < input.length()) {
      if (input.charAt(posizione) == 'A'
              || input.charAt(posizione) == 'a') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'B'
              || input.charAt(posizione) == 'b') {
        System.out.printf("| |_/ / ");
      } else if (input.charAt(posizione) == 'C'
              || input.charAt(posizione) == 'c') {
        System.out.printf("| \\__/\\ ");
      } else if (input.charAt(posizione) == 'D'
              || input.charAt(posizione) == 'd') {
        System.out.printf("| |/ /  ");
      } else if (input.charAt(posizione) == 'E'
              || input.charAt(posizione) == 'e') {
        System.out.printf("| |___  ");
      } else if (input.charAt(posizione) == 'F'
              || input.charAt(posizione) == 'f') {
        System.out.printf("| |     ");
      } else if (input.charAt(posizione) == 'G'
              || input.charAt(posizione) == 'g') {
        System.out.printf("| |_\\ \\ ");
      } else if (input.charAt(posizione) == 'H'
              || input.charAt(posizione) == 'h') {
        System.out.printf("| | | | ");
      } else if (input.charAt(posizione) == 'I'
              || input.charAt(posizione) == 'i') {
        System.out.printf(" _| |_  ");
      } else if (input.charAt(posizione) == 'J'
              || input.charAt(posizione) == 'j') {
        System.out.printf("/\\__/ / ");
      } else if (input.charAt(posizione) == 'K'
              || input.charAt(posizione) == 'k') {
        System.out.printf("| |\\  \\ ");
      } else if (input.charAt(posizione) == 'L'
              || input.charAt(posizione) == 'l') {
        System.out.printf("| |____ ");
      } else if (input.charAt(posizione) == 'M'
              || input.charAt(posizione) == 'm') {
        System.out.printf("| |  | | ");
      } else if (input.charAt(posizione) == 'N'
              || input.charAt(posizione) == 'n') {
        System.out.printf("| |\\  | ");
      } else if (input.charAt(posizione) == 'O'
              || input.charAt(posizione) == 'o') {
        System.out.printf("\\ \\_/ / ");
      } else if (input.charAt(posizione) == 'P'
              || input.charAt(posizione) == 'p') {
        System.out.printf("| |     ");
      } else if (input.charAt(posizione) == 'Q'
              || input.charAt(posizione) == 'q') {
        System.out.printf("\\ \\/' / ");
      } else if (input.charAt(posizione) == 'R'
              || input.charAt(posizione) == 'r') {
        System.out.printf("| |\\ \\  ");
      } else if (input.charAt(posizione) == 'S'
              || input.charAt(posizione) == 's') {
        System.out.printf("/\\__/ / ");
      } else if (input.charAt(posizione) == 'T'
              || input.charAt(posizione) == 't') {
        System.out.printf("  | |   ");
      } else if (input.charAt(posizione) == 'U'
              || input.charAt(posizione) == 'u') {
        System.out.printf("| |_| | ");
      } else if (input.charAt(posizione) == 'V'
              || input.charAt(posizione) == 'v') {
        System.out.printf("\\ \\_/ / ");
      } else if (input.charAt(posizione) == 'W'
              || input.charAt(posizione) == 'w') {
        System.out.printf("\\  /\\  / ");
      } else if (input.charAt(posizione) == 'X'
              || input.charAt(posizione) == 'x') {
        System.out.printf("/ / \\ \\ ");
      } else if (input.charAt(posizione) == 'Y'
              || input.charAt(posizione) == 'y') {
        System.out.printf("  | |   ");
      } else if (input.charAt(posizione) == 'Z'
              || input.charAt(posizione) == 'z') {
        System.out.printf("./ /___ ");
      } else if (input.charAt(posizione) == '!') {
        System.out.printf("|_| ");
      } else if (input.charAt(posizione) == '\'') {
        System.out.printf("    ");
      }

      posizione++;
    }
  }

  /**
   * Metodo statico che si occupa di convertire
   * la sesta riga del titolo in AsciiArt.
   *
   * @param input
   */
  private static void stampareSestaRiga(final String input) {
    int posizione;

    posizione = 0;
    while (posizione < input.length()) {
      if (input.charAt(posizione) == 'A'
              || input.charAt(posizione) == 'a') {
        System.out.printf("\\_| |_/ ");
      } else if (input.charAt(posizione) == 'B'
              || input.charAt(posizione) == 'b') {
        System.out.printf("\\____/  ");
      } else if (input.charAt(posizione) == 'C'
              || input.charAt(posizione) == 'c') {
        System.out.printf(" \\____/ ");
      } else if (input.charAt(posizione) == 'D'
              || input.charAt(posizione) == 'd') {
        System.out.printf("|___/   ");
      } else if (input.charAt(posizione) == 'E'
              || input.charAt(posizione) == 'e') {
        System.out.printf("\\____/  ");
      } else if (input.charAt(posizione) == 'F'
              || input.charAt(posizione) == 'f') {
        System.out.printf("\\_|     ");
      } else if (input.charAt(posizione) == 'G'
              || input.charAt(posizione) == 'g') {
        System.out.printf(" \\____/ ");
      } else if (input.charAt(posizione) == 'H'
              || input.charAt(posizione) == 'h') {
        System.out.printf("\\_| |_/ ");
      } else if (input.charAt(posizione) == 'I'
              || input.charAt(posizione) == 'i') {
        System.out.printf(" \\___/  ");
      } else if (input.charAt(posizione) == 'J'
              || input.charAt(posizione) == 'j') {
        System.out.printf("\\____/  ");
      } else if (input.charAt(posizione) == 'K'
              || input.charAt(posizione) == 'k') {
        System.out.printf("\\_| \\_/ ");
      } else if (input.charAt(posizione) == 'L'
              || input.charAt(posizione) == 'l') {
        System.out.printf("\\_____/ ");
      } else if (input.charAt(posizione) == 'M'
              || input.charAt(posizione) == 'm') {
        System.out.printf("\\_|  |_/ ");
      } else if (input.charAt(posizione) == 'N'
              || input.charAt(posizione) == 'n') {
        System.out.printf("\\_| \\_/ ");
      } else if (input.charAt(posizione) == 'O'
              || input.charAt(posizione) == 'o') {
        System.out.printf(" \\___/  ");
      } else if (input.charAt(posizione) == 'P'
              || input.charAt(posizione) == 'p') {
        System.out.printf("\\_|     ");
      } else if (input.charAt(posizione) == 'Q'
              || input.charAt(posizione) == 'q') {
        System.out.printf(" \\_/\\_\\ ");
      } else if (input.charAt(posizione) == 'R'
              || input.charAt(posizione) == 'r') {
        System.out.printf("\\_| \\_| ");
      } else if (input.charAt(posizione) == 'S'
              || input.charAt(posizione) == 's') {
        System.out.printf("\\____/  ");
      } else if (input.charAt(posizione) == 'T'
              || input.charAt(posizione) == 't') {
        System.out.printf("  \\_/   ");
      } else if (input.charAt(posizione) == 'U'
              || input.charAt(posizione) == 'u') {
        System.out.printf(" \\___/  ");
      } else if (input.charAt(posizione) == 'V'
              || input.charAt(posizione) == 'v') {
        System.out.printf(" \\___/  ");
      } else if (input.charAt(posizione) == 'W'
              || input.charAt(posizione) == 'w') {
        System.out.printf(" \\/  \\/  ");
      } else if (input.charAt(posizione) == 'X'
              || input.charAt(posizione) == 'x') {
        System.out.printf("\\/   \\/ ");
      } else if (input.charAt(posizione) == 'Y'
              || input.charAt(posizione) == 'y') {
        System.out.printf("  \\_/   ");
      } else if (input.charAt(posizione) == 'Z'
              || input.charAt(posizione) == 'z') {
        System.out.printf("\\_____/ ");
      } else if (input.charAt(posizione) == '!') {
        System.out.printf("(_) ");
      } else if (input.charAt(posizione) == '\'') {
        System.out.printf("    ");
      }

      posizione++;
    }
  }
public static final int SIZE = 7;
  /**
   * Metodo che si occupa di stampare a video il tavoliere con le
   * pedine posizionate secondo la partita in corso.
   * @param tavoliere
   */
  public static void stampareTavoliere(final Tavoliere tavoliere) {
    System.out.println(ETICHETTA_RIGHE);
    for (int i = 0; i < SIZE; i++) {
      System.out.print(ETICHETTA_COLONNE[i] + "  ");
      for (int j = 0; j < SIZE; j++) {
        System.out.print(tavoliere.getCella(i, j).getIcona() + "  ");
      }
      System.out.print(" " + ETICHETTA_COLONNE[i]);
      System.out.println("");
    }
    System.out.println(ETICHETTA_RIGHE);
}

 /**
   * Metodo che si occupa di stampare il tavoliere vuoto.
   */
public static void stampareTavoliereVuoto() {
  System.out.println(ETICHETTA_RIGHE);
  for (int i = 0; i < SIZE; i++) {
    System.out.print(ETICHETTA_COLONNE[i] + "  ");
    for (int j = 0; j < SIZE; j++) {
      System.out.print(Cella.ICONA_CELLA_VUOTA + "  ");
    }
    System.out.print(" " + ETICHETTA_COLONNE[i]);
    System.out.println("");
  }
  System.out.println(ETICHETTA_RIGHE);
}

/**
 * Metodo per pulire lo schermo.
 */
public static void clearTerminale() {
  System.out.print("\033[H\033[2J");
  System.out.flush();
}
/**
 * Metodo che si occupa di stampare il giocatore corrente.
 * @param giocatoreCorrente
 */
public static void stampareGiocatoreCorrente(final int giocatoreCorrente) {
  if (giocatoreCorrente == 1) {
      GestoreStampa.stampareMessaggio("E' il turno di: " + Partita.getGiocatore1() + " (Nero).\n\n");
    } else if (giocatoreCorrente == 2) {
      GestoreStampa.stampareMessaggio("E' il turno di: " + Partita.getGiocatore2() + " (Bianco).\n\n");
    }

}
}
