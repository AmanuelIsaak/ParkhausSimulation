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
            System.out.println("2. Bezahlen");
            System.out.println("3. Ausfahren");
            System.out.println("4. Beenden");

            String auswahl = scanner.next();
            String stockWerk = scanner.next();
            String zahlen = scanner.next();

            switch (auswahl) {
                case "1":
                    System.out.println("Willkommen!");
                    System.out.println("Wollen Sie 1. Stock oder 2. Stock?");
                    if (stockWerk == "1") {
                        meinParkhaus.einfahren();
                    } else if (stockWerk == "2") {
                       meinParkhaus.einfahren();
                    }
                default:
                    System.out.println("Ungültige Auswahl");
                    break;
                case "2":
                    System.out.println("Danke, dass Sie hier waren!");
                    System.out.println("Der Endpreis ist" + ticketMaschine.erstelleTicket());
                    System.out.println("Zahlen? (y/n)");

                case "3":
                    System.out.print("");

                    break;
            }
        }
    }
}
