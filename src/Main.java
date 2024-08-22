import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parkhaus meinParkhaus = new Parkhaus();
        Fahrzeug meinFahrzeug = new Fahrzeug();
        TicketMaschine ticketMaschine = new TicketMaschine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Willkommen zum Parkhaus!");
            System.out.println("1. Einfahren");
            System.out.println("1. Parkieren");
            System.out.println("2. Ausfahren");
            System.out.println("3. Beenden");

            int auswahl = scanner.nextInt();

            switch (auswahl) {
                case 1:
                    System.out.print("Bitte geben Sie Ihre Ticketnummer ein: ");
                    meinParkhaus.einfahren(meinFahrzeug);
                    break;
                case 2:
                    System.out.println("");
                case 3:
                    System.out.print("Bitte geben Sie Ihre Ticketnummer ein: ");

                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}