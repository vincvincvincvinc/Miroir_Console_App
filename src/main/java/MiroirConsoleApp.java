import java.util.Scanner;
import java.util.Calendar;

public class MiroirConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        saluer();

        // Main loop
        while (true) {
            System.out.print("Entrez du texte (ou 'exit' pour quitter) : ");
            String input = scanner.nextLine();

            // Palindrome
            if (estPalindrome(input)) {
                System.out.println("Bien dit! C'est un palindrome");
            } else {
                // Miroir
                System.out.println("En miroir : " + inverserChaine(input));
            }

            // Quitter
            if (input.equalsIgnoreCase("exit")) {
                // Au revoir
                direAuRevoir();
                break;
            }
        }

        scanner.close();
    }

    private static void saluer() {
        Calendar calendar = Calendar.getInstance();
        int heure = calendar.get(Calendar.HOUR_OF_DAY);

        if (heure >= 6 && heure < 12) {
            System.out.println("Labas rytas!");
        } else if (heure >= 12 && heure < 18) {
            System.out.println("Laba diena!");
        } else {
            System.out.println("Labas vakaras!");
        }
    }

    static boolean estPalindrome(String texte) {
        String texteSansEspaces = texte.replaceAll("\\s", "").toLowerCase();
        String inverse = new StringBuilder(texteSansEspaces).reverse().toString();
        return texteSansEspaces.equals(inverse);
    }

    static String inverserChaine(String texte) {
        return new StringBuilder(texte).reverse().toString();
    }

    private static void direAuRevoir() {
        Calendar calendar = Calendar.getInstance();
        int heure = calendar.get(Calendar.HOUR_OF_DAY);

        if (heure >= 6 && heure < 12) {
            System.out.println("Iki!");
        } else if (heure >= 12 && heure < 18) {
            System.out.println("Geros dienos!");
        } else {
            System.out.println("Gero vakaro!");
        }
    }

    public static void simulateTimeAndCallSaluer(Calendar morning) {
    }

    public static void simulateTimeAndCallDireAuRevoir(Calendar morning) {
    }
}
