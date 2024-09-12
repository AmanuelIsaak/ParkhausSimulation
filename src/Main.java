import java.util.Scanner;

private Fahrzeug fahrzeug;
private Parkhaus parkhaus;
private int ticket;
private TicketMaschine ticketMaschine;

public static void main(String[] args) {
    String NummerSchild = "CH BS 69420";
    int ticketNummer = 234947;

    Scanner scanner = new Scanner(System.in);
    TicketMaschine ticketMaschine = new TicketMaschine();
    Parkhaus meinParkhaus = new Parkhaus();
    Fahrzeug meinFahrzeug = new Fahrzeug(NummerSchild);
    Ticket meinTicket = new Ticket(ticketNummer);

    int auswahl;

    System.out.println("Willkommen zu unsere Parkhaus! Suchen Sie sich einen Parkplatz");
    do {
        System.out.println("1. Ticket lösen und parkieren");
        System.out.println("2. Ausfahren und an die Kasse");
        System.out.println("3. Bezahlen und Parkhaus verlassen");
        System.out.println("4. Beenden");
        auswahl = scanner.nextInt();

        switch (auswahl) {
            case 1:
                System.out.println("Ticket lösen.... ");
                ticketMaschine.fuegeTicketHinzu(meinTicket);
                System.out.println("Freie Parkplatz suchen...... ");
                System.out.println("Gefunden");
                meinParkhaus.einfahren(meinFahrzeug);
                System.out.println(STR."Auto mit dem Nr: \{meinFahrzeug.getNummerSchild()} parkiert");
                break;
            case 3:
                meinParkhaus.ausfahren(meinTicket);
                break;
            case 2:
                System.out.println("Ticket abgeben... ");
                ticketMaschine.findeTicket(ticketNummer);
                System.out.println("Transaktion läuft....");
                ticketMaschine.bezahlTicket(ticketNummer);
                meinTicket.beendeParkvorgang();
                break;
            case 4:
                return;
            default:
                System.out.println("ungültige Auswahl");
                break;
        }
    } while (auswahl != 3);
}
// Code geschrieben von Amanuel Isaak am 23.08.2024{