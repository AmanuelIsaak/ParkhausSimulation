import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random(3);
        Parkhaus parkhaus = new Parkhaus();
        Fahrzeug fahrzeug = new Fahrzeug();
        Ticket meinTicket = new Ticket(random.nextInt(), fahrzeug);

        System.out.println("Willkommen zum Parkhaus!");
        System.out.println("1. Einfahrt und parkieren");
        System.out.println("2. Bezahlen und und Parkhaus verlassen");
        System.out.println("x. Abbrechen des Simulations");

        String auswahlt = scanner.next();

        switch (auswahlt) {
            case "1":
                parkhaus.findeFreieParkplatz();
                parkhaus.einfahren(fahrzeug);
                fahrzeug.getFahrzeugID();
                break;
            case "2":
                parkhaus.ausfahren(meinTicket);
                break;
            case "x":
                return;
            default:
                System.out.println("Ungültige Auswahl");
        }
    }
}
