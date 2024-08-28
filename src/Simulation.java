import java.util.Scanner;

public class Simulation {
  public static void main(String[] args) {
    String NummerSchild = "CH BS 69420";
    int ticketNummer = 234947;

    Scanner scanner = new Scanner(System.in);
    TicketMaschine ticketMaschine = new TicketMaschine();
    Parkhaus meinParkhaus = new Parkhaus();
    Fahrzeug meinFahrzeug = new Fahrzeug(NummerSchild);
    Ticket meinTicket = new Ticket(ticketNummer);

    int auswahl;

    do {
      System.out.println("Willkommen zu unsere Parkhaus! Suchen Sie sich einen Parkplatz");
      System.out.println("1. Ticket lösen und parkieren");
      System.out.println("2. Ausfahren und an die bezahlen");
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
          System.out.println("Parkiert");
        case 2:
          meinParkhaus.ausfahren(meinTicket);
        case 3:
          System.out.println("Ticket abgeben... ");
          ticketMaschine.findeTicket(ticketNummer);
          System.out.println("Transaktion....");
          ticketMaschine.bezahlTicket(ticketNummer);
          meinTicket.beendeParkvorgang();
        case 4:
          return;
        default:
          System.out.println("ungültige Auswahl");
      }
    } while (auswahl != 3);
  }
}