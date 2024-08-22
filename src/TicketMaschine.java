import java.time.LocalDateTime;
import java.util.ArrayList;

public class TicketMaschine {
    private int autoIncrementID= 1;
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public Ticket erstelleTicket(Fahrzeug fahrzeug) {
        Ticket neuesTicket = new Ticket(autoIncrementID, fahrzeug);
        tickets.add(neuesTicket);
        autoIncrementID++;
        System.out.println("Hier ist Ihr Ticket: "+neuesTicket.getTicketNummer());
        return neuesTicket;
    }
}

class Ticket {
    private int ticketNummer;
    private LocalDateTime einfahrtszeit;
    private LocalDateTime ausfahrtszeit;
    private Fahrzeug fahrzeug;
    private double preisProSekunde = 0.15;

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
        double stunden = dauerInSekunden * 3600.0;
        return stunden;
    }
}