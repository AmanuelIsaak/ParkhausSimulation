import java.time.LocalDateTime;
import java.util.Scanner;

public class Ticket {
    private int ticketNummer;
    private LocalDateTime einfahrtszeit;
    private LocalDateTime ausfahrtszeit;
    private Fahrzeug fahrzeug;
    private double preisProSekunde = 0.15;
    private double preise = preisProSekunde * 3600;
    private boolean bezahlt = false;

    public Ticket(int ticketNummer, Fahrzeug fahrzeug) {
        this.ticketNummer = ticketNummer;
        this.einfahrtszeit = LocalDateTime.now();
        this.fahrzeug = fahrzeug;
    }

    public int getTicketNummer() {
        return ticketNummer;
    }

    public double berechnePreis() {
        if (ausfahrtszeit == null) {
            return 0.0;
        }
        long dauerInSekunden= java.time.Duration.between(einfahrtszeit, ausfahrtszeit).toMinutes();
        double preise = dauerInSekunden * 3600.0;
        return preise;
    }

    public void bezahlen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zahlen Sie bitte die Rechnung [ja]");

        String bezahle = scanner.next();

        switch (bezahle) {
            case "ja":
                System.out.println("Ihr Rechnung im Betrag von "+ preise + " wurde bezahlt.");
            default:
                System.out.println("Sie müssen die Rechnung zahlen!!!");
        }
        this.fahrzeug = null;
    }
}
